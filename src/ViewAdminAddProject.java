import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * This class is a GUI class that allows the admin to add a project
 * 
 * @author Lovesh 
 */
public class ViewAdminAddProject extends JFrame {
    JLabel apADHEAD, aPID, aPNAME, aPDESC, aPSPEC, aPSTATUS;
    JTextField idTF, nameTF;
    JTextArea descTF;
    JComboBox<String> Spec;
    JRadioButton pjActivatedStatus, pjDeactivatedStatus;
    JButton btnAddProjectAD, btnGoBackAD;
    JPanel panelAddPAD;
    ButtonGroup adGroup ;
    

/**
 * 
 *  The constructor of the class. It is called when you create an instance of the class. It has all the components needed to form the GUI
 *  Frame
 * 
 */ 
    public ViewAdminAddProject()
    {   
        this.setTitle("Admin Add Project");
        this.setSize(850,800);
        this.setResizable(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        

        JPanel panelAddPAD = new JPanel(null);
        panelAddPAD.setBackground(Color.CYAN);

        //JLabel
        apADHEAD = new JLabel("ADD A PROJECT", SwingConstants.CENTER);
        apADHEAD.setFont(new Font("Arial", Font.BOLD, 28));
        apADHEAD.setForeground(Color.red);
        apADHEAD.setBounds(0, 0, 890, 105);
        apADHEAD.setBackground(Color.black);
        apADHEAD.setOpaque(true);
        panelAddPAD.add(apADHEAD);
       
        

        aPID = new JLabel("Project ID                 :");
        aPID.setFont(new Font("Arial", Font.PLAIN, 20));
        aPID.setForeground(Color.black);
        aPID.setBounds(134, 100, 900, 100);
        panelAddPAD.add(aPID);

        idTF = new JTextField();
        idTF.setFont(new Font("Arial", Font.PLAIN, 15));
        idTF.setBounds(340, 134, 300, 30);
        panelAddPAD.add(idTF);

        aPNAME = new JLabel("Project Name            :");
        aPNAME.setFont(new Font("Arial", Font.PLAIN, 20));
        aPNAME.setForeground(Color.black);
        aPNAME.setBounds(134, 180, 900, 100);
        panelAddPAD.add(aPNAME);

        nameTF = new JTextField();
        nameTF.setFont(new Font("Arial", Font.PLAIN, 15));
        nameTF.setBounds(340, 215, 300, 30);
        panelAddPAD.add(nameTF);

        aPDESC = new JLabel("Project Description    :");
        aPDESC.setFont(new Font("Arial", Font.PLAIN, 20));
        aPDESC.setForeground(Color.black);
        aPDESC.setBounds(134, 260, 900, 100);
        panelAddPAD.add(aPDESC);

        descTF = new JTextArea();
        descTF.setFont(new Font("Arial", Font.PLAIN, 15));
        descTF.setBounds(340, 296, 300, 120);
        descTF.setLineWrap(true);
        panelAddPAD.add(descTF);

        aPSPEC = new JLabel("Project Specialisation :");
        aPSPEC.setFont(new Font("Arial", Font.PLAIN, 20));
        aPSPEC.setForeground(Color.black);
        aPSPEC.setBounds(134, 425, 900, 100);
        panelAddPAD.add(aPSPEC);


        String[] adSpecial = {"Cybersecurity", "Data Science", "Software Engineering", "Game Development"};
        Spec = new JComboBox<>(adSpecial);
        Spec.setBounds(340, 460, 300, 30);
        panelAddPAD.add(Spec);

        btnAddProjectAD = new JButton("ADD");
        btnAddProjectAD.setFont(new Font("Arial", Font.PLAIN, 15));
        btnAddProjectAD.setBounds(520, 670, 100, 30);

        panelAddPAD.add(btnAddProjectAD);

        btnGoBackAD = new JButton("BACK");
        btnGoBackAD.setFont(new Font("Arial", Font.PLAIN, 15));
        btnGoBackAD.setBounds(640, 670, 100, 30);

        panelAddPAD.add(btnGoBackAD);

        aPSTATUS = new JLabel("Project Status            :");
        aPSTATUS.setFont(new Font("Arial", Font.PLAIN, 20));
        aPSTATUS.setForeground(Color.black);
        aPSTATUS.setBounds(134, 510, 900, 100);
        panelAddPAD.add(aPSTATUS);

        pjActivatedStatus = new JRadioButton("Activated");
        pjActivatedStatus.setFont(new Font("Arial", Font.PLAIN, 15));
        pjActivatedStatus.setBackground(Color.cyan);
        pjActivatedStatus.setBounds(340, 545, 100, 30);
        
        

        pjDeactivatedStatus = new JRadioButton("Deactivated");
        pjDeactivatedStatus.setFont(new Font("Arial", Font.PLAIN, 15));
        pjDeactivatedStatus.setBackground(Color.cyan);
        pjDeactivatedStatus.setBounds(525, 545, 120, 30);
       
        adGroup = new ButtonGroup();
        adGroup.add(pjActivatedStatus);
        adGroup.add(pjDeactivatedStatus);

        panelAddPAD.add(pjActivatedStatus);
        panelAddPAD.add(pjDeactivatedStatus);

        
        this.add(panelAddPAD);
        this.setVisible(true);
    }

    /**
     * It creates a new instance of the ViewAdminAddProject class.
     * 
     * @param args The arguments passed to the program.
     */
    public static void main(String[]args)
    { 
        new ViewAdminAddProject();
    }

    //ActionListener

  /**
   * This function adds an action listener to the add project button.
   * 
   * @param listenerForAddProjectButton This is the ActionListener that will be added to the button.
   */
    void addAddProjectListener (ActionListener listenerForAddProjectButton){
        btnAddProjectAD.addActionListener(listenerForAddProjectButton);
    }
  /**
   * This function adds an action listener to the go back button
   * 
   * @param listenerForGoBackButton The ActionListener that will be added to the button.
   */

    void addGoBackBtnListener (ActionListener listenerForGoBackButton){
        btnGoBackAD.addActionListener(listenerForGoBackButton);
    }

    



    
}

