import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The AdminViewProjectC class is the controller for the AdminViewProjectV view and the
 * AdminViewProjectM model.
 * @author Lovesh
 */
public class AdminViewProjectC {
    private AdminViewProjectV theAdminViewProjectView;
    private AdminViewProjectM theAdminViewProjectModel;
    

    // A constructor that takes in two parameters.
    /**
     * @param theAdminViewProjectView the view class that contains GUI components
     * @param theAdminViewProjectModel the model class that builds the logic of the functionality
     */
    public AdminViewProjectC(AdminViewProjectV theAdminViewProjectView, AdminViewProjectM theAdminViewProjectModel){
        this.theAdminViewProjectView = theAdminViewProjectView;
        this.theAdminViewProjectModel = theAdminViewProjectModel;

        this.theAdminViewProjectView.addGoBackBtnListener(new AdminViewPGoBackBtnListener());
     
    }
    
    /**
     * This class is an action listener for the button that takes the user back to the admin menu
     */
    class AdminViewPGoBackBtnListener implements ActionListener{
  
        /* (non-Javadoc)
         * An action listener for the button that takes the user back to the admin menu.
         * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
         */
        @Override
        public void actionPerformed(ActionEvent e)  {

            // TODO Auto-generated method stub

            if (e.getSource() == theAdminViewProjectView.btnGoBackViewAD ){
                AdminMenuFrame adminFrame = new AdminMenuFrame();
                adminFrame.setVisible(true);
                theAdminViewProjectView.setVisible(false);
                   

            }
            
        }

    }





}