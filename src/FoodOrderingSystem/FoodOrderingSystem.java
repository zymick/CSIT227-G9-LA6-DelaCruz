package FoodOrderingSystem;

import javax.swing.*;
import java.text.DecimalFormat;

public class FoodOrderingSystem {
    private JCheckBox cPizza;
    private JCheckBox cBurger;
    private JCheckBox cFries;
    private JCheckBox cSoftDrinks;
    private JCheckBox cTea;
    private JCheckBox cSundae;
    private JRadioButton rbNone;
    private JRadioButton rb5;
    private JRadioButton rb10;
    private JRadioButton rb15;
    private JButton btnOrder;
    private JPanel panel1;

    private static final double PIZZA_PRICE = 100;
    private static final double BURGER_PRICE = 80;
    private static final double FRIES_PRICE = 65;
    private static final double SOFT_DRINKS_PRICE = 55;
    private static final double TEA_PRICE = 50;
    private static final double SUNDAE_PRICE = 40;

    public FoodOrderingSystem() {
        ButtonGroup discounts = new ButtonGroup();
        discounts.add(rbNone);
        discounts.add(rb5);
        discounts.add(rb10);
        discounts.add(rb15);
        btnOrder.addActionListener(e -> {
            double total = 0;

            if (cPizza.isSelected()) total += PIZZA_PRICE;
            if (cBurger.isSelected()) total += BURGER_PRICE;
            if (cFries.isSelected()) total += FRIES_PRICE;
            if (cSoftDrinks.isSelected()) total += SOFT_DRINKS_PRICE;
            if (cTea.isSelected()) total += TEA_PRICE;
            if (cSundae.isSelected()) total += SUNDAE_PRICE;

            double dscnt = 0;
            if (rb5.isSelected()) {
                dscnt = 0.05;
            } else if (rb10.isSelected()) {
                dscnt = 0.10;
            } else if (rb15.isSelected()) {
                dscnt = 0.15;
            }

            total-=total*dscnt;
            DecimalFormat df = new DecimalFormat("0.00");
            String tAmount= df.format(total);

            JOptionPane.showMessageDialog(null,"The total price is Php " + tAmount, "Total Price", JOptionPane.INFORMATION_MESSAGE);

        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Food Ordering System");
        FoodOrderingSystem menu = new FoodOrderingSystem();
        frame.setContentPane(menu.panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setSize(350,400);

    }
}
