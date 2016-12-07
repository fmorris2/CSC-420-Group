package org.main_components;
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.TreeSelectionModel;

import org.functionality.jtree.InfoListHandler;
import org.functionality.jtree.TreeListener;

import net.miginfocom.swing.MigLayout;

public class InfoList extends JPanel
{
	private static final long serialVersionUID = -6328349686501381045L;
	
	private JScrollPane scrollPane = new JScrollPane();
	private JTree tree;
	private InfoListHandler handler = new InfoListHandler();
	
	public InfoList()
	{		
		tree = new JTree(handler.OVERALL_ROOT);
		tree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
		tree.addTreeSelectionListener(new TreeListener());
		setLayout(new MigLayout("fill", "10[grow, fill]", ""));
		setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
		
		scrollPane.setViewportView(tree);
		add(scrollPane, "grow, width max(200, 50%)");
	}

}
