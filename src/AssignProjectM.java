import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * It's a class that assigns a student to a project.
 * @author Najmuddin
 */
public class AssignProjectM {
    private String adminProjectID;
    private String adminProjectName;
    private String adminProjectDesc;
    private String adminProjectSpec;
    private String adminProjectStatus;
    private String StudentID;
    private String LecturerID;

    public AssignProjectM() {
    }

    /**
     * This is a constructor for the AssignProjectM class that takes in 7 parameters
     * @param adminProjectID admin project id
     * @param adminProjectName admin project name 
     * @param adminProjectDesc admin project description
     * @param adminProjectSpec admin project specialisation
     * @param adminProjectStatus admin project status (activated/deactivated)
     * @param LecturerID Lecturer Id
     * @param StudentID Student Id
     */
    
    public AssignProjectM(String adminProjectID, String adminProjectName, String adminProjectDesc,
            String adminProjectSpec, String adminProjectStatus, String LecturerID, String StudentID) {
        this.adminProjectID = adminProjectID;
        this.adminProjectName = adminProjectName;
        this.adminProjectDesc = adminProjectDesc;
        this.adminProjectSpec = adminProjectSpec;
        this.adminProjectStatus = adminProjectStatus;
        this.StudentID = StudentID;
        this.LecturerID = LecturerID;

    }

    public String getAdminProjectID() {
        return adminProjectID;
    }

    public void setAdminProjectID(String adminProjectID) {
        this.adminProjectID = adminProjectID;
    }

    public String getStudentID() {
        return StudentID;
    }

    public void setStudentID(String StudentID) {
        this.StudentID = StudentID;
    }

    public String getLecturerID() {
        return LecturerID;
    }

    public void setSLecturerID(String LecturerID) {
        this.LecturerID = LecturerID;
    }

    public String getAdminProjectName() {
        return adminProjectName;
    }

    public void setAdminProjectName(String adminProjectName) {
        this.adminProjectName = adminProjectName;
    }

    public String getAdminProjectDesc() {
        return adminProjectDesc;
    }

    public void setAdminProjectDesc(String adminProjectDesc) {
        this.adminProjectDesc = adminProjectDesc;
    }

    public String getAdminProjectSpec() {
        return adminProjectSpec;
    }

    public void setAdminProjectSpec(String adminProjectSpec) {
        this.adminProjectSpec = adminProjectSpec;
    }

    public String getAdminProjectStatus() {
        return adminProjectStatus;
    }

    public void setAdminProjectStatus(String adminProjectStatus) {
        this.adminProjectStatus = adminProjectStatus;
    }

