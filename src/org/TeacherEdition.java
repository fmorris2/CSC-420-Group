package org;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.main_components.InfoList;
import org.main_components.MainPane;
import org.main_components.ToolBar;

import net.miginfocom.swing.MigLayout;

public class TeacherEdition extends JFrame
{
	private static final long serialVersionUID = -7684843444939271292L;
	
	private JPanel contentPanel;
	private JPanel toolBar = new ToolBar();
	//private JPanel secondToolBar = new BreadcrumbsBar();
	private JPanel infoList = new InfoList();
	private static MainPane mainPane = new MainPane();
	
	public TeacherEdition()
	{	
		setTitle("Teacher Edition");
		setPreferredSize(new Dimension(1200, 750));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Layout, Column, Row constraints
		contentPanel = new JPanel(new MigLayout("fill", "-1[grow,fill]", ""));
		
		contentPanel.add(toolBar, "dock north, wrap");
		//contentPanel.add(secondToolBar, "dock north, wrap");
		contentPanel.add(infoList, "dock west, wmin pref");
		contentPanel.add(mainPane, "grow, width max(500, 50%)");
		
		setContentPane(contentPanel);
		pack();
	}
	
	public static void changeMainDisplay(JPanel d)
	{
		mainPane.setDisplay(d);
	}
}
