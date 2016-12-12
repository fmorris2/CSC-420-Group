package org.main_components.main_pane_displays.creation_displays;

import java.awt.Dimension;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import org.functionality.Assignment;
import org.functionality.Classroom;
import org.functionality.generators.ClassroomGenerator;

import org.main_components.main_pane_displays.MainPaneDisplay;

import net.miginfocom.swing.MigLayout;
import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;

public class AddAssignment extends MainPaneDisplay implements ActionListener
{
	private static final long serialVersionUID = 1318874985175193927L;
	private static final Font FONT =  new Font("Serif", Font.BOLD, 15);
	private static final Font FONT2 =  new Font("Serif", Font.BOLD, 30);
	private JTextField fieldName;
	private JTextArea descriptionArea;
	private JComboBox<String> classChoose;
	private JLabel fields;
	private JDatePickerImpl datePicker;
	
	@Override
	protected void addComponents()
	{
		setLayout(new MigLayout(
				"",
				"[][][]",
				"[][][][][]"));
		JLabel addTaskLabel = new JLabel("Add New Task");
		addTaskLabel.setFont(FONT2);
		JLabel labelName = new JLabel("Assignment Name:");
		labelName.setFont(FONT);
		fieldName = new JTextField(400);
		fieldName.isEditable();
		JLabel descriptionLabel = new JLabel("Assignment Description:");
		descriptionLabel.setFont(FONT);
		descriptionArea = new JTextArea(5,100);
		descriptionArea.isEditable();
		descriptionArea.setMaximumSize(new Dimension(1000, 400));
		descriptionArea.setLineWrap(true);
		classChoose = getClassBox();
		JLabel dateLabel = new JLabel("Due Date: ");
		dateLabel.setFont(FONT);
		UtilDateModel model = new UtilDateModel();
		model.setDate(2016, 12, 13);
		JDatePanelImpl datePanel = new JDatePanelImpl(model);
		datePanel.setSize(50, 10);
		datePicker = new JDatePickerImpl(datePanel);
		JButton submit = new JButton("Submit");
		submit.setFont(FONT);
		submit.addActionListener((ActionListener) this);
		fields = new JLabel("      ");
		fields.setVisible(false);
		fields.setFont(FONT);
		
		//Add components
		add(addTaskLabel, "wrap");
		add(labelName, "split");
		add(fieldName, "span, wrap");
		add(descriptionLabel, "wrap");
		add(descriptionArea, "span, wrap");
//		add(dateLabel);
		add(datePicker, "split, left");
		add(classChoose, "wrap" );
		add(fields, "span 1");
		add(submit);
		
		
		
		
	}
	private JComboBox<String> getClassBox() {
		// NEED HELP HERE FRED
		return new JComboBox<String>(ClassroomGenerator.CLASS_NAMES);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (allfieldsfull()){
			createAssignment();
		} else {
			fields.setText("Please fill out all fields");
			fields.setVisible(true);
		}
		
	}
	private void createAssignment() {
		Date d = (Date) datePicker.getModel().getValue();
		Instant instant = d.toInstant();
		LocalDateTime ldt = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
		System.out.println(ldt.toString());
		Assignment a = new Assignment(fieldName.getText(), ldt, new Classroom(classChoose.getSelectedItem().toString()), descriptionArea.getText());
		//NEED HELP HERE FRED
	}
	private boolean allfieldsfull() {
		if (fieldName.getText().isEmpty() || descriptionArea.getText().isEmpty()){
		return false;
		} else {
			return true;
		}
	}

}
