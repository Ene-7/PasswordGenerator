package sample;

import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class Controller {
    public CheckBox UpperCase, LowerCase, SpecialChars, NumericalChars;
    private boolean DisplayContent = false;
    public TextField AmountPicker;
    public Button GenerateButton;
    public TextArea PasswordDisplay;


    public void generatePassword(){
        if(DisplayContent == false) {
            PasswordDisplay.setText("1. TEST PASSWORD\n" +
                    "This GUI is currently not fully functional!");
            DisplayContent = true;
            GenerateButton.setText("Clear Passwords");
        }
        else{
            PasswordDisplay.setText("");
            DisplayContent = false;
            GenerateButton.setText("Generate");
        }

    }

}
