import java.util.*;
import java.io.*;
public class Deneme {
    public static void main(String[] args) {
        Scanner keyboard=new Scanner(System.in);
        String input=keyboard.nextLine();
        String num="",name="", department="", grade="";
        if ((int)input.charAt(0)-(int)'0'<=9){//ASCII tablosuna gore ilk char rakamlari isaret ediyorsa ID taramasi...
            num=input;
            Scanner readerName;
            try{
                readerName=new Scanner(new File("Classroom.txt"));
                while (readerName.hasNextLine()){
                    String line=readerName.nextLine();
                    String numPart=line.substring(0, line.indexOf(","));//linedan ID cekilir
                    if (num.equals(numPart))//num var ise
                        name=line.substring(line.indexOf(",")+1);//name cekilir
                }
                if (name.equals(""))
                    throw new InvalidSearchException();
            }catch (InvalidSearchException e){
                System.out.println("There are no matching students for the query "+input+"." );
                System.exit(0);
            }
            catch (FileNotFoundException e){}
        }
        else if ((input.charAt(0)>='A' && input.charAt(0)<='Z' )&& input.contains(" ")
                && (input.charAt(input.indexOf(" ")+1)>='A' && input.charAt(input.indexOf(" ")+1)<='Z' )){
            //ascii tablosuna gore girilen bilgi ad soyaddir
            name=input;
            Scanner readerNum;
            try{
                readerNum=new Scanner(new File("Classroom.txt"));
                while (readerNum.hasNextLine()){
                    String line=readerNum.nextLine();
                    String namePart=line.substring(line.indexOf(",")+1);
                    if (name.equals(namePart))//name var ise
                        num=line.substring(0, line.indexOf(","));
                }
                if (num.equals(""))
                    throw new University.InvalidSearchException();
            }catch (University.InvalidSearchException e){
                System.out.println("There are no matching students for the query "+input+"." );
                System.exit(0);
            }
            catch (FileNotFoundException e){}
        }
        else
        {
            try {
                throw new University.InvalidSearchException();
            }
            catch (University.InvalidSearchException e){
                System.out.println("There are no matching students for the query "+input+"." );
                System.exit(0);
            }
        }

        try{
            Scanner readerDep;
            Scanner readerGrade;
            readerDep=new Scanner(new File("Departments.txt"));
            while (readerDep.hasNextLine()){
                String line=readerDep.nextLine();
                if (line.contains(name))//name var ise
                    department=line.substring(line.indexOf("-")+1);
            }
            if (department.equals(""))
                throw new University.InvalidSearchException();

            readerGrade=new Scanner(new File("Grades.txt"));
            if (readerGrade.hasNextLine()){//one line
                String allLine=readerGrade.nextLine();
                if (allLine.contains(num)){//ID bulunuyorsa
                    int endOfindexOfID=allLine.indexOf(num)+num.length()+1;
                    String newLine=allLine.substring(endOfindexOfID);
                    if (newLine.substring(0, newLine.indexOf(";")).length()>2)
                        throw new University.InvalidSearchException();
                    grade=newLine.substring(0, newLine.indexOf(";"));
                }
            }
            if (grade.equals(""))
                throw new University.InvalidSearchException();

        }catch (University.InvalidSearchException e){
            System.out.println("There are no matching students for the query "+input+"." );
            System.exit(0);
        }
        catch (FileNotFoundException e){
        }
        System.out.println(num+" - "+name+": "+grade+" ("+department+")");
    }
    static class InvalidSearchException extends Exception{
        public InvalidSearchException(){
            super();
        }
    }
}
