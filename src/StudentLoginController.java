
import java.awt.event.*;
import java.io.FileNotFoundException;
import javax.swing.JOptionPane;

/**
 * It's a controller class that handles the login button of the student login frame
 * 
 * @author Lovesh 
 */
public class StudentLoginController {
    private ViewStudentLoginFrame theStudentView;
    private ModelStudent theStudentModel;

    /**
     * 
     * It's a constructor that takes two parameters, the view and the model. It then adds a listener to
     * the login button.
     * @param theStudentView the view class that contains the GUI components
     * @param theStudentModel the model class that consists of the logic 
     */
    public StudentLoginController(ViewStudentLoginFrame theStudentView, ModelStudent theStudentModel) {
        this.theStudentView = theStudentView;
        this.theStudentModel = theStudentModel;

        this.theStudentView.addLoginBtnListener(new LoginListener());
        this.theStudentView.addGoBackBtnListener(new StdLoginGoBackBtnListener());
    }

    /**
     * The LoginListener class implements the ActionListener interface and overrides the
     * actionPerformed method
     */
    class LoginListener implements ActionListener {

        @Override
        // It's a method that is called when the login button is clicked. It checks if the username and
        // password are valid. If they are, it displays a message saying that the username and password
        // are valid. If they are not, it displays a message saying that the username and password are
        // invalid.
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == theStudentView.loginBtn) {
                try {
                    if (theStudentModel.verifyLogin(theStudentView.usernameTF.getText(),
                            new String(theStudentView.passwordF.getPassword()))) {
                        JOptionPane.showMessageDialog(null, "Login Successful !!");
                        MVCStudentViewProject.main(null);
                        theStudentView.setVisible(false);


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

    class StdLoginGoBackBtnListener implements ActionListener{
  
        @Override
        public void actionPerformed(ActionEvent e)  {

            // TODO Auto-generated method stub

            if (e.getSource() == theStudentView.btnGoBackSL){
                StartMenuFrame smf = new StartMenuFrame();
                smf.setVisible(true);
                theStudentView.setVisible(false);
                   

            }
            
        }

    }

}