import java.io.*;

import javax.swing.JOptionPane;

/**
 * This class is a model for the AddAdmin. It contains the username and password of the admin
 * to be added
 * @author Najmuddin 
 */
public class AddAdminModel {
  private String username;
  private String password;

  /**
   * A constructor that takes in the username and password of the admin to be added.
   * @param username of the admin
   * @param password of the admin
   */
 
  public AddAdminModel(String username, String password) {
    this.username = username;
    this.password = password;
  }

/**
 * It returns the username.
 * 
 * @return The username.
 */
  public String getUsername() {
    return username;
  }

 /**
  * This function sets the username of the user
  * 
  * @param username The username of the user.
  */
  public void setUsername(String username) {
    this.username = username;
  }

  /**
   * This function returns the password of the user
   * 
   * @return The password.
   */
  public String getPassword() {
    return password;
  }

  /**
   * This function sets the password of the user
   * 
   * @param password The password to use for the connection.
   */
  public void setPassword(String password) {
    this.password = password;
  }
  
  // Checking if the admin already exists.
  public boolean isAdminExist(String username) {
    boolean isExist = false;
    try (BufferedReader br = new BufferedReader(new FileReader("admin.csv"))) {
        String line;
        while ((line = br.readLine()) != null) {
            String[] values = line.split(",");
            if (values[0].equals(username)) {
                isExist = true;
                break;
            }
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
    return isExist;
}


  // Checking if the admin already exists.
  public void save() throws IOException {
    if (isAdminExist(username)) {
      JOptionPane.showMessageDialog(null, "Admin already exists!");
  }
    // Check that none of the fields are empty
    else if (username.isEmpty() || password.isEmpty()) {
      JOptionPane.showMessageDialog(null, "Cannot leave any field empty");
    } 
    // Check that the name is only alphabetical
    else if (!username.matches("[a-zA-Z]+")) {
      JOptionPane.showMessageDialog(null, "Please enter a valid name");
    }
    else {
      try {
        // Open a file for writing
        FileWriter writer = new FileWriter("admin.csv", true);
        JOptionPane.showMessageDialog(null, "Registration successful!");

        // Write the user's username and password to the file, separated by a comma
        writer.write(username + "," + password + "\n");

        // Close the file
        writer.close();

      } catch (IOException ex) {
        // If an error occurs, print a message
        System.out.println("Error writing to file: " + ex.getMessage());
      }
    }
  }


}

