package org.main_components.main_pane_displays.creation_displays;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import org.functionality.Assignment;
import org.functionality.Classroom;
import org.functionality.jtree.InfoListHandler;
import org.functionality.jtree.node.impl.ClassNode;
import org.main_components.main_pane_displays.MainPaneDisplay;

import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;

public class AddAssignment extends MainPaneDisplay implements ActionListener
{
	private static final long serialVersionUID = 1318874985175193927L;
	private JTextField fieldName;
	private JTextArea descriptionArea;
	private JComboBox<Classroom> classChoose;
	private DefaultComboBoxModel<Classroom> boxModel;
	private JLabel fields;
	private JDatePickerImpl datePicker;
	
	@Override
	protected void addComponents()
	{
		JLabel addTaskLabel = new JLabel("Add New Assignment");
		addTaskLabel.setFont(MainPaneDisplay.HEADER_FONT);
		JLabel labelName = new JLabel("Assignment Name:");
		labelName.setFont(MainPaneDisplay.INFO_FONT);
		fieldName = new JTextField();
		fieldName.isEditable();
		fieldName.setFont(MainPaneDisplay.MINOR_FONT);
		JLabel descriptionLabel = new JLabel("Assignment Description:");
		descriptionLabel.setFont(MainPaneDisplay.INFO_FONT);
		descriptionArea = new JTextArea(5,100);
		descriptionArea.setMaximumSize(new Dimension(400, 400));
		descriptionArea.setLineWrap(true);
		descriptionArea.setFont(MainPaneDisplay.MINOR_FONT);
		descriptionArea.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
		boxModel = new DefaultComboBoxModel<>();
		classChoose = getClassBox();
		JLabel dateLabel = new JLabel("Due Date: ");
		dateLabel.setFont(MainPaneDisplay.INFO_FONT);
		UtilDateModel model = new UtilDateModel();
		model.setDate(2016, 12, 13);
		JDatePanelImpl datePanel = new JDatePanelImpl(model);
		datePanel.setSize(50, 10);
		datePicker = new JDatePickerImpl(datePanel);
		datePicker.setFont(MainPaneDisplay.MINOR_FONT);
		JButton submit = new JButton("Submit");
		submit.setFont(MainPaneDisplay.INFO_FONT);
		submit.addActionListener((ActionListener) this);
		fields = new JLabel("      ");
		fields.setVisible(false);
		fields.setFont(MainPaneDisplay.INFO_FONT);
		
		JLabel classLabel = new JLabel("Class:");
		classLabel.setFont(MainPaneDisplay.INFO_FONT);
		classChoose.setFont(MainPaneDisplay.INFO_FONT);
		
		//Add components
		add(addTaskLabel, "wrap");
		add(labelName, "split");
		add(fieldName, "span, wrap, growx");
		add(descriptionLabel, "wrap");
		add(descriptionArea, "span, wrap, grow");
		add(dateLabel, "wrap");
		add(datePicker, "split, left, grow, wrap");
		add(classLabel, "wrap");
		add(classChoose, "wrap, grow");
		add(fields, "span 1");
		add(submit);
	}
	
	private JComboBox<Classroom> getClassBox() {
		for(ClassNode c : InfoListHandler.classNodes)
			boxModel.addElement(c.getClassroom());
		
		return new JComboBox<>(boxModel);
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
		Assignment toAdd = new Assignment(fieldName.getText(), ldt, 
				classChoose.getItemAt(classChoose.getSelectedIndex()), descriptionArea.getText());
		InfoListHandler.addAssignment(toAdd);
	}
	private boolean allfieldsfull() {
		if (fieldName.getText().isEmpty() || descriptionArea.getText().isEmpty()){
		return false;
		} else {
			return true;
		}
	}

}
