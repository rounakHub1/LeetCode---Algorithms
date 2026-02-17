import java.util.*;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    public static ListNode deserialize(String data) {
        if (data == null || data.equals("[]") || data.isEmpty()) return null;
    
        String[] parts = data.replace("[", "").replace("]", "").split(",");
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        
        for (String part : parts) {
            curr.next = new ListNode(Integer.parseInt(part.trim()));
            curr = curr.next;
        } return dummy.next;
    }
}
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode curr = dummyHead;
        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {
            int x = (l1 != null) ? l1.val : 0;
            int y = (l2 != null) ? l2.val : 0;
            
            int sum = carry + x + y;
            carry = sum / 10;
            
            curr.next = new ListNode(sum % 10);
            curr = curr.next;

            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        } return dummyHead.next;
    }
}
public class Main {
    public static void main(String[] args) {
    
        Solution sol = new Solution();

        ListNode l1 = ListNode.deserialize("[2,4,3]");
        ListNode l2 = ListNode.deserialize("[5,6,4]");

        ListNode lr = sol.addTwoNumbers(l1, l2);

        ArrayList<Integer> list = new ArrayList<>();
        while (lr != null) {
            list.add(lr.val);
            lr = lr.next;
        }
        int[] sum = list.stream().mapToInt(i -> i).toArray();
        System.out.println("Result Array: " + Arrays.toString(sum));
    }
}