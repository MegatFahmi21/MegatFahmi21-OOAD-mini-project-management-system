import java.util.ArrayList;

/**
 * Model for Lecturer Add Project page
 * @author Syamil
 */
public class LecturerAddProjectM extends LecturerProjectM {

    /**
     * No arguements constructor for LecturerAddProjectM
     */
    public LecturerAddProjectM() {
    }

    /**
     * Constructor for LecturerAddProjectM class
     * 
     * @param projectID     project ID needs to be unique
     * @param projectName   name of the project
     * @param projectDesc   description of the project
     * @param projectSpec   specialization of the project
     * @param projectStatus status of the project
     */
    public LecturerAddProjectM(String projectID, String projectName, String projectDesc, String projectSpec,
            String projectStatus, String assignedStudentID, String lecturerID) {
        super(projectID, projectName, projectDesc, projectSpec, projectStatus, assignedStudentID, lecturerID);
    }

    /**
     * Check whether project ID that user entered already exists in the CSV file
     * 
     * @return true if project ID exist in the CSV file
     */
    public boolean projectIdExist() {
        ArrayList<String[]> projectList = new ArrayList<String[]>();
        projectList = loadCSVFile();
        for (String[] project : projectList) {
            if ((this.getProjectID()).equals(project[0])) {
                return true;
            }
        }
        return false;
    }

    /**
     * Check whether the fetched user input is not empty or contains only space
     * 
     * @return true if the fetched user input is empty
     */
    public boolean emptySpaceExist() {
        String[] projectDetails = new String[] { getProjectID(), getProjectName(), getProjectDesc(), getProjectSpec(),
                getProjectStatus(), getLecturerID() };
        for (String details : projectDetails) {
            if (details.trim().isEmpty()) {
                return true;
            }
        }
        return false;
    }



}
