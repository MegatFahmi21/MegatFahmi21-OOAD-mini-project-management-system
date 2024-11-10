import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * Abstract class for creating an project class
 * @author Syamil
 */
public abstract class LecturerProjectM {
    private String projectID;
    private String projectName;
    private String projectDesc;
    private String projectSpec;
    private String projectStatus;
    private String assignedStudentID;
    private String lecturerID;

    public LecturerProjectM() {
    }

    public LecturerProjectM(String projectID, String projectName, String projectDesc,
            String projectSpec, String projectStatus, String assignedStudentID, String lecturerID) {
        this.projectID = projectID;
        this.projectName = projectName;
        this.projectDesc = projectDesc;
        this.projectSpec = projectSpec;
        this.projectStatus = projectStatus;
        this.assignedStudentID = assignedStudentID;
        this.lecturerID = lecturerID;
    }

    /**
     * Getter for projectID
     */
    public String getProjectID() {
        return projectID;
    }

    /**
     * Setter for project ID
     * 
     * @param projectID new project ID
     */
    public void setProjectID(String projectID) {
        this.projectID = projectID;
    }

    /**
     * Getter for project name
     */
    public String getProjectName() {
        return projectName;
    }

    /**
     * Setter for project name
     * 
     * @param projectName new project name
     */
    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    /**
     * Getter for project description
     * 
     * @return project description
     */
    public String getProjectDesc() {
        return projectDesc;
    }

    /**
     * Setter for project desctiption
     * 
     * @param projectDesc new project desctiption
     */
    public void setProjectDesc(String projectDesc) {
        this.projectDesc = projectDesc;
    }

    /**
     * Getter for project specialization
     * 
     * @return project specialization
     */
    public String getProjectSpec() {
        return projectSpec;
    }

    /**
     * Setter for project specialization
     * 
     * @param projectSpec new project specialization
     */
    public void setProjectSpec(String projectSpec) {
        this.projectSpec = projectSpec;
    }

    /**
     * Getter for project status
     */
    public String getProjectStatus() {
        return projectStatus;
    }

    /**
     * Setter for project status
     * 
     * @param projectStatus new project status
     */
    public void setProjectStatus(String projectStatus) {
        this.projectStatus = projectStatus;
    }

    /**
     * Getter for project status
     */
    public String getAssignedStudentID() {
        return assignedStudentID;
    }

    /**
     * Setter for project status
     * 
     * @param AssignedStudentID new project status
     */
    public void setAssignedStudentID(String assignedStudentID) {
        this.assignedStudentID = assignedStudentID;
    }

    /**
     * Getter for lecturer ID
     */
    public String getLecturerID() {
        return lecturerID;
    }

     /**
     * Setter for lecturer ID
     */
    public void setLecturerID(String lecturerID) {
        this.lecturerID = lecturerID;
    }

    /**
     * Save project details to CSV file
     */
    public void saveToCSV() {
        try {
            FileWriter fw = new FileWriter("lecturerprojects.csv", true);
            PrintWriter pw = new PrintWriter(fw);
            pw.println(getProjectID() + "," + getProjectName() + "," + getProjectDesc() + "," + getProjectSpec()
                    + "," + getProjectStatus() + "," + getAssignedStudentID() + "," + getLecturerID());
            pw.flush();
            pw.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Load project details in an ArrayList from CSV file
     * 
     * @return ArrayList<String[]> project list
     */
    public ArrayList<String[]> loadCSVFile() {
        ArrayList<String[]> projectList = new ArrayList<String[]>();
        String[] project;
        BufferedReader br;
        String line;

        try {
            br = new BufferedReader(new FileReader("lecturerprojects.csv"));
            while ((line = br.readLine()) != null) {
                project = line.split(",");
                projectList.add(project);
            }
            br.close();
        } catch (FileNotFoundException e) {
            System.out.println("ERROR: File not found");
        } catch (IOException e) {
            System.out.println("ERROR: Could not read file");
        }

        return projectList;
    }
}
