import java.util.ArrayList;
import java.awt.event.*;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 * Controller for Lecturer Edit Project page
 * @author Syamil
 */
public class LecturerEditProjectC {
    private LecturerEditProjectM editProjectM;
    private LecturerEditProjectV editProjectV;

    /**
     * Constructor for LecturerEditProjectC class
     * @param editProjectM edit project model
     * @param editProjectV edit project view
     */
    public LecturerEditProjectC(LecturerEditProjectM editProjectM, LecturerEditProjectV editProjectV) {
        this.editProjectM = editProjectM;
        this.editProjectV = editProjectV;

        this.editProjectV.addTableListener(new SelectRowListener());
        this.editProjectV.addUpdateBtnListener(new UpdateBtnListener());
        this.editProjectV.addBackBtnListener(new BackBtnListener());
        this.editProjectV.addHelpBtnListener(new HelpBtnListener());


    }

    /**
     * This listener class will fetch the project data when user click on the table row
     */
    class SelectRowListener implements ListSelectionListener {

        @Override
        public void valueChanged(ListSelectionEvent event) {

            JTable table = editProjectV.getTable();
            int selectedRow = table.getSelectedRow();
            int col = 0; // projectID column's

            if (!event.getValueIsAdjusting() && selectedRow != -1) {

                String selectedID = (String) table.getValueAt(selectedRow, col);
                System.out.println(selectedID);
                updateForm(selectedID);
                
            }
        }

        /**
         * Set the empty text field with project data based on the selected projectID
         * @param selectedID projectID from the selected table row
         */
        private void updateForm(String selectedID) {
            ArrayList<String[]> projectList = new ArrayList<String[]>();
            projectList = editProjectM.loadCSVFile();
    
            // Set the GUI components text with selected project details
            for (String[] project : projectList) {
                if( (project[0]).equals(selectedID) ) {
                    editProjectV.showID(selectedID);
                    editProjectV.showName(project[1]);
                    editProjectV.showDescription(project[2]);
                    editProjectV.showSpecialization(project[3]);
                    editProjectV.showStatus(project[4]);
                }
            }
        }

    }   

    /**
     * This listener class will update the CSV file with the newly entered project details
     */
    class UpdateBtnListener implements  ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String projectID = editProjectV.getIdTF().getText();
            String name = editProjectV.getNameTF().getText();
            String description = editProjectV.getDescArea().getText();
            String specialization = (String) editProjectV.getSpecComboBox().getSelectedItem();
            boolean isActivated = editProjectV.getActivatedBtn().isSelected();
            String status = isActivated ? "Activated" : "Deactivated"; // if true, set as activated. else, set as deactivated
            String studentID = null;
            String lecturerID = null;

            // Create instance of project with new details
            editProjectM = new LecturerEditProjectM(projectID, name, description, specialization, status, studentID, lecturerID);
            
            // Error checking
            if (projectID.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "ERROR: There is no selected project");
            }
            else if (editProjectM.emptySpaceExist()){
                JOptionPane.showMessageDialog(null, "ERROR: The text field is empty");
            }
            else {
                editProjectM.updateCSVfile(); // save the new project data to csv file
                editProjectM.updateTable(editProjectV.getTable()); //refresh the table
                JOptionPane.showMessageDialog(null, "Project update successfuly");
            } 
        }

    }

    /**
     * This listener class will redirect user back to the lecturer menu
     */
    class BackBtnListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            if (e.getSource() == editProjectV.getBackBtn()) {
                LecturerMenuFrame lecturerFrame = new LecturerMenuFrame();
                lecturerFrame.setVisible(true); // open lecture menu page
                editProjectV.setVisible(false); // close edit project page
            }

        }

    }


    /**
     * This listener class will show the user how to edit project
     */
    class HelpBtnListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(null, "Please select the project that you want to edit by clicking the table row");            
        }

    }

}
