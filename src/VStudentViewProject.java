import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * This class is a GUI class that allows the student to view a project
 * 
 * @author Lovesh 
 */


public class VStudentViewProject extends JFrame {
    JLabel vpSTDHEAD, vPID, vPNAME, vPDESC, vPSPEC, vPSTATUS, vPLECTID, vPSTDID;
    JTextField vidTF, vnameTF, vSIDTF, vLIDTF;
    JTextArea vdescTF;
    JComboBox<String> vSpec;
    JRadioButton vpjActivatedStatus, vpjDeactivatedStatus;
    JButton btnGoBackVSTD, btnVPSTD;
    JPanel panelViewPSTD;
    ButtonGroup stdvGroup;

 

    /**
     * The constructor of the class with the necessary GUI components defined 
     */

    public VStudentViewProject() {
        this.setTitle("Student View Project");
        this.setSize(890, 950);
        this.setResizable(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panelViewPSTD = new JPanel(null);
        panelViewPSTD.setBackground(Color.CYAN);

        // JLabel
        vpSTDHEAD = new JLabel("VIEW OFFERED PROJECT", SwingConstants.CENTER);
        vpSTDHEAD.setFont(new Font("Arial", Font.BOLD, 28));
        vpSTDHEAD.setForeground(Color.red);
        vpSTDHEAD.setBounds(0, 0, 890, 105);
        vpSTDHEAD.setBackground(Color.black);
        vpSTDHEAD.setOpaque(true);
        panelViewPSTD.add(vpSTDHEAD);

        vPSTDID = new JLabel("Student ID                 :");
        vPSTDID.setFont(new Font("Arial", Font.PLAIN, 20));
        vPSTDID.setForeground(Color.black);
        vPSTDID.setBounds(134, 100, 900, 100);
        panelViewPSTD.add(vPSTDID);

        vSIDTF = new JTextField();
        vSIDTF.setFont(new Font("Arial", Font.PLAIN, 15));
        vSIDTF.setBounds(340, 134, 300, 30);
        panelViewPSTD.add(vSIDTF);

        vPID = new JLabel("Project ID                 :");
        vPID.setFont(new Font("Arial", Font.PLAIN, 20));
        vPID.setForeground(Color.black);
        vPID.setBounds(134, 175, 900, 100);
        panelViewPSTD.add(vPID);

        vidTF = new JTextField();
        vidTF.setFont(new Font("Arial", Font.PLAIN, 15));
        vidTF.setBounds(340, 210, 300, 30);
        panelViewPSTD.add(vidTF);

        vPNAME = new JLabel("Project Name            :");
        vPNAME.setFont(new Font("Arial", Font.PLAIN, 20));
        vPNAME.setForeground(Color.black);
        vPNAME.setBounds(134, 250, 900, 100);
        panelViewPSTD.add(vPNAME);

        vnameTF = new JTextField();
        vnameTF.setFont(new Font("Arial", Font.PLAIN, 15));
        vnameTF.setBounds(340, 285, 300, 30);
        panelViewPSTD.add(vnameTF);

        vPDESC = new JLabel("Project Description    :");
        vPDESC.setFont(new Font("Arial", Font.PLAIN, 20));
        vPDESC.setForeground(Color.black);
        vPDESC.setBounds(134, 345, 900, 100);
        panelViewPSTD.add(vPDESC);


        vdescTF = new JTextArea();
        vdescTF.setFont(new Font("Arial", Font.PLAIN, 15));
        vdescTF.setBounds(340, 380, 300, 120);
        vdescTF.setLineWrap(true);
        panelViewPSTD.add(vdescTF);

      
        
       

        vPSPEC = new JLabel("Project Specialisation :");
        vPSPEC.setFont(new Font("Arial", Font.PLAIN, 20));
        vPSPEC.setForeground(Color.black);
        vPSPEC.setBounds(134, 515, 900, 100);
        panelViewPSTD.add(vPSPEC);

        String[] vpSpecial = { "Cybersecurity", "Data Science", "Software Engineering", "Game Development" };
        vSpec = new JComboBox<>(vpSpecial);
        vSpec.setBounds(340, 550, 300, 30);
        panelViewPSTD.add(vSpec);

        btnGoBackVSTD = new JButton("BACK");
        btnGoBackVSTD.setFont(new Font("Arial", Font.PLAIN, 15));
        btnGoBackVSTD.setBounds(640, 800, 100, 30);

        panelViewPSTD.add(btnGoBackVSTD);

        btnVPSTD = new JButton("VIEW");
        btnVPSTD.setFont(new Font("Arial", Font.PLAIN, 15));
        btnVPSTD.setBounds(760, 800, 100, 30);

        panelViewPSTD.add(btnVPSTD);

        vPSTATUS = new JLabel("Project Status            :");
        vPSTATUS.setFont(new Font("Arial", Font.PLAIN, 20));
        vPSTATUS.setForeground(Color.black);
        vPSTATUS.setBounds(134, 600, 900, 100);
        panelViewPSTD.add(vPSTATUS);

        vpjActivatedStatus = new JRadioButton("Activated");
        vpjActivatedStatus.setFont(new Font("Arial", Font.PLAIN, 15));
        vpjActivatedStatus.setBackground(Color.cyan);
        vpjActivatedStatus.setBounds(340, 635, 100, 30);

        vpjDeactivatedStatus = new JRadioButton("Deactivated");
        vpjDeactivatedStatus.setFont(new Font("Arial", Font.PLAIN, 15));
        vpjDeactivatedStatus.setBackground(Color.cyan);
        vpjDeactivatedStatus.setBounds(525, 635, 120, 30);

        stdvGroup = new ButtonGroup();
        stdvGroup.add(vpjActivatedStatus);
        stdvGroup.add(vpjDeactivatedStatus);

        panelViewPSTD.add(vpjActivatedStatus);
        panelViewPSTD.add(vpjDeactivatedStatus);

        vPLECTID = new JLabel("Lecturer ID                 :");
        vPLECTID.setFont(new Font("Arial", Font.PLAIN, 20));
        vPLECTID.setForeground(Color.black);
        vPLECTID.setBounds(134, 670, 900, 100);
        panelViewPSTD.add(vPLECTID);

        vLIDTF = new JTextField();
        vLIDTF.setFont(new Font("Arial", Font.PLAIN, 15));
        vLIDTF.setBounds(340, 705, 300, 30);
        panelViewPSTD.add(vLIDTF);

        this.add(panelViewPSTD);
        this.setVisible(true);
    }

    /**
     * Main method that creates a new instance of the VStudentViewProject class.
     */
    public static void main(String[] args) {
        new VStudentViewProject();
    }

 
    /**
     * This function adds an action listener to the go back button.
     * 
     * @param listenerForGoBackButton This is the action listener that will be added to the button.
     */
    void addGoBackBtnListener(ActionListener listenerForGoBackButton) {
        btnGoBackVSTD.addActionListener(listenerForGoBackButton);
    }

    /**
     * This function adds an action listener to the view project button.
     * 
     * @param listenerForViewSPButton This is the action listener that will be added to the button.
     */
    void addVSPBtnListener(ActionListener listenerForViewSPButton) {
        btnVPSTD.addActionListener(listenerForViewSPButton);
    }

    
}