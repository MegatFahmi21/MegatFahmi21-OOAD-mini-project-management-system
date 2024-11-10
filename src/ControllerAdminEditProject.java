import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

/**
 * The ControllerAdminEditProject class is a controller class that controls the
 * ViewAdminEditProject
 * and ModelAdminProject classes.
 * @author Lovesh
 */
public class ControllerAdminEditProject {

    private ViewAdminEditProject theAdminEditProjectView;
    private ModelAdminProject theAdminEditProjectModel;

    /**
     * This is a constructor that accepts two parameters
     * 
     * @param theAdminEditProjectView  View class that contains the GUI components
     * @param theAdminEditProjectModel Model class that has the logic of edit
     *                                 project
     */
    public ControllerAdminEditProject(ViewAdminEditProject theAdminEditProjectView,
            ModelAdminProject theAdminEditProjectModel) {
        this.theAdminEditProjectView = theAdminEditProjectView;
        this.theAdminEditProjectModel = theAdminEditProjectModel;

        this.theAdminEditProjectView.addEditProjectListener(new AdminEditProjectListener());
        this.theAdminEditProjectView.addGoBackBtnListener(new AdminGoBackBtnListener());
        this.theAdminEditProjectView.addSearchEAPBtnListener(new AdminSearchEPBtnListener());

    }

    /**
     * The AdminEditProjectListener class is a class that implements the
     * ActionListener interface.
     */
    class AdminEditProjectListener implements ActionListener {

        @Override
        // The actionPerformed method that is called when the user clicks the edit button. It will get
        // the text from the text fields and pass it to the model class.
        public void actionPerformed(ActionEvent e) {
            String adminProjectID = theAdminEditProjectView.eidTF.getText();
            ModelAdminProject adEdProject = theAdminEditProjectModel.search(adminProjectID);
            if (adEdProject != null) {
                if (theAdminEditProjectView.enameTF.getText().isEmpty() ||
                        theAdminEditProjectView.edescTF.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please fill in all the fields!");
                
                } else {

                    adEdProject.edit(theAdminEditProjectView.eidTF, theAdminEditProjectView.enameTF,
                    theAdminEditProjectView.edescTF, theAdminEditProjectView.eSpec,
                    theAdminEditProjectView.epjActivatedStatus, theAdminEditProjectView.epjDeactivatedStatus);
                    JOptionPane.showMessageDialog(null, "Editing Success !");

                }

            } else {
                JOptionPane.showMessageDialog(null, "Editing Failed !");
            }

        }

    }

    /**
     * This class is used to go back to the Admin Menu Frame from the Admin Edit
     * Project Frame.
     * 
     */
    class AdminGoBackBtnListener implements ActionListener {
        @Override
        // A method that is called when the user clicks the edit button. It will get the
        // text from the
        // text fields and pass it to the model class.
        public void actionPerformed(ActionEvent e) {

            // TODO Auto-generated method stub

            if (e.getSource() == theAdminEditProjectView.btnGoBackAD) {
                theAdminEditProjectView.setVisible(false);
                AdminMenuFrame adminFrame = new AdminMenuFrame();
                adminFrame.setVisible(true);
              

            }

        }

    }

    /**
     * This class is used to search for a project in the database and display the
     * project's details in
     * the text fields.
     * 
     */
    class AdminSearchEPBtnListener implements ActionListener {

        /**
         * It will search for the project ID that the user has entered in the text field
         * and if it is
         * found, it will display the project name, description, specification and
         * status in the text
         * fields
         * 
         * @param e the event object
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            String adminProjectID = theAdminEditProjectView.eidTF.getText();
            ModelAdminProject adEdProject = theAdminEditProjectModel.search(adminProjectID);
            if(theAdminEditProjectView.eidTF.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "Error: Please enter an ID");

            }
   
            else if (adEdProject != null) {
                theAdminEditProjectView.enameTF.setText(adEdProject.getAdminProjectName());
                theAdminEditProjectView.edescTF.setText(adEdProject.getAdminProjectDesc());
                theAdminEditProjectView.eSpec.setSelectedItem(adEdProject.getAdminProjectSpec());

                if (adEdProject.getAdminProjectStatus().equals("activated")) {
                    theAdminEditProjectView.epjActivatedStatus.setSelected(true);
                } else {
                    theAdminEditProjectView.epjDeactivatedStatus.setSelected(true);
                }

            } else {
                // not found
                JOptionPane.showMessageDialog(null, "Project ID is not found");

            }

        }

    }
}
