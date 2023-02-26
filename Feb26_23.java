//https://classroom.pepcoding.com/myClassroom/the-switch-program-3/arrays-&-strings-level-2/sort_array_by_parity/ojquestion
public static void sortArrayByParity(int[] nums) {
        // write your code here
        int i = 0;//first unsolved
        int j = 0;//first odd
        
        while(i<nums.length){
            if(nums[i]%2==0){
                //even -> swap -> i++, j++
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
                j++;
            }else{
                //odd -> i++
                i++;
            }
        }
        
    }

//https://leetcode.com/problems/sort-array-by-parity-ii/
class Solution {
    public int[] sortArrayByParityII(int[] nums) {
        int i=0;
        int j=1;
        while(i<nums.length)
             if(nums[i]%2!=0 && nums[j]%2!=1){
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i=i+2;
                j=j+2;
            }
            else if(nums[i]%2==0){
                i+=2;
            }
           else{
               j+=2;
           }
        
        return nums;
    }
}
//https://leetcode.com/problems/sort-array-by-increasing-frequency/
class Solution {
    
    public int[] frequencySort(int[] nums) {
        
      Map<Integer,Integer> map = new HashMap<>();
      //iterates through the nums array
      Arrays.stream(nums).forEach(el -> map.put(el,map.getOrDefault(el,0)+1));
      //
      return Arrays.stream(nums).boxed()
      .sorted((a,b) -> map.get(a)!=map.get(b) ? map.get(a)-map.get(b) : b - a )
      .mapToInt(n->n)
      .toArray();
// custom sort explanation:
// .stream(nums)
// iterates through the nums array

// .boxed()
// converts each int to Integer object, this is because .sorted() can only operate on objects

// .sorted((a,b) -> map.get(a) != map.get(b) ? map.get(a) - map.get(b) : b - a)
// if frequency of two numbers are not the same, sort by ascending frequency. If frequencies are the same, sort by decending numeric value

// .mapToInt(n -> n)
// converts Integer to int

// .toArray()
// returns array
    }
}

//https://classroom.pepcoding.com/myClassroom/the-switch-program-3/arrays-&-strings-level-2/maximum-swap/ojquestion
 public static void swap(char[] arr,int i, int j){
      char temp = arr[i];
      arr[i] = arr[j];
      arr[j] = temp;
  }
  
  public static String maximumSwap(String num) {
    // write your code here
    char[] arr = num.toCharArray();
    
    //1. Prepare last index of digit
    int[] li = new int[10];
    for(int i=0;i<arr.length;i++){
        int digit = arr[i] - '0';
        li[digit] = i; 
    }
    //2. figure out position for swapping
    boolean flag = false;
    for(int i=0;i<arr.length;i++){
        int digit = arr[i]-'0';
        for(int j=9;j>digit;j--){
            if(i < li[j]){
                //swapping and break;
                swap(arr,i,li[j]);
                flag = true;
                break;
            }
        }
        if(flag == true){
            break;
        }
    }
    //3. prepare answer in form of string
    String res = "";
    for(int i=0;i<arr.length;i++){
        res += arr[i];
    }
    return res;
  }
