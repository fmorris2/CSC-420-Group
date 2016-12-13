package org.main_components.main_pane_displays.info_displays.jtree_displays;

import org.functionality.jtree.InfoListHandler;
import org.functionality.jtree.node.impl.StudentNode;

public class StudentsOverview extends MainPaneDynamicDisplay
{
	private static final long serialVersionUID = -7330451733493834930L;

	@Override
	protected String[] getInfo()
	{
		return new String[]{
				"Number of students: " + getNumStudents(),
				"Average incomplete assignments per student: " + getIncompletePerStudent(),
				"Average complete assignments per student: " + getCompletePerStudent(),
				"Average late assignments per student: " + getLatePerStudent()};
	}

	@Override
	protected String getHeader()
	{
		return "Students Overview";
	}
	
	private int getNumStudents()
	{
		return InfoListHandler.studentNodes.size();
	}
	
	private int getIncompletePerStudent()
	{
		double inc = 0;
		for(StudentNode node : InfoListHandler.studentNodes)
			inc += node.getStudent().getIncompleteAssignments().size();
		
		return (int)Math.round(inc / getNumStudents());
	}
	
	private int getCompletePerStudent()
	{
		double comp = 0;
		for(StudentNode node : InfoListHandler.studentNodes)
			comp += node.getStudent().getCompletedAssignments().size();
		
		return (int)Math.round(comp / getNumStudents());
	}
	
	private int getLatePerStudent()
	{
		double late = 0;
		for(StudentNode node : InfoListHandler.studentNodes)
			late += node.getStudent().getLateAssignments().size();
		
		return (int)Math.round(late / getNumStudents());
	}

}
