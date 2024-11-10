import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * It's a class that creates a GUI for a lecturer to login.
 * @author Ameera
 */
public class LecturerViewLoginFrame extends JFrame  {

    JLabel usernameLabel, passwordLabel, loginheadLabel;
    JTextField usernameField;
    JPasswordField passwordField;
    JButton loginBtn;
    JPanel panelLoginStd, panelLoginStd2;

    // Creating a GUI for a lecturer to login.
    public LecturerViewLoginFrame() {
        this.setTitle("Lecturer Login Frame");
        this.setSize(900, 609);
        this.setLayout(null);
        this.setResizable(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // JLabel
        loginheadLabel = new JLabel("LECTURER LOGIN PAGE", SwingConstants.CENTER);
        loginheadLabel.setFont(new Font("Arial", Font.BOLD, 28));
        loginheadLabel.setForeground(Color.red);
        loginheadLabel.setBounds(0, 0, 900, 100);
        loginheadLabel.setBackground(Color.black);
        loginheadLabel.setOpaque(true);

        this.add(loginheadLabel);

        usernameLabel = new JLabel("Username");
        usernameLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        usernameLabel.setForeground(Color.black);
        usernameLabel.setBounds(196, 150, 180, 70);

        usernameField = new JTextField();
        usernameField.setFont(new Font("Arial", Font.PLAIN, 15));
        usernameField.setBounds(300, 170, 320, 30);

        this.add(usernameLabel);
        this.add(usernameField);

        passwordLabel = new JLabel("Password");
        passwordLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        passwordLabel.setForeground(Color.black);
        passwordLabel.setBounds(196, 200, 280, 100);

        passwordField = new JPasswordField();
        passwordField.setFont(new Font("Arial", Font.PLAIN, 15));
        passwordField.setBounds(300, 235, 320, 30);

        this.add(passwordLabel);
        this.add(passwordField);

        loginBtn = new JButton("Login");
        loginBtn.setFont(new Font("Arial", Font.PLAIN, 15));
        loginBtn.setBounds(520, 350, 100, 30);
       

        this.add(loginBtn);

        this.setVisible(true);

    }


    /**
     * This function adds an action listener to the login button.
     * 
     * @param listenerForLoginBtn The ActionListener object that will listen for the button click.
     */
    void addLoginBtnListener(ActionListener listenerForLoginBtn){
        loginBtn.addActionListener(listenerForLoginBtn);
    }

    /**
     * The main function of the program.
     */
    public static void main(String[] args) {
        new LecturerViewLoginFrame();
    }
            
            
        
}
