package org.main_components.toolbar_buttons;

import org.TeacherEdition;
import org.main_components.helpers.ButtonWithImage;
import org.main_components.main_pane_displays.info_displays.SettingsDisplay;

public class SettingsButton extends ButtonWithImage
{
	private static final long serialVersionUID = -3815260226980654650L;
	private static final String SETTINGS_ICON_PATH = "pics/gearIcon.png";

	public SettingsButton()
	{
		super(SETTINGS_ICON_PATH);
		addActionListener((e) -> TeacherEdition.changeMainDisplay(new SettingsDisplay()));
	}
}
