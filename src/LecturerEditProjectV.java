import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.ListSelectionListener;

/**
 * GUI Components for Lecturer Edit Project page
 * @author Syamil
 */
public class LecturerEditProjectV extends JFrame {
    private LecturerEditProjectM editProjectM;
    private JRadioButton aBtn;
    private ButtonGroup adBtnGroup;
    private JButton backBtn;
    private JRadioButton dBtn;
    private JTextArea descArea;
    private JLabel descLabel;
    private JScrollPane descPane;
    private JLabel header;
    private JButton helpBtn;
    private JLabel idLabel;
    private JTextField idTF;
    private JLabel nameLabel;
    private JTextField nameTF;
    private JPanel panelEP;
    private JButton updateBtn;
    private JScrollPane scrollPaneTable;
    private JComboBox<String> specComboBox;
    private JLabel specLabel;
    private JLabel statusLabel;
    private JTable table;

    /**
     * Constructor for LecturerEditProjectV class
     */
    public LecturerEditProjectV() {
        this.setTitle("Edit Project Page");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        editProjectM = new LecturerEditProjectM();
        initComponents();
        setComponents();
        setComponentsLayout();
    }

    /**
     * Initialize the GUI components
     */
    private void initComponents() {
        adBtnGroup = new ButtonGroup();
        panelEP = new JPanel();
        idTF = new JTextField();
        nameTF = new JTextField();
        descPane = new JScrollPane();
        descArea = new JTextArea();
        specComboBox = new JComboBox<>();
        aBtn = new JRadioButton();
        dBtn = new JRadioButton();
        scrollPaneTable = new JScrollPane();
        table = new JTable();
        idLabel = new JLabel();
        nameLabel = new JLabel();
        descLabel = new JLabel();
        specLabel = new JLabel();
        statusLabel = new JLabel();
        header = new JLabel();
        updateBtn = new JButton();
        backBtn = new JButton();
        helpBtn = new JButton();

    }

    /**
     * Set text for the GUI components
     */
    private void setComponents() {

        idTF.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        idTF.setEditable(false);

        nameTF.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        descArea.setColumns(20);
        descArea.setRows(5);
        descPane.setViewportView(descArea);

        String[] specList = { "Cybersecurity", "Data Science", "Software Engineering", "Game Development" };
        specComboBox.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        specComboBox.setModel(new DefaultComboBoxModel<>(specList));

        adBtnGroup.add(aBtn);
        aBtn.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        aBtn.setText("Activated");

        adBtnGroup.add(dBtn);
        dBtn.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        dBtn.setText("Deactivated");

        table.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        table = editProjectM.createTable();

        scrollPaneTable.setViewportView(table);

        idLabel.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        idLabel.setText("Project ID :");

        nameLabel.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        nameLabel.setText("Project Name :");

        descLabel.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        descLabel.setText("Description :");

        specLabel.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        specLabel.setText("Specialization :");

        statusLabel.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        statusLabel.setText("Status :");

        header.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        header.setText("Edit Project");

        updateBtn.setText("Update");
        backBtn.setText("Back");
        helpBtn.setText("Help");

    }

