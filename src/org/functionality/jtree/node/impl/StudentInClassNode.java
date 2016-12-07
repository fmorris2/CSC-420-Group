package org.functionality.jtree.node.impl;

import org.functionality.Classroom;
import org.functionality.Student;
import org.functionality.jtree.node.InfoNode;
import org.main_components.main_pane_displays.info_displays.StudentInClassDisplay;

public class StudentInClassNode extends InfoNode
{
	private static final long serialVersionUID = 2926941033209273657L;

	public StudentInClassNode(Student s, Classroom c)
	{
		super(s.getName(), new StudentInClassDisplay(s, c));
	}

}
