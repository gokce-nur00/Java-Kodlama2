import java.util.Scanner;
public class KAralik {
    public static void main(String[] args) {
        Scanner key=new Scanner(System.in);
        String str=key.nextLine();
        int indexofcomma=str.indexOf(",");
        String dizi=str.substring(0, indexofcomma);
        String kStr=""+ str.charAt(str.length()-1);
        String[] arrStr=dizi.split(" ");
        int[] arr=new int[arrStr.length];
        for (int i=0; i<arr.length; i++)
            arr[i]=Integer.parseInt(arrStr[i]);
        int k=Integer.parseInt(kStr);
        recusiveAralik(arr,k);
    }

    public static void recusiveAralik(int[] arr, int k){

        int son= arr.length;
        if (son<k)
        {
        }
        else if (son<k);
        else {
            int[] temp = new int[son - k];
            for (int i = 0; i < son - k; i++)
                temp[i] = arr[i];
            System.out.print(arr[son - k] + " ");
            recusiveAralik(temp, k);
        }
    }
}
