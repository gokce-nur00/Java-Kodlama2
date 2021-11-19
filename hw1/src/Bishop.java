import java.util.Arrays;

public class Bishop extends Piece{
    public Bishop(String color) {
        super(color);
    }

    @Override
    public boolean canMove(String newPosition) {
        boolean type= false;
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
        // row daki fark ile columndaki fark ayni ise dogrudur
        if (gapOfColumn==gapOfRow){
            type=true;
        }
        return type;
    }

    @Override
    public String[] getAllMoves() {
        String[] allMoves=new String[15];
        //there are 4 different zone
        //look at a1, a8, h1, h8
        //the center is bishop and I'm gonna look at each zone

        calculate(getPosition());
        //first zone is a and 1
        int distanceOfRows=8-getRow()-1;//to 1
        int distanceOfColumns=getColumn();//to a
        int temp=0;//index
        for (int i = 1; i < (int)Math.min(distanceOfColumns,distanceOfRows); i++) {//to a1
            int intColumn=(int)'a'+getColumn()-i;
            int intRow=8-getRow()-i;
            allMoves[temp]=""+(char)intColumn+intRow;
            temp++;
        }
        distanceOfRows=getRow();//if getRow is 0 that gives us the distance of rows between 8 and position's row.
        for (int i = 1; i <Math.min(distanceOfColumns,distanceOfRows) ; i++) {//to a8
            int intColumn=(int)'a'+ getColumn()-i;//to a
            int intRow=8-getRow()+i;
            allMoves[temp]=""+(char)intColumn+intRow;
            temp++;
        }
        //to h1
        distanceOfRows=8-getRow()-1;//to 1
        distanceOfColumns=7-getColumn();//to h
        for (int i = 1; i < (int)Math.min(distanceOfColumns,distanceOfRows); i++) {//to h1
            int intColumn=(int)'a'+getColumn()+i;//to h
            int intRow=8-getRow()-i;//to 1
            allMoves[temp]=""+(char)intColumn+intRow;
            temp++;
        }
        //to h8
        distanceOfRows=getRow();//to 8
        for (int i = 1; i < (int)Math.min(distanceOfColumns,distanceOfRows); i++) {//to h8
            int intColumn=(int)'a'+getColumn()+i;//to h
            int intRow=8-getRow()+i;//to 8
            allMoves[temp]=""+(char)intColumn+intRow;
            temp++;
        }
        Arrays.sort(allMoves);
        for (int i = 0; i < allMoves.length; i++) {
            if(allMoves[i].equals(getPosition()))
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
