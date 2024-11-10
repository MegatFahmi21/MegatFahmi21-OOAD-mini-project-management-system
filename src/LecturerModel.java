import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Model for Lecturer login page
 * @author Ameera
 */
public class LecturerModel extends ModelUser {

    /**
     * Constructor for LecturerModel class
     * @param username  lecturer name
     * @param password  lecturer password
     */
    public LecturerModel(String username, String password) {
        super(username, password);
    }

    /**
     * Check whether username and password that user entered already exists in the CSV file
     * @param username
     * @param password
     * @return true if username and password match in csv file
     * @throws FileNotFoundException
     */
    public boolean verifyLogin(String username, String password) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("Lecturer.csv"));
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
