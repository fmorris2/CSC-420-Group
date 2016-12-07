package org.functionality.jtree.node.impl;

import org.functionality.Student;
import org.functionality.jtree.node.InfoNode;
import org.main_components.main_pane_displays.info_displays.StudentDisplay;

public class StudentNode extends InfoNode
{
	private static final long serialVersionUID = -7691535147215738376L;

	public StudentNode(Student s)
	{
		super(s.getFirstName() + " " + s.getLastName(), new StudentDisplay(s));
	}

}
