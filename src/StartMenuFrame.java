import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * This class is a JFrame for the main programs frame that contains a JLabel, a JComboBox and an ActionListener
 * 
 * @author Lovesh 
 */ 
public class StartMenuFrame extends JFrame implements ActionListener {
    JLabel labelSm1, labelSm2;
    JComboBox<String> comboBox;
    /**
    * The constructor of the class.
    */
    StartMenuFrame() {
        this.setTitle("User Selection Frame");
        this.setSize(800, 400);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        labelSm1 = new JLabel("USER SELECTION PAGE");
        labelSm1.setFont(new Font("Arial", Font.BOLD, 40));
        labelSm1.setForeground(Color.BLUE);
        labelSm1.setBounds(160, 15, 700, 50);
        this.add(labelSm1);

        labelSm2 = new JLabel("Select A User Role");
        labelSm2.setFont(new Font("Arial", Font.PLAIN, 28));
        labelSm2.setForeground(Color.BLACK);
        labelSm2.setBounds(280, 120, 700, 50);
        this.add(labelSm2);

        String[] userRoles = { "Admin", "Lecturer", "Student" };
        comboBox = new JComboBox<>(userRoles);
        comboBox.setBounds(340, 170, 120, 30);
        comboBox.addActionListener(this);
        this.add(comboBox);

        this.setVisible(true);

    }

  /**
   * The main method of the class. It is the entry point of the program.
   * It creates a new StartMenuFrame object
   */

    public static void main(String[] args) {
        new StartMenuFrame();
    }

    /**
     * If the user selects "Admin" from the dropdown menu, the AdminMenuFrame is displayed. If the user
     * selects "Student" from the dropdown menu, the MVCStudentLogin is displayed.
     * 
     * 
     * @param e the event object
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if (comboBox.getSelectedItem().equals("Admin")) {
            AdminMVCLogin.main(null);
            setVisible(false);
            
        } else if (comboBox.getSelectedItem().equals("Student")) {
            MVCStudentLogin.main(null);
            setVisible(false);
        }
        else if (comboBox.getSelectedItem().equals("Lecturer")) {
            LecturerLoginMVC.main(null);
            setVisible(false);
        }

    }
}
