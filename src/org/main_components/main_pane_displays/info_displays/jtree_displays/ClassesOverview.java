package org.main_components.main_pane_displays.info_displays.jtree_displays;

import org.functionality.generators.ClassroomGenerator;
import org.functionality.jtree.InfoListHandler;
import org.functionality.jtree.node.impl.ClassNode;

public class ClassesOverview extends MainPaneDynamicDisplay
{
	private static final long serialVersionUID = -6821867273410649254L;
	
	@Override
	protected String[] getInfo()
	{
		return new String[]{"Number of classes: " + getNumClasses(), 
				"Average students per class: " + getStudentsPerClass(),
				"Average assignments per class: " + getAssignmentsPerClass()};
	}

	@Override
	protected String getHeader()
	{
		return "Classes Overview";
	}
	
	private int getNumClasses()
	{
		return InfoListHandler.classNodes.size();
	}
	
	private int getStudentsPerClass()
	{
		double students = 0;
		for(ClassNode node : InfoListHandler.classNodes)
			students += node.getClassroom().getStudents().size();
		
		return (int)Math.round(students / getNumClasses());
	}
	
	private int getAssignmentsPerClass()
	{
		double assignments = 0;
		for(ClassNode node : InfoListHandler.classNodes)
			assignments += node.getClassroom().getAssignments().size();
		
		return (int)Math.round(assignments / getNumClasses());
	}
}
