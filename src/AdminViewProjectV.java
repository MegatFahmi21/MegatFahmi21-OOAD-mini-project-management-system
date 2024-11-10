import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.SwingConstants;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;




/**
 * It's a GUI class that displays a table of data from a CSV file.
 * @ author Lovesh
 */
public class AdminViewProjectV extends JFrame {
    JLabel vpADHEAD, scLabel;
    JButton btnGoBackViewAD;
    JPanel panelViewPAD;
    JTextField searchCriteriaTf;
    String[][] data = AdminViewProjectM.readCSV("lecturerprojects.csv");
    String[] columnNames = { "ID", "NAME", "DESC", "SPEC", "STATUS", "LECID", "STUID" };
    JTable table;
    JScrollPane scrollPane;
    JTableHeader head;
    TableRowSorter<TableModel> sorter;

    /**
     * 
     * The constructor of the class. It is called when you create an instance of the
     * class. It has all the components needed to form the GUI
     * Frame
     * 
     */
    public AdminViewProjectV() {
        this.setTitle("Admin View Project");
        this.setSize(900, 850);
        this.setResizable(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panelViewPAD = new JPanel(null);
        panelViewPAD.setBackground(Color.CYAN);

        // JLabel
        vpADHEAD = new JLabel("VIEW PROJECTS OFFERED", SwingConstants.CENTER);
        vpADHEAD.setFont(new Font("Arial", Font.BOLD, 28));
        vpADHEAD.setForeground(Color.red);
        vpADHEAD.setBounds(0, 0, 900, 105);
        vpADHEAD.setBackground(Color.black);
        vpADHEAD.setOpaque(true);
        panelViewPAD.add(vpADHEAD);

        scLabel = new JLabel("Search a criteria :", SwingConstants.CENTER);
        scLabel.setFont(new Font("Arial", Font.PLAIN, 22));
        scLabel.setForeground(Color.black);
        scLabel.setBounds(22, 123, 400, 105);
        panelViewPAD.add(scLabel);

  
        table = new JTable(data, columnNames);
        scrollPane = new JScrollPane(table);
        head = table.getTableHeader();
        sorter = new TableRowSorter<>(table.getModel());
        table.setPreferredScrollableViewportSize(new Dimension(830, 230));
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        table.setRowHeight(30);
        table.setFont(new Font("Verdana", Font.PLAIN, 10));
        table.setGridColor(Color.BLACK);
        table.setRowSorter(sorter);
        head.setBackground(Color.LIGHT_GRAY);
        head.setFont(new Font("Verdana", Font.BOLD, 15));

        scrollPane.setBounds(30, 300, 830, 230);

        searchCriteriaTf = new JTextField();
        searchCriteriaTf.setFont(new Font("Arial", Font.PLAIN, 15));
        searchCriteriaTf.setBounds(360, 160, 300, 30);
        panelViewPAD.add(searchCriteriaTf);

        
        // A code that allows the user to search for a specific data in the table.
        searchCriteriaTf.getDocument().addDocumentListener(new DocumentListener() {
            public void changedUpdate(DocumentEvent e) {
                filter();
            }
            public void removeUpdate(DocumentEvent e) {
                filter();
            }
            public void insertUpdate(DocumentEvent e) {
                filter();
            }
        
            public void filter() {
                sorter.setRowFilter(RowFilter.regexFilter("(?i)" + searchCriteriaTf.getText().trim()));
            }
         
        });

        
        
        panelViewPAD.add(scrollPane);

        btnGoBackViewAD = new JButton("BACK");
        btnGoBackViewAD.setFont(new Font("Arial", Font.PLAIN, 15));
        btnGoBackViewAD.setBounds(730, 670, 100, 30);

        panelViewPAD.add(btnGoBackViewAD);

        this.add(panelViewPAD);
        this.setVisible(true);

    }

    /**
     * It creates a new instance of the AdminViewProjectV class.
     * 
     * @param args The arguments passed to the program.
     */
    public static void main(String[] args) {
        new AdminViewProjectV();
    }

    // ActionListener

    /**
     * This function adds an action listener to the go back button
     * 
     * @param listenerForGoBackButton The ActionListener that will be added to the
     *                                button.
     */

    void addGoBackBtnListener(ActionListener listenerForGoBackButton) {
        btnGoBackViewAD.addActionListener(listenerForGoBackButton);
    }
}