import java.util.Arrays;

public class Queen extends Piece{
    public Queen(String color) {
        super(color);
    }

    @Override
    public boolean canMove(String newPosition) {
        boolean type=false;
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

        int gapOfRow=Math.abs(oldRow-newRow);
        int gapOfColumn=Math.abs((int)oldColumn-(int)newColumn);
        //The queen moves any number of vacant squares horizontally, vertically, or diagonally.
        //like rook or bishop
        // therefore, I'm gonna use rook's and bisjop's features together.

        //if the queen wants to move like a rook
        if(getPosition().charAt(0) == newPosition.charAt(0) || getPosition().charAt(1) == newPosition.charAt(1) )
            type=true;
        //if the queen wants to move like a bishop
        else if (gapOfColumn==gapOfRow)
            type=true;

        return type;
    }

    @Override
    public String[] getAllMoves() {
        String[] allMoves_bishopPart=new String[15];
        String[] allMoves_rookPart=new String[16];
        String[] allMoves=new String[31];
        //all possible moves are same with rook and bishop
        Bishop bp=new Bishop(getColor());
        Rook r=new Rook(getColor());
        bp.setPosition(getPosition());
        r.setPosition(getPosition());
        allMoves_bishopPart=bp.getAllMoves();
        allMoves_rookPart=r.getAllMoves();
        int temp=0;
        for (int i = 0; i < allMoves_bishopPart.length; i++) {
            allMoves[temp]=allMoves_bishopPart[i];
            temp++;
        }
        for (int i = 0; i <allMoves_rookPart.length ; i++) {
            allMoves[temp]=allMoves_rookPart[i];
            temp++;
        }
        Arrays.sort(allMoves);
        int counter=0;
        for (int i = 0; i <allMoves.length ; i++) {
            if (allMoves[i].equals(getPosition())) {
                allMoves[i] = "";
                counter++;
            }
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
