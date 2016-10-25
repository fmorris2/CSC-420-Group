import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JTree;

import net.miginfocom.swing.MigLayout;

public class InfoList extends JPanel
{
	private static final long serialVersionUID = -6328349686501381045L;
	
	private JTree tree;
	
	public InfoList()
	{
		tree = new JTree();
		setLayout(new MigLayout("fill", "10[grow, fill]", ""));
		setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
		
		add(tree, "grow, width max(150, 50%)");
	}

}
