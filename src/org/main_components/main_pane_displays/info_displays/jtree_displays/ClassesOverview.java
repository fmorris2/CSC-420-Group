package org.main_components.main_pane_displays.info_displays.jtree_displays;

import java.awt.Font;

import javax.swing.JLabel;

import org.main_components.main_pane_displays.DynamicInfoDisplay;
import org.main_components.main_pane_displays.MainPaneDisplay;

public class ClassesOverview extends MainPaneDisplay implements DynamicInfoDisplay
{
	private static final long serialVersionUID = -6821867273410649254L;
	private static final Font FONT =  new Font("Serif", Font.BOLD, 24);

	@Override
	protected void addComponents()
	{
		JLabel labelOne = new JLabel("CLASSES OVERVIEW");
		labelOne.setFont(FONT);
		labelOne.setHorizontalAlignment(JLabel.CENTER);
		
		add(labelOne, "span");
	}

	@Override
	public void refresh()
	{
	}

}
