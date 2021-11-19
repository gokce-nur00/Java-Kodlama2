public class Estate implements Comparable {
    private String address, facade;
    private int floor, bedrooms, aream2, quality;



    public int compareTo(Estate p, String s) {
        int answer=0;
        if (s.equals("Price")){
            if (this.getPrice()> p.getPrice())
                return answer=1;
            else if (this.getPrice()< p.getPrice()){
                return answer=-1;
            }
            else
                return answer=0;
        }
        if (s.equals("Quality")){
            if (this.getQuality()> p.getQuality())
                return answer=1;
            if (this.getQuality()<p.getQuality())
                return answer=-1;
            else
                return answer=0;
        }
        if (s.equals("Bedrooms")){
            if (this.getBedrooms() > p.getBedrooms())
                return answer=1;
            if (this.getBedrooms() < p.getBedrooms())
                return answer=-1;
            else
                return answer=0;
        }
        if (s.equals("Area")){
            if (this.getAream2()> p.getAream2())
                return answer=1;
            if (this.getAream2() < p.getAream2())
                return answer=-1;
            else
                return answer=0;
        }
        return answer;

    }
    public int getPrice() {
        return 0;
    }


    public Estate copy() {
        Estate e=new Estate();
        e.aream2=this.aream2;
        e.quality=this.quality;
        e.bedrooms=this.bedrooms;
        e.facade=this.facade;
        e.address=this.address;
        e.floor=this.floor;
        return e;
    }

    @Override
    public String toString() {
        return
                "Address: " + getAddress() + "\n" +
                "Floor: " + getFloor() + "\n" + "Facade: " + getFacade() + "\n" +
                "Number of bedrooms: " + getBedrooms() + "\n" +
                "Area in m2: " + getAream2() + "\n" +
                "Quality: " + getQuality() + "\n" +
                "Price: " + this.getPrice();
    }

    public void setAddress(String s) {
        this.address=s;
    }

    public void setFloor(int i) {
        this.floor=i;
    }

    public void setAream2(int i) {
        this.aream2=i;
    }
    public void setQuality(int i) {
        this.quality=i;
    }

    public void setBedrooms(int bedrooms) {
        this.bedrooms = bedrooms;
    }

    public void setFacade(String facade) {
        this.facade = facade;
    }

    public int getQuality() {
        return this.quality;
    }



    public int getAream2() {
        return aream2;
    }

    public int getBedrooms() {
        return bedrooms;
    }

    public int getFloor() {
        return floor;
    }

    public String getAddress() {
        return address;
    }

    public String getFacade() {
        return facade;
    }
    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
