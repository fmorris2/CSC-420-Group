package org.functionality.jtree.node.impl;

import org.functionality.Assignment;
import org.functionality.jtree.node.InfoNode;
import org.main_components.main_pane_displays.info_displays.jtree_displays.AssignmentDisplay;

public class AssignmentNode extends InfoNode
{
	private static final long serialVersionUID = -8945514140136857402L;
	
	private Assignment assignment;
	
	public AssignmentNode(Assignment a)
	{
		super(a.getName(), new AssignmentDisplay(a));
		this.assignment = a;
	}

	public Assignment getAssignment()
	{
		return assignment;
	}
}
