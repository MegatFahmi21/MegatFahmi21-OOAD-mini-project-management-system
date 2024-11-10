/**
 * Combination of Model, View and Controller for Lecturer Add Project page
 * @author Syamil
 */
public class LecturerAddProjectMVC {
    LecturerAddProjectM addProjectModel;
    LecturerAddProjectV addProjectView;
    LecturerAddProjectC addProjectController;

    /**
     * Constructor for LecturerAddProjectMVC class
     */
    public LecturerAddProjectMVC() {
        addProjectModel = new LecturerAddProjectM();
        addProjectView = new LecturerAddProjectV();
        addProjectController = new LecturerAddProjectC(addProjectModel, addProjectView);
        addProjectView.setVisible(true); // show the page
    }

    public static void main(String[] args) {
        new LecturerAddProjectMVC();
    }

}
