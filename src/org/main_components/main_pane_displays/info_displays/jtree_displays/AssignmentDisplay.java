package org.main_components.main_pane_displays.info_displays.jtree_displays;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

import org.functionality.Assignment;
import org.main_components.main_pane_displays.DynamicInfoDisplay;

import net.miginfocom.swing.MigLayout;

public class AssignmentDisplay extends JPanel implements DynamicInfoDisplay
{
	private static final long serialVersionUID = 4009042997141522798L;
	private static final Font FONT =  new Font("Serif", Font.BOLD, 24);
	
	private Assignment assignment;
	
	public AssignmentDisplay(Assignment a)
	{
		assignment = a;
		setLayout(new MigLayout("fill", "10[grow, fill]", ""));
		addComponents();
	}
	
	protected void addComponents()
	{
		JLabel labelOne = new JLabel("DYNAMIC DISPLAY FOR ASSIGNMENT: " + assignment.getName());
		labelOne.setFont(FONT);
		labelOne.setHorizontalAlignment(JLabel.CENTER);
		
		add(labelOne, "span");
	}

	@Override
	public void refresh()
	{
	}

}
