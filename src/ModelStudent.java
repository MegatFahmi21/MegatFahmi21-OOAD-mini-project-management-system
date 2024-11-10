import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * It's a subclass that extends the ModelUser superclass and adds a student ID and a student specialisation
 * @author Lovesh
 */
public class ModelStudent extends ModelUser {

    private String studentID;
    private String stdSpecial;

    /**
     * It's a constructor that takes in the username, password, studentID and stdSpecial and sets them
     * to the variables in the class.
     * @param username - username of the student 
     * @param password - password of the student 
     * @param studentID - id of the student 
     * @param stdSpecial - specialisation of the students like cybersecurity, data science, software engineering, game development 
     */
    public ModelStudent(String username, String password, String studentID, String stdSpecial) {
        super(username, password);
        this.stdSpecial = stdSpecial;
        this.stdSpecial = studentID;

    }

   /**
    * This function returns the studentID of the student
    * 
    * @return The studentID
    */
    public String getStudentID() {
        return studentID;
    }

   /**
    * This function sets the studentID to the value of the parameter studentID
    * 
    * @param studentID The student's ID number
    */
    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    /**
     * This function returns the value of the variable stdSpecial
     * 
     * @return The value of the stdSpecial variable.
     */
    public String getStdSpecial() {
        return stdSpecial;
    }

    /**
     * This function sets the value of the variable stdSpecial to the value of the parameter stdSpecial
     * 
     * @param stdSpecial The students programme specialisation course
     */
    public void setStdSpecial(String stdSpecial) {
        this.stdSpecial = stdSpecial;
    }

    /**
     * This function takes in a username and password and checks if the username and password are in
     * the Student.csv file
     * 
     * @param username The username of the user trying to log in.
     * @param password The password that the user entered.
     * @return A boolean value.
     */
    public boolean verifyLogin(String username, String password) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("Student.csv"));
        while (scanner.hasNextLine()) {
            String[] line = scanner.nextLine().split(",");
            String usernameCSV = line[0];
            String passwordCSV = line[1];

            if (usernameCSV.equals(username) && passwordCSV.equals(password)) {
                return true;
            }
        }
        return false;

    }

}
