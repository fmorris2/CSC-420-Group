package org.main_components.main_pane_displays.info_displays;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.main_components.main_pane_displays.MainPaneDisplay;

import net.miginfocom.swing.MigLayout;

public class SettingsDisplay extends MainPaneDisplay
{
	public SettingsDisplay() {}
	private static final long serialVersionUID = -1089625993780803796L;
	private static final Font FONT =  new Font("Serif", Font.PLAIN, 14);
	
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
		JPanel pane = new JPanel();
		pane.setLayout(new MigLayout("", "[][]","[][][][][][][]"));
		
		JLabel labelOne = new JLabel("SETTINGS:");
		labelOne.setFont(new Font("Serif", Font.BOLD, 24));
		labelOne.setHorizontalAlignment(JLabel.CENTER);

		emailLabel = new JLabel("Email Address: " + email);
		emailLabel.setFont(FONT);

		notif_E = new JCheckBox("Recieve email notifications?");
		notif_E.setSelected(true);
		
		emailField = new JTextField();
		emailField.setPreferredSize(new Dimension(200, 0));
		
		submitE = new JButton("Change Email");
		submitE.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(emailField.getText().contains("@") && (emailField.getText().contains(".com") || emailField.getText().contains(".edu"))) {
					email = emailField.getText();
					emailField.setText("");
					emailLabel.setText("Email Address: " + email);
				}
			}
		});
		
		phoneLabel = new JLabel("Phone Number: " + phone);
		phoneLabel.setFont(FONT);
		
		notif_P = new JCheckBox("Recieve phone notifications?");
		
		phoneField = new JTextField();
		phoneField.setPreferredSize(new Dimension(200, 0));
		
		submitP = new JButton("Change Phone");
		submitP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(phoneField.getText().contains("-")) {
					phone = phoneField.getText();
					phoneField.setText("");
					phoneLabel.setText("Phone Number: " + phone);
				}
			}
		});
			
		
		notif_D= new JCheckBox("Recieve about due assignments?");
		
		notif_L= new JCheckBox("Recieve about late assignments?");
		notif_L.setSelected(true);

		pane.add(labelOne, "cell 0 0 2 1");
		pane.add(emailLabel, "cell 0 1");
		pane.add(notif_E, "cell 1 1");
		pane.add(emailField, "cell 0 2");
		pane.add(submitE, "cell 1 2");
		pane.add(phoneLabel, "cell 0 3");
		pane.add(notif_P, "cell 1 3");
		pane.add(phoneField, "cell 0 4");
		pane.add(submitP, "cell 1 4");
		pane.add(notif_D, "cell 0 5");
		pane.add(notif_L, "cell 0 6");
		
		add(pane, "span");
	}

}
