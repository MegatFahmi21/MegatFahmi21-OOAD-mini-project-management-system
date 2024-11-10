
/**
 * A class that is used to login to the student dashboard.
 * 
 * @author Lovesh
 */
public class MVCStudentLogin {

    /**
    * The main method creates the view, model, and controller objects, and then makes the view visible
    */

    public static void main (String[] args){
        ViewStudentLoginFrame theStudentView = new ViewStudentLoginFrame();
        ModelStudent theStudentModel = new ModelStudent(null, null, null, null);
        StudentLoginController theStudentController = new StudentLoginController(theStudentView, theStudentModel);
        theStudentView.setVisible(true);
    }
    
}
