package org.main_components.main_pane_displays.info_displays.jtree_displays;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

import org.functionality.Classroom;
import org.main_components.main_pane_displays.DynamicInfoDisplay;

import net.miginfocom.swing.MigLayout;

public class AssignmentsInClassOverview extends JPanel implements DynamicInfoDisplay
{
	private static final long serialVersionUID = -4306809118719837120L;
	private static final Font FONT =  new Font("Serif", Font.BOLD, 24);
	
	private Classroom classroom;
	
	public AssignmentsInClassOverview(Classroom c)
	{
		classroom = c;
		setLayout(new MigLayout("fill", "10[grow, fill]", ""));
		addComponents();
	}
	
	protected void addComponents()
	{
		JLabel labelOne = new JLabel("ASSIGNMENTS IN CLASS OVERVIEW FOR: " + classroom.getName());
		labelOne.setFont(FONT);
		labelOne.setHorizontalAlignment(JLabel.CENTER);
		
		add(labelOne, "span");
	}

	@Override
	public void refresh()
	{
		
	}

}
