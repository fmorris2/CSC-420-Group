package org.main_components;
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JTree;
import javax.swing.tree.TreeSelectionModel;

import net.miginfocom.swing.MigLayout;

import org.functionality.jtree.InfoListHandler;
import org.functionality.jtree.TreeListener;

public class InfoList extends JPanel
{
	private static final long serialVersionUID = -6328349686501381045L;
	
	private JTree tree;
	private InfoListHandler handler = new InfoListHandler(null, null, null);
	
	public InfoList()
	{
	
		/*
		 * THIS IS TREE INFO JUST FOR AN EXAMPLE FOR THE PRESENTATION
		 * HORRIBLY BRUTE FORCED WAY TO DO IT, WILL BE COMPLETELY DIFFERENT
		 * WHEN THE REAL SYSTEM IS IMPLEMENTED
		 
        DefaultMutableTreeNode root = new DefaultMutableTreeNode("Classes");
        DefaultMutableTreeNode mathNode = new DefaultMutableTreeNode("Math");
        DefaultMutableTreeNode studentNode = new DefaultMutableTreeNode("Students");
        DefaultMutableTreeNode currentAssNode = new DefaultMutableTreeNode("Current Assignments");
        DefaultMutableTreeNode pastDueAssNode = new DefaultMutableTreeNode("Past Due Assignments");
        DefaultMutableTreeNode studentNode1 = new DefaultMutableTreeNode("Students");
        DefaultMutableTreeNode currentAssNode1 = new DefaultMutableTreeNode("Current Assignments");
        DefaultMutableTreeNode pastDueAssNode1 = new DefaultMutableTreeNode("Past Due Assignments");
        DefaultMutableTreeNode ssNode = new DefaultMutableTreeNode("Social Studies");
		
        mathNode.add(studentNode);
        mathNode.add(currentAssNode);
        mathNode.add(pastDueAssNode);
        
        ssNode.add(studentNode1);
        ssNode.add(currentAssNode1);
        ssNode.add(pastDueAssNode1);
        
        root.add(mathNode);
        root.add(ssNode);
		
        //END EXAMPLE TREE
		*/
		
		tree = new JTree(handler.OVERALL_ROOT);
		tree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
		tree.addTreeSelectionListener(new TreeListener());
		setLayout(new MigLayout("fill", "10[grow, fill]", ""));
		setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
		
		add(tree, "grow, width max(200, 50%)");
	}

}
