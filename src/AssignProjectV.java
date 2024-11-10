import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

    /**
     * This class is used to assign a project to a student.
     * @author Najmuddin
     */
    public class AssignProjectV extends JFrame {
        JLabel epADHEAD, ePID, ePNAME, ePDESC, ePSPEC, ePSTATUS, eSTID, eStuID, idLabel, nameLabel,lcLabel,Lcnamelabel;
        JTextField eidTF, enameTF, esidTF,elcidTF;
        JTextArea edescTF;
        JComboBox<String> eSpec;
        JButton btnAssignProjectAD, btnGoBackAD, btnSearchEPAD,btnUnassignProjectAD;
        JPanel panelEditPAD;
        ButtonGroup adeGroup;
        AssignProjectM assignProjectM;
        String projectSpec;
        ArrayList<StudentModel> studentList;
        ArrayList<LecturerAddModel> LecturerList;
        JComboBox studentComboBox;
        JComboBox LecturerComboBox;
       
    
        public AssignProjectV() {
            this.setTitle("Lecturer Assign Project");
            this.setSize(890, 900);
            this.setResizable(true);
            this.setLocationRelativeTo(null);
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
            JPanel panelEditAD = new JPanel(null);
            panelEditAD.setBackground(Color.CYAN);
    
            // JLabel
            epADHEAD = new JLabel("PROJECT ASSIGNMENT", SwingConstants.CENTER);
            epADHEAD.setFont(new Font("Arial", Font.BOLD, 28));
            epADHEAD.setForeground(Color.red);
            epADHEAD.setBounds(0, 0, 890, 105);
            epADHEAD.setBackground(Color.black);
            epADHEAD.setOpaque(true);
            panelEditAD.add(epADHEAD);
    
            ePID = new JLabel("Project ID                 :");
            ePID.setFont(new Font("Arial", Font.PLAIN, 20));
            ePID.setForeground(Color.black);
            ePID.setBounds(134, 100, 900, 100);
            panelEditAD.add(ePID);
    
            eidTF = new JTextField();
            eidTF.setFont(new Font("Arial", Font.PLAIN, 15));
            eidTF.setBounds(340, 134, 300, 30);
            panelEditAD.add(eidTF);
    
            ePNAME = new JLabel("Project Name            :");
            ePNAME.setFont(new Font("Arial", Font.PLAIN, 20));
            ePNAME.setForeground(Color.black);
            ePNAME.setBounds(134, 180, 900, 100);
            panelEditAD.add(ePNAME);
    
            enameTF = new JTextField();
            enameTF.setFont(new Font("Arial", Font.PLAIN, 15));
            enameTF.setBounds(340, 215, 300, 30);
            panelEditAD.add(enameTF);
    
            ePDESC = new JLabel("Project Description    :");
            ePDESC.setFont(new Font("Arial", Font.PLAIN, 20));
            ePDESC.setForeground(Color.black);
            ePDESC.setBounds(134, 260, 900, 100);
            panelEditAD.add(ePDESC);
    
            edescTF = new JTextArea();
            edescTF.setFont(new Font("Arial", Font.PLAIN, 15));
            edescTF.setBounds(340, 296, 300, 75);
            panelEditAD.add(edescTF);
    
            ePSPEC = new JLabel("Project Specialisation :");
            ePSPEC.setFont(new Font("Arial", Font.PLAIN, 20));
            ePSPEC.setForeground(Color.black);
            ePSPEC.setBounds(134, 360, 900, 100);
            panelEditAD.add(ePSPEC);
    
            String[] adeSpecial = { "Cybersecurity", "Data Science", "Software Engineering", "Game Development" };
            eSpec = new JComboBox<>(adeSpecial);
            eSpec.setBounds(340, 395, 300, 30);
            panelEditAD.add(eSpec);

            idLabel = new JLabel("Student ID :");
            idLabel.setFont(new Font("Arial", Font.PLAIN, 20));
            idLabel.setForeground(Color.black);
            idLabel.setBounds(134, 480, 900, 30);
            panelEditAD.add(idLabel);
            
            esidTF = new JTextField();
            esidTF.setBounds(340, 480, 300, 30);
            panelEditAD.add(esidTF);
    
            nameLabel = new JLabel("Assign to Student :");
            nameLabel.setFont(new Font("Arial", Font.PLAIN, 20));
            nameLabel.setForeground(Color.black);
            nameLabel.setBounds(134, 560, 900, 30);
            panelEditAD.add(nameLabel);

            // get the specialisation from the spec combo box
            projectSpec = (String) eSpec.getSelectedItem();

            assignProjectM = new AssignProjectM();
            studentList = assignProjectM.loadStudentFromCSV(projectSpec); // load Students class from "Student.csv" to ArrayList

            if (studentList.size() == 0) {
                StudentModel nullStudent = new StudentModel(null, null, null, null);
                studentList.add(nullStudent);
            }
            
            studentComboBox = StudentComboBox(studentList);
            studentComboBox.setBounds(340, 560, 300, 30);
            panelEditAD.add(studentComboBox);    

            lcLabel = new JLabel("Lecturer ID :");
            lcLabel.setFont(new Font("Arial", Font.PLAIN, 20));
            lcLabel.setForeground(Color.black);
            lcLabel.setBounds(134, 630, 900, 30);
            panelEditAD.add(lcLabel);
            
            elcidTF = new JTextField();
            elcidTF.setBounds(340, 630, 300, 30);
            panelEditAD.add(elcidTF);
    
            Lcnamelabel = new JLabel("Lecturer Assigning :");
            Lcnamelabel.setFont(new Font("Arial", Font.PLAIN, 20));
            Lcnamelabel.setForeground(Color.black);
            Lcnamelabel.setBounds(134, 700, 900, 30);
            panelEditAD.add(Lcnamelabel);
            
            assignProjectM = new AssignProjectM();
            LecturerList = assignProjectM.loadLecturerFromCSV(); // load Lecturer class from "Lecturer.csv" to ArrayList

            if (LecturerList.size() > 0) {
                LecturerComboBox = LecturerComboBox(LecturerList);
                LecturerComboBox.setBounds(340, 700, 300, 30);
                panelEditAD.add(LecturerComboBox); 
            }

            btnAssignProjectAD = new JButton("ASSIGN");
            btnAssignProjectAD.setFont(new Font("Arial", Font.PLAIN, 15));
            btnAssignProjectAD.setBounds(385, 800, 100, 30);
    
            panelEditAD.add(btnAssignProjectAD);

            btnUnassignProjectAD = new JButton("UNASSIGN");
            btnUnassignProjectAD.setFont(new Font("Arial", Font.PLAIN, 15));
            btnUnassignProjectAD.setBounds(505, 800, 110, 30);
    
            panelEditAD.add(btnUnassignProjectAD);
    
            btnGoBackAD = new JButton("BACK");
            btnGoBackAD.setFont(new Font("Arial", Font.PLAIN, 15));
            btnGoBackAD.setBounds(640, 800, 100, 30);
    
            panelEditAD.add(btnGoBackAD);
    
            btnSearchEPAD = new JButton("SEARCH");
            btnSearchEPAD.setFont(new Font("Arial", Font.PLAIN, 15));
            btnSearchEPAD.setBounds(760, 800, 100, 30);
    
            panelEditAD.add(btnSearchEPAD);
    
            this.add(panelEditAD);
            this.setVisible(true);
        }
    

        /**
         * Create combo box with ArrayList of StudentModel
         * @param ArrayList of StudentModel 
         * @return JComboBox
         */
        public JComboBox StudentComboBox(ArrayList<StudentModel> studentList) {
            final JComboBox comboBox = new JComboBox(studentList.toArray());
            comboBox.setRenderer(new ComboBoxRenderer());
            comboBox.addItemListener(new ItemListener() {
                @Override
                public void itemStateChanged(ItemEvent e) {
                    if (e.getStateChange() == ItemEvent.SELECTED) {
                        StudentModel student = (StudentModel) comboBox.getSelectedItem();
                        esidTF.setText(student.getId());
                    }
                }
            });
            return comboBox;
        }


        /**
         * Set the combo box with students name
         */
        public class ComboBoxRenderer extends DefaultListCellRenderer {

            @Override
            public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                JLabel label = new JLabel();
                label.setText(null);
                try {
                    label = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                    StudentModel student = (StudentModel) value;
                    label.setText(student.getUsername());
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "There is no student available with the same specialisaion as the project");
                }
                return label;
            }
        }


        /**
         * Create combo box with ArrayList of StudentModel
         * @param ArrayList of StudentModel 
         * @return JComboBox
         */
        public JComboBox LecturerComboBox(ArrayList<LecturerAddModel> LecturerList) {
            final JComboBox comboBox = new JComboBox(LecturerList.toArray());
            comboBox.setRenderer(new ComboBoxRenderer2());
            comboBox.addItemListener(new ItemListener() {
                @Override
                public void itemStateChanged(ItemEvent e) {
                    if (e.getStateChange() == ItemEvent.SELECTED) {
                        LecturerAddModel Lecturer = (LecturerAddModel) comboBox.getSelectedItem();
                        elcidTF.setText(Lecturer.getId()); //
                    }
                }
            });
            return comboBox;
        }


         /**
         * Set the combo box with students name
         */
        public class ComboBoxRenderer2 extends DefaultListCellRenderer {

            @Override
            public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                JLabel label = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                LecturerAddModel Lecturer = (LecturerAddModel) value;
                label.setText(Lecturer.getUsername());
                return label;
            }
        }


        // ActionListener
    
        void addAssignProjectListener(ActionListener listenerForEditProjectButton) {
            btnAssignProjectAD.addActionListener(listenerForEditProjectButton);
        }

        void addUnassignProjectListener(ActionListener listenerForEditProjectButton) {
            btnUnassignProjectAD.addActionListener(listenerForEditProjectButton);
        }
    
        void addGoBackBtnListener(ActionListener listenerForGoBackButton) {
            btnGoBackAD.addActionListener(listenerForGoBackButton);
        }
    
        void addSearchEAPBtnListener(ActionListener listenerForSearchEAPButton) {
            btnSearchEPAD.addActionListener(listenerForSearchEAPButton);
        }
    
        
    

public static void main(String[] args) {
    new AssignProjectV();
}
}




