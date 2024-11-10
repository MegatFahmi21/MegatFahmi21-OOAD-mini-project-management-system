import java.awt.event.*;
import java.io.IOException;

/**
 * Controller for Lecturer Registration page
 * @author Megat
 */
public class LecturerRegistrationController implements ActionListener {
    private LecturerRegistrationView view;
    private LecturerAddModel model;
  
    /**
     * Constructor for LecturerRegistrationController class
     * @param view registration view
     * @param model registration model
     */
    public LecturerRegistrationController(LecturerRegistrationView view, LecturerAddModel model) {
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
  