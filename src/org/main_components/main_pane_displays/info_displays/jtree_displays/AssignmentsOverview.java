package org.main_components.main_pane_displays.info_displays.jtree_displays;

import org.functionality.jtree.InfoListHandler;
import org.functionality.jtree.node.impl.AssignmentNode;

public class AssignmentsOverview extends MainPaneDynamicDisplay
{
	private static final long serialVersionUID = 3843032058848483990L;

	@Override
	protected String[] getInfo()
	{
		final int TOTAL_ASSIGNMENTS = getTotalAssignments();
		final int PAST_DUE = getTotalPastDueAssignments();
		return new String[]{
				"Total number of assignments: " + TOTAL_ASSIGNMENTS,
				"Total assignments not yet due: " + (TOTAL_ASSIGNMENTS - PAST_DUE),
				"Total assignments past due: " + PAST_DUE};
	}
	
	@Override
	protected String getHeader()
	{
		return "Assignments Overview";
	}
	
	private int getTotalAssignments()
	{
		return InfoListHandler.assignmentNodes.size();
	}
	
	private int getTotalPastDueAssignments()
	{
		int count = 0;
		for(AssignmentNode node : InfoListHandler.assignmentNodes)
			if(node.getAssignment().isPastDue())
				count++;
		
		return count;
	}
}
