package org.main_components.main_pane_displays.creation_displays;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import org.functionality.generators.ClassroomGenerator;
import org.main_components.main_pane_displays.MainPaneDisplay;

import net.miginfocom.swing.MigLayout;

public class AddStudent extends MainPaneDisplay implements ActionListener
{
	private static final long serialVersionUID = 5796983569443360161L;
	private static final Font FONT =  new Font("Serif", Font.BOLD, 15);
	private static final Font FONT2 =  new Font("Serif", Font.BOLD, 24);
	private JTextField nameFirstField, nameLastField;
	private DefaultListModel<String> inModel, outModel;
	JList<String> inList, outList;
	
	@Override
	protected void addComponents()
	{
		setLayout(new MigLayout(
				"",
				"[][]",
				"[][][][][][]"));
		JLabel labelOne = new JLabel("ADD STUDENT");
		labelOne.setFont(FONT2);
		JLabel nameLabel = new JLabel("First Name");
		nameLabel.setFont(FONT);
		nameFirstField = new JTextField(20);
		JLabel lastLabel = new JLabel("Last Name");
		lastLabel.setFont(FONT);
		nameLastField = new JTextField(20);
		inModel = new DefaultListModel<>();
		inList = getClassList();
		JScrollPane namePane = new JScrollPane(inList);
		namePane.setPreferredSize(new Dimension(180, 400));
		outModel = new DefaultListModel<String>();
		outList = new JList<String>(outModel);
		JScrollPane classPane = new JScrollPane(outList);
		classPane.setPreferredSize(new Dimension(180, 400));
		JButton addButton = new JButton("Add Student to Class");
		addButton.addActionListener((ActionListener) this);
		addButton.setActionCommand("ADD");
		JButton remove = new JButton("Remove Student from Class");
		remove.addActionListener((ActionListener) this);
		remove.setActionCommand("REMOVE");
		JButton submit = new JButton("Submit");
		submit.setFont(FONT);
		submit.addActionListener((ActionListener) this);
		submit.setActionCommand("SUBMIT");
		add(labelOne, "span");
		
		add(labelOne, "wrap");
		add(nameLabel);
		add(nameFirstField, "wrap");
		add(lastLabel);
		add(nameLastField, "wrap");
		add(namePane, "span 1 2");
		JPanel buttonGroup = new JPanel();
		add(buttonGroup, "");
		buttonGroup.setLayout(new BorderLayout());
		buttonGroup.add(addButton, BorderLayout.NORTH);
		buttonGroup.add(remove, BorderLayout.SOUTH);
		add(classPane, "span 1 2");
		add(submit, "cell 2 5");
		
	}

	private JList<String> getClassList() {
		// NEED HELP HERE FRED
		for (String s : ClassroomGenerator.CLASS_NAMES){
			inModel.addElement(s);
		}
		return new JList<String>(inModel);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// NEED HELP HERE FRED
		if (e.getActionCommand().equals("ADD")) {
			outModel.addElement(inList.getSelectedValue());
			inModel.removeElement(inList.getSelectedValue());
		} else if (e.getActionCommand().equals("REMOVE")) {
			inModel.addElement(outList.getSelectedValue());
			outModel.removeElement(outList.getSelectedValue());
		} else {
			//NEED HELP HERE
		}
	}

}
