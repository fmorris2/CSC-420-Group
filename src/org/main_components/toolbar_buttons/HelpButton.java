package org.main_components.toolbar_buttons;

import javax.swing.JButton;

import org.TeacherEdition;
import org.main_components.main_pane_displays.info_displays.HelpDisplay;

public class HelpButton extends JButton
{
	private static final long serialVersionUID = -5107534670138722042L;
	
	public HelpButton()	
	{
		super("Help");
		addActionListener((e) -> TeacherEdition.changeMainDisplay(new HelpDisplay()));
	}

}
