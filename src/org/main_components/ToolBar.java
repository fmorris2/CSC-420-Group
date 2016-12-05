package org.main_components;
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;

import org.main_components.toolbar_buttons.AddButton;
import org.main_components.toolbar_buttons.AlertButton;
import org.main_components.toolbar_buttons.HelpButton;
import org.main_components.toolbar_buttons.HomeButton;
import org.main_components.toolbar_buttons.SettingsButton;


public class ToolBar extends JPanel
{
	private static final long serialVersionUID = -2774364211932299911L;
	
	private JButton homeButton = new HomeButton();
	private JButton addButton = new AddButton();
	private JButton alertButton = new AlertButton();
	private JButton helpButton = new HelpButton();
	private JButton settingsButton = new SettingsButton();
	private JLabel textField = new JLabel("Welcome Mr. Doe, today is Tuesday October 25, 2016");
	
	public ToolBar()
	{
		setLayout(new MigLayout("fill", "-1[grow, fill]", ""));
		setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
		
		add(homeButton);
		add(addButton);
		add(alertButton);
		textField.setHorizontalAlignment(JLabel.CENTER);
		add(textField, "width max(100, 30%)");
		add(helpButton);	
		add(settingsButton);
	}
}
