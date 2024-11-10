import java.awt.event.*;
import javax.swing.JOptionPane;

/**
 * Controller for Lecturer Add Project page
 * @author Syamil
 */
public class LecturerAddProjectC {
    private LecturerAddProjectM addProjectModel;
    private LecturerAddProjectV addProjectView;

    /**
     * Constuctor for LecturerAddProjectC class
     * 
     * @param modelAddProject the logic for add project
     * @param viewAddProject  the GUI for add project
     */
    public LecturerAddProjectC(LecturerAddProjectM modelAddProject, LecturerAddProjectV viewAddProject) {
        this.addProjectModel = modelAddProject;
        this.addProjectView = viewAddProject;

        this.addProjectView.addAddProjectListener(new AddProjectListener());
        this.addProjectView.addGoBackBtnListener(new BackBtnListener());

    }

    /**
     * Action listener for when the user clicks the add button to add project
     */
    class AddProjectListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            // Get all the input from add project page
            String projectID = addProjectView.idTF.getText();
            String name = addProjectView.nameTF.getText();
            String description = addProjectView.descTF.getText();
            String specialization = (String) addProjectView.specComBox.getSelectedItem();
            boolean isActivated = addProjectView.activatedBtn.isSelected();
            String status = isActivated ? "Activated" : "Deactivated"; // if true, set as activated 
                                                                       // else, set as deactivated
            String studentID = "unassigned";
            String lecturerID = "unassigned";

            // Create an instance of project
            addProjectModel = new LecturerAddProjectM(projectID, name, description, specialization, status, studentID,
                    lecturerID);

            // Error checking
            if (addProjectModel.projectIdExist()) {
                JOptionPane.showMessageDialog(null, "ERROR: Project ID already exists");
            } else if (addProjectModel.emptySpaceExist()) {
                JOptionPane.showMessageDialog(null, "ERROR: The text field is empty");
            } else {
                addProjectModel.saveToCSV(); // save project details to csv file
                JOptionPane.showMessageDialog(null, "Project Added Successfuly");
            }

        }

    }

    /**
     * Action listener for when the user clicks the back button to go to the main
     * menu
     */
    class BackBtnListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            if (e.getSource() == addProjectView.backBtn) {
                LecturerMenuFrame lecturerFrame = new LecturerMenuFrame();
                lecturerFrame.setVisible(true);
                addProjectView.setVisible(false);

            }

        }

    }
}
