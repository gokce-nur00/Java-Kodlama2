public class World {
    private Organism[][] board;
    public static final int WIDTH=20;
    public World(){
        board=new Organism[WIDTH][WIDTH];
        for (int i = 0; i < WIDTH; i++) {
            for (int j = 0; j < WIDTH; j++) {
                setOrganism(i,j,null);
            }
        }
    }



    public void isMove(int x, int y){
        Ant a=new Ant(x,y);//class karsilastirmasi icin
        Doodlebug doodlebug=new Doodlebug(x,y);
        if (board[x][y].getClass().equals(a.getClass())){//eger hareket ettirilmek istenen organizma ant ise
            if (y-1>=0 && isEmpty(x,y-1)){
                board[x][y].move(x,y-1);
                setOrganism(x,y-1,board[x][y]);
                board[x][y]=board[x][y-1].breed(x,y);

            }
            else if (isEmpty(x,y+1))
            {
                board[x][y].move(x,y+1);
                setOrganism(x,y+1,board[x][y]);
                board[x][y]=board[x][y+1].breed(x,y);

            }
            else if(isEmpty(x-1,y))
            {
                board[x][y].move(x-1,y);
                setOrganism(x-1,y,board[x][y]);
                board[x][y]=board[x-1][y].breed(x,y);

            }
            else if ( isEmpty(x+1, y))
            {
                board[x][y].move(x+1,y);
                setOrganism(x+1,y,board[x][y]);
                board[x][y]=board[x+1][y].breed(x,y);

            }
        }
        else if (board[x][y].getClass().equals(doodlebug.getClass())){
            //hareket ettirilmek istenen organizma doodlebug ise
                if (board[x][y].starve()){//eger ac kaldiysa
                    setOrganism(x,y,null);
                }
                else if (  getOrganism(x,y-1)!=null && getOrganism(x,y-1).getClass().equals(a.getClass())){//once varsa ant aranir
                    board[x][y].move(x,y-1);
                    setOrganism(x,y-1,board[x][y]);
                    board[x][y]=board[x][y-1].breed(x,y);

                }
                else if (getOrganism(x,y+1)!=null && getOrganism(x,y+1).getClass().equals(a.getClass())){
                    board[x][y].move(x,y+1);
                    setOrganism(x,y+1,board[x][y]);
                    board[x][y]=board[x][y+1].breed(x,y);
                }
                else if (  getOrganism(x-1,y)!=null && getOrganism(x-1,y).getClass().equals(a.getClass())){
                    board[x][y].move(x-1,y);
                    setOrganism(x-1,y,board[x][y]);
                    board[x][y]=board[x-1][y].breed(x,y);
                }
                else if (getOrganism(x+1,y)!=null && getOrganism(x+1,y).getClass().equals(a.getClass())){
                    board[x][y].move(x-1,y);
                    setOrganism(x+1,y,board[x][y]);
                    board[x][y]=board[x+1][y].breed(x,y);

                }
                else  if ( isEmpty(x,y-1)){//eger hicbir yerde ant yoksa bos olan yere hareket eder
                    board[x][y].move(x,y-1);
                    setOrganism(x,y-1,board[x][y]);
                    board[x][y]=board[x][y-1].breed(x,y);

                }
                else if (isEmpty(x,y+1))
                {
                    board[x][y].move(x,y+1);
                    setOrganism(x,y+1,board[x][y]);
                    board[x][y]=board[x][y+1].breed(x,y);

                }
                else if( isEmpty(x-1,y))
                {
                    board[x][y].move(x-1,y);
                    setOrganism(x-1,y,board[x][y]);
                    board[x][y]=board[x-1][y].breed(x,y);

                }
                else if (isEmpty(x+1, y))
                {
                    board[x][y].move(x+1,y);
                    setOrganism(x+1,y,board[x][y]);
                    board[x][y]=board[x+1][y].breed(x,y);

                }

        }

    }


    public void simulator() {//in one term the method do the movements.
        Ant ant = new Ant(0, 0);
        Doodlebug doodlebug = new Doodlebug(0, 0);
        for (int i = 0; i < WIDTH; i++){//ilk once doodlebuglar
            for (int j = 0; j < WIDTH; j++)
                if (getOrganism(i, j) != null && getOrganism(i, j).getClass().equals(doodlebug.getClass()))
                    if (i-1>=0 && i+1<20 && j-1>=0 && j+1<20)
                        isMove(i, j);
        }
        for (int i = 0; i < WIDTH; i++){//daha sonra ant
            for (int j = 0; j < WIDTH; j++)
                if (getOrganism(i, j) != null && getOrganism(i, j).getClass().equals(ant.getClass()))
                    if (i-1>=0 && i+1<20 && j-1>=0 && j+1<20)
                        isMove(i, j);
        }
    }

    public boolean isEmpty(int x, int y){
        if (getOrganism(x,y)==null)
            return true;
        return false;
    }

    public Organism getOrganism(int x, int y)//return the organism
    {
        if ((x>=0) && (x<WIDTH) && (y>=0) && (y<WIDTH))
            return board[x][y];
        return null;
    }
    public void setOrganism(int x, int y, Organism org)//put the organism to the board
    {
        if ((x>=0) && (x<WIDTH) && (y>=0) && (y<WIDTH))
        {
            board[x][y] = org;
        }
    }

    public int getDoodleBug(){//the number of doodlebug
        int doodlebugcount=0;
        for (int i = 0; i <WIDTH; i++) {
            for (int j = 0; j < WIDTH ; j++) {
                if (getOrganism(i,j) instanceof Doodlebug){
                    doodlebugcount++;
                }
            }
        }
        return doodlebugcount;
    }
    public int getAnt(){//the number of ant
        int antcount=0;
        for (int i = 0; i <WIDTH; i++) {
            for (int j = 0; j < WIDTH ; j++) {
                if (getOrganism(i,j) instanceof Ant){
                    antcount++;
                }
            }
        }
        return antcount;
    }


    public void DisplayMethod()
    {
        System.out.println();
        for (int i=0; i<WIDTH; i++)
        {
            for (int j=0; j<WIDTH; j++)
            {
                if (board[i][j]==null)
                    System.out.print(".");
                else
                    System.out.print(board[i][j].getPrintableChar());
            }
            System.out.println();
        }
    }
}
