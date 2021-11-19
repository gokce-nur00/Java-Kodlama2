public class Doodlebug extends Organism{
    private final int DEATHLIMIT=3;
    private final int DOODLEBUGBREEDLIMIT=8;
    private int starveCalculator;
    public Doodlebug(int x, int y){
        super(x,y);
        setStarveCalculator(0);
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
    @Override
    public Doodlebug breed(int x, int y) {
        if (getBreedCalculator()==DOODLEBUGBREEDLIMIT){
            setBreedCalculator(0);
            Doodlebug offspring=new Doodlebug(x,y);
            return offspring;
        }
        return null;
    }
    @Override
    public boolean starve(){
        boolean isStarve=false;
        if (getStarveCalculator()==DEATHLIMIT){
            isStarve=true;
            setStarveCalculator(0);
        }
        return isStarve;
    }

    public void setStarveCalculator(int starveCalculator) {
        this.starveCalculator = starveCalculator;
    }

    public int getStarveCalculator() {
        return starveCalculator;
    }

    public String getPrintableChar()
    {
        return "X";
    }
}
