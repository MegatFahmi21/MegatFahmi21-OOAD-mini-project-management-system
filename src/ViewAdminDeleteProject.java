import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


/**
 * This class is a GUI class for the admin to delete a project.
 * @author Lovesh 
 */
public class ViewAdminDeleteProject extends JFrame {
    JLabel dpADHEAD, dPID;
    JTextField didTF;
    JButton btnDeleteProjectAD,btnGoBackAD;
    JPanel panelDeletePAD;
   

  /**
    * The constructor of the class.
    * Creating a GUI for the user to delete a project.
    */
    
    public ViewAdminDeleteProject() {
        this.setTitle("Admin Edit Project");
        this.setSize(890, 400);
        this.setResizable(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panelDeletePAD = new JPanel(null);
        panelDeletePAD.setBackground(Color.CYAN);

        // JLabel
        dpADHEAD = new JLabel("DELETE A PROJECT", SwingConstants.CENTER);
        dpADHEAD.setFont(new Font("Arial", Font.BOLD, 28));
        dpADHEAD.setForeground(Color.red);
        dpADHEAD.setBounds(0, 0, 890, 105);
        dpADHEAD.setBackground(Color.black);
        dpADHEAD.setOpaque(true);
        panelDeletePAD.add(dpADHEAD);

        dPID = new JLabel("Project ID                 :");
        dPID.setFont(new Font("Arial", Font.PLAIN, 20));
        dPID.setForeground(Color.black);
        dPID.setBounds(134, 100, 900, 100);
        panelDeletePAD.add(dPID);

        didTF = new JTextField();
        didTF.setFont(new Font("Arial", Font.PLAIN, 15));
        didTF.setBounds(340, 134, 300, 30);
        panelDeletePAD.add(didTF);

        btnDeleteProjectAD = new JButton("DELETE");
        btnDeleteProjectAD.setFont(new Font("Arial", Font.PLAIN, 15));
        btnDeleteProjectAD.setBounds(520, 300, 100, 30);

        panelDeletePAD.add(btnDeleteProjectAD);

        btnGoBackAD = new JButton("BACK");
        btnGoBackAD.setFont(new Font("Arial", Font.PLAIN, 15));
        btnGoBackAD.setBounds(640, 300, 100, 30);

        panelDeletePAD.add(btnGoBackAD);

        this.add(panelDeletePAD);
        this.setVisible(true);
    }

  
    /**
     * Main method which creates a new instance of the ViewAdminDeleteProject class.
     */
    public static void main(String[] args) {
        new ViewAdminDeleteProject();
    }

    // ActionListener
    /**
     * This function adds an action listener to the delete project button
     * 
     * @param listenerForDeleteProjectButton This is the ActionListener that will be added to the button.
     */

    void addDeleteProjectListener(ActionListener listenerForDeleteProjectButton) {
        btnDeleteProjectAD.addActionListener(listenerForDeleteProjectButton);
    }
    /**
     * This function adds an action listener to the go back button.
     * 
     * @param listenerForGoBackButton This is the action listener that will be added to the button.
     */
    void addGoBackBtnListener(ActionListener listenerForGoBackButton) {
        btnGoBackAD.addActionListener(listenerForGoBackButton);
    }

   

    
}
