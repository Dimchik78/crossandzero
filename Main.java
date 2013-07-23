import java.io.IOException;

public class Main {
    private static char choice,ignore;private static int x,y;
    public  static void main(String args[]) throws IOException {

        System.out.println("Welcome to Cross and Zero");
        CrossAndZero game=new CrossAndZero();
        for(;;) {
            do  {
                System.out.println("Choose who is first.Type x or 0. To quit type q");
                choice=(char)   System.in.read();
                do {
                    ignore=(char)   System.in.read();
                }  while (ignore !='\n');

            } while (choice!='x' & choice!='0'& choice!='q') ;

            if (choice=='q') break;
             game.clearField();
            game.printField();
            game.setWhosMove(choice);
            do{
              choice=game.getWhosMove();
              System.out.println("Now "+choice+" move.");
              do {
                  System.out.println("Enter horizontal coordinates Between 0 and " + (game.getFieldSize() - 1) + ". To quit type q");
                  x=readNumber();
              }  while (x<0 | x>game.getFieldSize()-1);
              do {
                  System.out.println("Enter vertical coordinates Between 0 and " + (game.getFieldSize() - 1) + ". To quit type q");
                 y=readNumber();
                }  while (y<0 | y>game.getFieldSize()-1);
                game.move(x,y,choice);
                game.printField();


            } while (!game.getLine(choice));
            System.out.println("Congratulations! The "+choice+" won!");


        }
        System.out.println("Game over");
    }

    public static int readNumber() throws IOException {
        int number=-1; String stringNumber="";
        do {
            ignore=(char)  System.in.read();
            if (ignore!='\n')stringNumber=stringNumber+ignore;
            else {
                try {
                    number= Integer.parseInt(stringNumber);
                    if (number>=0) {
                        break;
                    }
                     else {
                        stringNumber="";
                        continue;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Enter valid number and press Enter. To quit type q");
                    stringNumber="";
                    continue;
                }

            }
        }  while (ignore!='q') ;
        return number;
    }

}
