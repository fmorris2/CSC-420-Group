package org.main_components.main_pane_displays;

import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;

public abstract class MainPaneDisplay extends JPanel
{
	private static final long serialVersionUID = 4534675547376113541L;
	
	public MainPaneDisplay()
	{
		setLayout(new MigLayout("fill", "10[grow, fill]", ""));
		addComponents();
	}
	
	protected abstract void addComponents();
}
