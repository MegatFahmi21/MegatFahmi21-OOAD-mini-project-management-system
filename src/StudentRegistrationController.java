import java.awt.event.*;
import java.io.IOException;

/**
 * Controller for Student Registration page
 * @author Megat
 */
public class StudentRegistrationController implements ActionListener {
    private StudentRegistrationView view;
    private StudentModel model;
  
    /**
     * Constructor for StudentRegistrationController class
     * @param view registration view
     * @param model registration model
     */
    public StudentRegistrationController(StudentRegistrationView view, StudentModel model) {
      this.view = view;
      this.model = model;
  
      this.view.getRegisterBtn().addActionListener(this);
      this.view.getBackBtn().addActionListener(this);
    }
  
    @Override
    public void actionPerformed(ActionEvent e) {
      if (e.getSource() == view.getRegisterBtn()) {
        model.setUsername(view.getUsernameField().getText());
        model.setPassword(new String(view.getPasswordField().getPassword()));
        model.setId(view.getIdField().getText());
        model.setSpecialization((String)view.getSpecialComboBox().getSelectedItem());
        try {
          model.save();
        } catch (IOException ex) {
            System.out.println("Error writing to file: " + ex.getMessage());
        }
      } else if (e.getSource() == view.getBackBtn()) {
        this.view.setVisible(false);
        new AdminMenuFrame();
      }
    }
  }
  