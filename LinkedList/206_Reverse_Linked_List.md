[206. Reverse Linked List](https://leetcode.com/problems/reverse-linked-list/)

# Intuition and approach
1. This is simple program where we have to reverse the linked list.We use two approaches to solve this problem.
2. First approach is by creating a new linkedlist and adding every element from given linked list to first of the newly created list.
3. Second approach is just having a previous node and pointing every node to the previous while itearting the element.This takes less memory.

# Complexity

- Time complexity : O(n)
- Space complexity : O(1)

# Code
```
class Solution {
    public ListNode reverseList(ListNode head) {
        //The below approach takes a new list memory
        // ListNode res = null;
        // ListNode currentNode = head;
        // while(currentNode!=null){
        //     ListNode temp = new ListNode(currentNode.val);
        //     temp.next = res;
        //     res = temp;
        //     currentNode = currentNode.next;
        // }
        // return res;

        ListNode prev = null;
        ListNode current = head;
        while(current!=null){
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
       
    }
}
```

