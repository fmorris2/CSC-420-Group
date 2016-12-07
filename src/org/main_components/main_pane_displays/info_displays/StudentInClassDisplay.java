package org.main_components.main_pane_displays.info_displays;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

import org.functionality.Classroom;
import org.functionality.Student;
import org.main_components.main_pane_displays.DynamicInfoDisplay;

import net.miginfocom.swing.MigLayout;

public class StudentInClassDisplay extends JPanel implements DynamicInfoDisplay
{
	private static final long serialVersionUID = 6572889490347849148L;
	private static final Font FONT = new Font("Serif", Font.BOLD, 24);

	private Student student;
	private Classroom classroom;
	
	public StudentInClassDisplay(Student s, Classroom c)
	{
		student = s;
		classroom = c;
		setLayout(new MigLayout("fill", "10[grow, fill]", ""));
		addComponents();
	}

	protected void addComponents()
	{
		JLabel labelOne = new JLabel("DYNAMIC DISPLAY FOR STUDENT: " + student.getFirstName() + " " + student.getLastName() + " IN CLASS: " + classroom.getName());
		labelOne.setFont(FONT);
		labelOne.setHorizontalAlignment(JLabel.CENTER);

		add(labelOne, "span");
	}

	@Override
	public void refresh()
	{

	}

}
