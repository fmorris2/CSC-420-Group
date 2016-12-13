package org.functionality.jtree.node;

import javax.swing.JPanel;
import javax.swing.tree.DefaultMutableTreeNode;

public class InfoNode extends DefaultMutableTreeNode
{
	private static final long serialVersionUID = -6467809171498560817L;
	
	protected JPanel display;
	protected String name;
	
	public InfoNode(String name, JPanel display)
	{
		super(name);
		this.name = name;
		this.display = display;
	}
	
	public InfoNode(String name)
	{
		super(name);
		this.name = name;
	}
	
	public JPanel getDisplay()
	{
		return display;
	}
	
	public void setDisplay(JPanel display)
	{
		this.display = display;
	}
	
	public String toString()
	{
		return name;
	}
}
