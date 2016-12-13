package org.main_components.main_pane_displays;

import java.awt.Font;

import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;

public abstract class MainPaneDisplay extends JPanel
{
	private static final long serialVersionUID = 4534675547376113541L;
	public static final Font HEADER_FONT = new Font("Segoe UI", Font.BOLD, 32);
	public static final Font INFO_FONT = new Font("Segoe UI", Font.BOLD, 18);
	public static final Font MINOR_FONT = new Font("Segoe UI", Font.PLAIN, 13);
	
	private boolean addedComponents;
	
	public MainPaneDisplay()
	{
		setLayout(new MigLayout("fill", "10[grow, fill]", ""));
	}
	
	protected abstract void addComponents();
	
	public void init()
	{
		addComponents();
		addedComponents = true;
	}
	
	public boolean hasAddedComponents()
	{
		return addedComponents;
	}
}
