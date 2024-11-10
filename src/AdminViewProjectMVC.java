
/**
 * This class is the main class for the AdminViewProjectMVC. It creates the AdminViewProjectV,
 * AdminViewProjectM, and AdminViewProjectC objects and sets the AdminViewProjectV to visible.
 * @author Lovesh
 */

public class AdminViewProjectMVC {

    /**
     * Creating the AdminViewProjectV, AdminViewProjectM, and AdminViewProjectC objects and sets
     * the AdminViewProjectV to visible.
     * @param args
     */
    public static void main(String[] args) {
        AdminViewProjectV theAdminViewProjectView = new AdminViewProjectV();
        AdminViewProjectM theAdminViewProjectModel = new AdminViewProjectM(null, null, null, null, null, null, null);
        AdminViewProjectC theAdminViewProjectController = new AdminViewProjectC(theAdminViewProjectView, theAdminViewProjectModel);

        theAdminViewProjectView.setVisible(true);
    }
}
