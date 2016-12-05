package org.main_components.helpers;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;

public class ButtonWithImage extends JButton
{
	private static final long serialVersionUID = -9094827261492472949L;
	
	private Image original;
	
	public ButtonWithImage(String imageDir)
	{
		try
		{
			setText(" ");
			original = ImageIO.read(new File(imageDir));
			setIcon(new StretchIcon(original));
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
}
