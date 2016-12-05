package org.main_components.toolbar_buttons;

import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

import org.TeacherEdition;
import org.main_components.main_pane_displays.creation_displays.AddAssignment;
import org.main_components.main_pane_displays.creation_displays.AddClass;
import org.main_components.main_pane_displays.creation_displays.AddStudent;

public class AddButton extends JButton
{
	private static final long serialVersionUID = -885998939215708049L;
	private final JPopupMenu MENU = new JPopupMenu("Test");
	private final JMenuItem CLASS, STUDENT, ASSIGNMENT;
	
	public AddButton()
	{
		super("Add Item");
		addActionListener((e) ->  MENU.show(this, this.getX(), this.getY()));
		
		CLASS = new JMenuItem("Class");
		CLASS.addActionListener((e) -> TeacherEdition.changeMainDisplay(new AddClass()));
		
		STUDENT = new JMenuItem("Student");
		STUDENT.addActionListener((e) -> TeacherEdition.changeMainDisplay(new AddStudent()));
		
		ASSIGNMENT = new JMenuItem("Assignment");
		ASSIGNMENT.addActionListener((e) -> TeacherEdition.changeMainDisplay(new AddAssignment()));
		
		MENU.add(CLASS);
		MENU.add(STUDENT);
		MENU.add(ASSIGNMENT);
	}
}
