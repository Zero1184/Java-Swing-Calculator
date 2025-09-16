package Interface;

import javax.swing.JButton; 
import javax.swing.JFrame;
import javax.swing.JTextField;
import Operations.*;
import java.awt.ComponentOrientation;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Interface extends JFrame{
    private JTextField txtArea;
    private JButton btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn10, btn11, btn12, btn13, btn14, btn15, btn16, btn17, btn18, btn19, btn20; 
    private String operation = "";
    private  double firstNum = 0;
    private Sum sum = new Sum();
    private Subtraction subtraction = new Subtraction();
    private Multiplication multiplication = new Multiplication(); 
    private Division division = new Division();
    private Root root = new Root();
    private Square square = new Square();
   
    public Interface() {
        setTitle("Calculator");
        setLayout(null);
        setSize(420, 460);
        
        txtArea = new JTextField("0");
        btn1 = new JButton("CE");
        btn2 = new JButton("√");
        btn3 = new JButton("X²");
        btn4 = new JButton("÷");
        
        btn5 = new JButton("7"); 
        btn6 = new JButton("8");
        btn7 = new JButton("9");
        btn8 = new JButton("x");
        
        btn9 = new JButton("4");
        btn10 = new JButton("5");
        btn11 = new JButton("6");
        btn12 = new JButton("-");
        
        btn13 = new JButton("1");
        btn14 = new JButton("2");
        btn15 = new JButton("3");
        btn16 = new JButton("+");
        
        btn17 = new JButton("C");
        btn18 = new JButton("0");
        btn19 = new JButton(",");
        btn20 = new JButton("=");
        
       
        //Localization of the elements
        txtArea.setBounds(10, 10, 385, 100);
        btn1.setBounds(10,120,90,50);
        btn2.setBounds(110,120,90,50);
        btn3.setBounds(210,120,90,50);
        btn4.setBounds(310,120,85,50);
        
        btn5.setBounds(10,180,90,50);
        btn6.setBounds(110,180,90,50);
        btn7.setBounds(210,180,90,50);
        btn8.setBounds(310,180,85,50);
        
        btn9.setBounds(10,240,90,50);
        btn10.setBounds(110,240,90,50);
        btn11.setBounds(210,240,90,50);
        btn12.setBounds(310,240,85,50);
        
        btn13.setBounds(10,300,90,50);
        btn14.setBounds(110,300,90,50);
        btn15.setBounds(210,300,90,50);
        btn16.setBounds(310,300,85,50);
        
        btn17.setBounds(10,360,90,50);
        btn18.setBounds(110,360,90,50);
        btn19.setBounds(210,360,90,50);
        btn20.setBounds(310,360,85,50);
        
        //Prevents the user to type letters
        txtArea.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isDigit(c) && c != '.' && !(c == '-' && txtArea.getCaretPosition() == 0)) {
                    e.consume();
                }
            }
        });
        
        //Action for number buttons and dot button
        ActionListener listener = e -> {
            JButton button = (JButton) e.getSource(); // Identifies witch button was clicked
            String value = button.getText();
            String currentText = txtArea.getText();
            if (value.matches("\\d")) {
            	if (currentText.equals("0")) {
                    txtArea.setText(value);
                } else {
                    txtArea.setText(currentText + value);
                }
            } else if (value.equals("C")) {
                firstNum = 0;
                operation = "";
                txtArea.setText("0");
            } else if (value.equals(",")) {
                if (!currentText.contains(".") && !currentText.equals("")) {
                    txtArea.setText(currentText + ".");
                }
            } else if(value.equals("=")) {
            	if(!operation.equals("")) {
            		switch(operation){
            		case "+":
            			txtArea.setText(Double.toString(sum.sumN(firstNum,Double.parseDouble(currentText))));
            			break;
            		case "-":
            			txtArea.setText(Double.toString(subtraction.sub(firstNum,Double.parseDouble(currentText))));
            			break;
            		case "x":
            			txtArea.setText(Double.toString(multiplication.multi(firstNum,Double.parseDouble(currentText))));
            			break;
            		case "÷":
            			double divisor = Double.parseDouble(currentText);
            		    if (divisor == 0) {
            		        txtArea.setText("Erro");
            		    } else {
            		        txtArea.setText(Double.toString(division.div(firstNum, divisor)));
            		    }
            			break;
            		}
            	}
            } else if(value.equals("CE")) {
            	txtArea.setText("0");
            } else if(value.equals("√")) {
            	txtArea.setText(Double.toString(root.rooting(Double.parseDouble(currentText))));
            } else if(value.equals("X²")) {
            	txtArea.setText(Double.toString(square.sqr(Double.parseDouble(currentText))));
            } else {
            	firstNum = Double.parseDouble(currentText);
            	txtArea.setText("");
            	operation = value;
            }
        };
        
        btn1.addActionListener(listener);
        btn2.addActionListener(listener);
        btn3.addActionListener(listener);
        btn4.addActionListener(listener);
        btn5.addActionListener(listener);
        btn6.addActionListener(listener);
        btn7.addActionListener(listener);
        btn8.addActionListener(listener);
        btn9.addActionListener(listener);
        btn10.addActionListener(listener);
        btn11.addActionListener(listener);
        btn12.addActionListener(listener);
        btn13.addActionListener(listener);
        btn14.addActionListener(listener);
        btn15.addActionListener(listener);
        btn16.addActionListener(listener);
        btn17.addActionListener(listener);
        btn18.addActionListener(listener);
        btn19.addActionListener(listener);
        btn20.addActionListener(listener);
		
        add(txtArea);
        add(btn1);
        add(btn2);
        add(btn3);
        add(btn4);
        add(btn5);
        add(btn6);
        add(btn7);
        add(btn8);
        add(btn9);
        add(btn10);
        add(btn11);
        add(btn12);
        add(btn13);
        add(btn14);
        add(btn15);
        add(btn16);
        add(btn17);
        add(btn18);
        add(btn19);
        add(btn20);    
 
        txtArea.applyComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        
        setResizable(false);
        setVisible(true);
      
    }
    

    public static void main(String[] args) {
        new Interface();

    }
}

