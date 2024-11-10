/**
 * Combination of Model, View and Controller for Admin Login page
 * @author Ameera
 */
public class LecturerLoginMVC {
    public static void main (String[] args){
        LecturerViewLoginFrame theLecturerView = new LecturerViewLoginFrame();
        LecturerModel theLecturerModel = new LecturerModel(null, null);
        LecturerLoginController theLecturerController = new LecturerLoginController(theLecturerView, theLecturerModel);
        theLecturerView.setVisible(true);
    }
    
}
