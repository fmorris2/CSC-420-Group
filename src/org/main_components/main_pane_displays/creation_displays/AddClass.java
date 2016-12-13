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
import org.functionality.Student;
import org.functionality.jtree.InfoListHandler;
import org.functionality.jtree.node.impl.StudentNode;
import org.main_components.main_pane_displays.MainPaneDisplay;

public class AddClass extends MainPaneDisplay implements ActionListener
{
	private static final long serialVersionUID = -5227614264518741078L;
	private JTextField nameField;
	private DefaultListModel<Student> inModel, outModel;
	JList<Student> nameList, classList;

	@Override
	protected void addComponents()
	{
		JLabel labelOne = new JLabel("ADD CLASS");
		labelOne.setFont(MainPaneDisplay.HEADER_FONT);
		JLabel nameLabel = new JLabel("Classroom Name");
		nameLabel.setFont(MainPaneDisplay.INFO_FONT);
		nameField = new JTextField(20);
		nameField.setFont(MainPaneDisplay.MINOR_FONT);
		inModel = new DefaultListModel<>();
		nameList = getNameList();
		nameList.setFont(MainPaneDisplay.MINOR_FONT);
		JScrollPane namePane = new JScrollPane(nameList);
		namePane.setPreferredSize(new Dimension(180, 400));
		outModel = new DefaultListModel<>();
		classList = new JList<>(outModel);
		classList.setFont(MainPaneDisplay.MINOR_FONT);
		JScrollPane classPane = new JScrollPane(classList);
		classPane.setPreferredSize(new Dimension(180, 400));
		JButton addButton = new JButton("Add Student");
		addButton.setFont(MainPaneDisplay.MINOR_FONT);
		addButton.addActionListener((ActionListener) this);
		addButton.setActionCommand("ADD");
		JButton remove = new JButton("Remove Student");
		remove.setFont(MainPaneDisplay.MINOR_FONT);
		remove.addActionListener((ActionListener) this);
		remove.setActionCommand("REMOVE");
		JButton submit = new JButton("Submit");
		submit.setFont(MainPaneDisplay.INFO_FONT);
		submit.addActionListener(this);
		submit.setActionCommand("SUBMIT");
		
		
		add(labelOne, "wrap");
		add(nameLabel);
		add(nameField, "wrap");
		add(namePane, "span 1 2");
		JPanel buttonGroup = new JPanel();
		add(buttonGroup, "");
		buttonGroup.setLayout(new BorderLayout());
		buttonGroup.add(addButton, BorderLayout.NORTH);
		buttonGroup.add(remove, BorderLayout.SOUTH);
		add(classPane, "span 1 2");
		add(submit, "cell 2 5");
		
	}

	private JList<Student> getNameList() 
	{
		for(StudentNode n : InfoListHandler.studentNodes)
			inModel.addElement(n.getStudent());
		
		return new JList<Student>(inModel);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("ADD")) {
			outModel.addElement(nameList.getSelectedValue());
			inModel.removeElement(nameList.getSelectedValue());
		} else if (e.getActionCommand().equals("REMOVE")) {
			inModel.addElement(classList.getSelectedValue());
			outModel.removeElement(classList.getSelectedValue());
		} else {
			Classroom newClass = new Classroom(nameField.getText());
			for(int i = 0; i < outModel.size(); i++)
			{
				Student toAdd = outModel.getElementAt(i);
				if(toAdd == null)
					continue;
				newClass.addStudent(toAdd);
			}
			
			System.out.println("Adding new class: " + newClass);
			InfoListHandler.addClass(newClass, true);
		}
		
	}

}
