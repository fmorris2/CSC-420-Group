package org.functionality.jtree;

import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;

import org.TeacherEdition;
import org.functionality.jtree.node.InfoNode;

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
		
		TeacherEdition.changeMainDisplay(node.getDisplay());
		
	}
}
