//https://classroom.pepcoding.com/myClassroom/the-switch-program-3/arrays-&-strings-level-2/range_addition/ojquestion
import java.util.*;

public class Main {
    // ~~~~~~~~~~~~~~~~~~~~~User Section~~~~~~~~~~~~~~~~~~~~~
    public static int[] getModifiedArray(int length, int[][] queries) {
        //Time complexity -> O(q) + O(n) => O(n),if n>>>>q or O(q), if q>>>>n 
        // write your code here
        int[] res = new int[length];
        
        //provide impact to res
        for(int q=0;q<queries.length;q++){
            int st = queries[q][0];
            int end = queries[q][1];
            int inc = queries[q][2];
            res[st] += inc;
            if(end+1<length){
                res[end+1] -= inc;
            }
        }
        
        int sum = 0;
        //prefix sum
        for(int i=0;i<length;i++){
            sum += res[i];
            res[i] = sum;
        }
        
        return res;
        
    }

    // ~~~~~~~~~~~~~~~~~~~Input Management~~~~~~~~~~~~~~~~~~~

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        
        int length = scn.nextInt();

        int nq = scn.nextInt();
        
        int[][] queries = new int[nq][3];

        for(int q = 0; q < nq; q++) {
            queries[q][0] = scn.nextInt();
            queries[q][1] = scn.nextInt();
            queries[q][2] = scn.nextInt();
        }


        int[] res = getModifiedArray(length, queries);

        for(int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
    }
}              

//https://classroom.pepcoding.com/myClassroom/the-switch-program-3/arrays-&-strings-level-2/best-meeting-point/ojquestion
import java.util.*;

public class Main {
    // ~~~~~~~~~~~~~~~~~User Section~~~~~~~~~~~~~~~~
    public static int minTotalDistance(int[][] grid) {
        // Write your code here
//Steps :-
//1. Get x-coordinate -> row wise travel -> guaranteed sorted
ArrayList<Integer> xcord = new ArrayList<>();
        for(int r=0;r<grid.length;r++){
            for(int c=0;c<grid[0].length;c++){
                if(grid[r][c]==1){
                    xcord.add(r);
                }
            }
        }
//2. Get y-coordinate -> column wise travel -> guaranteed sorted
ArrayList<Integer> ycord = new ArrayList<>();
        for(int c=0;c<grid[0].length;c++){
            for(int r=0;r<grid.length;r++){
                if(grid[r][c]==1){
                    ycord.add(c);
                }
            }
        }
//3. Get mid of x and y -> Best meeting point
int x = xcord.get(xcord.size() / 2);
int y = ycord.get(ycord.size() / 2);
//4. Calculate distance -> min distance(because of median)
int dist = 0;
for(int xval:xcord){
    dist += Math.abs(x-xval);
}

for(int yval:ycord){
    dist += Math.abs(y-yval);
}
//5. Return answer
        return dist;
    }

    // ~~~~~~~~~~~~~~~Input Management~~~~~~~~~~~~~~
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();


        int[][] grid = new int[n][m];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                grid[i][j] = scn.nextInt();
            }
        }

        int dist = minTotalDistance(grid);
        System.out.println(dist);
    }
}

//https://leetcode.com/problems/range-addition-ii/
class Solution {

    public int maxCount(int m, int n, int[][] ops) {
        if(ops.length==0){
            return m*n;
        }
        int[] intersect = new int[]{Integer.MAX_VALUE,Integer.MAX_VALUE};

        for(int i=0;i<ops.length;i++){
               intersect[0] = Math.min(intersect[0],ops[i][0]);//1
                intersect[1] = Math.min(intersect[1],ops[i][1]);//2
        }
   return intersect[0]*intersect[1];
    }
}

//https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/editorial/
class Solution {
    // Check whether the packages can be shipped in less than "days" days with
    // "c" capacity.
    Boolean feasible(int[] weights, int c, int days) {
        int daysNeeded = 1, currentLoad = 0;
        for (int weight : weights) {
            currentLoad += weight;
            if (currentLoad > c) {
                daysNeeded++;
                currentLoad = weight;
            }
        }

        return daysNeeded <= days;
    }

    public int shipWithinDays(int[] weights, int days) {
        int totalLoad = 0, maxLoad = 0;
        for (int weight : weights) {
            totalLoad += weight;
            maxLoad = Math.max(maxLoad, weight);
        }

        int l = maxLoad, r = totalLoad;

        while (l < r) {
            int mid = (l + r) / 2;
            if (feasible(weights, mid, days)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
}

