package org.main_components.main_pane_displays.info_displays;

import java.awt.Font;

import javax.swing.JLabel;

import org.main_components.main_pane_displays.MainPaneDisplay;

public class HelpDisplay extends MainPaneDisplay
{
	public HelpDisplay() {
	}
	private static final long serialVersionUID = 2507460209069385990L;
	private static final Font FONT =  new Font("Serif", Font.PLAIN, 14);

	@Override
	protected void addComponents()
	{
		JLabel label1 = new JLabel("<html><h1>Help</h1>"
				+ "<p>Welcome to the Teacher Edition. In this application you can create and organize classes of students and assign work to those classes.</p>"
				+ "<br>"
				+ "<br>"
				+ "<p>Create:</p>"
				+ "<br>"
				+ "<p>&nbsp;&nbsp;To create a new Class, Student, or Assignemnt</p>"
				+ "<br>"
				+ "<p>&nbsp;&nbsp;&nbsp;&nbsp;Click 'Add Item' -> 'Class/Student/Assignemnt' -> Fill in all fields</p>"
				+ "<br>"
				+ "<p>Organize:</p>"
				+ "<br>"
				+ "<p>&nbsp;&nbsp;The list on the left side of the screen contains list of all Classes, Students, and Assignments. "
				+ "To navigate, either double click on the section you would like to open/close or click that section's arrow.</p></html>");
		label1.setFont(FONT);
		label1.setHorizontalAlignment(JLabel.CENTER);

		add(label1, "span");
	}

}
