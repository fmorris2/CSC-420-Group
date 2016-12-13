package org.main_components;
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import org.main_components.main_pane_displays.HomeDisplay;
import org.main_components.main_pane_displays.MainPaneDisplay;

import net.miginfocom.swing.MigLayout;

public class MainPane extends JPanel
{
	private static final long serialVersionUID = 3316843144278038556L;
	
	private MainPaneDisplay home = new HomeDisplay();
	
	private JPanel currentDisplay;
	
	public MainPane()
	{
		currentDisplay = home;
		home.init();
		setLayout(new MigLayout("fill", "-1[grow, fill]", ""));
		setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
		add(currentDisplay, "grow");
	}
	
	public void setDisplay(JPanel p)
	{	
		if(p instanceof MainPaneDisplay && !((MainPaneDisplay)p).hasAddedComponents())
			((MainPaneDisplay)p).init();
		
		remove(currentDisplay);
		repaint();
		currentDisplay = p == null ? new JPanel() : p;
		add(currentDisplay, "grow");
		revalidate();
	}
}
