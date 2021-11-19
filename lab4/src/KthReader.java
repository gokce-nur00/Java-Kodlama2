import java.util.*;
import java.io.*;
public class KthReader {
    public static void main(String[] args) {
        //-t Text.txt -k 3
        /* args[0]=-t, args[1]=Text.txt args[2]=-k, args[3]=3
        * I'm gonna print them*/
        String filename="";
        int kTh=1;
        int counter=0;
        for (int i = 0; i < args.length; i++) {
            if (args[i].equals("-t")){
                filename=args[i+1];
            }
            if (args[i].equals("-k")){
                if (i+1<args.length)
                    kTh=Integer.parseInt(args[i+1]);
                else
                    kTh=1;
            }
        }
        Scanner inputStream=null;
        try {
            inputStream=new Scanner(new File(filename));
        }catch (FileNotFoundException e){}
        int i=1;
        while (inputStream.hasNext()){
            String str=inputStream.next();
            if (i%kTh==0){
                System.out.println(str);
                counter++;
            }
            i++;
        }
        System.out.println("==========");
        System.out.println("In total "+ counter+" words have been printed.");
        inputStream.close();
    }
}
