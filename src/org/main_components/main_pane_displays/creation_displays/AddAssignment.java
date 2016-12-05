package org.main_components.main_pane_displays.creation_displays;

import java.awt.Font;

import javax.swing.JLabel;

import org.main_components.main_pane_displays.MainPaneDisplay;

public class AddAssignment extends MainPaneDisplay
{
	private static final long serialVersionUID = 1318874985175193927L;
	private static final Font FONT =  new Font("Serif", Font.BOLD, 24);

	@Override
	protected void addComponents()
	{
		JLabel labelOne = new JLabel("ADD ASSIGNMENT");
		labelOne.setFont(FONT);
		labelOne.setHorizontalAlignment(JLabel.CENTER);
		
		add(labelOne, "span");
	}

}
