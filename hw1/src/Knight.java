import java.util.Arrays;

public class Knight extends Piece {
    public Knight(String color) {
        super(color);
    }
    public boolean canMove(String newPosition){
        boolean type=false;
        /*knight L seklinde gider ve bu dikey veya yatay olabilir.
        iki durumu da kontrol etmek gerekiyor
        yatay 2 birim dikey 1 birim veya yatay 1 birim dikey 2 birim hareket ediyorsa dogru*/
        char oldColumn=' ', newColumn=' ';
        int oldRow, newRow;
        oldRow=Integer.parseInt(""+getPosition().charAt(1));
        newRow=Integer.parseInt(""+newPosition.charAt(1));
        for (int i=(int)'a'; i<=(int)'h'; i++){
            if (getPosition().charAt(0)==(char)i)
                oldColumn=(char) i;
            if (newPosition.charAt(0)==(char) i)
                newColumn=(char) i;
        }
        if (Math.abs(oldRow-newRow)==1)
            if (Math.abs((int) oldColumn-(int) newColumn)==2)
                type=true;
        if (Math.abs(oldRow-newRow)==2)
            if (Math.abs((int) oldColumn-(int) newColumn)==1)
                type=true;
        return type;
    }
    public String[] getAllMoves() {
        String[] allMoves=new String[8];
        //all possible movements
        int X[] = { 2, 1, -1, -2, -2, -1, 1, 2 };
        int Y[] = { 1, 2, 2, 1, -1, -2, -2, -1 };
        int temp=0;
        for (int i = 0; i < 8; i++) {
            // Position of knight after move
            int x = 8-getRow() + X[i];
            int y = getColumn() + Y[i];
            if (x >= 0 && x<=8 && y >= 0 && y<=7 ){
                int intColumn=(int)'a'+y;
                //x has correct value, hence I don't have to change it.
                allMoves[temp]=""+(char)intColumn+x;
                temp++;
            }

        }
        Arrays.sort(allMoves);//sorting
        for (String str: allMoves){
            if (str.equals(getPosition()))//this movement already begun
                str="";//clear
        }
        int counter=0;
        for (int i = 0; i < allMoves.length ; i++) {
            if (allMoves[i].equals(""))
                counter++;
        }
        String[] lastMoves=new String[allMoves.length-counter];
        int temp1=0;
        for (int i = 0; i <allMoves.length ; i++) {
            if (!allMoves[i].equals("")) {
                lastMoves[temp1] = allMoves[i];
                temp1++;
            }
        }
        return lastMoves;
    }
}
/* a b c d e f g h
8                   0
7                   1
6                   2
5                   3
4                   4
3                   5
2                   6
1                   7
   0 1 2 3 4 5 6 7
   */
