package org.main_components.main_pane_displays;

import java.awt.Font;

import javax.swing.JLabel;

public class HomeDisplay extends MainPaneDisplay
{
	private static final long serialVersionUID = -2051404803673569698L;
	private static final Font FONT =  new Font("Serif", Font.BOLD, 24);
	
	@Override
	protected void addComponents()
	{
		JLabel labelOne = new JLabel("Teacher Edition - Home Screen");
		labelOne.setFont(FONT);
		labelOne.setHorizontalAlignment(JLabel.CENTER);
		
		JLabel labelTwo = new JLabel("Mr. John Doe");
		labelTwo.setFont(FONT);
		labelTwo.setHorizontalAlignment(JLabel.CENTER);
		
		add(labelOne, "wrap, span");
		add(labelTwo, "wrap, span");
		
		/*
		add(new JButton("Classes"));
		add(new JButton("Tasks"));
		add(new JButton("Students"));
		*/
	}
	

}
