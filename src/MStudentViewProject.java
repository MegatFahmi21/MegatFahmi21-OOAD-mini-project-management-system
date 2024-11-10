import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

/**
 * This is a model class used to search for a project that is assigned to a
 * student
 * 
 * @author Lovesh
 */
public class MStudentViewProject {
    private String studProjectID;
    private String studProjectName;
    private String studProjectDesc;
    private String studProjectSpec;
    private String studProjectStatus;
    private String StudentID;
    private String LecturerID;

    public MStudentViewProject() {
    }

    /**
     * A constructor that takes in 7 parameters
     * 
     * @param studProjectID     student's project id
     * @param studProjectName   student's project Name
     * @param studProjectDesc   student's project Description
     * @param studProjectSpec   student's project specialisation (Game Dev, SE, Data
     *                          Sc, CyberSec)
     * @param studProjectStatus student's project Status (activated/ deactivated)
     * @param LecturerID        lecturer's id
     * @param StudentID         student's id
     * 
     */

    public MStudentViewProject(String studProjectID, String studProjectName, String studProjectDesc,
            String studProjectSpec, String studProjectStatus, String LecturerID, String StudentID) {
        this.studProjectID = studProjectID;
        this.studProjectName = studProjectName;
        this.studProjectDesc = studProjectDesc;
        this.studProjectSpec = studProjectSpec;
        this.studProjectStatus = studProjectStatus;
        this.StudentID = StudentID;
        this.LecturerID = LecturerID;

    }

    /**
     * This function returns the student project ID
     * 
     * @return The studProjectID is being returned.
     */
    public String getStudProjectID() {
        return studProjectID;
    }

    /**
     * This function sets the value of the studProjectID variable to the value of
     * the studProjectID
     * parameter
     * 
     * @param studProjectID The ID of the project
     */
    public void setStudProjectID(String studProjectID) {
        this.studProjectID = studProjectID;
    }

    /**
     * This function returns the name of the project
     * 
     * @return The studProjectName is being returned.
     */
    public String getStudProjectName() {
        return studProjectName;
    }

    /**
     * This function sets the value of the studProjectName variable to the value of
     * the studProjectName
     * parameter
     * 
     * @param studProjectName The name of the project
     */
    public void setStudProjectName(String studProjectName) {
        this.studProjectName = studProjectName;
    }

    /**
     * This function returns the description of the project
     * 
     * @return The studProjectDesc is being returned.
     */
    public String getStudProjectDesc() {
        return studProjectDesc;
    }

    /**
     * This function sets the description of the project
     * 
     * @param studProjectDesc This is the description of the project.
     */
    public void setStudProjectDesc(String studProjectDesc) {
        this.studProjectDesc = studProjectDesc;
    }

    /**
     * This function returns the student's project specialization
     * 
     * @return The studProjectSpec is being returned.
     */
    public String getStudProjectSpec() {
        return studProjectSpec;
    }

    /**
     * This function sets the student project specialization
     * 
     * @param studProjectSpec The name of the project
     */
    public void setStudProjectSpec(String studProjectSpec) {
        this.studProjectSpec = studProjectSpec;
    }

    /**
     * This function returns the status of the project
     * 
     * @return The studProjectStatus is being returned.
     */
    public String getStudProjectStatus() {
        return studProjectStatus;
    }

    /**
     * This function sets the status of the project
     * 
     * @param studProjectStatus The status of the project.
     */
    public void setStudProjectStatus(String studProjectStatus) {
        this.studProjectStatus = studProjectStatus;
    }

    /**
     * This function returns the student ID of the student
     * 
     * @return The StudentID is being returned.
     */
    public String getStudentID() {
        return StudentID;
    }

    /**
     * This function sets the student ID to the value of the parameter studentID
     * 
     * @param studentID The student's ID number
     */

    public void setStudentID(String studentID) {
        StudentID = studentID;
    }

    /**
     * This function returns the LecturerID of the Lecturer object
     * 
     * @return The LecturerID is being returned.
     */
    public String getLecturerID() {
        return LecturerID;
    }



    /**
     * This function sets the LecturerID to the value of the parameter lecturerID
     * 
     * @param lecturerID The ID of the lecturer
     */
    public void setLecturerID(String lecturerID) {
        LecturerID = lecturerID;
    }

    /**
     * It searches for a project by student ID and returns the project if found
     * 
     * @param StudentID The student ID of the student who is logged in
     * @return The method is returning a MStudentViewProject object.
     */
    public MStudentViewProject search(String StudentID) {
        try (BufferedReader br = new BufferedReader(new FileReader("lecturerprojects.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");

                if (values[6].trim().equalsIgnoreCase(StudentID)) {
                    if (values[4].equalsIgnoreCase("Activated")) {
                        return new MStudentViewProject(values[0], values[1], values[2], values[3], "Activated",
                                values[5], values[6]);
                    } else {
                        return new MStudentViewProject(values[0], values[1], values[2], values[3], "Deactivated",
                                values[5], values[6]);
                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        // if no records
        return null;
    }

}
