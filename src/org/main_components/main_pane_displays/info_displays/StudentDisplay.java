package org.main_components.main_pane_displays.info_displays;

import org.functionality.Student;
import org.main_components.main_pane_displays.DynamicInfoDisplay;
import org.main_components.main_pane_displays.MainPaneDisplay;

public class StudentDisplay extends MainPaneDisplay implements DynamicInfoDisplay
{
	private static final long serialVersionUID = -2464804348911959743L;

	private Student student;
	
	public StudentDisplay(Student s)
	{
		student = s;
	}
	
	@Override
	protected void addComponents()
	{
	}

	@Override
	public void refresh()
	{
	}

}
