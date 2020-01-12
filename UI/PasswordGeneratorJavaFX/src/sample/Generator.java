package sample;

import java.util.Random;

public class Generator {
    private final String ALPHABET_UPPERCASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private final String ALPHABET_LOWERCASE = "abcdefghijklmnopqrstuvwxyz";
    private final String SPECIAL_CHARS = "`~!@#$%^&*()-_=+";
    private final String NUMERICAL_CHARS ="0123456789";
    private int length;
    private boolean hasNum = false, hasUpper = false, hasLower = false, hasSpecial = false;
    private StringBuilder password = new StringBuilder();

    public Generator(int passwordLength, boolean hasUppercase, boolean hasLowercase, boolean hasSpecialChar, boolean hasNumerical) {
        this.length = passwordLength;
        this.hasUpper = hasUppercase;
        this.hasLower = hasLowercase;
        this.hasSpecial = hasSpecialChar;
        this.hasNum = hasNumerical;
        makePassword();
    }

    private void makePassword() {
        if(length == 0){
            System.err.println("Password length is too short.");
            return;
        }
        if(!hasNum && !hasUpper && !hasLower && !hasSpecial){
            System.out.println("Cannot make a password without any characters");
            return;
        }//1
        if(!hasNum && !hasUpper && !hasLower && hasSpecial){
            //GENERATE STRING WITH ONLY SPECIAL CHARS
            for(int i = 0; i < length; i++){
                password.append(getRandomChar(SPECIAL_CHARS));
            }
            return;
        }//2
        if(!hasNum && !hasUpper && hasLower && !hasSpecial){
            //GENERATE STRING WITH ONLY LOWERCASE CHARS
            for(int i = 0; i < length; i++){
                password.append(getRandomChar(ALPHABET_LOWERCASE));
            }
            return;
        }//3
        if(!hasNum && !hasUpper && hasLower && hasSpecial){
            //GENERATE STRING WITH LOWER AND SPECIAL CHARS
            for(int i = 0; i < length; i++){
                int choice = randInt(0,1);
                if(choice == 0){
                    password.append(getRandomChar(ALPHABET_LOWERCASE));
                }
                else{
                    password.append(getRandomChar(SPECIAL_CHARS));
                }
            }
            return;
        }//4
        if(!hasNum && hasUpper && !hasLower && !hasSpecial){
            //GENERATE STRING WITH ONLY UPPERCASE CHARS
            for(int i = 0; i < length; i++){
                password.append(getRandomChar(ALPHABET_UPPERCASE));
            }
            return;
        }//5
        if(!hasNum && hasUpper && !hasLower && hasSpecial){
            //GENERATE STRING WITH ONLY UPPER AND SPECIAL CHARS
            for(int i = 0; i < length; i++){
                int choice = randInt(0,1);
                if(choice == 0){
                    password.append(getRandomChar(ALPHABET_UPPERCASE));
                }
                else{
                    password.append(getRandomChar(SPECIAL_CHARS));
                }
            }
            return;
        }//6
        if(!hasNum && hasUpper && hasLower && !hasSpecial){
            //GENERATE STRING WITH UPPERCASE AND LOWERCASE CHARS
            for(int i = 0; i < length; i++){
                int choice = randInt(0,1);
                if(choice == 0){
                    password.append(getRandomChar(ALPHABET_UPPERCASE));
                }
                else{
                    password.append(getRandomChar(ALPHABET_LOWERCASE));
                }
            }
            return;
        }//7
        if(!hasNum && hasUpper && hasLower && hasSpecial){
            //GENERATE STRING WITH UPPERCASE, LOWERCASE, AND SPECIAL CHARS
            for(int i = 0; i < length; i++){
                int choice = randInt(0,2);
                if(choice == 0){
                    password.append(getRandomChar(ALPHABET_UPPERCASE));
                }
                else if(choice == 1){
                    password.append(getRandomChar(ALPHABET_LOWERCASE));
                }
                else{
                    password.append(getRandomChar(SPECIAL_CHARS));
                }
            }
            return;
        }//8
        if(hasNum && !hasUpper && !hasLower && !hasSpecial){
            //GENERATE STRING WITH ONLY NUMERICAL CHARS
            for(int i = 0; i < length; i++){
                password.append(getRandomChar(NUMERICAL_CHARS));
            }
            return;
        }//9
        if(hasNum && !hasUpper && !hasLower && hasSpecial){
            //GENERATE STRING WITH ONLY NUMERICAL AND SPECIAL CHARS
            for(int i = 0; i < length; i++){
                int choice = randInt(0,1);
                if(choice == 0){
                    password.append(getRandomChar(NUMERICAL_CHARS));
                }
                else{
                    password.append(getRandomChar(SPECIAL_CHARS));
                }
            }
            return;
        }//10
        if(hasNum && !hasUpper && hasLower && !hasSpecial){
            //GENERATE STRING WITH ONLY NUMERICAL AND LOWERCASE CHARS
            for(int i = 0; i < length; i++){
                int choice = randInt(0,1);
                if(choice == 0){
                    password.append(getRandomChar(NUMERICAL_CHARS));
                }
                else{
                    password.append(getRandomChar(ALPHABET_LOWERCASE));
                }
            }
            return;
        }//11
        if(hasNum && !hasUpper && hasLower && hasSpecial){
            //GENERATE STRING WITH ONLY NUMERICAL, LOWERCASE, AND SPECIAL CHARS
            for(int i = 0; i < length; i++){
                int choice = randInt(0,2);
                if(choice == 0){
                    password.append(getRandomChar(NUMERICAL_CHARS));
                }
                else if(choice == 1){
                    password.append(getRandomChar(ALPHABET_LOWERCASE));
                }
                else{
                    password.append(getRandomChar(SPECIAL_CHARS));
                }
            }
            return;
        }//12
        if(hasNum && hasUpper && !hasLower && !hasSpecial){
            //GENERATE STRING WITH ONLY NUMERICAL AND UPPERCASE
            for(int i = 0; i < length; i++){
                int choice = randInt(0,1);
                if(choice == 0){
                    password.append(getRandomChar(NUMERICAL_CHARS));
                }
                else{
                    password.append(getRandomChar(ALPHABET_UPPERCASE));
                }
            }
            return;
        }//13
        if(hasNum && hasUpper && !hasLower && hasSpecial){
            //GENERATE STRING WITH ONLY NUMERICAL, UPPERCASE, AND SPECIAL CHARS
            for(int i = 0; i < length; i++){
                int choice = randInt(0,2);
                if(choice == 0){
                    password.append(getRandomChar(NUMERICAL_CHARS));
                }
                else if(choice == 1){
                    password.append(getRandomChar(ALPHABET_UPPERCASE));
                }
                else{
                    password.append(getRandomChar(SPECIAL_CHARS));
                }
            }
            return;
        }//14
        if(hasNum && hasUpper && hasLower && !hasSpecial){
            //GENERATE STRING WITH ONLY NUMERICAL, UPPERCASE, AND LOWERCASE CHARS
            for(int i = 0; i < length; i++){
                int choice = randInt(0,2);
                if(choice == 0){
                    password.append(getRandomChar(NUMERICAL_CHARS));
                }
                else if(choice == 1){
                    password.append(getRandomChar(ALPHABET_UPPERCASE));
                }
                else{
                    password.append(getRandomChar(ALPHABET_LOWERCASE));
                }
            }
            return;
        }//15
        if(hasNum && hasUpper && hasLower && hasSpecial){
            //GENERATE STRING WITH ONLY NUMERICAL, UPPERCASE, SPECIAL, AND LOWERCASE CHARS
            for(int i = 0; i < length; i++){
                int choice = randInt(0,3);
                if(choice == 0){
                    password.append(getRandomChar(NUMERICAL_CHARS));
                }
                else if(choice == 1){
                    password.append(getRandomChar(ALPHABET_UPPERCASE));
                }
                else if(choice == 2){
                    password.append(getRandomChar(SPECIAL_CHARS));
                }
                else{
                    password.append(getRandomChar(ALPHABET_LOWERCASE));
                }
            }
            return;
        }//16

    }

/*
* @param Alphabet a String containing the chars to pick from
* @return Random Char from the Input Alphabet
*/
    private char getRandomChar(String Alphabet){
        return Alphabet.charAt(randInt(0,Alphabet.length()-1));
    }

/*
* @param Min minimum value
* @param Max maximum value
* @return Random Int based on a time Seed
*/
    private int randInt(int min, int max) {
        Random rand = new Random();
        return rand.nextInt((max - min) + 1) + min;
    }

    public String toString(){
        return password.toString();
    }
}
