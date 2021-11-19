abstract class Inner {
    // This method should add up the given parameters print it once then return the
    // sum.
    public abstract int printAndReturnSum(int a, int b);

    // This method calculates square of a and then prints the result.
    public abstract void printSquared(int a);

    // This method should capitalize the first character of every word then return
    // the result.
    public abstract String returnProper(String ss);

    // This method should return the string given as input in reverse.
    public abstract void printInReverse(String s);
}

public class Tangible {
    public static void main(String[] args) {
        /*
         * Write your code here and only here. You cannot add any method or classes
         * anywhere else.
         */
        class InnerClass extends Inner{

            @Override
            public int printAndReturnSum(int a, int b) {
                System.out.println(a+b);
                return a+b;
            }

            @Override
            public void printSquared(int a) {
                System.out.println(a*a);
            }

            @Override
            public String returnProper(String ss) {
                String str="";

                char first=ss.charAt(0);
                if (first>=97 && first<=122)
                {
                    first=(char)(first-32);
                }
                str+=first;
                for (int i = 1; i < ss.length() ; i++) {
                    str+=ss.charAt(i);
                    if (ss.charAt(i)==' '){
                        char upper=ss.charAt(i+1);
                        if (upper>=97 && upper<=122)
                            upper=(char)(upper-32);
                        str+=upper;
                        i++;
                    }
                }
                System.out.println(str);
                return str;
            }

            @Override
            public void printInReverse(String s) {
                String str="";
                for (int i = s.length()-1; i >=0 ; i--) {
                    str+=s.charAt(i);
                }
                System.out.println(str);
            }
        }
        InnerClass obj=new InnerClass();
        int sum = obj.printAndReturnSum(12, 85);
        obj.printSquared(sum);
        String proper = obj.returnProper("Lorem ipsum dolor sit amet, consectetur adipiscing elit");
        obj.printInReverse(proper);
    }
}
