import java.util.*;
public class Piece {
    private String position;
    private String color;
    private int column, row;
    public Piece(String color) {this.color=color;}

    public boolean canMove(String newPosition) {
        boolean type=true;
        if (getPosition().equals(newPosition));
        else
            type=false;
        return type;
    }
    //Hamleleri alfabetik sirada doner
    public String[] getAllMoves() {
        String[] allMoves=new String[64];
        int temp=0;
        for (int i = 0; i <= 7; i++) {//row
            for (int j = 0; j <= 7; j++) {//column
                int intColumn=(int) 'a'+j;
                int intRow=8-i;
                allMoves[temp]=""+(char)intColumn+intRow;
                temp++;
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

    public void setPosition(String newPosition){
        this.position=newPosition;
    }
    public String getPosition(){
        return this.position;
    }
    public String getColor(){
        return this.color;
    }

    public int getColumn() {
        return column;
    }

    public int getRow() {
        return row;
    }

    public void calculate(String pos){
        //first index gives me column
        //second index gives me row
        //a=0, b=1, c=2, d=3, e=4, f=5, g=6, h=7
        int positiveIndex=8;
        //w positiveIndex, I'm gonna get the real index-> positiveIndex-(int)pos[1]=the real row index
        //ex: pos="a6";-> a gives me 0. column and positiveIndex-6=2 gives me row.
        this.row=positiveIndex-Integer.parseInt(""+pos.charAt(1));
        String letter=""+ pos.charAt(0);
        switch (letter){
            case "a":
                this.column=0;
                break;
            case "b":
                this.column=1;
                break;
            case "c":
                this.column=2;
                break;
            case "d":
                this.column=3;
                break;
            case "e":
                this.column=4;
                break;
            case "f":
                this.column=5;
                break;
            case "g":
                this.column=6;
                break;
            case "h":
                this.column=7;
                break;
        }
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
