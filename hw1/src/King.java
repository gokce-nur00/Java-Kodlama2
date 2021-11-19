import java.util.Arrays;

public class King extends Piece{
    public King(String color) {
        super(color);
    }
    /*  a b c d e f g h
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

    @Override
    public boolean canMove(String newPosition) {
        boolean typeColumn=false;
        boolean typeRow=false;
        //her yone 1 adim atabilir
        //-x +x or -y +y
        //b3
        int oldRow=Integer.parseInt(""+getPosition().charAt(1));//3
        char oldColumn= ' ';
        //c4
        int newRow=Integer.parseInt(""+newPosition.charAt(1));//4
        char newColumn=' ';
        for (int i=(int)'a'; i<=(int)'h'; i++){
            if (getPosition().charAt(0)==(char)i)
                oldColumn=(char) i;//b
            if (newPosition.charAt(0)==(char) i)
                newColumn=(char) i;//c
        }
        //en ust row=8, en alt row=1
        switch (oldRow){
            case 1:
                //board[7][]-> board[7][] or board[6][]
                if (newRow==1 || newRow==2)
                    typeRow=true;
                break;
            case 2:
                if (newRow==1 || newRow==2 || newRow==3)
                    typeRow=true;
                break;
            case 3:
                if (newRow==4 || newRow==2 || newRow==3)
                    typeRow=true;
                break;
            case 4:
                if (newRow==4 || newRow==5 || newRow==3)
                    typeRow=true;
                break;
            case 5:
                if (newRow==4 || newRow==5 || newRow==6)
                    typeRow=true;
                break;
            case 6:
                if (newRow==7 || newRow==5 || newRow==6)
                    typeRow=true;
                break;
            case 7:
                if (newRow==7 || newRow==8 || newRow==6)
                    typeRow=true;
                break;
            case 8:
                if (newRow==7 || newRow==8)
                    typeRow=true;
                break;

        }
        switch (oldColumn){
            case 'a':
                //bu durumda board[][0]
                if (newColumn=='a' || newColumn== 'b')
                    typeColumn=true;
                break;
            case 'b':
                //bu durumda board[][1]-> board[][0] or board[][1] or board[][2]
                if (newColumn=='a' || newColumn== 'b'|| newColumn=='c')
                    typeColumn=true;
                break;
            case 'c':
                if (newColumn=='d' || newColumn== 'b'|| newColumn=='c')
                    typeColumn=true;
                break;
            case 'd':
                if (newColumn=='d' || newColumn== 'e'|| newColumn=='c')
                    typeColumn=true;
                break;
            case 'e':
                if (newColumn=='d' || newColumn== 'e'|| newColumn=='f')
                    typeColumn=true;
                break;
            case 'f':
                if (newColumn=='g' || newColumn== 'e'|| newColumn=='f')
                    typeColumn=true;
                break;
            case 'g':
                if (newColumn=='g' || newColumn== 'h'|| newColumn=='f')
                    typeColumn=true;
                break;
            case 'h':
                if (newColumn=='g' || newColumn== 'h')
                    typeColumn=true;
                break;

        }
        if (getPosition().equals(newPosition)){
            typeColumn=false;
            typeRow=false;
        }
        return typeRow&typeColumn;
    }

    @Override
    public String[] getAllMoves() {
        String[] allMoves=new String[9];
        //king's column is a or h
        calculate(getPosition());
        char charColumn=getPosition().charAt(0);//a b c d e f g h
        //specials
        if (8-getRow()==8){
            if (charColumn=='a'){

                allMoves[0]="a7"; allMoves[1]="b7"; allMoves[2]="b8";

            }
            if (charColumn=='h'){

                allMoves[0]="g7"; allMoves[1]="g8"; allMoves[2]="h7";
            }
            else {
                int temp=0;

                for (int i = 0; i >=-1 ; i++) {//row
                    for (int j = -1; j <=1; j++) {//column
                        int intColumn=(int)charColumn+j;
                        int intRow=8-getRow()+i;
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
        }
        if (8-getRow()==1){
            if (charColumn=='a'){

                allMoves[0]="a2"; allMoves[1]="b1"; allMoves[2]="b2";
            }
            if (charColumn=='h'){

                allMoves[0]="g1"; allMoves[1]="g2"; allMoves[2]="h2";
            }
            else
            {
                int temp=0;

                for (int i = 0; i <=1 ; i++) {//row
                    for (int j = -1; j <=1; j++) {//column
                        int intColumn=(int)charColumn+j;
                        int intRow=8-getRow()+i;
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

        }
        else {
            //the king is not in the limits of the board
            allMoves=new String[9];
            int temp=0;//for keeping index
            for (int i = -1; i <=1 ; i++) {//row
                for (int j = -1; j <= 1; j++) {//column
                    int intColumn=(int)('a'+getColumn()+j);
                    int intRow=8-getRow()+i;
                    allMoves[temp]=""+(char)intColumn+intRow;
                    temp++;

                }
            }
        }
        Arrays.sort(allMoves);
        for (int i = 0; i <allMoves.length ; i++) {
            if (allMoves[i].equals(getPosition()))
                allMoves[i]="";
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
