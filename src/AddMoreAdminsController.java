import java.awt.event.*;
import java.io.IOException;

/**
 * @author Najmuddin
 * It's a controller class that handles the events of the AddMoreAdminsView class
 */
public class AddMoreAdminsController implements ActionListener {
  private AddMoreAdminsView view;
  private AddAdminModel model;

  /**
   * A constructor that takes in the view and model and adds action listeners to the buttons.
   * @param AddMoreAdminsview view class of AddMoreAdmin
   * @param AddMoreAdminsmodel model class of AddMoreAdmin
   */
  
  public AddMoreAdminsController(AddMoreAdminsView AddMoreAdminsview, AddAdminModel AddMoreAdminsmodel) {
    this.view = AddMoreAdminsview;
    this.model = AddMoreAdminsmodel;

    this.view.getRegisterBtn().addActionListener(this);
    this.view.getBackBtn().addActionListener(this);
  }

  /**
   * The function is called when the user clicks the register button. It takes the username and
   * password from the text fields and saves them to a file
   * 
   * @param e the event that occurred
   */
  @Override
  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == view.getRegisterBtn()) {
      model.setUsername(view.getUsernameField().getText());
      model.setPassword(new String(view.getPasswordField().getPassword()));
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