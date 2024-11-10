/**
 * @author Megat
 * Combination of Model, View and Controller for Admin Login page
 */
public class AdminMVCLogin {
    /**
     * Creating a new instance of the AdminViewLoginFrame, AdminModel and AdminLoginController.
     * 
     * @param args
     */
    public static void main (String[] args){
        AdminViewLoginFrame theAdminView = new AdminViewLoginFrame();
        AdminModel theAdminModel = new AdminModel(null, null);
        AdminLoginController theAdminController = new AdminLoginController(theAdminView, theAdminModel);
        theAdminView.setVisible(true);
        
    }
    
}
