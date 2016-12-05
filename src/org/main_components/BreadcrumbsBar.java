package org.main_components;
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;

import org.main_components.helpers.ButtonWithImage;

public class BreadcrumbsBar extends JPanel
{
	private static final long serialVersionUID = -7437140489601558366L;
	private static final String HOME_BUTTON_PATH = "pics/home.png";
	
	public BreadcrumbsBar()
	{		
		setLayout(new MigLayout("fill", "-1[grow, fill]", ""));
		setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
		
		add(new ButtonWithImage(HOME_BUTTON_PATH));
	}
}
