public class Market {
    private Urun[] marketUrunu;
    private AlisverisListesi liste;
    public Market(Urun[] marketUrunleri) {
        this.marketUrunu=marketUrunleri;
    }
    private Urun[] alinamayanlar;
    private float ucret=(float) 0;
    public float alisverisUcreti(AlisverisListesi liste) {
        this.liste=liste;
        this.alinamayanlar=new Urun[liste.getAlisverisListesiUrunleri().length];
        //alisveris listesindeki urunler ile market urunlerini karsilastir.
        //ayni anda miktar adet ve kalite kontrolu soz konusu
        //3 adet 2. kalite elma isteniyor ama 2 adet 1. kalite, 2 adet 2. kalite varsa 2 adet 2. kalite 1 adet 1. kalite urunu ucrete eklenir.
        //eger ust kalitede de miktari karsilayacak urun yoksa alinamaz.
        //asagi kaliteden urun eklenemez
        int temp=0;
        int indexOfalinamayanlar=0;
        while (temp<liste.getAlisverisListesiUrunleri().length){
            int gerekenMiktar=liste.getAlisverisListesiUrunleri()[temp].getMiktar();
            int istenenKalite=liste.getAlisverisListesiUrunleri()[temp].getKalite();//3 max
            int aramaSonucu=arama(liste.getAlisverisListesiUrunleri()[temp]);
            //int aranan-> return -1= uyusmuyor, return gerekenMiktar= gerekenMiktar
            if (aramaSonucu==-1){
                if (istenenKalite==1){
                    alinamayanlar[indexOfalinamayanlar++]=liste.getAlisverisListesiUrunleri()[temp];
                    temp++;
                }
                else
                    liste.getAlisverisListesiUrunleri()[temp].setKalite(--istenenKalite);
            }
            if (aramaSonucu>0){
                if (istenenKalite==1){
                    alinamayanlar[indexOfalinamayanlar++]=liste.getAlisverisListesiUrunleri()[temp];
                    temp++;
                }
                else{
                    liste.getAlisverisListesiUrunleri()[temp].setKalite(--istenenKalite);
                }
            }
            if (aramaSonucu==0){
                temp++;
            }
        }
        return ucret;
    }

    public String alinamayanlar(AlisverisListesi liste) {
        this.liste=liste;
        Ekmek ekmeks=new Ekmek(1,-1,1,1,"1/1/1111");
        Elma elmas=new Elma(1,-1,1,1,"1/1/1111");
        Pirinc pirincs=new Pirinc(1,-1,1,1,"1/1/1111");
        Peynir peynirs=new Peynir(1,-1,1,1,"1/1/1111");
        String str="";
        for (int i=0; i< alinamayanlar.length;i++){
            if (alinamayanlar[i]==null)
                continue;
            else if (alinamayanlar[i].getClass().equals(ekmeks.getClass())){
                str+="Ekmek "+ alinamayanlar[i].getMiktar()+" "+ alinamayanlar[i].getKalite()+" ";
            }
            else if (alinamayanlar[i].getClass().equals(elmas.getClass())){
                str+="Elma "+ alinamayanlar[i].getMiktar()+" "+ alinamayanlar[i].getKalite()+" ";
            }
            else if (alinamayanlar[i].getClass().equals(peynirs.getClass())){
                str+="Peynir "+ alinamayanlar[i].getMiktar()+" "+ alinamayanlar[i].getKalite()+" ";
            }
            else if (alinamayanlar[i].getClass().equals(pirincs.getClass())){
                str+="Pirinc "+ alinamayanlar[i].getMiktar()+" "+ alinamayanlar[i].getKalite()+" ";
            }
        }

        return str;
    }

    private int arama(Urun alisverisUrunu){
        int alinanMiktar=0;
        int gerekenMiktar=alisverisUrunu.getMiktar();
        int varMi=0;
        for (int i=0; i<marketUrunu.length;i++){
            if (gerekenMiktar!=0) {
                if (alisverisUrunu.getClass().equals(marketUrunu[i].getClass())) {
                    if (gramajKontrol(alisverisUrunu.getGramaj(), marketUrunu[i].getGramaj())) {//istenilen gramaj ise
                        if (sonKullanimTarihi(alisverisUrunu, marketUrunu[i])) {//tarihi gecmemis ise
                            if (kaliteKontrol(alisverisUrunu.getKalite(), marketUrunu[i].getKalite())) {//istenilen kalite de ise
                                if (marketUrunu[i].getMiktar()!=0) {
                                    if (miktarKontrol(alisverisUrunu.getMiktar(), marketUrunu[i].getMiktar())==0){
                                        gerekenMiktar=0;
                                        alinanMiktar=alisverisUrunu.getMiktar();
                                        marketUrunu[i].setMiktar(marketUrunu[i].getMiktar()-alinanMiktar);
                                        ucret=(float) (ucret+alinanMiktar*marketUrunu[i].getFiyat());
                                        varMi=1;
                                        break;
                                    }
                                    if (miktarKontrol(alisverisUrunu.getMiktar(), marketUrunu[i].getMiktar())!=0){
                                        gerekenMiktar = miktarKontrol(alisverisUrunu.getMiktar(), marketUrunu[i].getMiktar());
                                        alinanMiktar = alisverisUrunu.getMiktar() - gerekenMiktar;
                                        marketUrunu[i].setMiktar(marketUrunu[i].getMiktar() - alinanMiktar);
                                        ucret = (float) (ucret + alinanMiktar * marketUrunu[i].getFiyat());
                                        alisverisUrunu.setMiktar(gerekenMiktar);
                                        varMi = 1;//islem gordu
                                        break;
                                    }
                                }
                                else
                                    varMi=0;
                            }
                            else
                                varMi=0;//islem gormedi
                        }
                        else
                            varMi=0;
                    }
                    else
                        varMi=0;
                }
                varMi=0;
            }
            varMi=1;
        }
        if (varMi==0){
            return -1;
        }
        else
            return gerekenMiktar;
    }
    private int miktarKontrol(int istenenMiktar, int olanMiktar){
        if (istenenMiktar<= olanMiktar){
            return 0;
        }
        else
            return istenenMiktar-olanMiktar;
    }
    private boolean sonKullanimTarihi(Urun alisverisUrunu, Urun marketUrunu){
        int alisverisGun, alisverisAy, alisverisYil, marketGun, marketAy, marketYil;
        alisverisGun=alisverisUrunu.getDay();
        marketGun=marketUrunu.getDay();
        alisverisAy=alisverisUrunu.getMonth();
        marketAy=marketUrunu.getMonth();
        alisverisYil=alisverisUrunu.getYear();
        marketYil=marketUrunu.getYear();
        if (alisverisYil< marketYil){
            return true;
        }
        else if (alisverisYil == marketYil){
            if (alisverisAy< marketAy){
                return true;
            }
            else if (alisverisAy== marketAy){
                if (alisverisGun < marketGun)
                    return true;
                else if (alisverisGun== marketGun)
                    return true;
                else
                    return false;
            }
            else
                return false;
        }
        else
            return false;
    }

    private boolean kaliteKontrol(int istenenKalite, int olanKalite){
        //1. kalite en ust kalite
        if (istenenKalite == olanKalite){//esit kalite
            return true;
        }
        else
            return false;//ust kalite ise

    }

    private boolean gramajKontrol(int istenilenGramaj, int olanGramaj){
        if (istenilenGramaj==olanGramaj)
            return true;
        else
            return false;
    }

}
