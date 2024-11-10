import java.awt.event.*;

import javax.swing.JOptionPane;

/**
 * This class is a controller for the admin add project view and admin project model class
 * @author Lovesh
 */
public class ControllerAdminAddProject {
    private ViewAdminAddProject theAdminAddProjectView;
    private ModelAdminProject theAdminAddProjectModel;

     
    /**
     * A constructor that takes in two parameters.
     * @param theAdminAddProjectView the view class that contains GUI components
     * @param theAdminAddProjectModel the model class that builds the logic of the functionality
     */
    public ControllerAdminAddProject(ViewAdminAddProject theAdminAddProjectView,ModelAdminProject theAdminAddProjectModel){
        this.theAdminAddProjectView = theAdminAddProjectView;
        this.theAdminAddProjectModel = theAdminAddProjectModel;

        this.theAdminAddProjectView.addAddProjectListener(new AdminAddProjectListener());
        this.theAdminAddProjectView.addGoBackBtnListener(new AdminGoBackBtnListener());

    }
    
    /**
     * > This class is an ActionListener that adds a project to the database
     */
    class AdminAddProjectListener implements ActionListener{
  
        @Override
        public void actionPerformed(ActionEvent e)  {
            String adminProjectID = theAdminAddProjectView.idTF.getText();
            String adminProjectName = theAdminAddProjectView.nameTF.getText();
            String adminProjectDesc = theAdminAddProjectView.descTF.getText();
            String adminProjectSpec = (String)theAdminAddProjectView.Spec.getSelectedItem();
            boolean isActivated = theAdminAddProjectView.pjActivatedStatus.isSelected();
            String adminProjectStatus = isActivated ? "Activated" : "Deactivated";

           // TODO Auto-generated method stub

            if (e.getSource() == theAdminAddProjectView.btnAddProjectAD ){
                if (adminProjectID.isEmpty() || adminProjectName.isEmpty() || adminProjectDesc.isEmpty() || adminProjectSpec.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Error: Please fill in all fields.");
                } else {
                    boolean isProjectIDexist = theAdminAddProjectModel.adminCheckPJIDExist(adminProjectID);
                    if (isProjectIDexist) {
                        JOptionPane.showMessageDialog(null, "Error: Project ID exist");
                    } else {
                        theAdminAddProjectModel.adminAddPJToCsv(adminProjectID, adminProjectName, adminProjectDesc, adminProjectSpec, adminProjectStatus);
                        JOptionPane.showMessageDialog(null, "Added");
                    }
                }
            }
            
        }

    }

    /**
     * > This class is an ActionListener that listens for the AdminGoBackBtn to be clicked
     */
    class AdminGoBackBtnListener implements ActionListener{
  
        /**
         * When the user clicks the "Go Back" button, the current frame is set to invisible and the
         * AdminMenuFrame is set to visible
         * 
         * @param e the event object
         */
        @Override
        public void actionPerformed(ActionEvent e)  {

            // TODO Auto-generated method stub

            if (e.getSource() == theAdminAddProjectView.btnGoBackAD ){
                theAdminAddProjectView.setVisible(false);
                AdminMenuFrame adminFrame = new AdminMenuFrame();
                adminFrame.setVisible(true);
                
                   

            }
            
        }

    }
}
