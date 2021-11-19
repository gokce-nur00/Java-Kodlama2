import java.util.*;
import java.io.*;
public class University {
    public static void main(String[] args) {
        Scanner keyboard=new Scanner(System.in);
        String input=keyboard.nextLine();
        String num="";
        String name="";
        String department="";
        String grade="";
        if((int)input.charAt(0)-(int)'0'<=9) {//ascii tablosuna gore basamak bilgileri 0 ile 9 arasindaysa rakamdir.
            //bu durumda girilen input bir ID
            num=input;
            Scanner readerName=null;
            Scanner readerDep=null;
            Scanner readerGrade=null;
            try{//classroom.txt
                readerName=new Scanner(new File("Classroom.txt"));
                while (readerName.hasNextLine()){
                    String line=readerName.nextLine();
                    String numPart=line.substring(0, line.indexOf(","));
                    if (numPart.equals(num))//ID var ise
                        name=line.substring(line.indexOf(",")+1);
                    else
                        throw new InvalidSearchException();

                }
                if (name.equals(""))
                    throw new InvalidSearchException();

                readerDep=new Scanner(new File("Departments.txt"));
                while (readerDep.hasNextLine()){
                    String line=readerDep.nextLine();
                    if (line.indexOf(name)!=-1)//name var ise
                        department=line.substring(line.indexOf("-")+1);
                }
                if (department.equals(""))
                    throw new InvalidSearchException();

                readerGrade=new Scanner(new File("Grades.txt"));
                if (readerGrade.hasNextLine()){//one line
                    String allLine=readerGrade.nextLine();
                    if (allLine.indexOf(num)!=-1){//ID bulunuyorsa
                        int endOfindexOfID=allLine.indexOf(num)+num.length();
                        String newLine=allLine.substring(endOfindexOfID);
                        grade=newLine.substring(0, newLine.indexOf(";"));
                    }
                }
                if (grade.equals(""))
                    throw new InvalidSearchException();


            }catch (InvalidSearchException e){
                System.out.println("There are no matching students for the query "+input+"." );
                System.exit(0);
            }
            catch (FileNotFoundException e){
            }
            System.out.println(num+" - "+name+": "+grade.substring(1)+" ("+department+")");
        }
        else if (((input.charAt(0)>='A' && input.charAt(0)<='Z' ) || (input.charAt(0)>='a' && input.charAt(0)<='z' ))&& input.indexOf(" ")!=-1
                && ((input.charAt(input.indexOf(" ")+1)>='A' && input.charAt(input.indexOf(" ")+1)<='Z' ) || (input.charAt(input.indexOf(" ")+1)>='a' && input.charAt(input.indexOf(" ")+1)<='z' ))){
            //ascii tablosuna gore girilen bilgi ad soyaddir
            name=input;
            Scanner readerNum=null;
            Scanner readerDep=null;
            Scanner readerGrade=null;
            try{//classroom.txt
                readerNum=new Scanner(new File("Classroom.txt"));
                while (readerNum.hasNextLine()){
                    String line=readerNum.nextLine();
                    if (line.indexOf(name)!=-1)//name var ise
                        num=line.substring(0, line.indexOf(input)-1);
                }
                if (num.equals(""))
                    throw new InvalidSearchException();

                readerDep=new Scanner(new File("Departments.txt"));
                while (readerDep.hasNextLine()){
                    String line=readerDep.nextLine();
                    if (line.indexOf(name)!=-1)//name var ise
                        department=line.substring(line.indexOf("-")+1);
                }
                if (department.equals(""))
                    throw new InvalidSearchException();

                readerGrade=new Scanner(new File("Grades.txt"));
                if (readerGrade.hasNextLine()){//one line
                    String allLine=readerGrade.nextLine();
                    if (allLine.indexOf(num)!=-1){//ID bulunuyorsa
                        int endOfindexOfID=allLine.indexOf(num)+num.length();
                        String newLine=allLine.substring(endOfindexOfID);
                        grade=newLine.substring(0, newLine.indexOf(";"));
                    }
                }
                if (grade.equals(""))
                    throw new InvalidSearchException();


            }catch (InvalidSearchException e){
                System.out.println("There are no matching students for the query "+input+"." );
                System.exit(0);
            }
            catch (FileNotFoundException e){
            }
            System.out.println(num+" - "+name+": "+grade.substring(1)+" ("+department+")");


        }
        else
        {
            try {
                throw new InvalidSearchException();
            }
            catch (InvalidSearchException e){
                System.out.println("There are no matching students for the query "+input+"." );
                System.exit(0);
            }
        }


    }
    static class InvalidSearchException extends Exception{
        public InvalidSearchException(){
            super();
        }
    }
}
