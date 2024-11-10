//Import classes and create variables
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;


/**
 * It's a GUI class that displays the data from a CSV file.
 * @ author Ameera
 */

public class LecturerViewProject extends JFrame {
    private JTextArea dataText;

//Create the GUI interface
    public LecturerViewProject() {
        dataText = new JTextArea();

    JButton openButton = new JButton ("Open .csv file");
    openButton.addActionListener (new ActionListener() {

        @Override
        public void actionPerformed (ActionEvent e) {
            openCsv();
        }
    });

    add (openButton, BorderLayout.NORTH); // add the open button to the top of the frame
    add (dataText, BorderLayout.CENTER); // add the text area to the center of the frame
    pack();
    setVisible(true);
  }

//Create a function to open the csv file
  private void openCsv() {
    try {
        FileReader fileReader = new FileReader ("lecturerprojects.csv");
        BufferedReader reader = new BufferedReader (fileReader);

        String row;
        while ((row = reader.readLine()) != null) {
            dataText.append (row + "\n"); // append the data to the text area
        }
        reader.close();
    }

    catch (Exception ex) {
        ex.printStackTrace(); // print any exceptions
    }
  }

//Main method to run the GUI
  public static void main (String[] args) {
    new LecturerViewProject().setVisible(true);
  }
}


