package org.main_components.toolbar_buttons;

import java.awt.event.ActionEvent;

import org.TeacherEdition;
import org.main_components.helpers.ButtonWithImage;
import org.main_components.main_pane_displays.HomeDisplay;

public class HomeButton extends ButtonWithImage
{
	private static final long serialVersionUID = 4388966742559661724L;
	private static final String IMAGE_PATH = "pics/home.png";
	
	public HomeButton()
	{
		super(IMAGE_PATH);
		addActionListener((ActionEvent e) -> actionListener(e));
	}
	
	private void actionListener(ActionEvent e)
	{
		TeacherEdition.changeMainDisplay(new HomeDisplay());
	}
	
}
