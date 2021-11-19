public class Organism {
    private int xkonum, ykonum;
    private int breedCalculator;
    private int genislik;
    public Organism(int x, int y){
        this.breedCalculator=0;
        setXkonum(x); setYkonum(y);
        this.genislik=20;
        //x,y
    }
    public void move(int x, int y){
        if (x>=0 && x<genislik && y>=0 && y<genislik) {
            setXkonum(x);
            setYkonum(y);
        }
    }
    public Organism breed(int x, int y){
        return null;
    }

    public boolean starve(){ return false;}

    public int getXkonum() {
        return this.xkonum;
    }
    public int getYkonum() {
        return this.ykonum;
    }

    public void setXkonum(int xkonum) {
        this.xkonum = xkonum;
    }

    public void setYkonum(int ykonum) {
        this.ykonum = ykonum;
    }

    public int getBreedCalculator() {
        return breedCalculator;
    }

    public void setBreedCalculator(int breedCalculator) {
        this.breedCalculator = breedCalculator;
    }

    public String getPrintableChar() {
        return "*";
    }
}
