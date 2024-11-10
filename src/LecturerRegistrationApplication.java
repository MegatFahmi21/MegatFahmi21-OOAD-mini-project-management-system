/**
 * Combination of Model, View and Controller for Lecturer registration page
 * @author Megat
 */
public class LecturerRegistrationApplication {
    public static void main(String[] args) {
      LecturerRegistrationView view = new LecturerRegistrationView();
      LecturerAddModel model = new LecturerAddModel("", "", "", "");
      new LecturerRegistrationController(view, model);
    }
  }
  