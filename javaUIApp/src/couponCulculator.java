
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class couponCulculator extends culculater {

    //Declaring Objects
    
    //frame
    Frame f = new Frame();

    //Labels
    Label header = new Label("Culculate a price of a pond");
    Label l1 = new Label("Face Value:");
    Label l2 = new Label("Coupon Rate:");
    Label l3 = new Label("Number of periods(Months): ");
    Label l4 = new Label("Interest rate:");
    Label l5 = new Label("Result:");

    //Dilog
    Dialog dilog;

    //Text fields
    TextField t1 = new TextField();
    TextField t2 = new TextField();
    TextField t3 = new TextField();
    TextField t4 = new TextField();
    TextField t5 = new TextField();

    //button
    Button b1 = new Button("Enter");

    //constructor
    couponCulculator() {
        // align values
        alighnElements();
        //set resut text field to uneditable
        t5.setEnabled(false);

        //add ellements to the frame
        f.add(l1);
        f.add(l2);
        f.add(l3);
        f.add(l4);
        f.add(l5);
        f.add(t1);
        f.add(t2);
        f.add(t3);
        f.add(t4);
        f.add(t5);
        //initialise result to 0
        t5.setText("R"+0.00 + "");

        //add button to the frame
        f.add(b1);

        //add action listener to the butten
        b1.addActionListener(new ActionListenerClass());
        f.add(header);

        f.setLayout(null);
        f.setVisible(true);
        f.setSize(400, 350);

        f.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent we) {

                System.exit(0);
            }
        });

    }

    //Giving Coordinates
    private void alighnElements() {

        header.setBounds(80, 50, 200, 20);
        l1.setBounds(50, 100, 100, 20);
        l2.setBounds(50, 140, 100, 20);
        l3.setBounds(50, 180, 100, 20);
        l4.setBounds(50, 220, 100, 20);
        l5.setBounds(50, 260, 100, 20);

        t1.setBounds(200, 100, 100, 20);
        t2.setBounds(200, 140, 100, 20);
        t3.setBounds(200, 180, 100, 20);
        t4.setBounds(200, 220, 100, 20);
        t5.setBounds(200, 260, 100, 20);

        b1.setBounds(80, 305, 200, 20);

    }

    //Process the result
    public void getResult() {

        if ("".equals(validate())) {
            try {
                Double faceValue = Double.parseDouble(t1.getText());
                Double couRate = Double.parseDouble(t2.getText());
                Double period = Double.parseDouble(t3.getText());
                Double interestRate = Double.parseDouble(t4.getText());
                
                //update the value of the result
                t5.setText("R"+calculateBondRate(faceValue, couRate, period, interestRate) + "");
                
            } catch (NumberFormatException e) {
                //open error dilog non numeric values entered
                openDilog("Only numeric values allowd");
            }
        } else {
            //open error dilog if fields are empty
            openDilog(validate());
        }

    }

    //listen to button click
    private class ActionListenerClass implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == b1) {
                getResult();
            }
        }

    }

    //Validate text field
    private String validate() {
        String Massege = "";
        if ("".equals(t1.getText()) || "".equals(t2.getText()) || "".equals(t3.getText()) || "".equals(t4.getText())) {
            Massege = "Fields cannot be empty";
        }

        return Massege;
    }

    //Validation dialog
    private void openDilog(String massage) {
        dilog = new Dialog(f, "Erorr", true);
        Label message = new Label(massage, Label.CENTER);
        dilog.add(message);
        dilog.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {

                dilog.setVisible(false);
            }
        });
        dilog.pack();
        dilog.setLocationRelativeTo(f);
        dilog.setLocation(new Point(100, 100));
        dilog.setSize(200, 200);
        dilog.setVisible(true);

    }

    //main method
    public static void main(String[] args) {
        new couponCulculator();
    }

}
