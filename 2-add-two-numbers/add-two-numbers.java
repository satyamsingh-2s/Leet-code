class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode sum = new ListNode();
        ListNode head = sum;
        int carry = 0;

        while(l1 != null || l2 != null){
            int x = (l1!= null) ? l1.val : 0;
            int y = (l2!= null) ? l2.val : 0;

            int add = x+y+carry;
            if(add > 9)
                carry = 1;
            else
                carry = 0;
            sum.next = new ListNode(add%10);
            sum = sum.next;
            if(l1!=null) l1 = l1.next;
            if(l2!= null) l2 = l2.next;
        }
        if(carry > 0) 
            sum.next = new ListNode(carry);

        return head.next;
    }
}