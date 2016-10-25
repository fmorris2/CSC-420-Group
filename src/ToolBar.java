import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;

public class ToolBar extends JPanel
{
	private static final long serialVersionUID = -2774364211932299911L;
	private static final String SETTINGS_ICON_PATH = "pics/gearIcon.png";
	
	public ToolBar()
	{
		setLayout(new MigLayout("fill", "-1[grow, fill]", ""));
		setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
		add(new JButton("+"));
		add(new JButton("?"));
		add(new JTextField("Teacher Info"), "width max(100, 80%)");
		add(new JButton("?"));
		add(new ButtonWithImage(SETTINGS_ICON_PATH));
	}
}
