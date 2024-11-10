/**
 * This class is the main class of the MVC pattern for AdminEditProject MVC classes. 
 * It creates the view, model, and controller objects.
 * 
 * @author Lovesh 
 */
public class MVCAdminEditProject {
   //Main method that creates the view, model, and controller objects.
    public static void main (String[] args){
        ViewAdminEditProject theViewAdminEditProject = new ViewAdminEditProject();
        ModelAdminProject theAdminEditProjectModel = new ModelAdminProject(null, null, null, null, null);
        ControllerAdminEditProject theControllerAdminEditProject = new ControllerAdminEditProject(theViewAdminEditProject, theAdminEditProjectModel);

        theViewAdminEditProject.setVisible(true);
    }
}
