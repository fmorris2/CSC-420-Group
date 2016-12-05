package org.main_components.main_pane_displays.info_displays;

import java.awt.Font;

import javax.swing.JLabel;

import org.main_components.main_pane_displays.MainPaneDisplay;

public class HelpDisplay extends MainPaneDisplay
{
	private static final long serialVersionUID = 2507460209069385990L;
	private static final Font FONT =  new Font("Serif", Font.BOLD, 24);

	@Override
	protected void addComponents()
	{
		JLabel labelOne = new JLabel("HELP SCREEN");
		labelOne.setFont(FONT);
		labelOne.setHorizontalAlignment(JLabel.CENTER);
		
		add(labelOne, "span");
	}

}
