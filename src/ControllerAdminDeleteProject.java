import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

/**
 * The ControllerAdminDeleteProject class is a controller class that controls the
 * ViewAdminDeleteProject class and the ModelAdminProject class.
 * @author Lovesh
 */
public class ControllerAdminDeleteProject {
    private ViewAdminDeleteProject theAdminDeleteProjectView;
    private ModelAdminProject theAdminDeleteProjectModel;

    /**
     * constructor for ControllerAdminDeleteProject class  
     * @param theAdminDeleteProjectView the view class of DeleteProject GUI 
     * @param theAdminDeleteProjectModel the model class of the Project 
     */
    public ControllerAdminDeleteProject(ViewAdminDeleteProject theAdminDeleteProjectView,
        ModelAdminProject theAdminDeleteProjectModel) {
        this.theAdminDeleteProjectView = theAdminDeleteProjectView;
        this.theAdminDeleteProjectModel = theAdminDeleteProjectModel;

        this.theAdminDeleteProjectView.addDeleteProjectListener(new AdminDeleteProjectListener());
        this.theAdminDeleteProjectView.addGoBackBtnListener(new AdminGoBackBtnListener());
       

    }

    /**
     * This class is an ActionListener that deletes a project.
     */
    class AdminDeleteProjectListener implements ActionListener {

        /**
         * The action performed when the delete button is clicked
         * 
         * @param e the event object
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            String adminProjectID = theAdminDeleteProjectView.didTF.getText();
            theAdminDeleteProjectModel.delete(adminProjectID);
            JOptionPane.showMessageDialog(null, "Deleting Success !");
                
     

        }

    }

    /**
     * > This class is an ActionListener that listens for the AdminGoBackBtn to be clicked
     */
    class AdminGoBackBtnListener implements ActionListener {
        /**
         * When the button is clicked, the current frame is set to invisible and the AdminMenuFrame is
         * set to visible
         * 
         * @param e the event object
         */
        @Override
        // A method that is called when the button is clicked.
        public void actionPerformed(ActionEvent e) {

            // TODO Auto-generated method stub

            if (e.getSource() == theAdminDeleteProjectView.btnGoBackAD) {
                theAdminDeleteProjectView.setVisible(false);
                AdminMenuFrame adminFrame = new AdminMenuFrame();
                adminFrame.setVisible(true);
                

            }

        }

    }
}
