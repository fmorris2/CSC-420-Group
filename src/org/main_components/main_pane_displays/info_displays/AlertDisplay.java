package org.main_components.main_pane_displays.info_displays;

import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import org.main_components.main_pane_displays.MainPaneDisplay;

import net.miginfocom.swing.MigLayout;

public class AlertDisplay extends MainPaneDisplay
{
	ArrayList<AlertPanel> alerts = new ArrayList<AlertPanel>();
	JPanel listContainer;
	
	public AlertDisplay() {}
	
	private static final long serialVersionUID = -9014299627013426773L;

	@Override
	protected void addComponents()
	{
		this.setLayout(new MigLayout("", "[]", "[]"));
		this.setPreferredSize(new Dimension(700, 700));
		this.setMinimumSize(new Dimension(80, 200));
		alerts = makeAlertsList();
		listContainer = new JPanel();
		listContainer.setLayout(new BoxLayout(listContainer, BoxLayout.Y_AXIS));
		for(AlertPanel a: alerts) {
			listContainer.add(a);
		}
		
		add(new JScrollPane(listContainer), "span");
	}
	
	private ArrayList<AlertPanel> makeAlertsList() {
		ArrayList<AlertPanel> list = new ArrayList<AlertPanel>();
		list.add(new AlertPanel("Math Assignment 1 due. 4 assignments not turned in.","12/10/16 11:00AM"));
		list.add(new AlertPanel("Kelsi Parham turned Math Assignment 1 in late.","12/10/16 12:00PM"));
		list.add(new AlertPanel("Jonas Ivy turned Math Assignment 1 in late.","12/10/16 1:00PM"));
		list.add(new AlertPanel("Noel Finn turned Math Assignment 1 in late.","12/10/16 2:30PM"));
		list.add(new AlertPanel("Science Assignment 2 due. 7 assignments not turned in.","12/11/16 8:00AM"));
		list.add(new AlertPanel("Nita Baggett turned Science Assignment 2 homework in late.","12/11/16 9:00AM"));
		list.add(new AlertPanel("Daryl Mathews turned Science Assignment 2 homework in late.","12/11/16 9:01AM"));
		list.add(new AlertPanel("Ethyl Dewitt turned Science Assignment 2 homework in late.","12/11/16 9:01AM"));
		list.add(new AlertPanel("Ara Weldon turned Science Assignment 2 homework in late.","12/11/16 9:01AM"));
		list.add(new AlertPanel("Chia Kirby turned Science Assignment 2 homework in late.","12/11/16 9:02AM"));
		list.add(new AlertPanel("Liz Castro turned Science Assignment 2 homework in late.","12/11/16 9:02AM"));
		list.add(new AlertPanel("Tona Doyle turned Science Assignment 2 homework in late.","12/11/16 9:02AM"));
		return list;
	}
}
