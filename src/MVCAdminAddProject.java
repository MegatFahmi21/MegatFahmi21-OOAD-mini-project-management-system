/**
 * This class is the main class of the AdminAddProject class. It creates the view, model, and controller objects and
 * makes the view visible.
 * 
 * @author Lovesh 
 */
public class MVCAdminAddProject {
    /**
     * The main function creates a new instance of the ViewAdminAddProject class, a new instance of the
     * ModelAdminProject class, and a new instance of the ControllerAdminAddProject class
     */
    public static void main (String[] args){
        ViewAdminAddProject theAdminAddProjectView = new ViewAdminAddProject();
        ModelAdminProject theAdminAddProjectModel = new ModelAdminProject(null, null, null, null, null);
        ControllerAdminAddProject theAdminAddProjectController = new ControllerAdminAddProject(theAdminAddProjectView, theAdminAddProjectModel);
        theAdminAddProjectView.setVisible(true);
    }
    
    
}
