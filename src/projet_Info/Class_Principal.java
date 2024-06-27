package projet_Info;

import java.awt.CardLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Class_Principal {

    private JFrame frame;
    private JPanel panelContainer;
    private CardLayout cardLayout;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Class_Principal window = new Class_Principal();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public Class_Principal() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        panelContainer = new JPanel();
        panelContainer.setBounds(10, 40, 414, 210);
        frame.getContentPane().add(panelContainer);
        cardLayout = new CardLayout();
        panelContainer.setLayout(cardLayout);

        JMenuBar menuBar = new JMenuBar();
        frame.setJMenuBar(menuBar);

        JMenu mnOptions = new JMenu("Menu");
        menuBar.add(mnOptions);

        JMenuItem mntmOption1 = new JMenuItem("Clent");
        mntmOption1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(panelContainer, "option1");
            }
        });
        mnOptions.add(mntmOption1);

        JMenuItem mntmOption2 = new JMenuItem("Option 2");
        mntmOption2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(panelContainer, "option2");
            }
        });
        mnOptions.add(mntmOption2);

        JMenuItem mntmOption3 = new JMenuItem("Option 3");
        mntmOption3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(panelContainer, "option3");
            }
        });
        mnOptions.add(mntmOption3);

        // Ajoutez vos interfaces spécifiques ici avec un nom pour chaque carte (card)
        JPanel option1Panel = createOption1Interface();
        panelContainer.add(option1Panel, "option1");

        JPanel option2Panel = createOption2Interface();
        panelContainer.add(option2Panel, "option2");

        JPanel option3Panel = createOption3Interface();
        panelContainer.add(option3Panel, "option3");
    }

    // Méthodes pour créer les interfaces spécifiques à chaque option
    private JPanel createOption1Interface() {
        JPanel panel = new JPanel();
        // Ajouter les composants pour Option 1 ici
        return panel;
    }

    private JPanel createOption2Interface() {
        JPanel panel = new JPanel();
        // Ajouter les composants pour Option 2 ici
        return panel;
    }

    private JPanel createOption3Interface() {
        JPanel panel = new JPanel();
        // Ajouter les composants pour Option 3 ici
        return panel;
    }
}
