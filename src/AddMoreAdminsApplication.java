/**
 * It's the MVC class that runs the Add More Admins program.
 * @author Najmuddin
 * 
 */
public class AddMoreAdminsApplication {
  /**
   * The main function creates an instance of the AddMoreAdminsView, AddAdminModel, and
   * AddMoreAdminsController classes
   */
  public static void main(String[] args) {
    AddMoreAdminsView theAddMoreAdminsview = new AddMoreAdminsView();
    AddAdminModel theAddMoreAdminsmodel = new AddAdminModel(null, null);
    AddMoreAdminsController theaddmoreadminscontroller = new AddMoreAdminsController(theAddMoreAdminsview,
        theAddMoreAdminsmodel);

    theAddMoreAdminsview.setVisible(true);
  }
}
