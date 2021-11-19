public class Urun {
    private int miktar,gramaj,kalite;
    private double fiyat;
    private String sonTarih;
    public Urun(int miktar, int gramaj, double fiyat, int kalite, String sonTarih){
        this.miktar=miktar;
        this.gramaj=gramaj;
        this.fiyat=fiyat;
        this.kalite=kalite;
        this.sonTarih=sonTarih;
    }
    private int day, month, year;

    public void castSonTarih(String sonTarih) {
        this.sonTarih=sonTarih;
        int firstSlash, secondSlash;
        firstSlash=sonTarih.indexOf("/");
        this.day=Integer.parseInt(sonTarih.substring(0,firstSlash));
        sonTarih=sonTarih.substring(firstSlash+1);
        secondSlash=sonTarih.indexOf("/");
        this.month=Integer.parseInt(sonTarih.substring(0,secondSlash));
        sonTarih=sonTarih.substring(secondSlash+1);
        this.year=Integer.parseInt(sonTarih);
    }



    public double getFiyat() {
        return fiyat;
    }

    public int getGramaj() {
        return gramaj;
    }

    public void setKalite(int kalite) {
        this.kalite = kalite;
    }

    public int getKalite() {
        return kalite;
    }

    public void setMiktar(int miktar) {
        this.miktar = miktar;
    }

    public int getMiktar() {
        return miktar;
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

}
