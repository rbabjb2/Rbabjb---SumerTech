import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int[] array = new int[100];
        for (int i = 0; i < array.length; i++) {
            array[i] = i;
        }

        for (int i = 0; i < array.length; i++) {
            // System.out.print(array[i] + ", ");
        }

        System.out.println("");
        array = scramble(array);

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + ", ");
        }

        System.out.println("");
        long startTime = System.currentTimeMillis();
        array = quickSort(array, 0, array.length);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + ", ");
        }

        long endTime = System.currentTimeMillis();
        System.out.println("Time took = " + (endTime - startTime));
        array = scramble(array);
        long bubbleStartTime = System.currentTimeMillis();
        array = sort(array);
        long bubbleEndTime = System.currentTimeMillis();
        // System.out.println("Time took = " + (bubbleEndTime - bubbleStartTime));
        // System.out.println();
        if ((bubbleEndTime - bubbleStartTime) < (endTime - startTime)) {
            // System.out.println("Bubble sort is " + ((endTime - startTime) -
            // (bubbleEndTime - bubbleStartTime)) + " milliseconds faster.");
        } else {
            // System.out.println("Insertion sort is " + ((bubbleEndTime - bubbleStartTime)
            // - (endTime - startTime)) + " milliseconds faster.");
        }
    }

    public static int[] sort(int[] array) {
        int temp;
        for (int j = 0; j < array.length; j++) {
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] > array[i + 1]) {
                    temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                }
            }
        }
        return array;

    }

    public static int check(int[] array, int start, int end, int number) {
        int l = (end - start) / 2 + start;
        if (end < start) {
            return -1;
        }
        if (array[l] == number) {
            return l;
        } else if (array[l] < number) {
            return check(array, l + 1, end, number);
        } else if (array[l] > number) {
            return check(array, start, l - 1, number);
        }
        return -1;
    }

    public static int[] scramble(int[] array) {
        Random random = new Random();
        for (int i = array.length - 1; i > 0; i--) {
            int currentNumber = random.nextInt(i);
            int lastNumber = array[i];
            array[i] = array[currentNumber];
            array[currentNumber] = lastNumber;
        }
        return array;
    }

    public static int[] insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            for (int j = i; j > 0 && array[j] < array[j - 1]; j--) {
                int storage = array[j - 1];
                array[j - 1] = array[j];
                array[j] = storage;
            }
        }

        return array;
    }

    public static int[] selectionSort(int[] array) {
        int storage = -1;
        int storageLocation = 0;
        for (int x = 0; x < array.length - 1; x++) {
            for (int i = 0; i < array.length - (x + 1); i++) {
                if (array[i] > array[i + 1]) {
                    if (array[i] > storage) {
                        storage = array[i];
                        storageLocation = i;

                    }
                }
            }
            int temp = array[array.length - (x + 1)];
            array[array.length - (x + 1)] = storage;
            array[storageLocation] = temp;
            storage = -1;
        }
        return array;
    }

    public static int[] mergeSortSplit(int[] array) {
        int[] firstHalf = new int[array.length / 2];
        int size;
        for (int i = 0; i < (array.length / 2); i++) {
            firstHalf[i] = array[i];
        }
        if (array.length % 2 == 1) {
            size = (array.length / 2) + 1;
        } else {
            size = array.length / 2;
        }
        int[] secondHalf = new int[size];
        for (int i = (array.length / 2); i < array.length; i++) {
            secondHalf[i - (array.length / 2)] = array[i];
        }
        if (secondHalf.length > 1) {
            secondHalf = mergeSortSplit(secondHalf);
        }
        if (firstHalf.length > 1) {
            firstHalf = mergeSortSplit(firstHalf);
        }
        array = mergeSort(firstHalf, secondHalf);
        return array;
    }

    public static int[] mergeSort(int[] arrayOne, int[] arrayTwo) {
        int[] finalArray = new int[arrayOne.length + arrayTwo.length];
        int finalPointer = finalArray.length - 1;
        int arr1Pointer = arrayOne.length - 1;
        int arr2Pointer = arrayTwo.length - 1;
        while (finalPointer > -1) {
            if (arr1Pointer == -1) {
                finalArray[finalPointer] = arrayTwo[arr2Pointer];
                arr2Pointer--;
            } else if (arr2Pointer == -1) {
                finalArray[finalPointer] = arrayOne[arr1Pointer];
                arr1Pointer--;
            } else if (arrayOne[arr1Pointer] > arrayTwo[arr2Pointer]) {
                finalArray[finalPointer] = arrayOne[arr1Pointer];
                arr1Pointer--;
            } else if (!(arr2Pointer == -1)) {
                finalArray[finalPointer] = arrayTwo[arr2Pointer];
                arr2Pointer--;
            }
            finalPointer--;
        }
        return finalArray;
    }

    public static int[] bogoSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            if (array[i - 1] > array[i]) {
                array = bogoSort(scramble(array));
            }
        }
        return array;
    }


    public static int[] quickSort(int[] array, int start, int end) {
        if (start >= end) {
            return array; 
        }

        int[] storage = array.clone();
        int smallPos = start;
        int bigPos = end - 1;
        for (int i = start + 1; i < end; i++) {
            if (array[i] < array[start]) {
                storage[smallPos] = array[i];
                smallPos++;
            } else {
                storage[bigPos] = array[i];
                bigPos--;
            }
        }
        storage[smallPos] = array[start];
        if (smallPos > 2) {
            storage = quickSort(storage, start, smallPos);
        } else if (smallPos == 2) {
            if (storage[start] > storage[start + 1]) {
                int temp = storage[start + 1];
                storage[start + 1] = storage[start];
                storage[start] = temp;
            }
        }
        if (bigPos < (end - 3)) {
            storage = quickSort(storage, bigPos + 1, end);
        } else if (bigPos == (end - 3)) {
            if (storage[end - 2] > storage[end - 1]) {
                int temp = storage[end - 2];
                storage[end - 2] = storage[end - 1];
                storage[end - 1] = temp;
            }
        }
        return storage;
    }
}