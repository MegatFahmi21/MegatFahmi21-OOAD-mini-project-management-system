/**
 * This class is the main class of the MVC pattern for AdminDeleteProject MVC classes. It creates the view, model, and controller objects
 * and makes the view visible.
 * 
 * @author Lovesh 
 */

public class MVCAdminDeleteProject {
    /**
     * The main method creates an instance of the view, model, and controller classes, and then makes the
     * view visible.
     */
    public static void main (String[] args){
        ViewAdminDeleteProject theAdminDeleteProjectView = new ViewAdminDeleteProject();
        ModelAdminProject theAdminDeleteProjectModel = new ModelAdminProject(null, null, null, null, null);
        ControllerAdminDeleteProject theAdminDeleteProjectController = new ControllerAdminDeleteProject(theAdminDeleteProjectView, theAdminDeleteProjectModel);
        theAdminDeleteProjectView.setVisible(true);

    }
        
    
}
