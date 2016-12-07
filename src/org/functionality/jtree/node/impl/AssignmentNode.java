package org.functionality.jtree.node.impl;

import org.functionality.Assignment;
import org.functionality.jtree.node.InfoNode;
import org.main_components.main_pane_displays.info_displays.AssignmentDisplay;

public class AssignmentNode extends InfoNode
{
	private static final long serialVersionUID = -8945514140136857402L;

	public AssignmentNode(Assignment a)
	{
		super(a.getName(), new AssignmentDisplay(a));
	}

}
