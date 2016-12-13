package org.main_components.main_pane_displays.info_displays.jtree_displays;

import java.text.DecimalFormat;
import java.time.format.DateTimeFormatter;

import org.functionality.Assignment;
import org.functionality.jtree.InfoListHandler;
import org.functionality.jtree.node.impl.StudentNode;

public class AssignmentDisplay extends MainPaneDynamicDisplay
{
	private static final long serialVersionUID = 4009042997141522798L;
	
	private Assignment assignment;
	
	public AssignmentDisplay(Assignment a)
	{
		assignment = a;
	}

	@Override
	protected String[] getInfo()
	{
		final double COMPLETE = getNumComplete();
		final double INCOMPLETE = getNumIncomplete();
		final double TOTAL = COMPLETE + INCOMPLETE;
		final DecimalFormat DF = new DecimalFormat("#.#");
		final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("MM-dd-yyyy");
		
		return new String[]{
				"Description: " + assignment.getDescription(),
				"Due date: " + DATE_FORMAT.format(assignment.getDueDate()),
				"Students complete: " + DF.format((COMPLETE / TOTAL) * 100) + "%",
				"Students incomplete: " + DF.format((INCOMPLETE / TOTAL) * 100) + "%",
				};
	}

	@Override
	protected String getHeader()
	{
		return assignment.getName();
	}
	
	private int getNumComplete()
	{
		int num = 0;
		for(StudentNode s : InfoListHandler.studentNodes)
			for(Assignment a : s.getStudent().getCompletedAssignments())
				if(a.equals(assignment))
					num++;
		
		return num;
	}
	
	private int getNumIncomplete()
	{
		int num = 0;
		for(StudentNode s : InfoListHandler.studentNodes)
			for(Assignment a : s.getStudent().getIncompleteAssignments())
				if(a.equals(assignment))
					num++;
		
		return num;
	}

}
