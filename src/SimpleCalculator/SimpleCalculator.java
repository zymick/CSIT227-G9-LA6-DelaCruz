package SimpleCalculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleCalculator {
    private JTextField textField1;
    private JTextField textField2;
    private JButton button1;
    private JComboBox<String> comboBox1;
    private JLabel lblResult;
    private JPanel panel1;

    public SimpleCalculator() {
        textField1.setName("tfNumber1");
        textField2.setName("tfNumber2");
        button1.setName("btnCompute");
        comboBox1.setName("cbOperations");

        lblResult.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));


        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    double num1 = Double.parseDouble(textField1.getText());
                    double num2 = Double.parseDouble(textField2.getText());
                    String operator = comboBox1.getSelectedItem().toString();
                    double result = 0;

                    switch (operator){
                        case "+":
                            result = num1 + num2;
                            break;
                        case "-":
                            result = num1 - num2;
                            break;
                        case "*":
                            result = num1 * num2;
                            break;
                            case "/":
                                if(num2!=0) {
                                    result = num1 / num2;
                                } else {
                                    lblResult.setText(" error ");
                                    return;
                                }
                                break;

                    }
                    lblResult.setText(" "+result+" ");
                } catch (NumberFormatException ex){
                    lblResult.setText(" error ");
                }

            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Simple Calculator");
        SimpleCalculator calculator = new SimpleCalculator();
        frame.setContentPane(calculator.panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setSize(500, 200);


    }
}
