package org;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

public class Main
{
	public static void main(String[] args)
	{
		try
		{
			// enable anti-aliasing
			System.setProperty("awt.useSystemAAFontSettings","on");
			System.setProperty("swing.aatext", "true");
			
			//print out available LookAndFeels for debugging
			for(LookAndFeelInfo n : UIManager.getInstalledLookAndFeels())
				System.out.println(n.getClassName());
			
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
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
		frame.setVisible(true);
	}
}
