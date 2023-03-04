package algorithms;

public class SearchMissingElement {
    public static int missingNum(int[] nums) {
        int count = 0;
        int total = 0;
        for (int i = 1; i < 11; i++) {
            count += i;
        }
        for (int el : nums) {
            total += el;
        }
        return count - total;

        /* int[] elements = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int sum = Arrays.stream(elements).sum();
        int sumOther = Arrays.stream(nums).sum();
        return sum - sumOther; */
    }

    public static void main(String[] args) {
        int[] array = new int[] {8, 6, 1, 9, 5, 2, 3, 7, 10};
        System.out.println(missingNum(array));
    }
}

