package org.main_components.main_pane_displays.info_displays.jtree_displays;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

import org.functionality.Student;
import org.main_components.main_pane_displays.DynamicInfoDisplay;

import net.miginfocom.swing.MigLayout;

public class StudentDisplay extends JPanel implements DynamicInfoDisplay
{
	private static final long serialVersionUID = -2464804348911959743L;
	private static final Font FONT =  new Font("Serif", Font.BOLD, 24);
	
	private Student student;
	
	public StudentDisplay(Student s)
	{
		student = s;
		setLayout(new MigLayout("fill", "10[grow, fill]", ""));
		addComponents();
	}
	
	protected void addComponents()
	{
		JLabel labelOne = new JLabel("DYNAMIC DISPLAY FOR STUDENT: " + student.getFirstName() + " " + student.getLastName());
		labelOne.setFont(FONT);
		labelOne.setHorizontalAlignment(JLabel.CENTER);
		
		add(labelOne, "span");
	}

	@Override
	public void refresh()
	{
		
	}

}
