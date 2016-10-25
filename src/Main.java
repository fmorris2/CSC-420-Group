import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class Main
{
	public static void main(String[] args)
	{
		try
		{
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
			SwingUtilities.invokeLater(() -> {createAndShowGUI();});
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("There was an error loading the GUI");
		}
	}

	private static void createAndShowGUI()
	{
		// Create and set up the window.
		JFrame frame = new TeacherEdition();
		// frame.setPreferredSize(new Dimension(600,600));
		frame.setVisible(true);
	}
}
