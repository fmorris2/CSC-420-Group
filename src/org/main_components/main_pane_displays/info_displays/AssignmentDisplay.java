package org.main_components.main_pane_displays.info_displays;

import org.functionality.Assignment;
import org.main_components.main_pane_displays.DynamicInfoDisplay;
import org.main_components.main_pane_displays.MainPaneDisplay;

public class AssignmentDisplay extends MainPaneDisplay implements DynamicInfoDisplay
{
	private static final long serialVersionUID = 4009042997141522798L;

	private Assignment assignment;
	
	public AssignmentDisplay(Assignment a)
	{
		assignment = a;
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
