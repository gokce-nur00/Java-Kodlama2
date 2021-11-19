import java.util.Scanner;

public class PredatorSim {
    public static void main(String[] args) {
        World board=new World();

        int doodlebugcount=0;
        while (doodlebugcount < 5)
        {
            int x = (int) (Math.random() * board.WIDTH);
            int y = (int) (Math.random() * board.WIDTH);
            if (board.getOrganism(x,y)==null)
            {
                doodlebugcount++;
                Doodlebug doodlebug = new Doodlebug(x,y);
                board.setOrganism(x, y, doodlebug);
            }
        }

        int antcount = 0;
        while (antcount < 100)
        {
            int x = (int) (Math.random() * board.WIDTH);
            int y = (int) (Math.random() * board.WIDTH);
            if (board.getOrganism(x,y)==null)
            {
                antcount++;
                Ant ant = new Ant(x,y);
                board.setOrganism(x,y, ant);
            }
        }

        String str;
        Scanner keyboard=new Scanner(System.in);
        board.DisplayMethod();
        while (board.getDoodleBug()>0 && board.getAnt()>0
        ){
            str=keyboard.nextLine();//after 2 enter you gonna see the board
            board.DisplayMethod();
            board.simulator();


        }

    }
}
