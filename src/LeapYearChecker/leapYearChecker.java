package LeapYearChecker;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class leapYearChecker {
    private JPanel panel1;
    private JTextField textField1;
    private JButton button1;


    public leapYearChecker() {
        textField1.setName("YearTextField");
        button1.setName("CheckYearButton");
        panel1.setName("MainPanel");

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String yearText = textField1.getText();
                try {
                    int year = Integer.parseInt(yearText);
                    String message = isLeapYear(year) ? "Leap Year" : "Not a leap year";
                    JOptionPane.showMessageDialog(null, message, "Message", JOptionPane.INFORMATION_MESSAGE);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Please enter a valid year.", "Message", JOptionPane.ERROR_MESSAGE);
                }

            }
        });
    }

    private boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Leap Year Checker");
        leapYearChecker checker = new leapYearChecker();
        frame.setContentPane(checker.panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setSize(300,200);

    }
}
