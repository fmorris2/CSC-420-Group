package org.main_components.main_pane_displays.info_displays.jtree_displays;

import java.text.DecimalFormat;

import org.functionality.Assignment;
import org.functionality.Classroom;
import org.functionality.Student;

public class StudentsInClassOverview extends MainPaneDynamicDisplay
{
	private static final long serialVersionUID = -8148189815160083892L;

	private Classroom classroom;
	
	public StudentsInClassOverview(Classroom c)
	{
		classroom = c;
	}

	@Override
	protected String[] getInfo()
	{
		final int ON_TIME = getNumAssignments(true);
		final int LATE = getNumAssignments(false);
		DecimalFormat df = new DecimalFormat("#.#");
		final double TOTAL = ON_TIME + LATE;
		
		String onTimeRate;
		if(TOTAL != 0) 
			onTimeRate = df.format(((ON_TIME / TOTAL) * 100)) + "% of assignments were completed on time";
		else
			onTimeRate = "No assignments are due yet";
					
		return new String[]{
				"Students in class: " + classroom.getStudents().size(),
				"Total students with late assignments: " + getNumLateStudents(),
				onTimeRate};
	}

	@Override
	protected String getHeader()
	{
		return "Students Overview for " + classroom.getName();
	}
	
	private int getNumLateStudents()
	{
		int num = 0;
		for(Student student : classroom.getStudents())
		{
			for(Assignment a : classroom.getAssignments())
			{
				if(!a.isPastDue())
					continue;
				if(student.getLateAssignments().contains(a))
				{
					num++;
					break;
				}
			}
		}
		
		return num;
	}
	
	private int getNumAssignments(boolean onTime)
	{
		int assignments = 0;
		for(Student student : classroom.getStudents())
		{
			for(Assignment a : classroom.getAssignments())
			{
				if(!a.isPastDue())
					continue;
				
				if(onTime ? student.getCompletedAssignments().contains(a) : student.getLateAssignments().contains(a))
					assignments++;
			}
		}
		
		return assignments;
	}
}
