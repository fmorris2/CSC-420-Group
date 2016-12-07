package org.functionality.jtree.node.impl;

import javax.swing.JPanel;

import org.functionality.Assignment;
import org.functionality.Student;
import org.functionality.jtree.node.InfoNode;
import org.main_components.main_pane_displays.info_displays.jtree_displays.StudentDisplay;

public class StudentNode extends InfoNode
{
	private static final long serialVersionUID = -7691535147215738376L;
	
	private Student student;
	private InfoNode incompleteAssignmentsNode;
	private InfoNode lateAssignmentsNode;
	private InfoNode completedAssignmentsNode;
	
	public StudentNode(Student s)
	{
		super(s.getFirstName() + " " + s.getLastName(), new StudentDisplay(s));
		this.student = s;
		incompleteAssignmentsNode = new InfoNode("Incomplete Assignments", new JPanel());
		completedAssignmentsNode = new InfoNode("Completed Assignments", new JPanel());
		lateAssignmentsNode = new InfoNode("Late Assignments", new JPanel());
		
		add(incompleteAssignmentsNode);
		add(completedAssignmentsNode);
		add(lateAssignmentsNode);
	}
	
	public void loadAssignments()
	{
		System.out.println(student.getName() + " has " + student.getIncompleteAssignments().size() + " incomplete assignments");
		for(Assignment a : student.getIncompleteAssignments())
			incompleteAssignmentsNode.add(new AssignmentNode(a));
		
		for(Assignment a : student.getLateAssignments())
			lateAssignmentsNode.add(new AssignmentNode(a));
		
		for(Assignment a: student.getCompletedAssignments())
			completedAssignmentsNode.add(new AssignmentNode(a));
	}
	
	public Student getStudent()
	{
		return student;
	}

}
