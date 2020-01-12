package sample;

import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class Controller {
    public CheckBox UpperCase, LowerCase, SpecialChars, NumericalChars;
    private boolean DisplayContent = false;
    public TextField AmountPicker, SizePicker;
    public Button GenerateButton;
    public TextArea PasswordDisplay;


    public void generatePassword(){ // ON CLICK BUTTON (GENERATE)
        if(DisplayContent == false) { // IF THE DISPLAY IS CLEAR
            int generateCount = getGenerateAmount();
            int size = getPasswordSize();
            String result = "Password(s) will show here:\n";
            if(generateCount == 0){ // If Generate Amount is Invalid
                AmountPicker.setText("Invalid Input");
                GenerateButton.setText("Clear");
                DisplayContent = true;
            }
            else // if Password Size is Invalid
                if(size == 0){
                    SizePicker.setText("Invalid Input");
                    GenerateButton.setText("Clear");
                    DisplayContent = true;
            }
            else //
                if(!UpperCase.isSelected() && !LowerCase.isSelected() && !SpecialChars.isSelected() && !NumericalChars.isSelected()){
                PasswordDisplay.setText("No Contents Selected");
                GenerateButton.setText("Clear");
                DisplayContent = true;
            }
            else {
                for(int i = 0; i < generateCount; i++) {
                    result +=  ((i+1) +". " +
                            new Generator(size, UpperCase.isSelected(), LowerCase.isSelected(), SpecialChars.isSelected(), NumericalChars.isSelected()).toString() + "\n");
                }
                PasswordDisplay.setText(result);
                DisplayContent = true;
                GenerateButton.setText("Clear");
            }
        }
        else{
            PasswordDisplay.setText("");
            DisplayContent = false;
            GenerateButton.setText("Generate");
        }

    }


    private int getGenerateAmount(){ //EVALUATE INPUT FOR AMOUNT TO GENERATE
        try {
           if(AmountPicker.getText().isEmpty()) return 5; // DEFAULT VALUE
           return Integer.parseInt(AmountPicker.getText()); // ELSE INTERPRET INPUT
       }
       catch(NumberFormatException e){
           return 0;
       }
    }

    private int getPasswordSize(){ //EVALUATE INPUT FOR AMOUNT TO GENERATE
        try {
            if(SizePicker.getText().isEmpty()) return 12; // DEFAULT VALUE
            return Integer.parseInt(SizePicker.getText()); // ELSE INTERPRET INPUT
        }
        catch(NumberFormatException e){
            return 0;
        }
    }

}
