import java.util.Arrays;

public class AQA_Lesson_1 {
    public static void main(String[] args) {

        printThreeWords();

        checkSumSign();

        printColor();

        compareNumbers();

        System.out.println(checkSumInRange(10, 11));

        printNumberSign(-10);

        System.out.println(checkNumberSign(0));

        printStrNumTimes("ggg", 5);

        System.out.println(checkLeapYear(2045));
        //Задача 10
        int[] arr1 = {1, 0, 0, 1, 1, 0, 1};
        for(int i = 0; i < arr1.length; i++) {
            if(arr1[i] == 1)
                arr1[i] = 0;
            else
                arr1[i] = 1;
        }
        System.out.println(Arrays.toString(arr1));

        //Задача 11
        int[] arr2;
        arr2 = new int[100];
        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = i + 1;
        }
        System.out.println(Arrays.toString(arr2));

        //Задача 12
        int[] arr3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < arr3.length; i++) {
            if(arr3[i] < 6) {
                arr3[i] *= 2;
            }
        }
        System.out.println(Arrays.toString(arr3));

        //Задача 13
        int len = 5;
        int[][] array4 = new int[len][len];
        for (int i = 0; i < array4.length; i++) {
            array4[i][i] = 1;
            array4[i][array4.length - 1 - i] = 1;
        }
        for (int i = 0; i < array4.length; i++)
            System.out.println(Arrays.toString(array4[i]));

        int[] arr5 = createArray(5,30);
        System.out.println(Arrays.toString(arr5));
    }
    //Задача 1
    public static void printThreeWords() {
        System.out.println("Orange");
        System.out.println("Banana");
        System.out.println("Apple");
    }
    //Задача 2
    public static void checkSumSign() {
        int a, b;
        a = 10;
        b = -10;
        if(a + b >= 0)
            System.out.println("Сумма положительная");
        else
            System.out.println("Сумма отрицательная");
    }
    //Задача 3
    public static void printColor() {
        int value = 10;
        if(value <= 0)
            System.out.println("Красный");
        else if(value <= 100)
            System.out.println("Желтый");
        else
            System.out.println("Зеленый");
    }
    //Задача 4
    public static void compareNumbers() {
        int a, b;
        a = 10;
        b = 11;
        if(a >= b)
            System.out.println("a >= b");
        else
            System.out.println("a < b");
    }
    //Задача 5
    public static boolean checkSumInRange(int num1, int num2) {
        int sum;
        sum = num1 + num2;
        return sum >= 10 && sum <= 20;
    }
    //Задача 6
    public static void printNumberSign(int num) {
        if(num >= 0)
            System.out.println("Положительное число");
        else
            System.out.println("Отрицательное число");
    }
    //Задача 7
    public static boolean checkNumberSign(int num) {
        return num < 0;
    }
    //Задача 8
    public static void printStrNumTimes(String str, int num) {
        for(int i = 0; i < num; i++) {
            System.out.println(str);
        }
    }
    //Задача 9
    public static boolean checkLeapYear(int year) {
        return (year % 4 == 0) && (((year % 100 == 0) && (year % 400 == 0)) || (year % 100 != 0));
    }
    //Задача 14
    public static int[] createArray(int len, int initialValue) {
        int[] arr;
        arr = new int[len];
        while (len > 0) {
            arr[--len] = initialValue;
        }
        return arr;
    }

}
