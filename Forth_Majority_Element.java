/*
0 1 2 3 4 5 6 7 8 9 10 11
1,1,1,1,3,4,5,6,7,8 9  9
*/
public class Forth_Majority_Element.java {
    //Driver method
    public static void main(String[] args) throws IllegalArgumentException {
        System.out.println("Your answer:" + new Forth_Majority_Element.java().findMajority(new int[]{1, 1, 1, 2, 3}) + "\t");
        System.out.println("Correct ans: 1");
        try {
            System.out.print("Your answer: " + new Forth_Majority_Element.java().findMajority(new int[]{}) + " ");
        } catch (Exception e) {
            System.out.println("Correct: Not Found");
        } finally {
            System.out.print("Your answer: " + new Forth_Majority_Element.java().findMajority(new int[]{1, 2, 3}) + "\t");
            System.out.println("Correct ans: 1");
            System.out.print("Your answer: " + new Forth_Majority_Element.java().findMajority(new int[]{2, 5, 5, 6, 8, 10}) + "\t");
            System.out.println("Correct ans: 5");
            System.out.print("Your answer: " + new Forth_Majority_Element.java().findMajority(new int[]{5, 7, 8, 8, 8, 9, 9, 9}) + "\t");
            System.out.println("Correct ans: 8");
            System.out.print("Your answer: " + new Forth_Majority_Element.java().findMajority(new int[]{1, 3, 5, 5, 5, 6, 7, 7, 7, 7, 10, 10, 10, 10, 13}) + "\t");
            System.out.println("Correct ans: 7");
            //Followig test case is not found throws Exception
            //System.out.print("Your answer: " + new Forth_Majority_Element().findMajority(new int[]{1, 2, 3, 4, 5, 6, 7, 8}) + "\t");
            //System.out.println("Not Found");
            System.out.print("Your answer: " + new Forth_Majority_Element.java().findMajority(new int[]{5, 7, 8, 8, 9, 9, 9, 9, 9, 10, 10, 10}) + "\t");
            System.out.println("Correct ans: 9");
            System.out.print("Your answer: " + new Forth_Majority_Element.java().findMajority(new int[]{5, 5, 5, 5, 7, 8, 8, 9, 9}) + "\t");
            System.out.println("Correct ans: 5");
        }
    }

    public int findMajority(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("Not found");
        }
        if (arr.length <= 4) {
            return arr[0];
        }
        int base = arr.length / 4;
        for (int i = base, j = 0, z = base * 2; i < arr.length; i += base, j += base, z += base) {
            if (firstBinarySearch(arr, j, i, i) + lastBinarySearch(arr, i, z - 1, i) + 1 > base) {
                return arr[i];
            }
        }
        throw new IllegalArgumentException("Not found");
    }

    private int firstBinarySearch(int[] arr, int start, int end, int original) {
        if (arr[start] == arr[original]) return original - start;
        int result = -1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == arr[original]) {
                end = mid - 1;
                result = mid;
            } else start = mid + 1;
        }
        return original - result;
    }

    private int lastBinarySearch(int[] arr, int start, int end, int original) {
        if (arr[end] == arr[original]) return end - original;
        int result = -1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == arr[original]) {
                start = mid + 1;
                result = mid;
            } else end = mid - 1;
        }
        return result - original;
    }
}
