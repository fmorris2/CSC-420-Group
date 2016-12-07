package org.main_components.main_pane_displays.info_displays;

import org.functionality.Classroom;
import org.main_components.main_pane_displays.DynamicInfoDisplay;
import org.main_components.main_pane_displays.MainPaneDisplay;

public class ClassDisplay extends MainPaneDisplay implements DynamicInfoDisplay
{
	private static final long serialVersionUID = -6528163569575990221L;

	private Classroom classroom;
	
	public ClassDisplay(Classroom c)
	{
		classroom = c;
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
