package displays;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;

public class HomeDisplay extends JPanel
{
	private static final long serialVersionUID = -2051404803673569698L;
	private static final Font FONT =  new Font("Serif", Font.BOLD, 24);
	
	public HomeDisplay()
	{
		setLayout(new MigLayout("fill", "10[grow, fill]", ""));
		
		JLabel labelOne = new JLabel("Teacher Edition - Home Screen");
		labelOne.setFont(FONT);
		labelOne.setHorizontalAlignment(JLabel.CENTER);
		
		JLabel labelTwo = new JLabel("Mr. John Doe");
		labelTwo.setFont(FONT);
		labelTwo.setHorizontalAlignment(JLabel.CENTER);
		
		add(labelOne, "wrap, span");
		add(labelTwo, "wrap, span");
		add(new JButton("Classes"));
		add(new JButton("Tasks"));
		add(new JButton("Students"));
	}
}
