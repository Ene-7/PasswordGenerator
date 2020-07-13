package sample;

import javafx.scene.control.*;
import javafx.stage.FileChooser;
import javafx.stage.Window;

import java.io.File;
import java.io.PrintWriter;

public class Controller {
    public CheckBox UpperCase, LowerCase, SpecialChars, NumericalChars, NumberPass;
    public MenuItem SaveItem, ExitPG;
    public MenuBar MenuBar;
    private boolean DisplayContent = false;
    public TextField AmountPicker, SizePicker;
    public Button GenerateButton;
    public TextArea PasswordDisplay;
    private String TextContent =""; // Content That is ready to save to file.

    FileChooser fileChooser = new FileChooser();


    //MENU BAR OPTIONS:

    public void saveContent(){ // File -> Save Handler.
        Window stage = MenuBar.getScene().getWindow();
        fileChooser.setTitle("Save Dialog");
        fileChooser.setInitialFileName("Saved_Passwords");
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("text file", "*.txt"));
        File file = fileChooser.showSaveDialog(stage);
        try {
            PrintWriter writer;
            writer = new PrintWriter(file);
            writer.println(TextContent);
            writer.close();
        } catch (Exception ex) {
            System.out.println("Problem Saving File Because of: " + ex);
        }
    }

    public void Exit(){ // File -> Exit
        System.exit(0);
    }


    public void generatePassword(){ // ON CLICK BUTTON (GENERATE)
        if(DisplayContent == false) { // IF THE DISPLAY IS CLEAR
            int generateCount = getGenerateAmount();
            int size = getPasswordSize();
            String result = ""; //"Password(s) will show here:\n";
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
            else // if No Checkbox is Selected.
                if(!UpperCase.isSelected() && !LowerCase.isSelected() && !SpecialChars.isSelected() && !NumericalChars.isSelected()){
                PasswordDisplay.setText("No Contents Selected");
                GenerateButton.setText("Clear");
                DisplayContent = true;
            }
            else { // If at least one is selected generate Password based on checked options.
                for(int i = 0; i < generateCount; i++) {
                    if(!NumberPass.isSelected()){ // If Not Numbered Output:
                        result += (new Generator(size, UpperCase.isSelected(), LowerCase.isSelected(), SpecialChars.isSelected(), NumericalChars.isSelected()).toString() + "\n");
                    }
                    else { // Numbered Output:
                        result += ((i + 1) + ". " + new Generator(size, UpperCase.isSelected(), LowerCase.isSelected(), SpecialChars.isSelected(), NumericalChars.isSelected()).toString() + "\n");
                    }
                }
                TextContent = result;
                PasswordDisplay.setText(result);
                DisplayContent = true;
                GenerateButton.setText("Clear");
            }
        }
        else{
            TextContent = "";
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

    private int getPasswordSize(){ //EVALUATE INPUT FOR PASSWORD SIZE TO GENERATE
        try {
            if(SizePicker.getText().isEmpty()) return 12; // DEFAULT VALUE
            return Integer.parseInt(SizePicker.getText()); // ELSE INTERPRET INPUT
        }
        catch(NumberFormatException e){
            return 0;
        }
    }

}
