package org.main_components.main_pane_displays.info_displays;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

import org.main_components.main_pane_displays.MainPaneDisplay;

public class SettingsDisplay extends MainPaneDisplay
{
	public SettingsDisplay() {}
	private static final long serialVersionUID = -1089625993780803796L;
	
	private static String email = "email@email.com";
	private static String phone = "555-555-5555";
	
	private JLabel emailLabel;
	private JLabel phoneLabel;
	
	private JTextField emailField;
	private JTextField phoneField;
	
	private JButton submitE;
	private JButton submitP;
	
	private JCheckBox notif_E;//Email notifications
	private JCheckBox notif_P;//Phone notifications
	private JCheckBox notif_D;//Notifications about assignments being due
	private JCheckBox notif_L;//Notifications about assignments being turned in late
	
	@Override
	protected void addComponents()
	{
		JLabel labelOne = new JLabel("SETTINGS");
		labelOne.setFont(MainPaneDisplay.HEADER_FONT);
		labelOne.setHorizontalAlignment(JLabel.CENTER);

		emailLabel = new JLabel("Email Address: " + email);
		emailLabel.setFont(INFO_FONT);

		notif_E = new JCheckBox("Recieve email notifications?");
		notif_E.setSelected(true);
		notif_E.setFont(MainPaneDisplay.MINOR_FONT);
		
		emailField = new JTextField();
		emailField.setPreferredSize(new Dimension(200, 0));
		emailField.setFont(MainPaneDisplay.MINOR_FONT);
		
		submitE = new JButton("Change Email");
		submitE.setFont(MainPaneDisplay.MINOR_FONT);
		submitE.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(emailField.getText().contains("@") && (emailField.getText().contains(".com") || emailField.getText().contains(".edu"))) {
					email = emailField.getText();
					emailField.setText("");
					emailLabel.setText("Email Address: " + email);
					repaint();
				}
			}
		});
		
		phoneLabel = new JLabel("Phone Number: " + phone);
		phoneLabel.setFont(INFO_FONT);
		
		notif_P = new JCheckBox("Recieve phone notifications?");
		notif_P.setFont(MainPaneDisplay.MINOR_FONT);
		
		phoneField = new JTextField();
		phoneField.setFont(MainPaneDisplay.MINOR_FONT);
		phoneField.setPreferredSize(new Dimension(200, 0));
		
		submitP = new JButton("Change Phone");
		submitP.setFont(MainPaneDisplay.MINOR_FONT);
		submitP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(phoneField.getText().contains("-")) {
					phone = phoneField.getText();
					phoneField.setText("");
					phoneLabel.setText("Phone Number: " + phone);
					repaint();
				}
			}
		});
			
		
		notif_D= new JCheckBox("Recieve notifications about due assignments?");
		notif_D.setFont(MainPaneDisplay.MINOR_FONT);
		
		notif_L= new JCheckBox("Recieve notifications about late assignments?");
		notif_L.setFont(MainPaneDisplay.MINOR_FONT);
		notif_L.setSelected(true);

		add(labelOne, "span, wrap");
		add(emailLabel, "wrap");
		add(notif_E, "wrap");
		add(emailField, "wrap");
		add(submitE, "wrap");
		add(phoneLabel, "wrap");
		add(notif_P, "wrap");
		add(phoneField, "wrap");
		add(submitP, "wrap");
		add(notif_D, "");
		add(notif_L, "");
	}

}
