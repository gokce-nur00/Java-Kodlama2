import java.util.Scanner;
public class Sort {
    public static void main(String[] args) {
        Scanner keyboard=new Scanner(System.in);
        String dizi=keyboard.nextLine();
        String[] str= dizi.split(" ");
        int[] arr=new int[str.length+1];
        for (int i=0; i< str.length;i++){
            arr[i]=Integer.parseInt(str[i]);
        }
        arr[arr.length-1]=0;
        arr=Sort.rSort(arr);
    }
    public static int[] rSort(int[] arr){
        //sonunda ek bir eleman var
        //bu eleman hangi kisimdan baslayarak en kucuk elemani arayacagimizi soyluyor.
        if(arr[arr.length-1]==arr.length-1){
            int[] selection=new int[arr.length-1];
            for (int i=0;i< selection.length; i++){
                selection[i]=arr[i];
            }
            return selection;
        }
        else {
            int indexOfStart=arr[arr.length-1];
            int min=arr[indexOfStart];
            int indexOfMin=indexOfStart;
            for (int i=indexOfStart+1;i< arr.length-1;i++){//en kucuk bulundu
                if (min>arr[i]){
                    min=arr[i];
                    indexOfMin=i;
                }
            }
            for (int i=indexOfMin; i>indexOfStart; i--){
                arr[i]=arr[i-1];
            }
            arr[indexOfStart]=min;
            arr[arr.length-1]= indexOfStart+1;
            for (int i=0; i<arr.length-1;i++){
                if (i==arr.length-2){
                    System.out.print(arr[i]);
                    break;
                }
                System.out.print(arr[i]+ " ");
            }
            System.out.println("");
            return rSort(arr);


        }
    }
}
