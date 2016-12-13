package org.main_components.toolbar_buttons;

import javax.swing.JButton;

import org.TeacherEdition;
import org.main_components.main_pane_displays.info_displays.AlertDisplay;

public class AlertButton extends JButton
{
	private static final long serialVersionUID = -949492808662926859L;
	
	public AlertButton()
	{
		super("Alerts (14)");
		addActionListener((e) -> TeacherEdition.changeMainDisplay(new AlertDisplay()));
	}
}
