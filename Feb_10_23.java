//Problem Link :- https://leetcode.com/problems/next-greater-element-iii/description/
//Pepcoding Link :- https://classroom.pepcoding.com/myClassroom/the-switch-program-3/arrays-&-strings-level-2/next-greater-element-iii/ojquestion
  class Solution {
    public int nextGreaterElement(int n) {
        char[] arr = String.valueOf(n).toCharArray();
        
        // Finding the first index which should be swapped
        // Finding a number which is less than it's right value
        // For eg. n = 6537421, so our i will be 2 (arr[2] = 3)
        int i = arr.length - 2;
        while (i >= 0 && arr[i] >= arr[i + 1])
            i--;
        
        // Checking if we have the maximum permutation of our number
        // If we do then next smallest number does not exist
        if (i == -1)
            return -1;
        
        // Finding the second index which should be swapped
        // Finding a number just greater than arr[i]
        // For eg. n = 6537421, so our j will be 5 (arr[j] = 4)
        int j = arr.length - 1;
        while (arr[j] <= arr[i])
            j--;
        
        // Swapping the two indices
        // After swap n becomes 6547321, which is not the final answer. 
        // Though we make an observation that from i + 1 till the end of array is now in descending order 
        swap(arr, i, j);
        
      //concatenate from 0 to i index
        String res = "";
        for(int j=0;j<=i;j++){
            res += arr[j];
        }
        //concatenate from arr.length-1 to i+1 index(reverse order)
        for(int j=arr.length-1;j>i;j--){
            res += arr[j];
        }
        
      long ans = Long.parseLong(res);
        
        // If ans which is long is out of range we return -1
        if (ans > Integer.MAX_VALUE)
            return -1;
        else
            return (int)ans;
    }
    
    public void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    }


//Problem Link :- https://leetcode.com/problems/max-chunks-to-make-sorted-ii/description/
//Pepcoding Link :- https://classroom.pepcoding.com/myClassroom/the-switch-program-3/arrays-&-strings-level-2/max-chunks-to-make-array-sorted-2/ojquestion
class Solution {
    public int maxChunksToSorted(int[] arr) {
       //1. generate right min
       int[] rmin = new int[arr.length+1];
       rmin[arr.length] = Integer.MAX_VALUE;
       for(int i=arr.length-1;i>=0;i--){
           rmin[i] = Math.min(rmin[i+1],arr[i]);
       }
       //2. iterate on array and manage left max as well as count chunks
       int leftMax = Integer.MIN_VALUE;
       int count =0;
       
       for(int i=0;i<arr.length;i++){
           leftMax = Math.max(leftMax,arr[i]);
           if(leftMax <= rmin[i+1]){ 
               count++; //because maximum of the current chunk is before the minimum of the next,hence perfect spot to seggregate.Else if leftMax>rmin[i+1] then that means,current chunk will encompass the array value corresponding to rmin[i+1] too before closing up. 
           }
       }
       return count;
    }
}


//# Important to revise
//Problem Link:- https://leetcode.com/problems/number-of-subarrays-with-bounded-maximum/
//Pepcoding Link :- https://classroom.pepcoding.com/myClassroom/the-switch-program-3/arrays-&-strings-level-2/number-of-subarrays-with-bounded-maximum/ojquestion
class Solution {
    public int numSubarrayBoundedMax(int[] arr, int left, int right) {
    int si=0;
    int ei=0;
    
    int n = arr.length;
    int ans = 0;
    int prevc = 0;
    
    while(ei<n){
       if(left<=arr[ei] && arr[ei]<=right){
           prevc = ei-si+1;
          ans += prevc;
       } else if(arr[ei] < left){
           ans += prevc;
       } else{
           si = ei+1;
           prevc=0;
       }
       ei++;
    }
    return ans;
    }
}


//# Important to revise 
//Pepcoding Link :- https://classroom.pepcoding.com/myClassroom/the-switch-program-3/arrays-&-strings-level-2/wiggle-sort-1/ojquestion
class Solution {
public static void swap(int[] arr,int left, int right){
    int temp = arr[left];
    arr[left] = arr[right];
    arr[right] = temp;
}
  // ~~~~~~~~~~~~~~User Section~~~~~~~~~~~~~~
  public static void wiggleSort(int[] arr) {
    // write your code here
    for(int i=0;i<arr.length-1;i++){
       if(i%2==0){//even index
           if(arr[i]>arr[i+1]){
               swap(arr,i,i+1);
           }
       } 
       else{//odd index
           if(arr[i]<arr[i+1]){
               swap(arr,i,i+1);
           }
       }
    }
  }
}


//# Important to revise
//Problem Link :- https://leetcode.com/problems/reverse-vowels-of-a-string/description/Pepcoding Link :- https://classroom.pepcoding.com/myClassroom/the-switch-program-3/arrays-&-strings-level-2/reverse-vowels-of-a-string/ojquestionSolution :- 
public class Solution {
public static boolean isVowel(char[] arr, int index) {
    char ch = arr[index];
    if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' || ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U') {
      return true;
    }
    return false;
  }

  public static void swap(char[] arr, int left, int right) {
    char temp  = arr[left];
    arr[left] = arr[right];
    arr[right] = temp;
  }
  // ~~~~~~~~~~~~~~User Section~~~~~~~~~~~~
  public static String reverseVowels(String s) {
    // write your code here
    char[] arr = s.toCharArray();

    int left = 0;
    int right = arr.length - 1;

    while (left < right) { //stopping condition -> left >= right
      //left -> vowel
      while (left < right && isVowel(arr, left) == false) {
        left++;
      }
      //right -> vowel
      while (left < right && isVowel(arr, right) == false) {
        right--;
      }

      swap(arr, left, right);
      left++;
      right--;
    }
    String str = "";
    for (char ch : arr) {
      str += ch;
    }
    return str;
  }
}


//# Important to revise
//Problem Link :- https://leetcode.com/problems/product-of-array-except-self/submissions/895600986/
//Pepcoding Link :- https://classroom.pepcoding.com/myClassroom/the-switch-program-3/arrays-&-strings-level-2/product-of-array-except-itself/ojquestion
public class Solution { 
public static int[] productExceptSelf(int[] arr) {
        // write your code here
        //1. right product array
        int [] right = new int[arr.length];
        int prod = 1;
        for(int i=arr.length-1;i>=0;i--){
            prod = prod*arr[i];
            right[i]=prod;
        }
        
        //2. Make result with maintaining of left product
        prod = 1;
        int[] res = new int[arr.length];
        for(int i=0;i<arr.length-1;i++){
            int lp = prod;
            int rp = right[i+1];
            res[i] = lp*rp;
            prod = prod*arr[i];
        }
        res[arr.length-1] = prod;
        return res;
    }

    public static void main(String[] args){

    }
}