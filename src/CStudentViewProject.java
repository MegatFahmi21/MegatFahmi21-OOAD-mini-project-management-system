import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

/**
 * The ControllerAdminEditProject class is a controller class that controls the
 * ViewAdminEditProject
 * and ModelAdminProject classes.
 * @author Lovesh
 */
public class CStudentViewProject {

    private VStudentViewProject theStudentViewProjectView;
    private MStudentViewProject theStudentViewProjectModel;

    /**
     * This is a constructor that accepts two parameters
     * 
     * @param theAdminEditProjectView  View class that contains the GUI components
     * @param theAdminEditProjectModel Model class that has the logic of edit
     *                                 project
     */
    public CStudentViewProject(VStudentViewProject theStudentViewProjectView,
    MStudentViewProject theStudentViewProjectModel) {
        this.theStudentViewProjectView = theStudentViewProjectView;
        this.theStudentViewProjectModel = theStudentViewProjectModel;

  
        this.theStudentViewProjectView.addGoBackBtnListener(new StudentGoBackBtnListener());
        this.theStudentViewProjectView.addVSPBtnListener(new StudentVPBtnListener());

    }

   
    /**
     * This class is used to go back to the Admin Menu Frame from the Admin Edit
     * Project Frame.
     * 
     */
    class StudentGoBackBtnListener implements ActionListener {
        @Override
        // A method that is called when the user clicks the edit button. It will get the
        // text from the
        // text fields and pass it to the model class.
        public void actionPerformed(ActionEvent e) {

            // TODO Auto-generated method stub

            if (e.getSource() == theStudentViewProjectView.btnGoBackVSTD) {
                MVCStudentLogin.main(null);
                theStudentViewProjectView.setVisible(false);

            }

        }

    }

    /**
     * This class is used to search for a project in the database and display the
     * project's details in
     * the text fields.
     * 
     */
    class StudentVPBtnListener implements ActionListener {

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
            String StudentID = theStudentViewProjectView.vSIDTF.getText();
            theStudentViewProjectView.vSIDTF.setFont(new Font("Arial", Font.BOLD, 15));
            MStudentViewProject stdVProject = theStudentViewProjectModel.search(StudentID);
            if(theStudentViewProjectView.vSIDTF.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "Error: Please enter an ID");

            }
   
            else if (stdVProject != null) {
                theStudentViewProjectView.vidTF.setText(stdVProject.getStudProjectID());
                theStudentViewProjectView.vnameTF.setText(stdVProject.getStudProjectName());
                theStudentViewProjectView.vdescTF.setText(stdVProject.getStudProjectDesc());
                theStudentViewProjectView.vSpec.setSelectedItem(stdVProject.getStudProjectSpec());
                
                theStudentViewProjectView.vidTF.setEditable(false);
                theStudentViewProjectView.vidTF.setFont(new Font("Arial", Font.BOLD, 15));
                theStudentViewProjectView.vnameTF.setEditable(false);
                theStudentViewProjectView.vnameTF.setFont(new Font("Arial", Font.BOLD, 15));
                theStudentViewProjectView.vdescTF.setEditable(false);
                theStudentViewProjectView.vdescTF.setFont(new Font("Arial", Font.BOLD, 15));
                theStudentViewProjectView.vSpec.setEnabled(false);
                theStudentViewProjectView.vSpec.setFont(new Font("Arial", Font.BOLD, 15));
                
                theStudentViewProjectView.vSpec.setFont(new Font("Arial", Font.BOLD, 15));
                

                if (stdVProject.getStudProjectStatus().equals("Activated")) {
                    theStudentViewProjectView.vpjActivatedStatus.setSelected(true);
                    theStudentViewProjectView.vpjActivatedStatus.setEnabled(false);
                    theStudentViewProjectView.vpjDeactivatedStatus.setEnabled(false);
                    
                } else {
                    theStudentViewProjectView.vpjDeactivatedStatus.setSelected(true);
                    theStudentViewProjectView.vpjDeactivatedStatus.setEnabled(false);
                    theStudentViewProjectView.vpjActivatedStatus.setEnabled(false);

                    
                }

            
                theStudentViewProjectView.vLIDTF.setText(stdVProject.getLecturerID());
                theStudentViewProjectView.vLIDTF.setEditable(false);
                theStudentViewProjectView.vLIDTF.setFont(new Font("Arial", Font.BOLD, 15));

            } else {
                // not found
                JOptionPane.showMessageDialog(null, "You are not assigned with any projects yet !!");

            }

        }

    }
}
