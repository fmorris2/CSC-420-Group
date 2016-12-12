package org.main_components.main_pane_displays.creation_displays;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import org.main_components.main_pane_displays.MainPaneDisplay;

import net.miginfocom.swing.MigLayout;

public class AddClass extends MainPaneDisplay implements ActionListener
{
	private static final long serialVersionUID = -5227614264518741078L;
	private static final Font FONT =  new Font("Serif", Font.BOLD, 15);
	private static final Font FONT2 =  new Font("Serif", Font.BOLD, 24);
	private JTextField nameField;
	private DefaultListModel<String> inModel, outModel;
	JList<String> nameList, classList;

	@Override
	protected void addComponents()
	{
		setLayout(new MigLayout(
				"",
				"[180][][180]",
				"[][][][][]"));
		JLabel labelOne = new JLabel("ADD CLASS");
		labelOne.setFont(FONT2);
		JLabel nameLabel = new JLabel("Classroom Name");
		nameLabel.setFont(FONT);
		nameField = new JTextField(20);
		inModel = new DefaultListModel<>();
		nameList = getNameList();
		JScrollPane namePane = new JScrollPane(nameList);
		namePane.setPreferredSize(new Dimension(180, 400));
		outModel = new DefaultListModel<String>();
		classList = new JList<String>(outModel);
		JScrollPane classPane = new JScrollPane(classList);
		classPane.setPreferredSize(new Dimension(180, 400));
		JButton addButton = new JButton("Add Student");
		addButton.addActionListener((ActionListener) this);
		addButton.setActionCommand("ADD");
		JButton remove = new JButton("Remove Student");
		remove.addActionListener((ActionListener) this);
		remove.setActionCommand("REMOVE");
		JButton submit = new JButton("Submit");
		submit.setFont(FONT);
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

	private JList<String> getNameList() {
		//NEED HELP HERE
		inModel.addElement("Noah Pierce");
		inModel.addElement("Fred Morrison");
		return new JList<String>(inModel);
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
			//NEED HELP HERE
		}
		
	}

}
