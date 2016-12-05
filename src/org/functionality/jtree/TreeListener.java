package org.functionality.jtree;

import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;

import org.TeacherEdition;
import org.functionality.jtree.node.InfoNode;
import org.main_components.main_pane_displays.DynamicInfoDisplay;

public class TreeListener implements TreeSelectionListener
{
	
	@Override
	public void valueChanged(TreeSelectionEvent e)
	{
		InfoNode node = (InfoNode)e.getPath().getLastPathComponent();
	
		/* if nothing is selected */ 
		if (node == null) return;
		
		/* retrieve the appropriate display for the node that was selected */ 
		System.out.println(node);
		if(node.getDisplay() instanceof DynamicInfoDisplay)
			((DynamicInfoDisplay)(node.getDisplay())).refresh();
		
		TeacherEdition.changeMainDisplay(node.getDisplay());
		
	}
}
