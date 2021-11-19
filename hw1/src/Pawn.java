import java.util.Arrays;

public class Pawn extends Piece{


    public Pawn(String color){
        super(color);
    }


    @Override
    public boolean canMove(String newPosition) {
        boolean typeColumn=false, typeRow=false;
        /* black pawns start-> board[1][]
           white pawns start-> board[6][]
           in first time they can move 1 or 2 times
           another time they can move 1 vertical point
           when pawn tries to take a piece, it can move cross 1 */
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
        if (getColor().equals("black") && oldRow==7){//first movement
            if (newRow==6 || newRow==5)
                typeRow=true;
        }
        if (getColor().equals("white") && oldRow==2){//first movement
            if (newRow==3 || newRow==4)
                typeRow=true;
        }
        if (getColor().equals("black") && oldRow!=7){//not first
            if (newRow-oldRow==-1)
                typeRow=true;
        }
        if (getColor().equals("white") && oldRow!=2){//not first
            if (newRow-oldRow==1)
                typeRow=true;
        }
        int differenceBetweenColumns=(int) oldColumn-(int) newColumn;//can be 0(same column, 1(cross), -1(cross)
       if (differenceBetweenColumns==0 || differenceBetweenColumns==1 || differenceBetweenColumns==-1)
            typeColumn=true;
        return typeColumn&typeRow;
    }

    @Override
    public String[] getAllMoves() {
        String[] allMoves=new  String[6];
        int temp=0;
        //karsi sinira gidip geri donme ihtimalini gozardi ediyorum
        if (getColor().equals("white")){
            for (int i = 1; i <=6; i++) {//row
                for (int j = -1; j <=1 ; j++) {
                    if (getColumn()==0 && j==-1){
                        continue;
                    }
                    if (getColumn()==7 && j==1){
                        continue;
                    }
                    int intColumn=(int) 'a'+getColumn()+j;
                    int intRow=8-getRow()+i;
                    if (intRow>8)
                        break;
                    if (intColumn-(int) 'a'>7 || intColumn-(int) 'a'<0 )
                        break;
                    allMoves[temp]=""+(char)intColumn+intRow;
                    temp++;
                }
            }
        }
        if (getColor().equals("black")){
            for (int i = 1; i <=6; i++) {//row
                for (int j = -1; j <=1 ; j++) {
                    if (getColumn()==0 && j==-1){
                        continue;
                    }
                    if (getColumn()==7 && j==1){
                        continue;
                    }
                    int intColumn=(int) 'a'+getColumn()+j;
                    int intRow=8-getRow()-i;
                    if (intRow<1)
                        break;
                    if (intColumn-(int) 'a'>7 || intColumn-(int) 'a'<0 )
                        break;
                    allMoves[temp]=""+(char)intColumn+intRow;
                    temp++;
                }
            }
        }

        Arrays.sort(allMoves);
        for (int i = 0; i < allMoves.length; i++) {
            if (allMoves[i].equals(getPosition()))
                allMoves[i]="";
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

