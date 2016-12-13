package org.main_components.main_pane_displays.info_displays.jtree_displays;

import java.text.DecimalFormat;

import org.functionality.Student;

public class StudentDisplay extends MainPaneDynamicDisplay
{
	private static final long serialVersionUID = -2464804348911959743L;
	
	private Student student;
	
	public StudentDisplay(Student s)
	{
		student = s;
	}

	@Override
	protected String[] getInfo()
	{
		final double COMPLETE = student.getCompletedAssignments().size();
		final double INCOMPLETE = student.getIncompleteAssignments().size();
		final double LATE = student.getLateAssignments().size();
		final int TOTAL = (int)(COMPLETE + INCOMPLETE);
		final DecimalFormat DF = new DecimalFormat("#.#");
		final double INCOMPLETE_PERC = (INCOMPLETE / TOTAL) * 100;
		
		return new String[]{
				"Number of classes: " + student.getClasses().size(),
				"Total assignments: " + TOTAL,
				"Complete assignments: " + (int)COMPLETE + " (" + DF.format((COMPLETE / TOTAL) * 100) + "%)",
				"Incomplete assignments: " + (int)INCOMPLETE + " (" + DF.format(INCOMPLETE_PERC) + "%)",
				"Late assignments: " + (int)LATE};
	}

	@Override
	protected String getHeader()
	{
		return student.getName();
	}
}
