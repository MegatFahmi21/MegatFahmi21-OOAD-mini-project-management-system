import java.awt.*;
import javax.swing.*;

/**
 * It's a GUI class that creates a registration page for students.
 * 
 * @author Megat 
 */
public class StudentRegistrationView extends JFrame  {
  private JLabel usernameLabel, passwordLabel, idLabel, specialLabel, registerLabel, backLabel;
  private JTextField usernameField;
  private JPasswordField passwordField;
  private JTextField idField;
  private JTextField specialField;
  private JComboBox<String> specialComBox;
  private JButton registerBtn;
  private JButton backBtn;
  private JPanel panelRegisterStd, panelRegisterStd2;

  public  StudentRegistrationView() {
      this.setTitle("Student Registration");
      this.setSize(900, 609);
      this.setLayout(null);
      this.setResizable(true);
      this.setLocationRelativeTo(null);
      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      registerLabel = new JLabel("Student Registration Page", SwingConstants.CENTER);
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

        idLabel = new JLabel("ID");
        idLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        idLabel.setForeground(Color.black);
        idLabel.setBounds(196, 250, 380, 100);

        idField = new JTextField();
        idField.setFont(new Font("Arial", Font.PLAIN, 15));
        idField.setBounds(350, 285, 320, 30);

        this.add(idLabel);
        this.add(idField);

        specialLabel = new JLabel("Specialization");
        specialLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        specialLabel.setForeground(Color.black);
        specialLabel.setBounds(196, 270, 480, 160);
        this.add(specialLabel);

        String[] specialList = { "Cybersecurity", "Data Science", "Software Engineering", "Game Development" };
        specialComBox = new JComboBox<>(specialList);
        specialComBox.setBounds(350, 335, 320, 30);
        this.add(specialComBox);


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

  public JTextField getUsernameField() {
    return usernameField;
  }

  public JPasswordField getPasswordField() {
    return passwordField;
  }

  public JTextField getIdField() {
    return idField;
  }

  public JComboBox<String> getSpecialComboBox() {
    return specialComBox;
  }

  public JButton getRegisterBtn() {
    return registerBtn;
  }

  public JButton getBackBtn() {
    return backBtn;
  }
}
