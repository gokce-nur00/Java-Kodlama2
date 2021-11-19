public class House extends Estate {
    private String address, facade;
    private int floor, bedrooms, aream2, quality, price;
    public House(String str, int myFloor, String myfacade, int beds, int area, int myQuality) {
        super();
        this.address=str;
        this.floor=myFloor;
        this.bedrooms=beds;
        this.facade=myfacade;
        this.aream2=area;
        this.quality=myQuality;
        this.price=0;
    }
    @Override
    public int getPrice() {
        price=0;
        price+=this.getFloor() * 100000;
        price+=150000;
        price+=this.getBedrooms() * 65000;
        price+=3000 * (this.getAream2() / 5);
        price+=this.getQuality() * 110000;
        return price;
    }

    @Override
    public String toString() {
        return "Address: "+ getAddress()+"\n"+
                "Number of floors: "+ getFloor()+ "\n"+
                "Facade: "+ getFacade() + "\n"+
                "Number of bedrooms: " + getBedrooms() + "\n" +
                "Area in m2: "+ getAream2()+ "\n"+
                "Quality: "+ getQuality()+"\n"+
                "Price: " + getPrice();
    }
    @Override
    public House copy() {
        House h=new House(getAddress(),getFloor(),getFacade(),getBedrooms(),getAream2(), getQuality());
        return  h ;
    }

    @Override
    public int compareTo(Estate p, String s) {
        return super.compareTo(p, s);
    }

    @Override
    public void setAddress(String s) {
        this.address=s;
    }
    //set yapiminda fiyat guncellenir
    @Override
    public void setFloor(int i) {
        this.floor=i;
        this.price=getPrice();
    }
    @Override
    public void setAream2(int i) {
        this.aream2=i;
        this.price=getPrice();
    }
    @Override
    public void setQuality(int i) {
        if (i>5)
            this.quality=5;
        else
            this.quality=i;
        this.price=getPrice();
    }
    @Override
    public void setBedrooms(int bedrooms) {
        this.bedrooms = bedrooms;
        this.price=getPrice();
    }
    @Override
    public void setFacade(String facade) {
        this.facade = facade;
    }
    @Override
    public int getQuality() {
        return this.quality;
    }

    @Override
    public int getAream2() {
        return aream2;
    }
    @Override
    public int getBedrooms() {
        return bedrooms;
    }
    @Override
    public int getFloor() {
        return floor;
    }
    @Override
    public String getAddress() {
        return address;
    }
    @Override
    public String getFacade() {
        return facade;
    }
}
