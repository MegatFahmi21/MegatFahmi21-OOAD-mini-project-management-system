import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


/**
 * > This class is a subclass of ModelUser, and it has a constructor that takes a String as
 * parameters
 * @author Megat
 * 
 */
public class AdminModel extends ModelUser {

    /**
     * Constructor for AdminModel class
     * @param username  admin name
     * @param password  admin password
     */
    public AdminModel(String username, String password) {
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
        Scanner scanner = new Scanner(new File("admin.csv"));
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
