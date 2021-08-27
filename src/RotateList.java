public class RotateList {
    public static void main(String[] args) {
        ListNode head = null;
        int k = 4;
        head = add(0, head);
        head = add(1, head);
        head = add(2, head);

        head = rotateRight(head, k);
        print(head);
    }

    public static ListNode add(int val, ListNode head) {
        if (head == null)
            return new ListNode(val);
        head.next = add(val, head.next);
        return head;
    }

    private static void print(ListNode head) {
        if (head != null) {
            System.out.println(head.val);
            print(head.next);
        }
    }

    public static ListNode rotateRight(ListNode head, int k) {
        int s = 0;
        ListNode end = head, temp = head;
        while (temp != null) {
            s++;
            end = temp;
            temp = temp.next;
        }

        k = k % s;
        k = s - k - 1;
        temp = head;
        while (k-- > 0) {
            temp = temp.next;
        }

        ListNode temp2 = temp.next;
        temp.next = null;
        end.next = head;

        return temp2;
    }
}