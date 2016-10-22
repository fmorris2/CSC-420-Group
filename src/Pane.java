

import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;


/**
 * Created by noybo_000 on 10/22/2016.
 *//**
 * Created by noybo_000 on 10/21/2016.
 */
public class Pane extends JPanel {
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

    public Pane() {
        JPanel base = new JPanel(new MigLayout(
                "",
                "[grow][grow]",
                "[grow][grow]"
        ));

        //Component panels
        mainPanel = new JPanel(new MigLayout(
                "",
                "[]",
                "[][]"
        ));
//        mainPanel.setPreferredSize(new Dimension(400, 400));
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
    public static void main(String[] args){
        //Schedule a job for the event-dispatch thread:
        //creating and showing this GUI.
        try {
            // Set cross-platform Java L&F (also called "Metal")
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        }
        catch (UnsupportedLookAndFeelException e) {
            // handle exception
        }
        catch (ClassNotFoundException e) {
            // handle exception
        }
        catch (InstantiationException e) {
            // handle exception
        }
        catch (IllegalAccessException e) {
            // handle exception
        }

        javax.swing.SwingUtilities.invokeLater(new Runnable(){
            public void run(){
                createAndShowGUI();
            }
        });
    }

    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("Teacher Edition");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Create and set up the content pane.
        JPanel newContentPane = new Pane();
        newContentPane.setOpaque(true);
        frame.setContentPane(newContentPane);
//        frame.setPreferredSize(new Dimension(600,600));
        frame.pack();
        frame.setVisible(true);
    }
}