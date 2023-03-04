[21. Merge Two Sorted Lists](https://leetcode.com/problems/merge-two-sorted-lists/)

# Intuition and approach

1. This problem is merging the two sorted linked lists. We solved this problem by using two approaches.
2. In first approach we use the same algorithm of merging two arrays in merge sort.
3. In Second approach we use the recursive approach of merging the two arrays.

# Complexity

- Time complexity : O(n+m)
- Space complexity : O(n+m)

# Code
```
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        //This approach is same as merging in merge sort algorithm
        if(list1 == null) return list2;
        if(list2 == null) return list1;
        ListNode res = new ListNode(0);
        ListNode curr = res;
        while(list1 !=null && list2 != null){
            if(list1.val <= list2.val){
                curr.next = list1;
                list1 = list1.next;
            }
            else{
                curr.next = list2;
                list2 = list2.next;
            }
            curr = curr.next;
        }  
        if(list1 == null){
            curr.next = list2;
        }
        if(list2 == null){
            curr.next = list1;
        }
        return res.next;

        // this approach is based on recursion
        // if(list1 == null) return list2;
		// if(list2 == null) return list1;
		// if(list1.val < list2.val){
		// 	list1.next = mergeTwoLists(list1.next, list2);
		// 	return list1;
		// } else{
		// 	list2.next = mergeTwoLists(list1, list2.next);
		// 	return list2;
		// }
    }
}
```