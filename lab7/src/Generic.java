public class Generic {

/*
Implement your methods here, and only here.
IMPORTANT: You cannot import *any* libraries.
IMPORTANT: There will be a 2 point penalty for *each* method implemented past 4 methods.
*/
    public static <T> void printArray(T[] arr){
        String str="";
        for (int i = 0; i < arr.length; i++) {
            str+=arr[i];
            if (i!=arr.length-1)
                str+=", ";
        }
        System.out.println(str);
    }

    public static <T extends Comparable<T>> T[] sort(T[] arr){
        for (int i = 0; i < arr.length-1; i++){
            for (int j = 0; j < arr.length-i-1; j++){
                if (arr[j].compareTo((T) arr[j+1]) > 0) {
                    T temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        return (T[]) arr;
    }
    public static <T> T findMiddle(T[] arr){
        int middleIndex=0;
        if (arr.length%2==0){
            middleIndex=arr.length/2-1;//if arr.length is even(4), middle index must be 2
        }
        else if (arr.length%2==1){
            middleIndex= arr.length/2;//if arr.length is odd(5), middle index must be 3
        }
        return arr[middleIndex];
    }
    public static <T>String concatenate(T[] arr){
        String str="";
        for (int i = 0; i < arr.length; i++) {
            str+=arr[i];
        }
        return str;
    }

    public static void main(String args[]) {
        Integer[] integerArray = { 18362, 234, -3234, 0, 334655 };
        Double[] doubleArray = { -1.1, 0.0, 34.34534, 987.346};
        String[] stringArray = { "error:", "bad", "operand", "types", "for", "binary", "operator" };

        //printArray prints given array with a comma and a space between each element
        printArray(integerArray);
        printArray(doubleArray);
        printArray(stringArray);

        //sort method sorts the given array in ascending order (you can implement any sorting algorithm)
        Integer[] sortedIntegerArray = sort(integerArray);
        Double[] sortedDoubleArray = sort(doubleArray);
        String[] sortedStringArray= sort(stringArray);

        printArray(sortedIntegerArray);
        printArray(sortedDoubleArray);
        printArray(sortedStringArray);

        //findMiddle finds and returns the middle element of an array. if number of elements in the array is even, print the one with the smallest index.
        System.out.println(findMiddle(sortedIntegerArray));
        System.out.println(findMiddle(sortedDoubleArray));
        System.out.println(findMiddle(sortedStringArray));

        //concatenate method returns a string that has the elements of the array added back to back
        System.out.println(concatenate(sortedIntegerArray));
        System.out.println(concatenate(sortedDoubleArray));
        System.out.println(concatenate(sortedStringArray));
    }
}
