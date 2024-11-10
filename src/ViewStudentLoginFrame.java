import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * This class is a GUI class that creates a login frame for students.
 * 
 * @author Lovesh 
 */

public class ViewStudentLoginFrame extends JFrame  {

    JLabel usernameLabel, passwordLabel, loginheadLabel;
    JTextField usernameTF;
    JPasswordField passwordF;
    JButton loginBtn, btnGoBackSL;
    JPanel panelLoginStd, panelLoginStd2;

    /**
     * It's a constructor that creates the GUI components for a student login page.
     */
    public ViewStudentLoginFrame() {
        this.setTitle("Student Login Frame");
        this.setSize(900, 609);
        this.setLayout(null);
        this.setResizable(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // JLabel
        loginheadLabel = new JLabel("STUDENT LOGIN PAGE", SwingConstants.CENTER);
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

        usernameTF = new JTextField();
        usernameTF.setFont(new Font("Arial", Font.PLAIN, 15));
        usernameTF.setBounds(300, 170, 320, 30);

        this.add(usernameLabel);
        this.add(usernameTF);

        passwordLabel = new JLabel("Password");
        passwordLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        passwordLabel.setForeground(Color.black);
        passwordLabel.setBounds(196, 200, 280, 100);

        passwordF = new JPasswordField();
        passwordF.setFont(new Font("Arial", Font.PLAIN, 15));
        passwordF.setBounds(300, 235, 320, 30);

        this.add(passwordLabel);
        this.add(passwordF);

        loginBtn = new JButton("Login");
        loginBtn.setFont(new Font("Arial", Font.PLAIN, 15));
        loginBtn.setBounds(520, 350, 100, 30);
        this.add(loginBtn);

        btnGoBackSL = new JButton("Back");
        btnGoBackSL.setFont(new Font("Arial", Font.PLAIN, 15));
        btnGoBackSL.setBounds(520, 400, 100, 30);
        this.add(btnGoBackSL);


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

    void addGoBackBtnListener (ActionListener listenerForGoBackButton){
        btnGoBackSL.addActionListener(listenerForGoBackButton);
    }


    // Main method that creates a new instance of the ViewStudentLoginFrame class.
    public static void main(String[] args) {
        new ViewStudentLoginFrame();
    }


            
            
        
}
