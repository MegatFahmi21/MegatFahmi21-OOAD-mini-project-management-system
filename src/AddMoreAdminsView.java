import java.awt.*;
import javax.swing.*;

/**
 * It's a class that creates a GUI for the user to register a new admin
 * @author Najmuddin
 */
public class AddMoreAdminsView  extends JFrame  {
  private JLabel usernameLabel, passwordLabel, registerLabel, backLabel;
  private JTextField usernameField;
  private JPasswordField passwordField;
  private JButton registerBtn;
  private JButton backBtn;

  // It's a constructor that creates a GUI for the user to register a new admin
  public  AddMoreAdminsView () {
      this.setTitle("Adding More Admins");
      this.setSize(900, 609);
      this.setLayout(null);
      this.setResizable(true);
      this.setLocationRelativeTo(null);
      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      registerLabel = new JLabel("Additional Admin Registration Page", SwingConstants.CENTER);
        registerLabel.setFont(new Font("Arial", Font.BOLD, 28));
        registerLabel.setForeground(Color.red);
        registerLabel.setBounds(0, 0, 900, 100);
        registerLabel.setBackground(Color.black);
        registerLabel.setOpaque(true);

        this.add(registerLabel);

    usernameLabel = new JLabel("Username");
    usernameLabel.setFont(new Font("Arial", Font.PLAIN, 20));
    usernameLabel.setForeground(Color.black);
    usernameLabel.setBounds(196, 150, 180, 70);
    usernameField = new JTextField();
    usernameField.setFont(new Font("Arial", Font.PLAIN, 15));
    usernameField.setBounds(350, 170, 320, 30);

    this.add(usernameLabel);
    this.add(usernameField);

    passwordLabel = new JLabel("Password");
        passwordLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        passwordLabel.setForeground(Color.black);
        passwordLabel.setBounds(196, 200, 280, 100);

        passwordField = new JPasswordField();
        passwordField.setFont(new Font("Arial", Font.PLAIN, 15));
        passwordField.setBounds(350, 235, 320, 30);

        this.add(passwordLabel);
        this.add(passwordField);

        registerBtn = new JButton("Register");
        registerBtn.setFont(new Font("Arial", Font.PLAIN, 15));
        registerBtn.setBounds(320, 450, 100, 30);
       
        this.add(registerBtn);

        backBtn = new JButton("Back");
        backBtn.setFont(new Font("Arial", Font.PLAIN, 15));
        backBtn.setBounds(450, 450, 100, 30);
       
        this.add(backBtn);

        this.setVisible(true);
  }

/**
 * This function returns the usernameField object
 * 
 * @return The usernameField.
 */
  
  public JTextField getUsernameField() {
    return usernameField;
  }
/**
 * It returns the password field
 * 
 * @return The passwordField object.
 */

  public JPasswordField getPasswordField() {
    return passwordField;
  }

  /**
   * This function returns the registerBtn object
   * 
   * @return The registerBtn is being returned.
   */
  public JButton getRegisterBtn() {
    return registerBtn;
  }

  /**
   * This function returns the back button
   * 
   * @return The back button.
   */
  public JButton getBackBtn() {
    return backBtn;
  }
}
