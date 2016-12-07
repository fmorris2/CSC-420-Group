package org.functionality.jtree.node.impl;

import org.functionality.Classroom;
import org.functionality.jtree.node.InfoNode;
import org.main_components.main_pane_displays.info_displays.ClassDisplay;

public class ClassNode extends InfoNode
{
	private static final long serialVersionUID = 8040126114149623196L;
	
	public ClassNode(Classroom classroom)
	{
		super(classroom.getName(), new ClassDisplay(classroom));
	}

}
