import java.io.*;
import java.util.Scanner;

public class TextFileUtil implements EncryptDecrypt {
    //main eklemek gerektiginden emin olamadim bu sebeple eklemedim.
    @Override
    public void encrypt(String inputFileName, String key) {
        String encryptedText="";
        Scanner reader=null;
        FileWriter writer=null;
        try{
            reader=new Scanner(new File(""+inputFileName));
            writer=new FileWriter(inputFileName+".encr");
            while (reader.hasNextLine()){
                String temp=reader.nextLine();
                //encrypt function is E+K%26 because A-Z=[0-25]
                if (temp.length()>key.length()){//eger orijinal text keyden uzunsa
                    int lengthOfKey=key.length();
                    for (int i =0; i <temp.length()-lengthOfKey ; i++) {//keyi text kadar uzun olacak sekle getiriyorum.
                        int realIndex=i%lengthOfKey;
                        key+=key.charAt(realIndex);
                    }
                }
                for (int i = 0; i < temp.length(); i++) {
                    //eger gelen char buyuk harf araliginda degilse o zaman islem yapmaz.
                    //verilen wikipedia adresinde tablo sadece buyuk harfleri icerdiginden
                    // o araliktaki charlar icin islem yapan kod yazdim.
                    if (temp.charAt(i)>=65 && temp.charAt(i)<=90){//[A-Z]
                        int value=(temp.charAt(i)+key.charAt(i))%26;
                        //after mod, I have to add 'A' because of the value of the ASCII table
                        value+='A';
                        encryptedText+=(char)value;
                    }
                    else{//diger ASCII elemanlari-> .  , ; : gibi
                        encryptedText+=temp.charAt(i);
                    }

                }

                writer.write(encryptedText);

            }
            writer.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void decrypt(String inputFileName, String key, String outputFileName) {
        String originalText="";
        Scanner reader=null;
        FileWriter writer=null;
        try {
            reader=new Scanner(new FileInputStream(inputFileName));
            writer=new FileWriter(outputFileName);
            while (reader.hasNextLine()){
                String encryptedText=reader.nextLine();
                if (encryptedText.length()>key.length()){//eger orijinal text keyden uzunsa
                    int lengthOfKey=key.length();
                    for (int i =0; i <encryptedText.length()-lengthOfKey ; i++) {//keyi text kadar uzun olacak sekle getiriyorum.
                        int realIndex=i%lengthOfKey;
                        key+=key.charAt(realIndex);
                    }
                }
                for (int i = 0; i <encryptedText.length() ; i++) {
                    if (encryptedText.charAt(i)>=65 && encryptedText.charAt(i)<=90){//[A-Z]
                        int value=(encryptedText.charAt(i)-key.charAt(i)+26)%26;
                        //after mod, I have to add 'A' because of the value of the ASCII table
                        value+='A';
                        originalText+=(char)value;
                    }
                    else{//diger ASCII elemanlari-> .  , ; : gibi
                        originalText+=encryptedText.charAt(i);
                    }
                }

                writer.write(originalText);

            }
            writer.close();

        }catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
interface EncryptDecrypt {
    public void encrypt(String inputFileName, String key);
    public void decrypt(String inputFileName, String key, String outputFileName);
}
