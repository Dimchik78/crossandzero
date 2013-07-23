public class CrossAndZero {
    private static final int FIELD_SIZE=3;
    private char field [][];
    private boolean isMovex;
    private boolean isMove0;

    public CrossAndZero() {
        field = new  char [FIELD_SIZE][FIELD_SIZE];
        for(int y=0;y<FIELD_SIZE;y++) {
            for(int x=0;x<FIELD_SIZE;x++) {
                field[x][y]=' ' ;
            }
        }
        isMove0 = false;
        isMovex=false;
    }

    public void clearField () {
        for(int y=0;y<FIELD_SIZE;y++) {
            for(int x=0;x<FIELD_SIZE;x++) {
              field[x][y]=' ' ;
            }
        }
    }

    private boolean isCellEmpty (int x, int y) {
        if (field[x][y]!=' ') {
            return false ;
        }
        else {
            return  true;
        }
    }

   /* private char setWhosMove(char player) {

    }
    */

    public char getWhosMove() {
    if (isMovex){
        return 'x';
    }
    else {
        return '0';
    }
    }

    public void setWhosMove(char player) {
        if (player=='x'){
            isMovex=true;
            isMove0=false;
        }
        else {
            isMovex=false;
            isMove0=true;
        }
    }

    private boolean getHorLine(char player) {

        for(int y=0;y<FIELD_SIZE;y++) {
            for(int x=0;x<FIELD_SIZE;x++)  {
               if (field[x][y]!=player) break ;
                    else {
                     if (x==FIELD_SIZE-1) {
                       return true;

                        }
                    }
               }
            }
        return false;
        }



    private boolean getVerLine(char player) {
        for(int x=0;x<FIELD_SIZE;x++) {
            for(int y=0;y<FIELD_SIZE;y++) {
                if (field[x][y]!=player) break ;
                else {
                    if (y==FIELD_SIZE-1) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean getCrossLine(char player) {
        for(int y=0;y<FIELD_SIZE;y++) {
            if (field[y][y]!=player) break ;
            else {
                if (y==FIELD_SIZE-1) {
                    return true;
                }
            }
        }
        for(int y=0;y<FIELD_SIZE;y++) {
            if (field[y][FIELD_SIZE-y-1]!=player) break ;
            else {
                if (y==(FIELD_SIZE-1)) {
                    return true;
                }
            }
        }
        return  false;
    }

    public boolean getLine(char player) {
         if (getHorLine(player)) return true;
         if (getVerLine(player)) return true;
         if (getCrossLine(player)) return true;
    return false;
    }

    public void move(int x, int y,char player) {
         if (isCellEmpty(x,y)) {
          field[x][y]=player;
          if (player=='x') {
              isMovex=false;
              isMove0 = true;
          }
             else {
              isMovex=true;
              isMove0 = false;
          }

          }
    }

    public void printField () {
        for(int y=0;y<FIELD_SIZE;y++) {
            for(int x=0;x<FIELD_SIZE;x++) {
                System.out.print("["+field[x][y]+"] ") ;

            }
            System.out.println();
        }
    }

    public int getFieldSize() {
        return FIELD_SIZE;
    }

}
