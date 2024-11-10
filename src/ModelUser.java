/**
 * This class is a model class for the user
 * also known as the superclass 
 * @author Lovesh 
 */
public class ModelUser {
    private String username;
    private String password;

    /**
     *  A constructor that takes in two parameters, username and password.
     * @param username user's username (lecturer, admin or student)
     * @param password user's password (lecturer, admin or student)
     */
    public ModelUser(String username, String password) {
        this.username = username;
        this.password = password;
    }
    
    /**
     * This function returns the username of the user
     * 
     * @return The username
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
     * @param password The password for the user
     */

    public void setPassword(String password) {
        this.password = password;
    }

}
