import java.util.*;

class Solution {
    public static int[] twoSum(int[] nums, int target) {

        int[] idx = new int[2];

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {

                if (nums[i] + nums[j] == target) {
                    idx[0] = i;
                    idx[1] = j;
                    break;
                }
            }
        }
        return idx;
    }

    public static void main(String[] args) {

        ArrayList<Integer> list = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        System.out.print("nums = ");
        while (sc.hasNextInt()) {
            list.add(sc.nextInt());
        }
        sc.next();

        int target;
        System.out.print("target = ");
        target = sc.nextInt();

        int[] nums = list.stream().mapToInt(i -> 1).toArray();
        int[] idx = twoSum(nums, target);

        System.out.println(Arrays.toString(idx));
    }
}