/**
 * Combination of Model, View and Controller for Student registration page
 * 
 * @author Megat 
 */
public class StudentRegistrationApplication {
    public static void main(String[] args) {
      StudentRegistrationView view = new StudentRegistrationView();
      StudentModel model = new StudentModel("", "", "", "");
      new StudentRegistrationController(view, model);
    }
  }
  