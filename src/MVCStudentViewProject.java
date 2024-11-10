/**
 * The MVC class that has a main method that creates the view, model, and controller objects, and then makes the view visible
 * 
 * @author Lovesh 
 */
public class MVCStudentViewProject {

    /**
    * The main method creates the view, model, and controller objects, and then makes the view visible
    */

    public static void main (String[] args){
        VStudentViewProject theStudentViewProjectView = new VStudentViewProject();
        MStudentViewProject theStudentViewProjectModel = new MStudentViewProject(null, null, null, null, null, null, null);
        CStudentViewProject theStudentViewProjectController = new CStudentViewProject(theStudentViewProjectView, theStudentViewProjectModel);
        theStudentViewProjectView.setVisible(true);
    }
    
}
