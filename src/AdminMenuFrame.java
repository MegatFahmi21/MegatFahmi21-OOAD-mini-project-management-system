import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * This class is a JFrame that implements ActionListener
 * @author Lovesh
 */
public class AdminMenuFrame extends JFrame implements ActionListener {
    JPanel panelAD, panelAD2;
    JLabel labelAD;
    JButton btnAddAdmin;
    JButton btnRegStud;
    JButton btnRegLect;
    JButton btnAddProject;
    JButton btnEditProject;
    JButton btnViewProject;
    JButton btnDelProject;


    /**
     * The constructor of the class.
     */
    public AdminMenuFrame() {
        this.setTitle("Admin Menu Frame");
        this.setSize(600, 709);
        this.setLayout(new BorderLayout());
        this.setResizable(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panelAD = new JPanel();
        panelAD.setLayout(new BorderLayout());
        panelAD.setBackground(Color.black);
        panelAD.setPreferredSize(new Dimension(100, 49));

        labelAD = new JLabel("ADMIN PAGE", SwingConstants.CENTER);
        labelAD.setFont(new Font("Arial", Font.BOLD, 28));
        labelAD.setForeground(Color.red);
        panelAD.add(labelAD, BorderLayout.NORTH);

        panelAD2 = new JPanel();
        panelAD2.setLayout((new GridLayout(7, 7, 0, 40)));
        panelAD2.setBackground(Color.GRAY);
        panelAD2.setPreferredSize(new Dimension(0, 325));

        btnAddAdmin = new JButton("ADD MORE ADMINS");
        btnAddAdmin.setFont(new Font("Arial", Font.PLAIN, 18));
        btnAddAdmin.addActionListener(this);

        panelAD2.add(btnAddAdmin);

        btnRegStud = new JButton("REGISTER STUDENT");
        btnRegStud.setFont(new Font("Arial", Font.PLAIN, 18));
        btnRegStud.addActionListener(this);

        panelAD2.add(btnRegStud);

        btnRegLect = new JButton("REGISTER LECTURER");
        btnRegLect.setFont(new Font("Arial", Font.PLAIN, 18));
        btnRegLect.addActionListener(this);
        panelAD2.add(btnRegLect);

        btnAddProject = new JButton("ADD PROJECT");
        btnAddProject.setFont(new Font("Arial", Font.PLAIN, 18));
        btnAddProject.addActionListener(this);
        panelAD2.add(btnAddProject);

        btnEditProject = new JButton("EDIT PROJECT");
        btnEditProject.setFont(new Font("Arial", Font.PLAIN, 18));
        btnEditProject.addActionListener(this);
        panelAD2.add(btnEditProject);

        btnViewProject = new JButton("VIEW PROJECT");
        btnViewProject.setFont(new Font("Arial", Font.PLAIN, 18));
        btnViewProject.addActionListener(this);
        
        panelAD2.add(btnViewProject);

        btnDelProject = new JButton("DELETE PROJECT");
        btnDelProject.setFont(new Font("Arial", Font.PLAIN, 18));
        btnDelProject.addActionListener(this);
        panelAD2.add(btnDelProject);

        this.add(panelAD, BorderLayout.NORTH);
        this.add(panelAD2, BorderLayout.CENTER);
        this.setVisible(true);
    }

   
    

   /**
    * It creates a new AdminMenuFrame object.
    */
    public static void main(String[] args) {
        new AdminMenuFrame();

    }
    
    /* 
     *  An action listener that listens to the button clicks.
     *
     * (non-Javadoc)
     * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
     */
    @Override

 
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if (e.getSource() == btnAddProject){
            MVCAdminAddProject.main(null);
            
        }
        else if (e.getSource() == btnEditProject){
            MVCAdminEditProject.main(null);
        }
        else if (e.getSource() == btnAddAdmin){
            AddMoreAdminsApplication.main(null);
        }
        else if (e.getSource() == btnRegStud){
            StudentRegistrationApplication.main(null);
        }
        else if (e.getSource() == btnRegLect){
            LecturerRegistrationApplication.main(null);
        }
        else if (e.getSource() == btnViewProject){
            AdminViewProjectMVC.main(null);
        }
        else if (e.getSource() == btnDelProject){
            MVCAdminDeleteProject.main(null);
        }


    }

}
