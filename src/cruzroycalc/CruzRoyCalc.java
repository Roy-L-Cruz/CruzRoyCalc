
package cruzroycalc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class CruzRoyCalc implements ActionListener{
    
    JFrame frame;
    JTextField textField;
    JButton btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn10, btn11, btn12, btn13, btn14, btn15, btn16, btn17, btn18, btn19, btn20;
    String input = ""; 
    double result = 0;
    
    public static void main(String[] args) {
        new CruzRoyCalc();
    }
    
    CruzRoyCalc() {
        frame = new JFrame("Calculator");
        textField = new JTextField();
        frame.setLayout(null);
        frame.setSize(223, 372);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        
        btn1 = new JButton("AC");
        btn2 = new JButton("D");
        btn3 = new JButton("%");
        btn4 = new JButton("÷");
        btn5 = new JButton("7");
        btn6 = new JButton("8");
        btn7 = new JButton("9");
        btn8 = new JButton("×");
        btn9 = new JButton("4");
        btn10 = new JButton("5");
        btn11 = new JButton("6");
        btn12 = new JButton("-");
        btn13 = new JButton("1");
        btn14 = new JButton("2");
        btn15 = new JButton("3");
        btn16 = new JButton("+");
        btn17 = new JButton("00");
        btn18 = new JButton("0");
        btn19 = new JButton(".");
        btn20 = new JButton("=");
        
        btn1.setBounds(2, 75,50,50);
        btn2.setBounds(54, 75,50,50);
        btn3.setBounds(106, 75,50,50);
        btn4.setBounds(158, 75,50,50);

        btn5.setBounds(2, 127,50,50);
        btn6.setBounds(54, 127,50,50);
        btn7.setBounds(106, 127,50,50);
        btn8.setBounds(158, 127,50,50);

        btn9.setBounds(2, 179,50,50);
        btn10.setBounds(54, 179,50,50);
        btn11.setBounds(106, 179,50,50);
        btn12.setBounds(158, 179,50,50);

        btn13.setBounds(2, 231,50,50);
        btn14.setBounds(54, 231,50,50);
        btn15.setBounds(106, 231,50,50);
        btn16.setBounds(158, 231,50,50);

        btn17.setBounds(2, 283,50,50);
        btn18.setBounds(54, 283,50,50);
        btn19.setBounds(106, 283,50,50);
        btn20.setBounds(158, 283,50,50);
        
        frame.add(textField);
        frame.add(btn1);
        frame.add(btn2);
        frame.add(btn3);
        frame.add(btn4);
        frame.add(btn5);
        frame.add(btn6);
        frame.add(btn7);
        frame.add(btn8);
        frame.add(btn9);
        frame.add(btn10);
        frame.add(btn11);
        frame.add(btn12);
        frame.add(btn13);
        frame.add(btn14);
        frame.add(btn15);
        frame.add(btn16);
        frame.add(btn17);
        frame.add(btn18);
        frame.add(btn19);
        frame.add(btn20);
        
        textField.setBounds(2, 10, 207, 50);
        
        btn1.addActionListener(this);
        btn2.addActionListener(this);
        btn3.addActionListener(this);
        btn4.addActionListener(this);
        btn5.addActionListener(this);
        btn6.addActionListener(this);
        btn7.addActionListener(this);
        btn8.addActionListener(this);
        btn9.addActionListener(this);
        btn10.addActionListener(this);
        btn11.addActionListener(this);
        btn12.addActionListener(this);
        btn13.addActionListener(this);
        btn14.addActionListener(this);
        btn15.addActionListener(this);
        btn16.addActionListener(this);
        btn17.addActionListener(this);
        btn18.addActionListener(this);
        btn19.addActionListener(this);
        btn20.addActionListener(this);
    }
    
    public void show() {
        this.frame.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        JButton sButton = (JButton) e.getSource();
        
        if (sButton == btn1) {
            input = "";
            result = 0;
            textField.setText("");
            
        } 
        else if (sButton == btn2) {
            if (!input.isEmpty()) {
                input = input.substring(0, input.length() - 1);
                textField.setText(input);
                
            }
        } 
        else if (sButton == btn19) {
            input += ".";
            textField.setText(input);
            
        } 
        else if (sButton == btn20) {
            if (!input.isEmpty()) {
                eval();
                textField.setText(String.valueOf(result));
                input = "";
                
            }
        } 
        
        else {
            boolean empty = false;
            boolean operator = false;
            if (input == "") {
                empty = true;
            }
            
            if ((sButton.getText().equals("+") || sButton.getText().equals("-") || sButton.getText().equals("×") || sButton.getText().equals("÷") || sButton.getText().equals("%"))) {
                operator = true;
            }
            
            if (operator == false) {
                input += sButton.getText();
                textField.setText(input);
            }
            else if (operator == true && empty == false){
                input += sButton.getText();
                textField.setText(input);
            }
        }
    }
    
    private void eval() {
        String[] parts = input.split("(?<=[-+÷×%])|(?=[-+÷×%])");

        result = Double.parseDouble(parts[0]);
        
        for (int i = 1; i < parts.length; i += 2) {
            char operator = parts[i].charAt(0);
            double operand = Double.parseDouble(parts[i + 1]);

            switch (operator) {
                case '+':
                    result += operand;
                    break;
                case '-':
                    result -= operand;
                    break;
                case '×': 
                    result *= operand;
                    break;
                case '÷': 
                    if (operand != 0) {
                        result /= operand;
                    } else {
                        System.out.println("Error: Division by zero");
                    }
                    break;
                case '%':
                    result = (result*0.01)*operand;
                    break;
            }
        }
        textField.setText(String.valueOf(result));
        input = ""; 
        
    }
    
}
