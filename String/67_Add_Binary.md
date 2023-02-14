[67. Add Binary](https://leetcode.com/problems/add-binary/)

# Intuition and Approach
1. This is a simple where we are given two strings which contain a binary numbers and we have add those two binary numbers and return the result as string.
2. Here we have provided two approaches to solve the problem.  
**Solution-1**    
    In this approach we solve the problem by coding every case that involves in the problem while adding the binary digits 0 and 1.
    For example : 0+0 = 1, 0+1 = 1, 1+1 = 0 and a carry 1 etc.  
**Solution-2**  
    In this approach we solve the problem by understanding the logic that while adding the bits and carry and dividing the addition result by 2 because anyhow in addition of two binary numbers we will only get values 0,1,2,3 atmost.
# Complexity
- Time complexity : O(m+n) where m,n are lengths of given two strings respectively

- Space complexity: O(1)

# Solution-1
```
class Solution {
    public String addBinary(String a, String b) {
        a = new StringBuffer(a).reverse().toString();
        b = new StringBuffer(b).reverse().toString(); 
        if(a.length()>=b.length()){
            return add(a,b);
        }
        else{
            return add(b,a);
        }
    }

    private String add(String a,String b){
            int alen = a.length();
            int blen = b.length();
            String res = "";
            char carry = '0';
            int i=0;
            while(i<blen){
               if(a.charAt(i)=='1'&&b.charAt(i)=='1'){
                   if(carry == '1'){
                       res = res+'1';
                   }
                   else{
                       res = res+'0';
                       carry = '1';
                   }
               } 
               else if(a.charAt(i)=='1'||b.charAt(i)=='1'){
                    if(carry == '1'){
                       res = res+'0';
                   }
                   else{
                       res = res+'1';
                   } 
               }
               else{
                   if(carry == '1'){
                       res = res+'1';
                       carry = '0';
                   }
                   else{
                       res = res+'0';
                   }
               }
               i++;
               System.out.println(res +" " + carry);
            }
            i = blen;

            while(i<alen){
                if(carry == '1'&& a.charAt(i)=='1'){
                    res = res+'0';
                    carry = '1';
                }
                else if(carry == '1' || a.charAt(i)=='1'){
                    res = res + '1';
                    carry = '0';
                }
                else{
                    res = res+a.charAt(i);
                }
                i++;
                System.out.println(res +" "+ carry);
            }
            if(carry == '1') res = res+'1';
            return new StringBuffer(res).reverse().toString();
    }
}
```

# Solution-2
```
public class Solution {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1, j = b.length() -1, carry = 0;
        while (i >= 0 || j >= 0) {
            int sum = carry;
            if (j >= 0) sum += b.charAt(j--) - '0';
            if (i >= 0) sum += a.charAt(i--) - '0';
            sb.append(sum % 2);
            carry = sum / 2;
        }
        if (carry != 0) sb.append(carry);
        return sb.reverse().toString();
    }
}
```