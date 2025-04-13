import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame {

    private TextField nameField;
    private TextField surnameField;
    private TextField IDField;
    private TextField emailField;
    private TextField postalCodeField;
    private TextField phoneNumberField;
    private TextField nothingField;

    private JLabel nameLabel;
    private JLabel surnameLabel;
    private JLabel IDLabel;
    private JLabel emailLabel;
    private JLabel postalCodeLabel;
    private JLabel phoneNumberLabel;

    private Button saveButton;

    private String message;
    private int count;

    public Login(){

        message = new String("");

        nameField = new TextField();
        surnameField = new TextField();
        IDField = new TextField();
        emailField = new TextField();
        postalCodeField = new TextField();
        phoneNumberField = new TextField();
        nothingField = new TextField("");

        nameLabel = new JLabel("NAME (Must be at least 2 characters long, should start with a capital letter.) : ");
        surnameLabel = new JLabel("SURNAME (Must be at least 2 characters long, should start with a capital letter.) : ");
        IDLabel = new JLabel("ID NUMBER (Can only contain digits and must be 11 digits and cannot start with 0.) : ");
        emailLabel = new JLabel("E-MAIL (must contain one of the words com, edu, net, org) : ");
        postalCodeLabel = new JLabel("POSTAL CODE (Can only contain digits and must be 5 digits.) : ");
        phoneNumberLabel = new JLabel("PHONE NUMBER: Number must be 10 digits and cannot start with zero.");

        saveButton = new Button("Save");


        setTitle("GUI Application");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(10, 2));

        add(nameLabel);
        add(nameField);

        add(surnameLabel);
        add(surnameField);

        add(IDLabel);
        add(IDField);

        add(emailLabel);
        add(emailField);

        add(postalCodeLabel);
        add(postalCodeField);

        add(phoneNumberLabel);
        add(phoneNumberField);

        add(saveButton);

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               save();
            }
        });

    }

    public void save(){
        if(!nameField.getText().matches("[A-Z][a-z]+")) {
            message += "Name is in incorrect form.\n" + "Must be at least 2 characters long, should start with a capital letter.\n";
        }
        else count++;

        if(!surnameField.getText().matches("[A-Z][a-z]+")){
            message += "Surname is in incorrect form.\n" + "Must be at least 2 characters long, should start with a capital letter.\n";
        }
        else count++;

        if(!IDField.getText().matches("[1-9]([0-9]{10})")){
            message += "ID Number is in incorrect form.\n" + "Can only contain digits and must be 11 digits and cannot start with 0.\n";
        }
        else count++;

        if(!emailField.getText().matches("[a-zA-Z0-9._]+@[a-z]+.[com]*[edu]*[net]*[org]*")){
            message += "E-mail is in incorrect form.\n" + "Must contain one of the words com, edu, net, org.\n";
        }
        else count++;

        if(!postalCodeField.getText().matches("[0-9]{5}")){
            message += "Postal code is in incorrect form.\n" + "Can only contain digits and must be 5 digits.\n";
        }
        else count++;

        if(!phoneNumberField.getText().matches("[1-9][0-9]{2}-[1-9][0-9]{6}")){
            message += "Phone number is in incorrect form.\n" + "Must be in the format (Area code-number), area code must be 3 digits and number must be 7 digits.\n";
        }
        else count++;

        if(count == 6){
            message += "Successfully saved!\n" + "Name: " + nameField.getText() + ", Surname: " + surnameField.getText() +
                    ", ID Number: " + IDField.getText() + ", E-mail Address: " + emailField.getText() + ", Postal Code: " + postalCodeField.getText() +
                    ", Phone number: " + phoneNumberField.getText();
        }
        JOptionPane.showMessageDialog(this, message);
        message = "";
        count = 0;
        nameField.setText("");
        surnameField.setText("");
        IDField.setText("");
        emailField.setText("");
        postalCodeField.setText("");
        phoneNumberField.setText("");

    }



}
