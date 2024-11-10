import java.awt.event.*;
import java.io.FileNotFoundException;
import javax.swing.JOptionPane;

/**
 * @author Megat 
 * Controller for Admin Login page
 */
public class AdminLoginController {
    private AdminViewLoginFrame theAdminView;
    private AdminModel theAdminModel;

    /**
     * @param theAdminView  gui for login
     * @param theAdminModel logic for login
     */
    public AdminLoginController(AdminViewLoginFrame theAdminView, AdminModel theAdminModel) {
        this.theAdminView = theAdminView;
        this.theAdminModel = theAdminModel;

        this.theAdminView.addLoginBtnListener(new LoginListener());
    }

    
    /**
     * It's a listener class that listens for the login button to be pressed. If the login button is
     * pressed, it will check if the username and password are correct. If they are correct, it will
     * open a new frame.
     * 
     */
    class LoginListener implements ActionListener {
        /**
         *  Checking if the login button is pressed. If it is pressed, it will check if the username and
         *  password are correct. If they are correct, it will open a new frame.
         */
        @Override
       
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == theAdminView.loginBtn) {
                try {
                    if (theAdminModel.verifyLogin(theAdminView.usernameField.getText(),
                            new String(theAdminView.passwordField.getPassword()))) {
                        JOptionPane.showMessageDialog(null, "Login Successfull!");
                        
                        theAdminView.setVisible(false);
                       
                        new AdminMenuFrame();

                    } else {
                        JOptionPane.showMessageDialog(null, "Invalid username or password");
                    }
                } catch (FileNotFoundException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }

            }

        }

    }

}
