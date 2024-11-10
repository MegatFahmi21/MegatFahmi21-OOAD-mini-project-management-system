import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * GUI components for Lecturer Add Project page
 * @author Syamil
 */
public class LecturerAddProjectV extends JFrame {
    JPanel panelAP;
    JLabel header, idLabel, nameLabel, descLabel, specLabel, statusLabel;
    JTextField idTF, nameTF;
    JTextArea descTF;
    JComboBox<String> specComBox;
    JRadioButton activatedBtn, deactivatedBtn;
    JButton addBtn, backBtn;
    ButtonGroup adGroup;

    /**
     * Constructor for LecturerAddProjectV class
     */
    public LecturerAddProjectV() {
        this.setTitle("Add Project Page");
        this.setSize(850, 800);
        this.setResizable(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panelAP = new JPanel(null);
        panelAP.setBackground(Color.CYAN);

        header = new JLabel("ADD A PROJECT", SwingConstants.CENTER);
        header.setFont(new Font("Arial", Font.BOLD, 28));
        header.setForeground(Color.red);
        header.setBounds(0, 0, 890, 105);
        header.setBackground(Color.black);
        header.setOpaque(true);
        panelAP.add(header);

        idLabel = new JLabel("Project ID                 :");
        idLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        idLabel.setForeground(Color.black);
        idLabel.setBounds(134, 100, 900, 100);
        panelAP.add(idLabel);

        idTF = new JTextField();
        idTF.setFont(new Font("Arial", Font.PLAIN, 15));
        idTF.setBounds(340, 134, 300, 30);
        panelAP.add(idTF);

        nameLabel = new JLabel("Project Name            :");
        nameLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        nameLabel.setForeground(Color.black);
        nameLabel.setBounds(134, 180, 900, 100);
        panelAP.add(nameLabel);

        nameTF = new JTextField();
        nameTF.setFont(new Font("Arial", Font.PLAIN, 15));
        nameTF.setBounds(340, 215, 300, 30);
        panelAP.add(nameTF);

        descLabel = new JLabel("Project Description    :");
        descLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        descLabel.setForeground(Color.black);
        descLabel.setBounds(134, 260, 900, 100);
        panelAP.add(descLabel);

        descTF = new JTextArea();
        descTF.setFont(new Font("Arial", Font.PLAIN, 15));
        descTF.setBounds(340, 296, 300, 120);
        panelAP.add(descTF);

        specLabel = new JLabel("Project Specialisation :");
        specLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        specLabel.setForeground(Color.black);
        specLabel.setBounds(134, 425, 900, 100);
        panelAP.add(specLabel);

        String[] specList = { "Cybersecurity", "Data Science", "Software Engineering", "Game Development" };
        specComBox = new JComboBox<>(specList);
        specComBox.setBounds(340, 460, 300, 30);
        panelAP.add(specComBox);

        statusLabel = new JLabel("Project Status            :");
        statusLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        statusLabel.setForeground(Color.black);
        statusLabel.setBounds(134, 510, 900, 100);
        panelAP.add(statusLabel);

        activatedBtn = new JRadioButton("Activated");
        activatedBtn.setFont(new Font("Arial", Font.PLAIN, 15));
        activatedBtn.setBackground(Color.cyan);
        activatedBtn.setBounds(340, 545, 100, 30);

        deactivatedBtn = new JRadioButton("Deactivated");
        deactivatedBtn.setFont(new Font("Arial", Font.PLAIN, 15));
        deactivatedBtn.setBackground(Color.cyan);
        deactivatedBtn.setBounds(525, 545, 120, 30);
        
        adGroup = new ButtonGroup();
        adGroup.add(activatedBtn);
        adGroup.add(deactivatedBtn);
        panelAP.add(activatedBtn);
        panelAP.add(deactivatedBtn);
        activatedBtn.setSelected(true);
        
        addBtn = new JButton("ADD");
        addBtn.setFont(new Font("Arial", Font.PLAIN, 15));
        addBtn.setBounds(520, 670, 100, 30);
        panelAP.add(addBtn);

        backBtn = new JButton("BACK");
        backBtn.setFont(new Font("Arial", Font.PLAIN, 15));
        backBtn.setBounds(640, 670, 100, 30);
        panelAP.add(backBtn);
        
        this.add(panelAP);
        this.setVisible(true);
    }

    /**
     * Add Action Listener to add button
     * @param listenerAddBtn add listener class that implements Action Listener
     */
    void addAddProjectListener(ActionListener listenerAddBtn) {
        addBtn.addActionListener(listenerAddBtn);
    }

    /**
     * Add Action Listener to back button
     * @param listenerBackBtn add listener class that implements Action Listener
     */
    void addGoBackBtnListener(ActionListener listenerBackBtn) {
        backBtn.addActionListener(listenerBackBtn);
    }

}
