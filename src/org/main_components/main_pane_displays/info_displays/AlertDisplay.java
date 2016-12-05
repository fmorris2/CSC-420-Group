package org.main_components.main_pane_displays.info_displays;

import java.awt.Font;

import javax.swing.JLabel;

import org.main_components.main_pane_displays.MainPaneDisplay;

public class AlertDisplay extends MainPaneDisplay
{
	private static final long serialVersionUID = -9014299627013426773L;
	private static final Font FONT =  new Font("Serif", Font.BOLD, 24);

	@Override
	protected void addComponents()
	{
		JLabel labelOne = new JLabel("ALERTS");
		labelOne.setFont(FONT);
		labelOne.setHorizontalAlignment(JLabel.CENTER);
		
		add(labelOne, "span");
	}

}
