import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * It's a class that contains methods to add, edit, delete and search for
 * projects in a csv file.
 * 
 * @author Lovesh
 */
public class ModelAdminProject {
    private String adminProjectID;
    private String adminProjectName;
    private String adminProjectDesc;
    private String adminProjectSpec;
    private String adminProjectStatus;

    /**
     * It's a constructor that initialize the defined variables
     * 
     * @param adminProjectID     is the project id
     * @param adminProjectName   the projects name
     * @param adminProjectDesc   the description of the project
     * @param adminProjectSpec   the specialisation of the project
     * @param adminProjectStatus status of the project activated/deactivated
     */
    public ModelAdminProject(String adminProjectID, String adminProjectName, String adminProjectDesc,
            String adminProjectSpec, String adminProjectStatus) {
        this.adminProjectID = adminProjectID;
        this.adminProjectName = adminProjectName;
        this.adminProjectDesc = adminProjectDesc;
        this.adminProjectSpec = adminProjectSpec;
        this.adminProjectStatus = adminProjectStatus;
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
     * @param adminProjectID The ID of the project that the user is trying to
     *                       access.
     */
    public void setAdminProjectID(String adminProjectID) {
        this.adminProjectID = adminProjectID;
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
     * This function sets the adminProjectName variable to the value of the
     * adminProjectName parameter
     * 
     * @param adminProjectName The name of the project that will be used for
     *                         add/edit project
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
     * This function sets the adminProjectDesc variable to the value of the
     * adminProjectDesc parameter
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
     * This function sets the adminProjectSpec variable to the value of the
     * adminProjectSpec parameter
     * 
     * @param adminProjectSpec The specialisation of the project to be created.
     */
    public void setAdminProjectSpec(String adminProjectSpec) {
        this.adminProjectSpec = adminProjectSpec;
    }

    /**
     * This function returns the adminProjectStatus variable
     * 
     * @return adminProjectStatus
     */
    public String getAdminProjectStatus() {
        return adminProjectStatus;
    }

    /**
     * This function sets the adminProjectStatus variable to the value of the
     * adminProjectStatus
     * parameter
     * 
     * @param adminProjectStatus The status of the project.
     */
    public void setAdminProjectStatus(String adminProjectStatus) {
        this.adminProjectStatus = adminProjectStatus;
    }

    /**
     * adminAddPJToCsv method that takes in 5 parameters, and writes them to a csv
     * file
     * 
     * @param adminProjectID     The ID of the project
     * @param adminProjectName   The name of the project
     * @param adminProjectDesc   "This is a test project"
     * @param adminProjectSpec   "Cybersecurity, Data Science, Software Engineering,
     *                           Game Development"
     * @param adminProjectStatus "Activated / Deactivated"
     */
    public void adminAddPJToCsv(String adminProjectID, String adminProjectName, String adminProjectDesc,
            String adminProjectSpec, String adminProjectStatus) {
        try {
            FileWriter fw = new FileWriter("adminprojects.csv", true);
            PrintWriter pw = new PrintWriter(fw);
            pw.println(adminProjectID + "," + adminProjectName + "," + adminProjectDesc + "," + adminProjectSpec + ","
                    + adminProjectStatus);
            pw.flush();
            pw.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public boolean adminCheckPJIDExist(String adminProjectID) {
        try {
            BufferedReader br = new BufferedReader(new FileReader("adminprojects.csv"));
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                if (values[0].equals(adminProjectID)) {
                    br.close();
                    return true;
                }
            }
            br.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    /**
     * It reads a csv file and returns a ModelAdminProject object if the
     * adminProjectID matches the
     * first value in the csv file.
     *
     * @param adminProjectID the ID of the project
     * @return The method is returning a ModelAdminProject object.
     */
    public ModelAdminProject search(String adminProjectID) {
        try (BufferedReader br = new BufferedReader(new FileReader("adminprojects.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                if (values[0].equals(adminProjectID)) {
                    return new ModelAdminProject(values[0], values[1], values[2], values[3], values[4]);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        // if no projects
        return null;
    }

    /**
     * It reads the file, checks if the ID matches the search criteria, if it does,
     * it updates the
     * record data, if not, it just writes the line
     * 
     * @param eidTF                JTextField
     * @param enameTF              JTextField
     * @param edescTF              JTextArea
     * @param eSpec                JComboBox
     * @param epjActivatedStatus   JRadioButton
     * @param epjDeactivatedStatus JRadioButton
     */
    public void edit(JTextField eidTF, JTextField enameTF, JTextArea edescTF, JComboBox<String> eSpec,
            JRadioButton epjActivatedStatus, JRadioButton epjDeactivatedStatus) {
        adminProjectID = eidTF.getText();

        try {
            Scanner input = new Scanner(new File("adminprojects.csv"));

            // Read the first line of the file (the header row)
            String header = input.nextLine();

            // Read the rest of the file, one line at a time
            String lines = "";
            while (input.hasNextLine()) {
                String line = input.nextLine();

                // Split the line into fields
                String[] fields = line.split(",");

                // Check if the record ID matches the search criteria
                if (fields[0].equals(adminProjectID)) {
                    // Update the record data
                    adminProjectName = enameTF.getText();
                    adminProjectDesc = edescTF.getText();
                    adminProjectSpec = (String) eSpec.getSelectedItem();

                    if (epjActivatedStatus.isSelected()) {
                        adminProjectStatus = "activated";
                    } else {
                        adminProjectStatus = "deactivated";
                    }
                    lines += adminProjectID + "," + adminProjectName + "," + adminProjectDesc + "," + adminProjectSpec
                            + "," + adminProjectStatus + "\n";
                } else {
                    lines += line + "\n";
                }
            }
            input.close();
            // Open the CSV file for writing
            PrintWriter output = new PrintWriter(new File("adminprojects.csv"));

            // Write the header row
            output.println(header);

            // Write the updated records
            output.print(lines);

            // Close the file
            output.close();

        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    /**
     * It reads the file, line by line, and writes the lines to a new file, except
     * for the line that
     * contains the project ID that the user wants to delete. Then it deletes the
     * original file and
     * renames the new file to the original file's name
     * 
     * @param adminProjectID The ID of the project that the admin wants to delete.
     */
    public void delete(String adminProjectID) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("adminprojects.csv"));
            FileWriter writer = new FileWriter("new_projects.csv");

            String line;
            while ((line = reader.readLine()) != null) {
                String[] values = line.split(",");
                if (!values[0].equals(adminProjectID)) {
                    writer.append(line + "\n");
                }
            }
            reader.close();
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        // Rename the file back to its original name
        try {
            Path filePath = Paths.get("adminprojects.csv");
            Files.deleteIfExists(filePath);
            Files.move(Paths.get("new_projects.csv"), filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
