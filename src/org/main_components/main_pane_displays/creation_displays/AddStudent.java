package org.main_components.main_pane_displays.creation_displays;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import org.functionality.Classroom;
import org.functionality.jtree.InfoListHandler;
import org.functionality.jtree.node.impl.ClassNode;
import org.main_components.main_pane_displays.MainPaneDisplay;

public class AddStudent extends MainPaneDisplay implements ActionListener
{
	private static final long serialVersionUID = 5796983569443360161L;
	private JTextField nameFirstField, nameLastField;
	private DefaultListModel<Classroom> inModel, outModel;
	JList<Classroom> inList, outList;
	
	@Override
	protected void addComponents()
	{
		JLabel labelOne = new JLabel("ADD STUDENT");
		labelOne.setFont(MainPaneDisplay.HEADER_FONT);
		JLabel nameLabel = new JLabel("First Name");
		nameLabel.setFont(MainPaneDisplay.INFO_FONT);
		nameFirstField = new JTextField(20);
		nameFirstField.setFont(MainPaneDisplay.MINOR_FONT);
		JLabel lastLabel = new JLabel("Last Name");
		lastLabel.setFont(MainPaneDisplay.INFO_FONT);
		nameLastField = new JTextField(20);
		nameLastField.setFont(MainPaneDisplay.MINOR_FONT);
		inModel = new DefaultListModel<>();
		inList = getClassList();
		inList.setFont(MainPaneDisplay.MINOR_FONT);
		JScrollPane namePane = new JScrollPane(inList);
		namePane.setPreferredSize(new Dimension(180, 400));
		outModel = new DefaultListModel<>();
		outList = new JList<>(outModel);
		outList.setFont(MainPaneDisplay.MINOR_FONT);
		JScrollPane classPane = new JScrollPane(outList);
		classPane.setPreferredSize(new Dimension(180, 400));
		JButton addButton = new JButton("Add Student to Class");
		addButton.setFont(MainPaneDisplay.MINOR_FONT);
		addButton.addActionListener((ActionListener) this);
		addButton.setActionCommand("ADD");
		JButton remove = new JButton("Remove Student from Class");
		remove.setFont(MainPaneDisplay.MINOR_FONT);
		remove.addActionListener((ActionListener) this);
		remove.setActionCommand("REMOVE");
		JButton submit = new JButton("Submit");
		submit.setFont(MainPaneDisplay.INFO_FONT);
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

	private JList<Classroom> getClassList() {
		for (ClassNode n : InfoListHandler.classNodes){
			inModel.addElement(n.getClassroom());
		}
		return new JList<>(inModel);
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
