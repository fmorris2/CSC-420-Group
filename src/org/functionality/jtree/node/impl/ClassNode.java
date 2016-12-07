package org.functionality.jtree.node.impl;

import org.functionality.Classroom;
import org.functionality.jtree.node.InfoNode;
import org.main_components.main_pane_displays.info_displays.AssignmentsInClassOverview;
import org.main_components.main_pane_displays.info_displays.ClassDisplay;
import org.main_components.main_pane_displays.info_displays.StudentsInClassOverview;

public class ClassNode extends InfoNode
{
	private static final long serialVersionUID = 8040126114149623196L;
	
	private InfoNode studentsNode;
	private InfoNode assignmentsNode;
	private Classroom classroom;
	
	public ClassNode(Classroom classroom)
	{
		super(classroom.getName(), new ClassDisplay(classroom));
		this.classroom = classroom;
		studentsNode = new InfoNode("Students", new StudentsInClassOverview(classroom));
		assignmentsNode = new InfoNode("Assignments", new AssignmentsInClassOverview(classroom));
		add(studentsNode);
		add(assignmentsNode);
	}
	
	public InfoNode getStudentsNode()
	{
		return studentsNode;
	}
	
	public InfoNode getAssignments()
	{
		return assignmentsNode;
	}
	
	public Classroom getClassroom()
	{
		return classroom;
	}

}
