package org.main_components.main_pane_displays.info_displays.jtree_displays;

import org.functionality.Classroom;

public class ClassDisplay extends MainPaneDynamicDisplay
{
	private static final long serialVersionUID = -6528163569575990221L;

	private Classroom classroom;
	
	public ClassDisplay(Classroom c)
	{
		classroom = c;
	}

	@Override
	protected String[] getInfo()
	{
		return new String[]{};
	}

	@Override
	protected String getHeader()
	{
		return classroom.getName();
	}
}
