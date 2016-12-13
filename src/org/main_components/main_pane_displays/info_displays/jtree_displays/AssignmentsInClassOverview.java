package org.main_components.main_pane_displays.info_displays.jtree_displays;

import org.functionality.Assignment;
import org.functionality.Classroom;

public class AssignmentsInClassOverview extends MainPaneDynamicDisplay
{
	private static final long serialVersionUID = -4306809118719837120L;
	
	private Classroom classroom;
	
	public AssignmentsInClassOverview(Classroom c)
	{
		classroom = c;
	}

	@Override
	protected String[] getInfo()
	{
		final int CURRENT = getCurrentAssignments();
		final int TOTAL = classroom.getAssignments().size();
		
		return new String[]{
				"Total assignments: " + TOTAL,
				"Current assignments: " + CURRENT,
				"Past due assignments: " + (TOTAL - CURRENT)};
	}

	@Override
	protected String getHeader()
	{
		return "Assignments Overview for " + classroom.getName();
	}
	
	private int getCurrentAssignments()
	{
		int assignments = 0;
		for(Assignment a : classroom.getAssignments())
			if(!a.isPastDue())
				assignments++;
		
		return assignments;
	}
}
