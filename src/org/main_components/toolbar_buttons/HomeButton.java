package org.main_components.toolbar_buttons;

import java.awt.event.ActionEvent;

import javax.swing.JButton;

import org.TeacherEdition;
import org.main_components.main_pane_displays.HomeDisplay;

public class HomeButton extends JButton
{
	private static final long serialVersionUID = 4388966742559661724L;
	private static final String IMAGE_PATH = "pics/home.png";
	
	public HomeButton()
	{
		super("Home");
		addActionListener((ActionEvent e) -> actionListener(e));
	}
	
	private void actionListener(ActionEvent e)
	{
		TeacherEdition.changeMainDisplay(new HomeDisplay());
	}
	
}
