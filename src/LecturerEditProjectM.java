import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

/**
 * Model for Lecturer Edit Project page
 * @author Syamil
 */
public class LecturerEditProjectM extends LecturerProjectM {


    /**
     * No arguements constructor
     */
    public LecturerEditProjectM() {
    }


    /**
     * Constructor for LecturerEditProjectM class
     * 
     * @param projectID     project ID needs to be unique
     * @param projectName   name of the project
     * @param projectDesc   description of the project
     * @param projectSpec   specialization of the project
     * @param projectStatus status of the project
     */
    public LecturerEditProjectM(String projectID, String projectName, String projectDesc, String projectSpec,
            String projectStatus, String assignedStudentID, String lecturerID) {
        super(projectID, projectName, projectDesc, projectSpec, projectStatus, assignedStudentID, lecturerID);
    }


    /**
     * Create a table with custom table model
     */
    public JTable createTable() {
        JTable table = new JTable();
        String[][] tableData = getTableData();
        String[] tableHeader = { "Project ID", "Project Name", "Specialization", "Status" };

        // create instance of table model
        DefaultTableModel tableModel = new DefaultTableModel(tableData, tableHeader) {
            // override the DefaultTableModel so that the table cell is not editable
            @Override
            public boolean isCellEditable(int row, int column) {
                return true;
            }
        };
        table.setModel(tableModel);

        // set the table so that it can only select one row
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        return table;
    }


    /**
     * Fetch the projects details and set it to 2D String array type
     * 
     * @return data in 2D String array for the table
     */
    public String[][] getTableData() {
        ArrayList<String[]> projectList = new ArrayList<String[]>();
        projectList = loadCSVFile();

        String[][] tableData;
        tableData = new String[projectList.size()][4];

        // convert ArrayList<String[]> to String[][]
        for (int row = 0; row < projectList.size(); row++) {
            String[] project = projectList.get(row);
            tableData[row][0] = project[0];
            tableData[row][1] = project[1];
            tableData[row][2] = project[3];
            tableData[row][3] = project[4];
        }

        return tableData;
    }

    /**
     * Update the JTable with the newly updated table data
     * 
     * @param table JTable that already has been created
     */
    public void updateTable(JTable table) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
        model.fireTableDataChanged();

        ArrayList<String[]> projectList = new ArrayList<String[]>();
        projectList = loadCSVFile();

        // rearrange the project array so that project specialization and status is infront of description
        String temp;
        for (String[] project : projectList) {
            temp = project[3]; // temp = project specialization
            project[3] = project[4]; // set project status to index 2
            project[2] = temp; // set project specialization to index 3
            model.addRow(project);
        }
    }

    /**
     * Update the CSV file with the newly updated projects data
     */
    public void updateCSVfile() {
        ArrayList<String[]> projectList = new ArrayList<String[]>();
        projectList = loadCSVFile();

        // update project list with the new project
        for (String[] project : projectList) {
            String selectedID = getProjectID();
            if ((project[0]).equals(selectedID)) {
                project[1] = getProjectName();
                project[2] = getProjectDesc();
                project[3] = getProjectSpec();
                project[4] = getProjectStatus();
            }
        }

        // save to csv file
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("lecturerprojects.csv"));
            for (String[] project : projectList) {
                writer.write(
                        project[0] + "," + project[1] + "," + project[2] + "," + project[3] + "," + project[4] + ","
                                + project[5] + "," + project[6] + "\n");
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * Check wheteher the project details is empty
     * 
     * @return true if project details is empty
     */
    public boolean emptySpaceExist() {
        String[] projectDetails = new String[] { getProjectName(), getProjectDesc(), getProjectSpec(),
                getProjectStatus() };
        for (String details : projectDetails) {
            if (details.trim().isEmpty()) {
                return true;
            }
        }
        return false;
    }

}
