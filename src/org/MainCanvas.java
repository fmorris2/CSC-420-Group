package org;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;

public class MainCanvas extends JPanel 
{
	private static final long serialVersionUID = 5733242319703543762L;
	
	JPanel mainPanel;
    JPanel listPanel;
    JPanel toolBarPanel;
    JPanel explorerBarMainPanel;
    JPanel explorerBarListPanel;
    JButton plusButton;
    JButton helpButton;
    JButton settingsButton;
    JButton homeButton;

    public MainCanvas() 
    {
        JPanel base = new JPanel(new MigLayout(
                "",
                "[fill][fill]",
                "[fill][fill]"
        ));

        //Component panels
        mainPanel = new JPanel(new MigLayout(
                "",
                "[]",
                "[][]"
        ));
        //mainPanel.setPreferredSize(new Dimension(400, 400));
        mainPanel.setVisible(true);
        mainPanel.setBackground(new Color(164, 211, 238));

        explorerBarMainPanel = new JPanel();
        explorerBarMainPanel.setVisible(true);
        explorerBarMainPanel.setBackground(Color.MAGENTA);

        //List panel components
        listPanel = new JPanel(new MigLayout());
        listPanel.setVisible(true);
        listPanel.setBackground(Color.green);

        explorerBarListPanel = new JPanel();
        explorerBarListPanel.setVisible(true);
        explorerBarListPanel.setBackground(Color.orange);

        toolBarPanel = new JPanel(new MigLayout(
                "",
                "[][200:300:400][][]",
                "[]"
        ));
        toolBarPanel.setVisible(true);
        toolBarPanel.setBackground(Color.red);

        plusButton = new JButton("+");
        plusButton.setPreferredSize(new Dimension(30,30));

        //Add components to base
        add(base);
        base.add(toolBarPanel, "dock north, span, grow, height 40:30:100, width 50:600:1000");
        base.add(listPanel, "dock west, span, grow, height 100:570:700, width 50:100:200");
        base.add(mainPanel, "span, grow, height 100:570:700, width 400:500:700");

        //Add components to toolbar
        toolBarPanel.add(plusButton);

        //Add components to main panel
        mainPanel.add(explorerBarMainPanel, "dock north, span, wrap, width 400:500:700, height 40:30:100");

        //Add components to list panel
        listPanel.add(explorerBarListPanel, "dock north, span, wrap, height 10:25:100, width 50:100:200");


    }
}