public class Board {
    private Piece[][] board = new Piece[8][8];
    //construct an empty board
    //set all to null
    private int row, column;
    private String indexofEnemy;
    public Board(){
        this.column=0;
        this.row=0;
        indexofEnemy="";
        for (int i = 0; i <8 ; i++) {
            for (int j = 0; j <8 ; j++) {
                board[i][j]=null;
            }
        }
    }
    public boolean putPiece(Piece p, String pos){
        boolean put=false;
        returnType(pos);
        if(isEmpty(pos)){
            this.board[this.row][this.column]=p;
            p.setPosition(pos);
            put=true;
        }
        return put;
    }
    public Piece getPiece(String pos){
        returnType(pos);
        return this.board[this.row][this.column];
    }
    //devam et check metoduna
    public boolean check(String color){
        boolean isCheck=false;
        String indexOfKing=findKing(color);//king'in yerini tespit ettik.
        String white="white", black="black";
        String oppositeColor=color.equals(white)?black:white;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                int intColumn=(int)'a'+j;
                int intRow=8-i;
                if (! this.isEmpty(""+(char)intColumn+intRow) ){//if is not empty
                    if (getPiece(""+(char)intColumn+intRow).getColor().equals(oppositeColor)){//if the piece is opposite
                        if (this.board[i][j].canMove(indexOfKing)){
                            isCheck=true;
                            this.board[i][j].calculate(""+(char)intColumn+intRow);
                            this.indexofEnemy=this.board[i][j].getPosition();
                        }

                    }
                }
            }
        }

        return isCheck;
    }
    public boolean checkMate(String color){
        boolean isCheckmate=false;
        String indexOfKing=findKing(color);
        int rowOfKing=8-Integer.parseInt(""+indexOfKing.charAt(1));
        int columnOfKing=(int)indexOfKing.charAt(0)-(int)'a';
        int rowOfEnemy=8-Integer.parseInt(""+indexofEnemy.charAt(1));
        int columnOfEnemy=(int)indexofEnemy.charAt(0)-(int)'a';
        String white="white", black="black";
        String oppositeColor=color.equals(white)?black:white;
        if (check(color))
        {
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j <board[i].length ; j++) {
                    int intColumn=(int) 'a'+j;
                    int intRow=8-i;
                    String str=""+(char)intColumn+intRow;
                    if (isEmpty(str) && this.board[rowOfKing][columnOfKing].canMove(str) && !this.board[rowOfEnemy][columnOfEnemy].canMove(str) ){
                        isCheckmate=false;
                    }
                    else if (isEmpty(str) && this.board[rowOfKing][columnOfKing].canMove(str) && this.board[rowOfEnemy][columnOfEnemy].canMove(str) ){
                        isCheckmate=true;
                    }

                }
            }
        }
        return isCheckmate;
    }
    public boolean isEmpty(String pos) {
        boolean empty=false;
        returnType(pos);
        if (this.board[this.row][this.column]==null)
            empty=true;
        return empty;
    }
    private void returnType(String pos){
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
    private String findKing(String color){
        King k=new King(color);
        String indexOfKing="";
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if ( board[i][j]!=null &&board[i][j].getClass().equals(k.getClass()) && board[i][j].getColor().equals(color)){
                    indexOfKing=board[i][j].getPosition();
                }
            }
        }
        return indexOfKing;
    }
    private String[][] research(String color){
        //karsit colordan olanlarin arrayini donecek.
        String[][] isAttack=new String[2][16];//type and location
        String bishop="bishop", pawn="pawn", queen="queen", knight="knight", rook="rook", king="king";
        //isAttack[0]=type
        //isAttack[1]=location
        Pawn pawn1=new Pawn(color);
        Queen queen1=new Queen(color);
        Bishop bishop1=new Bishop(color);
        Knight knight1=new Knight(color);
        Rook rook1=new Rook(color);
        King king1=new King(color);
        int temp=0;
        for (int i = 0; i <2 ; i++) {
            for (int j = 0; j < 8; j++) {
                if (this.board[i][j]!=null && this.board[i][j].getColor().equals(color)!=true){
                    if (this.board[i][j].getClass().equals(pawn1)){
                        isAttack[0][temp]=pawn;
                        int intColumn=(int)'a'+j;
                        int intRow=8-i;
                        isAttack[1][temp]=""+(char)intColumn+intRow;
                        temp++;
                    }
                    if (this.board[i][j].getClass().equals(queen1)){
                        isAttack[0][temp]=queen;
                        int intColumn=(int)'a'+j;
                        int intRow=8-i;
                        isAttack[1][temp]=""+(char)intColumn+intRow;
                        temp++;
                    }
                    if (this.board[i][j].getClass().equals(bishop1)){
                        isAttack[0][temp]=bishop;
                        int intColumn=(int)'a'+j;
                        int intRow=8-i;
                        isAttack[1][temp]=""+(char)intColumn+intRow;
                        temp++;
                    }
                    if (this.board[i][j].getClass().equals(knight1)){
                        isAttack[0][temp]=knight;
                        int intColumn=(int)'a'+j;
                        int intRow=8-i;
                        isAttack[1][temp]=""+(char)intColumn+intRow;
                        temp++;
                    }
                    if (this.board[i][j].getClass().equals(rook1)){
                        isAttack[0][temp]=rook;
                        int intColumn=(int)'a'+j;
                        int intRow=8-i;
                        isAttack[1][temp]=""+(char)intColumn+intRow;
                        temp++;
                    }
                    if (this.board[i][j].getClass().equals(king1)){
                        isAttack[0][temp]=king;
                        int intColumn=(int)'a'+j;
                        int intRow=8-i;
                        isAttack[1][temp]=""+(char)intColumn+intRow;
                        temp++;
                    }

                }
            }
        }

        return isAttack;
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