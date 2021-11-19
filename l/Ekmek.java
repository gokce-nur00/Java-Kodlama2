public class Ekmek extends Sayilan{
    public Ekmek(int miktar, int gramaj, double fiyat, int kalite, String sonTarih) {
        super(miktar,gramaj,fiyat,kalite,sonTarih);
    }
    @Override
    public void castSonTarih(String sonTarih) {
        super.castSonTarih(sonTarih);
    }

    @Override
    public double getFiyat() {
        return super.getFiyat();
    }

    @Override
    public int getGramaj() {
        return super.getGramaj();
    }

    @Override
    public void setKalite(int kalite) {
        super.setKalite(kalite);
    }

    @Override
    public int getKalite() {
        return super.getKalite();
    }

    @Override
    public void setMiktar(int miktar) {
        super.setMiktar(miktar);
    }
    @Override
    public int getMiktar() {
        return super.getMiktar();
    }

    @Override
    public int getDay() {
        return super.getDay();
    }

    @Override
    public int getMonth() {
        return super.getMonth();
    }

    @Override
    public int getYear() {
        return super.getYear();
    }
}
