import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

/**
 * A class that is used to store the data from the csv file.
 * 
 * @author Lovesh
 */
public class AdminViewProjectM {
    private String adminProjectID;
    private String adminProjectName;
    private String adminProjectDesc;
    private String adminProjectSpec;
    private String adminProjectStatus;
    private String StudentID;
    private String LecturerID;

    public AdminViewProjectM() {
    }

    /**
     * A constructor that takes in 7 parameters .
     * 
     * @param adminProjectID     admins project id
     * @param adminProjectName   admins project name
     * @param adminProjectDesc   admins project description
     * @param adminProjectSpec   admins project specialisation (CyberSec, SE, Data
     *                           Sc, Game Dev)
     * @param adminProjectStatus admins project status (activated /deactivated)
     * @param LecturerID         lecturer's id
     * @param StudentID          student's id
     */

    public AdminViewProjectM(String adminProjectID, String adminProjectName, String adminProjectDesc,
            String adminProjectSpec, String adminProjectStatus, String LecturerID, String StudentID) {
        this.adminProjectID = adminProjectID;
        this.adminProjectName = adminProjectName;
        this.adminProjectDesc = adminProjectDesc;
        this.adminProjectSpec = adminProjectSpec;
        this.adminProjectStatus = adminProjectStatus;
        this.StudentID = StudentID;
        this.LecturerID = LecturerID;

    }

    /**
     * This function returns the adminProjectID
     * 
     * @return The adminProjectID
     */
    public String getAdminProjectID() {
        return adminProjectID;
    }

    /**
     * This function sets the adminProjectID variable to the value of the
     * adminProjectID parameter
     * 
     * @param adminProjectID The ID of the project that the user is currently in.
     */
    public void setAdminProjectID(String adminProjectID) {
        this.adminProjectID = adminProjectID;
    }

    /**
     * This function returns the StudentID of the student
     * 
     * @return The StudentID
     */

    public String getStudentID() {
        return StudentID;
    }

    /**
     * This function sets the student ID of the student
     * 
     * @param StudentID The ID of the student
     */
    public void setStudentID(String StudentID) {
        this.StudentID = StudentID;
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
    * This function sets the LecturerID to the value of the parameter LecturerID.
    * 
    * @param LecturerID String
    */
    public void setSLecturerID(String LecturerID) {
        this.LecturerID = LecturerID;
    }

    /**
     * This function returns the name of the admin project
     * 
     * @return The adminProjectName is being returned.
     */
    public String getAdminProjectName() {
        return adminProjectName;
    }

    /**
     * This function sets the adminProjectName variable to the value of the adminProjectName parameter
     * 
     * @param adminProjectName The name of the project that will be used to create the admin user.
     */
    public void setAdminProjectName(String adminProjectName) {
        this.adminProjectName = adminProjectName;
    }

    /**
     * This function returns the adminProjectDesc variable
     * 
     * @return adminProjectDesc
     */
    public String getAdminProjectDesc() {
        return adminProjectDesc;
    }

    /**
     * This function sets the adminProjectDesc variable to the value of the adminProjectDesc parameter
     * 
     * @param adminProjectDesc This is the description of the project.
     */
    public void setAdminProjectDesc(String adminProjectDesc) {
        this.adminProjectDesc = adminProjectDesc;
    }

    /**
     * This function returns the adminProjectSpec
     * 
     * @return adminProjectSpec
     */
    public String getAdminProjectSpec() {
        return adminProjectSpec;
    }

  /**
   * This function sets the adminProjectSpec variable to the value of the adminProjectSpec parameter
   * 
   * @param adminProjectSpec 
   */
    public void setAdminProjectSpec(String adminProjectSpec) {
        this.adminProjectSpec = adminProjectSpec;
    }

   /**
    * This function returns the adminProjectStatus
    * 
    * @return The adminProjectStatus is being returned.
    */
    public String getAdminProjectStatus() {
        return adminProjectStatus;
    }

    /**
     * This function sets the adminProjectStatus variable to the value of the adminProjectStatus
     * parameter
     * 
     * @param adminProjectStatus The status of the project.
     */
    public void setAdminProjectStatus(String adminProjectStatus) {
        this.adminProjectStatus = adminProjectStatus;
    }

    /**
     * It reads a CSV file and returns a 2D array of strings
     * 
     * @param fileName The name of the file to read.
     * @return A 2D array of strings.
     */
    public static String[][] readCSV(String fileName) {
        String[][] data = null;
        try {
            File file = new File(fileName);
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line;
            int row = 0;
            int col = 0;
            // if (row == 0) {
            // br.readLine();
            // }
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                if (data == null) {
                    col = values.length;
                    data = new String[row + 1][col];
                } else {
                    data = Arrays.copyOf(data, data.length + 1);
                    data[row] = new String[col];
                }
                for (int i = 0; i < values.length; i++) {
                    data[row][i] = values[i];
                }
                row++;
            }
            br.close();
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }

}