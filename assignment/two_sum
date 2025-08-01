import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();
        int[] a = new int[n];
        System.out.print("Enter elements: ");
        for (int i = 0; i < n; i++)
            a[i] = sc.nextInt();
        System.out.print("Enter target: ");
        int t = sc.nextInt();
        Solution s = new Solution();
        int[] res = s.twoSum(a, t);
        if (res != null)
            System.out.println("Indices: " + res[0] + ", " + res[1]);
        else
            System.out.println("No valid pair found.");
    }
}

class Solution {
    public int[] twoSum(int[] a, int t) {
        Map<Integer, Integer> m = new HashMap<>();
        for (int i = 0; i < a.length; i++) {
            int x = t - a[i];
            if (m.containsKey(x))
                return new int[] { m.get(x), i };
            m.put(a[i], i);
        }
        return null;
    }
}
