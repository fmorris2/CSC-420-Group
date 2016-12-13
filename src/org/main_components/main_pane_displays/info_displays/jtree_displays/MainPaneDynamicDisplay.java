package org.main_components.main_pane_displays.info_displays.jtree_displays;

import javax.swing.JLabel;

import org.main_components.main_pane_displays.MainPaneDisplay;

public abstract class MainPaneDynamicDisplay extends MainPaneDisplay
{
	private static final long serialVersionUID = 7930388170726043482L;

	@Override
	protected void addComponents()
	{
		//Title
		JLabel titleLabel = new JLabel(getHeader());
		titleLabel.setFont(HEADER_FONT);
		titleLabel.setHorizontalAlignment(JLabel.CENTER);
		add(titleLabel, "span");
		
		final String[] INFO = getInfo();
		for(int i = 0; i < INFO.length; i++)
		{
			JLabel label = new JLabel(INFO[i]);
			label.setFont(INFO_FONT);
			label.setHorizontalAlignment(JLabel.CENTER);
			add(label, "span");
		}
	}
	
	public void refresh()
	{
		if(this.hasAddedComponents())
		{
			System.out.println("Refresh!!");
			removeAll();
			addComponents();
			revalidate();
			repaint();
		}
	}
	
	protected abstract String[] getInfo();
	protected abstract String getHeader();

}
