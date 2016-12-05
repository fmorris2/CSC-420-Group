package org.main_components;
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import org.main_components.main_pane_displays.HomeDisplay;

import net.miginfocom.swing.MigLayout;

public class MainPane extends JPanel
{
	private static final long serialVersionUID = 3316843144278038556L;
	
	private JPanel home = new HomeDisplay();
	
	private JPanel currentDisplay;
	
	public MainPane()
	{
		currentDisplay = home;
		setLayout(new MigLayout("fill", "-1[grow, fill]", ""));
		setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
		add(currentDisplay, "grow");
	}
	
	public void setDisplay(JPanel p)
	{
		remove(currentDisplay);
		repaint();
		currentDisplay = p;
		add(p, "grow");
		revalidate();
	}
}
