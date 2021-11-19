
import java.util.Arrays;

public class Rook extends Piece{
    public Rook(String color) {
        super(color);
    }

    @Override
    public boolean canMove(String newPosition) {
        // rook sadece oldugu row veya column uzerinde ilerleyebilir
        boolean type=false;
    if(getPosition().charAt(0) == newPosition.charAt(0) || getPosition().charAt(1) == newPosition.charAt(1) )
        type=true;
        return type;
    }

    @Override
    public String[] getAllMoves() {
        String[] allMoves=new String[16];
        calculate(getPosition());
        int intRow=8-getRow();
        //same row with different columns
        for (int i = 0; i < 8; i++) {
            int temp=(int)('a'+i);
            allMoves[i]=""+(char)temp+intRow;
        }
        //same column with different rows
        int intColumn=(int)('a'+getColumn());
        for (int i = 0; i < 8; i++) {
            allMoves[i+8]=""+(char)intColumn+i;
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
        int temp=0;
        for (int i = 0; i <allMoves.length ; i++) {
            if (!allMoves[i].equals("")) {
                lastMoves[temp] = allMoves[i];
                temp++;
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