    /**
     * Set the layout of the GUI components
     */
    private void setComponentsLayout() {
        GroupLayout panelEPLayout = new GroupLayout(panelEP);
        panelEP.setLayout(panelEPLayout);
        panelEPLayout.setHorizontalGroup(
                panelEPLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(panelEPLayout.createSequentialGroup()
                                .addGroup(panelEPLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addComponent(helpBtn)
                                        .addGroup(panelEPLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                .addGroup(panelEPLayout.createSequentialGroup()
                                                        .addGroup(panelEPLayout
                                                                .createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                .addGroup(panelEPLayout.createSequentialGroup()
                                                                        .addGap(45, 45, 45)
                                                                        .addGroup(panelEPLayout
                                                                                .createParallelGroup(
                                                                                        GroupLayout.Alignment.TRAILING)
                                                                                .addComponent(idLabel)
                                                                                .addComponent(nameLabel)
                                                                                .addComponent(descLabel)
                                                                                .addComponent(specLabel)
                                                                                .addComponent(statusLabel))
                                                                        .addPreferredGap(
                                                                                LayoutStyle.ComponentPlacement.RELATED)
                                                                        .addGroup(panelEPLayout
                                                                                .createParallelGroup(
                                                                                        GroupLayout.Alignment.LEADING)
                                                                                .addComponent(nameTF,
                                                                                        GroupLayout.PREFERRED_SIZE, 234,
                                                                                        GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(idTF,
                                                                                        GroupLayout.PREFERRED_SIZE, 234,
                                                                                        GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(descPane,
                                                                                        GroupLayout.PREFERRED_SIZE,
                                                                                        GroupLayout.DEFAULT_SIZE,
                                                                                        GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(specComboBox,
                                                                                        GroupLayout.PREFERRED_SIZE, 234,
                                                                                        GroupLayout.PREFERRED_SIZE)
                                                                                .addGroup(panelEPLayout
                                                                                        .createSequentialGroup()
                                                                                        .addComponent(aBtn)
                                                                                        .addGap(32, 32, 32)
                                                                                        .addComponent(dBtn))))
                                                                .addGroup(panelEPLayout.createSequentialGroup()
                                                                        .addGap(119, 119, 119)
                                                                        .addComponent(backBtn)
                                                                        .addGap(18, 18, 18)
                                                                        .addComponent(updateBtn)))
                                                        .addGap(18, 18, 18)
                                                        .addComponent(scrollPaneTable, GroupLayout.PREFERRED_SIZE, 441,
                                                                GroupLayout.PREFERRED_SIZE))
                                                .addGroup(panelEPLayout.createSequentialGroup()
                                                        .addGap(371, 371, 371)
                                                        .addComponent(header))))
                                .addContainerGap(57, Short.MAX_VALUE)));
        panelEPLayout.setVerticalGroup(
                panelEPLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, panelEPLayout.createSequentialGroup()
                                .addContainerGap(41, Short.MAX_VALUE)
                                .addComponent(header)
                                .addGap(9, 9, 9)
                                .addComponent(helpBtn)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelEPLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(scrollPaneTable, GroupLayout.PREFERRED_SIZE,
                                                GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addGroup(panelEPLayout.createSequentialGroup()
                                                .addGroup(panelEPLayout
                                                        .createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(idTF, GroupLayout.PREFERRED_SIZE,
                                                                GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(idLabel))
                                                .addGap(18, 18, 18)
                                                .addGroup(panelEPLayout
                                                        .createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(nameTF, GroupLayout.PREFERRED_SIZE,
                                                                GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(nameLabel))
                                                .addGap(18, 18, 18)
                                                .addGroup(panelEPLayout
                                                        .createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(descPane, GroupLayout.PREFERRED_SIZE,
                                                                GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(descLabel))
                                                .addGap(18, 18, 18)
                                                .addGroup(panelEPLayout
                                                        .createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(specComboBox, GroupLayout.PREFERRED_SIZE,
                                                                GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(specLabel))
                                                .addGap(27, 27, 27)
                                                .addGroup(panelEPLayout
                                                        .createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(aBtn)
                                                        .addComponent(dBtn)
                                                        .addComponent(statusLabel))
                                                .addGap(47, 47, 47)
                                                .addGroup(panelEPLayout
                                                        .createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(backBtn)
                                                        .addComponent(updateBtn))))
                                .addGap(103, 103, 103)));

        getContentPane().add(panelEP, java.awt.BorderLayout.CENTER);

        pack();
    }

    /**
     * Get the created table
     * @return JTable
     */
    public JTable getTable() {
        return this.table;
    }

    public JTextField getIdTF() {
        return this.idTF;
    }

    public JTextField getNameTF() {
        return this.nameTF;
    }

    public JTextArea getDescArea() {
        return this.descArea;
    }

    public JRadioButton getActivatedBtn() {
        return this.aBtn;
    }

    public JComboBox<String> getSpecComboBox() {
        return this.specComboBox;
    }

    public JButton getBackBtn() {
        return this.backBtn;
    }

    public JButton getUpdateBtn() {
        return this.updateBtn;
    }

    public JButton getHelpButton() {
        return this.helpBtn;
    }

    /**
     * Set the project ID text field with the given parameter
     * @param projectID
     */
    public void showID(String projectID) {
        idTF.setText(projectID);
    }

    /**
     * Set the project name text field with the given parameter
     * @param projectName
     */
    public void showName(String projectName) {
        nameTF.setText(projectName);
    }

    /**
     * Set the project description text area with the given parameter
     * @param description
     */
    public void showDescription(String description) {
        descArea.setText(description);
    }

    /**
     * Set the project specialization combo box with the given parameter
     * @param specialization
     */
    public void showSpecialization(String specialization) {
        specComboBox.setSelectedItem(specialization);
    }

    /**
     * Set the project status radio button with the given parameter
     * @param status
     */
    public void showStatus(String status) {
        if (status.equals("Activated")) {
            aBtn.setSelected(true);
        }
        else if (status.equals("Deactivated")) {
            dBtn.setSelected(true);
        }
    }

    /**
     * Add Table Listener to the table
     * @param e
     */
    void addTableListener(ListSelectionListener e) {
        table.getSelectionModel().addListSelectionListener(e);
    }

    /**
     * Add Action Listener to update button
     * @param e
     */
    void addUpdateBtnListener(ActionListener e) {
        updateBtn.addActionListener(e);
    }

    /**
     * Add Action Listener to back button
     * @param e
     */
    void addBackBtnListener(ActionListener e) {
        backBtn.addActionListener(e);
    }

    /**
     * Add Action Listener to help button
     * @param e
     */
    void addHelpBtnListener(ActionListener e) {
        helpBtn.addActionListener(e);
    }


}
