/**
 * The MVC class that runs the main method of the program 
 */

public class AssignProjectMVC {
    /**
     * The main method creates an instance of the view, model, and controller
     * classes.
     */
    public static void main(String[] args) {
        AssignProjectV theViewAssignProject = new AssignProjectV();
        AssignProjectM theAssignProjectModel = new AssignProjectM(null, null, null, null, null, null, null);
        AssignProjectC theControllerAssignProject = new AssignProjectC(theViewAssignProject, theAssignProjectModel);

        theViewAssignProject.setVisible(true);
    }
}
