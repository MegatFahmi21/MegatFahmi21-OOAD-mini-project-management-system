import java.io.*;

import javax.swing.JOptionPane;

/**
 * Model for lecturer registration page
 * @author Lovesh 
 */
public class StudentModel {
  private String username;
  private String password;
  private String id;
  private String specialization;

  public StudentModel(String username, String password, String id, String specialization) {
    this.username = username;
    this.password = password;
    this.id = id;
    this.specialization = specialization;
  }

  /**
   * Getter for username
   */
  public String getUsername() {
    return username;
  }

  /**
   * Setter for username
   * @param username new username
   */
  public void setUsername(String username) {
    this.username = username;
  }

  /**
   * Getter for password
   */
  public String getPassword() {
    return password;
  }

  /**
   * Setter for password
   * @param password new password
   */
  public void setPassword(String password) {
    this.password = password;
  }

  /**
   * Getter for id
   */
  public String getId() {
    return id;
  }

  /**
   * Setter for id
   * @param id new id
   */
  public void setId(String id) {
    this.id = id;
  }

  /**
   * Getter for specialization
   */
  public String getSpecialization() {
    return specialization;
  }

  /**
   * Setter for specialization
   * @param specialization new specialization
   */
  public void setSpecialization(String specialization) {
    this.specialization = specialization;
  }

  /**
   * Save registration details to csv file
   * @throws IOException
   */
  public void save() throws IOException {
    if (!username.matches("[a-zA-Z]+")) {
        JOptionPane.showMessageDialog(null, "Please enter a valid name");
      }
      // Check that the id is only numeric
      else if (!id.matches("[0-9]+")) {
        JOptionPane.showMessageDialog(null, "Please enter a valid id");
      }
      // Check that none of the fields are empty
      else if (username.isEmpty() || password.isEmpty() || id.isEmpty() || specialization.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Cannot leave any field empty");
      }
      else {
        try {
            // Open a file for writing
            FileWriter writer = new FileWriter("Student.csv", true);
            JOptionPane.showMessageDialog(null, "Registration successful!");
            //this.setVisible(false);
            //new userTypePage();

            // Write the user's username and password to the file, separated by a comma
            writer.write(username + "," + password + "," + id + "," + specialization + "\n");
      
            // Close the file
            writer.close();
        } catch (IOException ex) {
            // If an error occurs, print a message
            System.out.println("Error writing to file: " + ex.getMessage());
        }
      }
  }
}
