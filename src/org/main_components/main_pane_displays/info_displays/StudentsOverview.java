package org.main_components.main_pane_displays.info_displays;

import java.awt.Font;

import javax.swing.JLabel;

import org.main_components.main_pane_displays.DynamicInfoDisplay;
import org.main_components.main_pane_displays.MainPaneDisplay;

public class StudentsOverview extends MainPaneDisplay implements DynamicInfoDisplay
{
	private static final long serialVersionUID = -7330451733493834930L;
	private static final Font FONT =  new Font("Serif", Font.BOLD, 24);

	@Override
	protected void addComponents()
	{
		JLabel labelOne = new JLabel("STUDENTS OVERVIEW");
		labelOne.setFont(FONT);
		labelOne.setHorizontalAlignment(JLabel.CENTER);
		
		add(labelOne, "span");
	}

	@Override
	public void refresh()
	{
	}

}
