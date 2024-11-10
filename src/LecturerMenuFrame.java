import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * The Lecturer Menu page 
 * @author Syamil
 */
public class LecturerMenuFrame extends JFrame implements ActionListener {
    JPanel panel1, panel2;
    JLabel header;
    JButton btnAddProject;
    JButton btnViewProject;
    JButton btnEditProject;
    JButton btnAssignStudent;

    /**
     * Constructor for LecturerMenuFrame class
     */
    public LecturerMenuFrame() {
        this.setTitle("Lecturer Main Menu");
        this.setSize(600, 709);
        this.setLayout(new BorderLayout());
        this.setResizable(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel1 = new JPanel();
        panel1.setLayout(new BorderLayout());
        panel1.setBackground(Color.black);
        panel1.setPreferredSize(new Dimension(100, 49));

        header = new JLabel("LECTURER PAGE", SwingConstants.CENTER);
        header.setFont(new Font("Arial", Font.BOLD, 28));
        header.setForeground(Color.red);
        panel1.add(header, BorderLayout.NORTH);

        panel2 = new JPanel();
        panel2.setLayout((new GridLayout(7, 7, 0, 40)));
        panel2.setBackground(Color.GRAY);
        panel2.setPreferredSize(new Dimension(0, 325));

        btnAddProject = new JButton("ADD PROJECTS");
        btnAddProject.setFont(new Font("Arial", Font.PLAIN, 18));
        btnAddProject.addActionListener(this);
        panel2.add(btnAddProject);

        btnViewProject = new JButton("VIEW PROJECTS");
        btnViewProject.setFont(new Font("Arial", Font.PLAIN, 18));
        btnViewProject.addActionListener(this);
        panel2.add(btnViewProject);

        btnEditProject = new JButton("EDIT PROJECTS");
        btnEditProject.setFont(new Font("Arial", Font.PLAIN, 18));
        btnEditProject.addActionListener(this);
        panel2.add(btnEditProject);

        btnAssignStudent = new JButton("ASSIGN PROJECT TO STUDENT");
        btnAssignStudent.setFont(new Font("Arial", Font.PLAIN, 18));
        btnAssignStudent.addActionListener(this);
        panel2.add(btnAssignStudent);

        this.add(panel1, BorderLayout.NORTH);
        this.add(panel2, BorderLayout.CENTER);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new LecturerMenuFrame();
    }

    /**
     * User will be redirect to different page based on the button clicked
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        this.setVisible(false);
        if (e.getSource() == btnAddProject) {
            LecturerAddProjectMVC addProjectPage;
            addProjectPage = new LecturerAddProjectMVC();
            
        }
        else if (e.getSource() == btnViewProject) {
            LecturerViewProject.main(null);
        }
        else if (e.getSource() == btnEditProject) {
            LecturerEditProjectMVC editProjectPage;
            editProjectPage = new LecturerEditProjectMVC();
            
        }
        else if (e.getSource() == btnAssignStudent){
            AssignProjectMVC.main(null);
        }

    }

}
