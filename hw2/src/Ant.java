public class Ant extends Organism{
    private final int ANTBREEDLIMIT=3;
    public Ant(int x, int y){
        super(x,y);
        setXkonum(x);
        setYkonum(y);

    }
    @Override
    public void move(int x, int y) {
        if ((Math.abs(this.getXkonum()-x)==1 || Math.abs(this.getXkonum()-x)==0) &&
                ( Math.abs(this.getYkonum()-y)==1 || Math.abs(this.getYkonum()-y)==0)){
            super.move(x, y);
            setBreedCalculator(getBreedCalculator()+1);
        }
    }


    public Ant breed(int x, int y) {
        if (getBreedCalculator()==ANTBREEDLIMIT){
            setBreedCalculator(0);
            Ant offspring=new Ant(x,y);
            return offspring;
        }
        return null;
    }

    public String getPrintableChar()
    {
        return "o";
    }


}
