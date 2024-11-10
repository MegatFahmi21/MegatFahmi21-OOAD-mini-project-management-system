import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;


/**
 * The AssignProjectC class is a controller class that handles the action events of the AssignProjectV
 * class.
 * @author Najmuddin
 */
public class AssignProjectC {
    
    private AssignProjectV theViewAssignProject;
    private AssignProjectM theAssignProjectModel;


    /**
     * A constructor that takes in two parameters.
     * 
     * @param theViewAssignProject A reference to the view class. 
     * @param theAssignProjectModel A reference to the model class.
     */
    public AssignProjectC(AssignProjectV theViewAssignProject,
    AssignProjectM theAssignProjectModel) {
    this.theViewAssignProject = theViewAssignProject;
    this.theAssignProjectModel = theAssignProjectModel;

    this.theViewAssignProject.addAssignProjectListener(new AssignProjectListener());
    this.theViewAssignProject.addUnassignProjectListener(new UnassignProjectListener());
    this.theViewAssignProject.addGoBackBtnListener(new GoBackBtnListener());
    this.theViewAssignProject.addSearchEAPBtnListener(new SearchEPBtnListener());

}


/**
 * This class is a listener class for the AssignProjectView class.
 */
class AssignProjectListener implements ActionListener {

    /**
     * It's supposed to take the values from the text fields in the GUI and assign them to the
     * variables in the model.
     * 
     * @param e the event object
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        String adminProjectID = theViewAssignProject.eidTF.getText();
        AssignProjectM adEdProject = theAssignProjectModel.search(adminProjectID);

        if (adEdProject != null) {
            adEdProject.edit(theViewAssignProject.eidTF,theViewAssignProject.esidTF,theViewAssignProject.elcidTF);
            JOptionPane.showMessageDialog(null, "Assignment Success !");
        } else {
            JOptionPane.showMessageDialog(null, "Assignment Failed !");
        }
            
 

    }

}


/**
 * This class is a listener class for the unassign button in the view class
 */
class UnassignProjectListener implements ActionListener {

    @Override
    /**
     * A method that is called when the unassign button is clicked. It takes the values from the text
     * fields in the GUI and assign them to the variables in the model.
     * 
     * @param e the event object
     */
  
    public void actionPerformed(ActionEvent e) {
        String adminProjectID = theViewAssignProject.eidTF.getText();
        AssignProjectM adEdProject = theAssignProjectModel.search(adminProjectID);

        if (adEdProject != null) {
            adEdProject.delete(theViewAssignProject.eidTF,theViewAssignProject.esidTF);
            JOptionPane.showMessageDialog(null, "Unassignment Success !");
        } else {
            JOptionPane.showMessageDialog(null, "Unassignment Failed !");
        }
            
 

    }

}



    /**
     * This class is used to go back to the lecturer menu frame when the lecturer clicks the go back
     * button.
     * </code>
     */
    class GoBackBtnListener implements ActionListener {
        /**
         * If the button is pressed, the lecturer menu frame is set to visible and the view assign
         * project frame is set to invisible
         * 
         * @param e the event object
         */
        @Override
        public void actionPerformed(ActionEvent e) {

            // TODO Auto-generated method stub

            if (e.getSource() == theViewAssignProject.btnGoBackAD) {
                LecturerMenuFrame lectureFrame = new LecturerMenuFrame();
                lectureFrame.setVisible(true);
                theViewAssignProject.setVisible(false);

            }

        }

    }

    /**
     * This is a listener class for the search button in the GUI. It searches for the
     * project ID and student ID in the database and displays the project details in the text fields
     */
    class SearchEPBtnListener implements ActionListener {
       
       /**
        * The function is supposed to load the student list from the CSV file based on the project
        * specialisation
        * 
        * @param e the event object
        */
        @Override
        public void actionPerformed(ActionEvent e) {
            String adminProjectID = theViewAssignProject.eidTF.getText();
            String StudentID = theViewAssignProject.esidTF.getText();
            AssignProjectM adEdProject = theAssignProjectModel.search(adminProjectID);
            StudentModel stuid = theAssignProjectModel.searchStudent(StudentID);

            if (adEdProject != null) {
                theViewAssignProject.enameTF.setText(adEdProject.getAdminProjectName());
                theViewAssignProject.edescTF.setText(adEdProject.getAdminProjectDesc());
                theViewAssignProject.eSpec.setSelectedItem(adEdProject.getAdminProjectSpec());

                theViewAssignProject.studentComboBox.removeAllItems();
                ArrayList<StudentModel> studentList = new ArrayList<StudentModel>();
                String projectSpec = (String) theViewAssignProject.eSpec.getSelectedItem();
                studentList = theAssignProjectModel.loadStudentFromCSV(projectSpec);
                
                if (studentList.size() == 0) {
                    StudentModel nullStudent = new StudentModel(null, null, null, null);
                    studentList.add(nullStudent);
                }

                for (StudentModel student : studentList) {
                    theViewAssignProject.studentComboBox.addItem(student);
                }

            } else {
                // not found
                JOptionPane.showMessageDialog(null, "Project ID is not found");

            }
           

        }


    }




}
