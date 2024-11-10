import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


/**
 * This class is a GUI class that allows the admin to edit a project.
 * it extends the JFrame class 
 * 
 * @author Lovesh 
 */

public class ViewAdminEditProject extends JFrame {
    JLabel epADHEAD, ePID, ePNAME, ePDESC, ePSPEC, ePSTATUS;
    JTextField eidTF, enameTF;
    JTextArea edescTF;
    JComboBox<String> eSpec;
    JRadioButton epjActivatedStatus, epjDeactivatedStatus;
    JButton btnEditProjectAD, btnGoBackAD, btnSearchEPAD;
    JPanel panelEditPAD;
    ButtonGroup adeGroup;

 

    /**
     * The constructor of the class with the necessary GUI components defined 
     */

    public ViewAdminEditProject() {
        this.setTitle("Admin Edit Project");
        this.setSize(890, 800);
        this.setResizable(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panelEditAD = new JPanel(null);
        panelEditAD.setBackground(Color.CYAN);

        // JLabel
        epADHEAD = new JLabel("EDIT A PROJECT", SwingConstants.CENTER);
        epADHEAD.setFont(new Font("Arial", Font.BOLD, 28));
        epADHEAD.setForeground(Color.red);
        epADHEAD.setBounds(0, 0, 890, 105);
        epADHEAD.setBackground(Color.black);
        epADHEAD.setOpaque(true);
        panelEditAD.add(epADHEAD);

        ePID = new JLabel("Project ID                 :");
        ePID.setFont(new Font("Arial", Font.PLAIN, 20));
        ePID.setForeground(Color.black);
        ePID.setBounds(134, 100, 900, 100);
        panelEditAD.add(ePID);

        eidTF = new JTextField();
        eidTF.setFont(new Font("Arial", Font.PLAIN, 15));
        eidTF.setBounds(340, 134, 300, 30);
        panelEditAD.add(eidTF);

        ePNAME = new JLabel("Project Name            :");
        ePNAME.setFont(new Font("Arial", Font.PLAIN, 20));
        ePNAME.setForeground(Color.black);
        ePNAME.setBounds(134, 180, 900, 100);
        panelEditAD.add(ePNAME);

        enameTF = new JTextField();
        enameTF.setFont(new Font("Arial", Font.PLAIN, 15));
        enameTF.setBounds(340, 215, 300, 30);
        panelEditAD.add(enameTF);

        ePDESC = new JLabel("Project Description    :");
        ePDESC.setFont(new Font("Arial", Font.PLAIN, 20));
        ePDESC.setForeground(Color.black);
        ePDESC.setBounds(134, 260, 900, 100);
        panelEditAD.add(ePDESC);


        edescTF = new JTextArea();
        edescTF.setFont(new Font("Arial", Font.PLAIN, 15));
        edescTF.setBounds(340, 296, 300, 120);
        edescTF.setLineWrap(true);
        panelEditAD.add(edescTF);

      
        
       

        ePSPEC = new JLabel("Project Specialisation :");
        ePSPEC.setFont(new Font("Arial", Font.PLAIN, 20));
        ePSPEC.setForeground(Color.black);
        ePSPEC.setBounds(134, 425, 900, 100);
        panelEditAD.add(ePSPEC);

        String[] adeSpecial = { "Cybersecurity", "Data Science", "Software Engineering", "Game Development" };
        eSpec = new JComboBox<>(adeSpecial);
        eSpec.setBounds(340, 460, 300, 30);
        panelEditAD.add(eSpec);

        btnEditProjectAD = new JButton("EDIT");
        btnEditProjectAD.setFont(new Font("Arial", Font.PLAIN, 15));
        btnEditProjectAD.setBounds(520, 670, 100, 30);

        panelEditAD.add(btnEditProjectAD);

        btnGoBackAD = new JButton("BACK");
        btnGoBackAD.setFont(new Font("Arial", Font.PLAIN, 15));
        btnGoBackAD.setBounds(640, 670, 100, 30);

        panelEditAD.add(btnGoBackAD);

        btnSearchEPAD = new JButton("SEARCH");
        btnSearchEPAD.setFont(new Font("Arial", Font.PLAIN, 15));
        btnSearchEPAD.setBounds(760, 670, 100, 30);

        panelEditAD.add(btnSearchEPAD);

        ePSTATUS = new JLabel("Project Status            :");
        ePSTATUS.setFont(new Font("Arial", Font.PLAIN, 20));
        ePSTATUS.setForeground(Color.black);
        ePSTATUS.setBounds(134, 510, 900, 100);
        panelEditAD.add(ePSTATUS);

        epjActivatedStatus = new JRadioButton("Activated");
        epjActivatedStatus.setFont(new Font("Arial", Font.PLAIN, 15));
        epjActivatedStatus.setBackground(Color.cyan);
        epjActivatedStatus.setBounds(340, 545, 100, 30);

        epjDeactivatedStatus = new JRadioButton("Deactivated");
        epjDeactivatedStatus.setFont(new Font("Arial", Font.PLAIN, 15));
        epjDeactivatedStatus.setBackground(Color.cyan);
        epjDeactivatedStatus.setBounds(525, 545, 120, 30);

        adeGroup = new ButtonGroup();
        adeGroup.add(epjActivatedStatus);
        adeGroup.add(epjDeactivatedStatus);

        panelEditAD.add(epjActivatedStatus);
        panelEditAD.add(epjDeactivatedStatus);

        this.add(panelEditAD);
        this.setVisible(true);
    }

    /**
     * Main method that creates a new instance of the ViewAdminEditProject class.
     */
    public static void main(String[] args) {
        new ViewAdminEditProject();
    }

        // ActionListener
    /**
     * This function adds an action listener to the edit project button
     * 
     * @param listenerForEditProjectButton This is the ActionListener that will be added to the button.
     */

    void addEditProjectListener(ActionListener listenerForEditProjectButton) {
        btnEditProjectAD.addActionListener(listenerForEditProjectButton);
    }

    /**
     * This function adds an action listener to the go back button.
     * 
     * @param listenerForGoBackButton This is the action listener that will be added to the button.
     */
    void addGoBackBtnListener(ActionListener listenerForGoBackButton) {
        btnGoBackAD.addActionListener(listenerForGoBackButton);
    }

    /**
     * This function adds an action listener to the search EAP button.
     * 
     * @param listenerForSearchEAPButton This is the action listener that will be added to the button.
     */
    void addSearchEAPBtnListener(ActionListener listenerForSearchEAPButton) {
        btnSearchEPAD.addActionListener(listenerForSearchEAPButton);
    }

    
}