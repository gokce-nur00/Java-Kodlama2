import java.lang.Number;
public class MatMul {
    //odev metninde gosterilene uygun maini yazdim ama gonderip gondermemek gerektiginden emin olmadigimdan eklemedim
    //mainde eger iki arrayin ici doluysa ve ilkinin sutun sayisi ile ikincinin satir sayisi denk ise dogru calisiyor.
    public static <T1 extends Number,T2 extends Number>Double[][] multiply(T1[][] first, T2[][] second) {
        Double[][] matris=null;
        try {

            if (first[0].length== second.length){
                matris=new Double[first.length][second[0].length];
                for (int i = 0; i < matris.length; i++) {
                    for (int j = 0; j <matris[i].length ; j++) {
                        matris[i][j]=0.0;
                        for (int k = 0; k < second.length; k++)
                            matris[i][j]+=(double) ((double)first[i][k] * (double)second[k][j]);
                    }
                }
            }
            else
                throw new Exception();
            
        }catch (Exception e){
            System.out.println("Matrisler carpilamaz.");
        }
        return matris;
    }



}
