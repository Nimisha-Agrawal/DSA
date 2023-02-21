//Leetcode Link :- https://leetcode.com/problems/wiggle-sort-ii/description/Pepcoding Link :- https://classroom.pepcoding.com/myClassroom/the-switch-program-3/arrays-&-strings-level-2/wiggle-sort-2/ojquestion
public class Solution {
public static void wiggleSort2(int[] nums) {
      //1 1 1 4 5 6 -> 1 6 1 5 1 4
    // write your code here
    //Step 1: Sort Array
    Arrays.sort(nums);
    //2Step 2: make an extra array and manage equality in it
    int n = nums.length;
    int[] res = new int[n];
    int i = 1;
    int j = n-1;
    while(i<n){
        res[i] = nums[j];
        i+=2;
        j--;
    }
    i=0;
    while(i<n){
        res[i] = nums[j];
        i+=2;
        j--;
    }
    //3. Step 3: fill input array from res
    for(i=0;i<n;i++){
 //if element is positive that means i+1 is missing in array, otherwise if (i+1) was present , it would have marked (i+1)-1 -> arr[i] as negative
        nums[i] = res[i];
    }
  }
}

public class Solution {
//# Important to revise
//Leetcode Link :- https://leetcode.com/problems/first-missing-positive/description/Pepcoding Link :- https://classroom.pepcoding.com/myClassroom/the-switch-program-3/arrays-&-strings-level-2/first-missing-positive/ojquestion
Solution :- class Solution {
    public int firstMissingPositive(int[] nums) {
         int n= nums.length;
        //step 1: find occurence of 1 and mark out of range element
            boolean one = false;
        for(int i=0;i<n;i++){
            if(nums[i]==1) one = true;
            if(nums[i]<1 || nums[i]>n){
                nums[i]=1;
            }
        }
        if(one==false) return 1;
        //step 2: mark element in array
        for(int i=0;i<n;i++){
            int val = Math.abs(nums[i]);
            int index = val-1;
            nums[index] = -Math.abs(nums[index]);
        }
        //step 3: check first missing positive
        for(int i=0;i<n;i++){
            if(nums[i]>0){
                return i+1;
            }
        }
        return n+1;
    }
}
}