    public AssignProjectM search(String adminProjectID) {
        try (BufferedReader br = new BufferedReader(new FileReader("lecturerprojects.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                if (values[0].equals(adminProjectID)) {
                    return new AssignProjectM(values[0], values[1], values[2], values[3], values[4], values[5],
                            values[6]);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        // if no projects
        return null;
    }

    public StudentModel searchStudent(String StudentID) {
        try (BufferedReader br = new BufferedReader(new FileReader("Student.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                if (values[3].equals(adminProjectSpec)) {
                    return new StudentModel(values[0], values[1], values[2], values[3]);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        // if no student
        return null;
    }

    public void edit(JTextField eidTF, JTextField esidTF, JTextField elcidTF) {
        adminProjectID = eidTF.getText();
        StudentID = esidTF.getText();
        LecturerID = elcidTF.getText();
        try {
            // Open the student assigned csv file for reading
            Scanner input4 = new Scanner(new File("StudentAssigned.csv"));
            boolean isDuplicate = false;
            while (input4.hasNextLine()) {
                String line = input4.nextLine();
                String[] fields = line.split(",");
                if (fields.length > 0 && fields[0].equals(adminProjectID)) {
                    isDuplicate = true;
                    break;
                }
            }
            input4.close();
            if(isDuplicate){
                // Show error message
                JOptionPane.showMessageDialog(null, "A student is already assigned to this project", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                // Open the CSV file for reading
                Scanner input = new Scanner(new File("lecturerprojects.csv"));
    
                // Read the file line by line, and store the lines in a list
                List<String> lines = new ArrayList<>();
    
                while (input.hasNextLine()) {
                    String line = input.nextLine();
                    String[] fields = line.split(",");
                    if (fields.length > 0 && fields[0].equals(adminProjectID)) {
                        fields[fields.length - 1] = StudentID;
                        fields[fields.length - 2] = LecturerID;
                        line = String.join(",", fields);
                    }
                    lines.add(line);
                }
    
                input.close();
                // Open the CSV file for writing
                PrintWriter output = new PrintWriter(new File("lecturerprojects.csv"));
    
                // Iterate through the list, and write each line to the file
                for (String line : lines) {
                    output.println(line);
                }
    
                // Close the file
                output.close();
    
                // Open the student assigned csv file for appending
                PrintWriter output4 = new PrintWriter(new FileWriter("StudentAssigned.csv", true));
                // Append the project id, student id, and lecturer id to the student assigned csv
                output4.append(adminProjectID + "," + StudentID + "," + LecturerID + "\n");
                // Close the file
                output4.close();
                // Open the students.csv file for reading
                Scanner input2 = new Scanner(new File("Student.csv"));
                // Read the file line by line, and store the lines in a list
                List<String> lines2 = new ArrayList<>();
                while (input2.hasNextLine()) {
                    String line = input2.nextLine();
                    String[] fields = line.split(",");
                    if (fields.length > 0 && fields[2].equals(StudentID)) {
                        line = line.substring(0, line.lastIndexOf(",") + 1) + adminProjectID;
                    }
                    lines2.add(line);
                }
                input2.close();
                // Open the students.csv file for writing
                PrintWriter output2 = new PrintWriter(new File("Student.csv"));
                // Iterate through the list, and write each line to the file
                for (String line : lines2) {
                    output2.println(line);
                }
                // Close the file
                output2.close();
                // Open the lecturers.csv file for reading
                Scanner input3 = new Scanner(new File("Lecturer.csv"));
                // Read the file line by line, and store the lines in a list
                List<String> lines3 = new ArrayList<>();
                while (input3.hasNextLine()) {
                    String line = input3.nextLine();
                    String[] fields = line.split(",");
                    if (fields.length > 0 && fields[2].equals(LecturerID)) {
                        line = line.substring(0, line.lastIndexOf(",") + 1) + adminProjectID;
                    }
                    lines3.add(line);
                }
                input3.close();
                // Open the lecturers.csv file for writing
                PrintWriter output3 = new PrintWriter(new File("Lecturer.csv"));
                // Iterate through the list, and write each line to the file
                for (String line : lines3) {
                    output3.println(line);
                }
                // Close the file
                output3.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    

    

    






    


    public void delete(JTextField eidTF, JTextField esidTF) {
        adminProjectID = eidTF.getText();
        StudentID = esidTF.getText();
        try {
            // Open the CSV file for reading
            Scanner input = new Scanner(new File("lecturerprojects.csv"));

            // Read the file line by line, and store the lines in a list
            List<String> lines = new ArrayList<>();
            while (input.hasNextLine()) {
                String line = input.nextLine();
                String[] fields = line.split(",");
                if (fields.length > 0 && fields[0].equals(adminProjectID)) {
                    fields[fields.length - 1] = "unassigned";
                    line = String.join(",", fields);
                }
                lines.add(line);
            }

            // Close the scanner
            input.close();

            // Open the CSV file for writing
            PrintWriter output = new PrintWriter(new File("lecturerprojects.csv"));

            // Iterate through the list, and write each line to the file
            for (String line : lines) {
                output.println(line);
            }

            // Close the file
            output.close();

            // Open the Student.csv file for reading
            Scanner input2 = new Scanner(new File("Student.csv"));

            // Read the file line by line, and store the lines in a list
            List<String> lines2 = new ArrayList<>();
            while (input2.hasNextLine()) {
                String line = input2.nextLine();
                String[] fields = line.split(",");
                if (fields.length > 0) {
                    // Check if the second field of the line matches the StudentID
                    if (fields[2].equals(StudentID)) {
                        // Change the last field of the line to "unassigned"
                        fields[fields.length - 1] = "unassigned";
                        line = String.join(",", fields);
                    }

                }
                lines2.add(line);
            }

            // Close the scanner
            input2.close();

            // Open the Student.csv file for writing
            PrintWriter output2 = new PrintWriter(new File("Student.csv"));

            // Iterate through the list, and write each line to the file
            for (String line : lines2) {
                output2.println(line);
            }

            // Close the file
            output2.close();

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Load Students from "Student.csv"
     * 
     * @return ArrayList of StudentModel
     */
    public ArrayList<StudentModel> loadStudentFromCSV(String projectSpec) {
        ArrayList<StudentModel> studentList = new ArrayList<StudentModel>();
        StudentModel student;
        BufferedReader br;
        String line;

        try {
            br = new BufferedReader(new FileReader("Student.csv"));
            while ((line = br.readLine()) != null) {
                String[] details = line.split(",");

                // add to student list if the specialisation is the same
                if (details[3].equals(projectSpec)) {
                    student = new StudentModel(details[0], details[1], details[2], details[3]);
                    studentList.add(student);
                }

            }
            br.close();
        } catch (FileNotFoundException e) {
            System.out.println("ERROR: File not found");
        } catch (IOException e) {
            System.out.println("ERROR: Could not read file");
        }

        return studentList;
    }

    /**
     * Load Lecturers from "Lecturer.csv"
     * 
     * @return ArrayList of LecturerModel
     */
    public ArrayList<LecturerAddModel> loadLecturerFromCSV() {
        ArrayList<LecturerAddModel> LecturerList = new ArrayList<LecturerAddModel>();
        LecturerAddModel Lecturer;
        BufferedReader br;
        String line;

        try {
            br = new BufferedReader(new FileReader("Lecturer.csv"));
            while ((line = br.readLine()) != null) {
                String[] details = line.split(",");
                Lecturer = new LecturerAddModel(details[0], details[1], details[2], details[3]);
                LecturerList.add(Lecturer);
            }
            br.close();
        } catch (FileNotFoundException e) {
            System.out.println("ERROR: File not found");
        } catch (IOException e) {
            System.out.println("ERROR: Could not read file");
        }

        return LecturerList;
    }

}
