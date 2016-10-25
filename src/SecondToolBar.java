import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

import helpers.ButtonWithImage;
import net.miginfocom.swing.MigLayout;

public class SecondToolBar extends JPanel
{
	private static final long serialVersionUID = -7437140489601558366L;
	private static final String HOME_BUTTON_PATH = "pics/home.png";

	public SecondToolBar()
	{
		setLayout(new MigLayout("fill", "-1[grow, fill]", ""));
		setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
		
		add(new ButtonWithImage(HOME_BUTTON_PATH));
		add(new JButton("Social Studies"));
		add(new JButton("Students"));
		add(new JButton("Noah Pierce"));
		add(new JButton("Missing Assignments"));
	}
}
