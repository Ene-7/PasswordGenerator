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
    int size = 10;


    public void generatePassword(){
        if(DisplayContent == false) { // IF THE DISPLAY IS CLEAR
            int count = getAmount();
            String result = "Password(s) will show here:\n";
            if(count == 0){
                AmountPicker.setText("Invalid Input");
                GenerateButton.setText("Clear");
                DisplayContent = true;
            }
            else if(!UpperCase.isSelected() && !LowerCase.isSelected() && !SpecialChars.isSelected() && !NumericalChars.isSelected()){
                PasswordDisplay.setText("No Contents Selected");
                GenerateButton.setText("Clear");
                DisplayContent = true;
            }
            else {

                for(int i = 0; i < count; i++) {
                    result +=  ((i+1) +". " +
                            new Generator(10, UpperCase.isSelected(), LowerCase.isSelected(), SpecialChars.isSelected(), NumericalChars.isSelected()).toString() + "\n");
                }
                PasswordDisplay.setText(result);
                DisplayContent = true;
                GenerateButton.setText("Clear");
            }
        }
        else{
            PasswordDisplay.setText("");
            AmountPicker.setText("");
            DisplayContent = false;
            GenerateButton.setText("Generate");
        }

    }


    private int getAmount(){ //EVALUATE INPUT FOR AMOUNT TO GENERATE
        try {
           if(AmountPicker.getText().isEmpty()) return 1; // DEFAULT VALUE
           return Integer.parseInt(AmountPicker.getText()); // ELSE INTERPRET INPUT
       }
       catch(NumberFormatException e){

           return 0;
       }
    }

}
