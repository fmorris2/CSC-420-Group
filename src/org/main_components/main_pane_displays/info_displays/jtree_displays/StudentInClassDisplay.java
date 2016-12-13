package org.main_components.main_pane_displays.info_displays.jtree_displays;

import org.functionality.Assignment;
import org.functionality.Classroom;
import org.functionality.Student;

public class StudentInClassDisplay extends MainPaneDynamicDisplay
{
	private static final long serialVersionUID = 6572889490347849148L;

	private Student student;
	private Classroom classroom;
	
	public StudentInClassDisplay(Student s, Classroom c)
	{
		student = s;
		classroom = c;
	}

	@Override
	protected String[] getInfo()
	{
		final int TOTAL = classroom.getAssignments().size();
		final int COMPLETE = getNumCompleteAssignments();
		final int INCOMPLETE = TOTAL - COMPLETE;
		final int LATE = getNumLateAssignments();
		
		return new String[]{
				"Total assignments: " + TOTAL,
				"Complete assignments: " + COMPLETE,
				"Incomplete assignments: " + INCOMPLETE,
				"Late assignments: " + LATE};
	}

	@Override
	protected String getHeader()
	{
		return student.getName() + " - " + classroom.getName();
	}
	
	private int getNumCompleteAssignments()
	{
		int num = 0;
		for(Assignment a : classroom.getAssignments())
			for(Assignment o : student.getCompletedAssignments())
				if(a.equals(o))
				{
					num++;
					break;
				}
		
		return num;
	}
	
	private int getNumLateAssignments()
	{
		int num = 0;
		for(Assignment a : classroom.getAssignments())
			for(Assignment o : student.getLateAssignments())
				if(a.equals(o))
				{
					num++;
					break;
				}
		
		return num;
	}
}
