

/* java FindReplace -i input.txt -f "ali?veli[3,4,5]" -r "aliveli49" -o output.txt
          java FindReplace -i0 doc1 -f2 "ali3 veli kirk dokuz elli" -r "ali veli 49 50" -o doc2*/


import java.util.*;
import java.io.*;

public class FindReplace {
    public static void main(String[] args) {
        String inputFile="";
        String outputFile="";
        String findValue="";
        String replaceValue="";
        int i=0;
        while (i<args.length){
            if (args[i].equals("-i")){
                inputFile=args[i+1];
            }
            if (args[i].equals("-o")){
                outputFile=args[i+1];
            }
            if (args[i].equals("-f")){
                int j=i+2;
                while (j<args.length){
                    if (args[j].equals("-o")){
                        String tillo="";
                        for (int k = i+1; k <j; k++) {
                            tillo+=args[j];
                        }
                        j++;
                        findValue=tillo;
                    }
                    if (args[j].equals("-r")){
                        String tillr="";
                        for (int k = i+1; k <j; k++) {
                            tillr+=args[j];
                        }
                        j++;
                        findValue=tillr;
                    }
                    if (args[j].equals("-i")){
                        String tilli="";
                        for (int k = i+1; k <j; k++) {
                            tilli+=args[j];
                        }
                        j++;
                        findValue=tilli;
                    }
                }
            }
            if (args[i].equals("-r")){
                int j=i+2;
                while (j<args.length){
                    if (args[j].equals("-o")){
                        String tillo="";
                        for (int k = i+1; k <j; k++) {
                            tillo+=args[j];
                        }
                        j++;
                        replaceValue=tillo;
                    }
                    if (args[j].equals("-f")){
                        String tillf="";
                        for (int k = i+1; k <j; k++) {
                            tillf+=args[j];
                        }
                        j++;
                        replaceValue=tillf;
                    }
                    if (args[j].equals("-i")){
                        String tilli="";
                        for (int k = i+1; k <j; k++) {
                            tilli+=args[j];
                        }
                        j++;
                        replaceValue=tilli;
                    }
                }

            }
        }

        FindReplace findReplace=new FindReplace();
        File inputF=null;
        File outputF=null;
        ArrayList<Integer> indexOfFindValues=null;
        ArrayList<String> arr=null;
        try {
            inputF=new File(inputFile);
            outputF=new File(outputFile);
            indexOfFindValues=findReplace.findValues(findValue,inputF);
            arr=findReplace.fileToArrayList(inputF);
            findReplace.replaceValues(arr, indexOfFindValues,findValue,replaceValue, outputF);
        }catch (Exception e){
            System.exit(0);
        }
    }

    public ArrayList<Integer> findValues(String str, File inputFile) throws Exception{
        //bu methodda istenilen kelimelerin oldugu indexleri tutan arraylist donecek
        ArrayList<Integer> indexOfFindValues=new ArrayList<Integer>();
        ArrayList<String> arr=null;
        try {
            arr=fileToArrayList(inputFile);
        }catch (Exception e){
            System.exit(0);
        }
        ArrayList<String> arananlar=new ArrayList<String>();//olabilecek tum kombinasyonlari buraya ekleyecegim
        String questionMark="?";
        String realFindValue="";
        String theGap="";//for [abc]
        int indexOfquestionMark=0;
        int indexOfparantesis1=0;
        int indexOfparantesis2=0;
        if (str.indexOf('[')!=-1){
            indexOfparantesis1=str.indexOf('[');
            indexOfparantesis2=str.indexOf(']');
            if (str.charAt(indexOfparantesis1-1)!='\\'){
                realFindValue=str.substring(0, indexOfparantesis1-1)+ str.substring(indexOfparantesis2+1);
                theGap=str.substring(indexOfparantesis1+1, indexOfparantesis2);
            }
        }
        if (str.indexOf('?')>-1){

            indexOfquestionMark=str.indexOf('?');
            if (str.charAt(indexOfquestionMark-1)!='\\'){
                for (int j = 0; j < 127 ; j++) {
                    realFindValue=str.substring(0,indexOfquestionMark)+(char)j+str.substring(indexOfquestionMark+2);
                    arananlar.add(realFindValue);
                }
            }
        }
        char[] eklentiler=new  char[theGap.length()];//alternatif butun charlari array haline getiriyorum
        for (int i = 0; i < eklentiler.length; i++) {
            eklentiler[i]=theGap.charAt(i);
        }
        for (int i = 0; i <eklentiler.length ; i++) {//tek tek olabilecek versiyonlari yaratip arananlara ekliyorum
            realFindValue=realFindValue.substring(0, indexOfparantesis1-1)+eklentiler[i]+realFindValue.substring(indexOfparantesis2+1);
            arananlar.add(realFindValue);
        }
        arr.trimToSize();
        arananlar.trimToSize();
        for (int i = 0; i < arr.size(); i++) {
            for (int j = 0; j < arananlar.size(); j++) {
                if (arr.get(i).equals(arr.get(j))){
                    indexOfFindValues.add(i);
                }
            }
        }
        indexOfFindValues.trimToSize();

        return indexOfFindValues;
    }

    public void replaceValues(ArrayList<String> arr,ArrayList<Integer> indexOfFindValues,String find,String replaceStr, File outputFile){
        //ArrayList<String> arr=all words
        //ArrayList<Integer> indexOfFindValues=hangi kelimelerde find values varsa onlarin indexleri
        //String find=bulunmasi istenen
        //String replaceStr=replace values
        FileWriter writer;
        try {
            writer=new FileWriter(outputFile);
            int temp=0;
            while (temp<arr.size()){
                if (indexOfFindValues.indexOf(temp)>-1){//eger guncel temp degeri indexOFFindValuesDa var ise o kelimeye islem uygulanir
                    String old=arr.get(indexOfFindValues.get(temp));//ilk once kelimeyi aliriz
                    int indexOfold=arr.indexOf(old);
                    old.replaceAll(find, replaceStr);
                    arr.set(indexOfold,old);
                }

                writer.write(arr.get(temp));
                temp++;
            }
        }catch (Exception e){
            System.exit(0);
        }

    }

    private ArrayList<String> fileToArrayList(File inputFile) throws Exception{
        ArrayList<String> arr=new ArrayList<>();
        Scanner reader;
        try {
            reader=new Scanner(inputFile);
            while (reader.hasNextLine()){
                String str=reader.nextLine();
                ArrayList<Integer> indexArrayList=new ArrayList<Integer>();
                int counter=0;
                for (int i = 0; i < str.length(); i++) {//line icindeki bosluk indexlerini arrayliste atiyorum
                    if (str.charAt(i)==' '){
                        indexArrayList.add(i);
                        counter++;
                    }

                }
                int temp=0;
                int j=0;
                while (temp<str.length()){//ilk string icindeki her kelimeyi arr arraylistine atiyorum
                    arr.add(str.substring(temp,indexArrayList.get(j)));
                    temp=indexArrayList.get(j);
                    j++;
                }
            }
        }catch (Exception e){
            System.exit(0);
        }

        return null;
    }

}