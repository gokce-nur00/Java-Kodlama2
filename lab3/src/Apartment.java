public class Apartment extends Estate {
    private String address, facade;
    private int floor, bedrooms, aream2, quality, price;

    public Apartment(String str, int myFloor, String myfacade, int beds, int area, int myQuality) {
        super();
        this.address=str;
        this.floor=myFloor;
        this.facade=myfacade;
        this.aream2=area;
        this.quality=myQuality;
        this.bedrooms=beds;
        this.price=0;
    }
    @Override
    public int getPrice() {
        price+=getFloor() * 30000;
        price+=getBedrooms() * 35000;
        price+=1000 * (getAream2() / 5);
        price+=getQuality() * 60000;
        if (getFacade().equals("North"))
            price-=20000;
        if (getFacade().equals("South"))
            price+=20000;
        if (getFacade().equals("East"))
            price-=5000;
        if (getFacade().equals("West"))
            price+=5000;
        return price;
    }
    @Override
    public int compareTo(Estate p, String s) {
        return super.compareTo(p, s);
    }


    @Override
    public Apartment copy() {
        Apartment a=new Apartment(getAddress(),getFloor(),getFacade(),getBedrooms(),getAream2(), getQuality());
        return a;
    }

    @Override
    public String toString() {
        return super.toString();
    }
    @Override
    public void setAddress(String s) {
        this.address=s;
        this.price=getPrice();
    }
    //her set zamani fiyat guncellenir
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
        this.price=getPrice();
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
