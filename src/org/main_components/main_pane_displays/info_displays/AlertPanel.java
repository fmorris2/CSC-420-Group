package org.main_components.main_pane_displays.info_displays;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import net.miginfocom.swing.MigLayout;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JLabel;

public class AlertPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	
	String message = "MESSAGE";
	String dateAndTime = "DA/T/E TI:ME";
	JLabel lblDatetime;
	JLabel lblMessage;
	
	public AlertPanel(String m, String dt) {
		this.setLayout(new MigLayout("", "[][]", "[][]"));
		message = m;
		dateAndTime = dt;
		addComponents();
	}
	
	protected void addComponents() {
		setBorder(new LineBorder(new Color(0, 0, 0)));
		this.setPreferredSize(new Dimension(900, 125));
		this.setMinimumSize(new Dimension(50, 125));
		this.setBackground(Color.LIGHT_GRAY);
		lblDatetime = new JLabel(dateAndTime);
		lblDatetime.setFont(new Font("Segoe UI", Font.BOLD, 9));
		lblDatetime.setForeground(Color.GRAY);
		lblMessage = new JLabel(message);
		lblMessage.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblMessage.setForeground(Color.BLACK);
		

		add(lblDatetime, "cell 1 0 1 1");
		add(lblMessage, "cell 0 1 2 1");
	}
}
