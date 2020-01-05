public class Main {
    static boolean UPPER, LOWER, SPECIAL;
    public static void main(String[] argv){
//        Generator PASSWORD = new Generator(9,false,true,false);
//        System.out.println(PASSWORD.toString());
        Generator[] Passwords = new Generator[8];
        for(int i = 0; i < 8; i++){
            getValues(i);
            Passwords[i] = new Generator(12,UPPER,LOWER,SPECIAL);
            System.out.println(Passwords[i].toString());
        }

    }

   public static void getValues(int i){
        if(i == 0){
            UPPER = LOWER = SPECIAL = false;
        }
        if(i == 1){
            UPPER = false;
            LOWER = false;
            SPECIAL = true;
        }
       if(i == 2) {
           UPPER = false;
           LOWER = true;
           SPECIAL = false;
       }
       if(i == 3){
           UPPER = false;
           LOWER = true;
           SPECIAL = true;
       }
       if(i == 4){
           UPPER = true;
           LOWER = false;
           SPECIAL = false;
       }
       if(i == 5){
           UPPER = true;
           LOWER = false;
           SPECIAL = true;
       }
       if(i == 6){
           UPPER = true;
           LOWER = true;
           SPECIAL = false;
       }
       if(i == 7){
           UPPER = true;
           LOWER = true;
           SPECIAL = true;
       }
   }
}