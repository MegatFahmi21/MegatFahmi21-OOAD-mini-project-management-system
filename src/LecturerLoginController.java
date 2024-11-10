import java.awt.event.*;
import java.io.FileNotFoundException;
import javax.swing.JOptionPane;

/**
 * Controller for Lecturer Login page
 * @author Ameera
 */
public class LecturerLoginController {
    private LecturerViewLoginFrame theLecturerView;
    private LecturerModel theLecturerModel;

    /**
     * @param theLecturerView  gui for login
     * @param theLecturerModel logic for login
     */
    public LecturerLoginController(LecturerViewLoginFrame theLecturerView,LecturerModel theLecturerModel) {
        this.theLecturerView = theLecturerView;
        this.theLecturerModel = theLecturerModel;

        this.theLecturerView.addLoginBtnListener(new LoginListener());
    }

    /**
     *Action listener for when the user clicks the login button to login
     */
    class LoginListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == theLecturerView.loginBtn) {
                try {
                    if (theLecturerModel.verifyLogin(theLecturerView.usernameField.getText(),
                            new String(theLecturerView.passwordField.getPassword()))) {
                        JOptionPane.showMessageDialog(null, "Login Successfull!");
                        theLecturerView.setVisible(false);
                        new LecturerMenuFrame();

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
