import java.util.Scanner;

public class Main {
    static boolean isUpperBoundFound = false, isLowerBoundFound = false;

    static void output(int b) {
        System.out.println(b);
    }
    static int wasFound(){return (!isLowerBoundFound && !isUpperBoundFound) ? 0 : 1;}

    public static int up(int[] array, int length, int value) {
        int result = 0;
        int high = length;
        while (result < high) {
            final int mid = (result + high) / 2;
            if (value >= array[mid]) {
                isUpperBoundFound =(value == array[mid]) ? true : false;
                result = mid + 1;
            } else {
                high = mid;
            }
        }
        return (isUpperBoundFound) ? result-1 : result;
    }

    public static int low(int[] array, int length, int value) {
        int result = 0;
        int high = length;
        if(value<array[0])
            return 0;
        while (result < high) {
            int mid = (result + high) / 2;
            if (value <= array[mid]) {
                isLowerBoundFound =(value == array[mid]) ? true : false ;
                high = mid;
            } else {
                result = mid + 1;
            }
        }
        return (isLowerBoundFound) ? result : result-1;
    }

    static void count(int[] a, int n) {
        int b = 0;
        for (int i = 1; i < n; i++) 
            if (a[i] == a[i - 1]) 
                b++;
        output(n - b);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int setsCounter = scan.nextInt();
        int arraySize, minValue, maxValue, rangesCounter, indexMin, indexMax;
        while (setsCounter > 0) {
            arraySize = scan.nextInt();
            int[] a = new int[arraySize];
            for (int i = 0; i < arraySize; i++) a[i] = scan.nextInt();
            rangesCounter = scan.nextInt();
            for (int i = 0; i < rangesCounter; i++) {
                minValue = scan.nextInt();
                maxValue = scan.nextInt();
                indexMin = low(a, arraySize, minValue);
                indexMax = up(a, arraySize, maxValue);
                if (minValue > maxValue) output(0);
                else if((minValue>a[arraySize-1]&&maxValue>a[arraySize-1])||(minValue<a[0]&&maxValue<a[0]))
                    output(0);
                else if (maxValue == minValue) {
                    if (wasFound()==0) output(0);
                    else output(indexMax - indexMin+1);
                } else {
                    if(isLowerBoundFound && isUpperBoundFound)
                        output(indexMax-indexMin+1);
                    else if(indexMin==0&&minValue<a[0]&& isUpperBoundFound)
                        output(indexMax-indexMin+1);
                    else if(wasFound()==0&&minValue>a[0])
                        output(indexMax-indexMin-1);
                    else
                        output(indexMax-indexMin);

                }
                isLowerBoundFound = isUpperBoundFound = false;
            }
            setsCounter--;
            count(a, arraySize);
        }
    }
}