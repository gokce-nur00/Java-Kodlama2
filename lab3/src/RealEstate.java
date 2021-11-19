public class RealEstate {
    public static void main(String [] args){
        Estate apart1 = new Apartment("860 Glenwood Ave SE, Atlanta, GA 30316", 3, "East", 4, 250, 4);//515
        Estate apart2 = new Apartment("392 Central Park W APT 12G, New York, NY 10025", 11, "North", 6, 250, 5);//650
        Estate apart3 = new Apartment("60 E 9th St APT 339, New York, NY 10003", -2, "West", 1, 75, 2);//115
        Estate house1 = new House("105 E 2nd St, Brooklyn, NY 11218", 3, "West", 5, 300, 3);//1285
        Estate house2 = new House("600 N Pine St E, Brooklyn, NY 11208", 4, "South", 7, 450, 5);//1825

        if(apart1.compareTo(apart2, "Price") < 0)
            System.out.println("Apartment 2 is more expensive.");
        else System.out.println("Apartment 1 is more expensive.");

        if(apart1.compareTo(house1, "Quality") > 0)
            System.out.println("Apartment 1's quality is higher than house 1.");
        else System.out.println("Apartment 1's quality is lower than house 1.");

        if(house1.compareTo(house2, "Bedrooms") > 0)
            System.out.println("House 1 has more bedrooms than house 2.");
        else System.out.println("House 2 has more bedrooms than house 1.");

        if(house1.compareTo(house2, "Area") < 0)
            System.out.println("House 2 is bigger than house 1.");
        else System.out.println("House 1 is bigger than house 2.");

        if(apart1.compareTo(apart2, "Area") < 0)
            System.out.println("Apartment 2 is bigger than Apartment 1.");
        else System.out.println("Apartment 2 is smaller than Apartment 1.");

        Estate house3 = house2.copy();//1825
        house3.setAddress("111-37 156, Jamaica, NY 11433");
        house3.setFloor(5);//1925
        house3.setAream2(500);//1975
        house3.setQuality(house1.getQuality() + 2);

        if(house2.compareTo(house3, "Area") < 0)
            System.out.println("House 2 is smaller than house 3.");

        System.out.println(house1.toString());
        System.out.println(house3.getPrice());
        System.out.println(apart3.toString());



    }
}

