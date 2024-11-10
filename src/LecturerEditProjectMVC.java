/**
 * Combination of Model, View and Controller for Lecturer Edit Project page
 */
public class LecturerEditProjectMVC {
    LecturerEditProjectM editProjectModel;
    LecturerEditProjectV editProjectView;
    LecturerEditProjectC editProjectController;

    /**
     * Constructor for LecturerEditProjectMVC class
     * @author Syamil
     */
    public LecturerEditProjectMVC() {
        editProjectModel = new LecturerEditProjectM();
        editProjectView = new LecturerEditProjectV();
        editProjectController = new LecturerEditProjectC(editProjectModel, editProjectView);
        editProjectView.setVisible(true);
    }

    public static void main(String[] args) {
        new LecturerEditProjectMVC();
    }

}

