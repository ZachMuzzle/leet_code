package Easy;

import java.util.Arrays;

public class two_sum {
    
    public static void main(String[] args) {
        two_sum obj = new two_sum();
        int []a = {3,2,4};
        int target = 6;
        // for (int x: obj.targetSum(a, target)) // print array with for loop
        //     System.out.print(x + " ");
        int[]b = obj.targetSum(a, target);
        System.out.println(Arrays.toString(b)); // display string
    }
    // Time complexity O(N). Only visit elements in array only once.
    public int[] targetSum(int []a, int target) {
        int[] copyArray = Arrays.copyOf(a, a.length);
        Arrays.sort(copyArray); // sorts the array
        int left = 0, right = copyArray.length - 1, tempSum; // - 1 b/c arrays start with 0
        int[] indices = new int[2]; // array of size 2
        
        while (left < right) {
            tempSum = copyArray[left] + copyArray[right]; // temp sum to compare later
            System.out.println(copyArray[left]);
            System.out.println(copyArray[right]);

            if(tempSum == target) {
                indices[0] = left;
                indices[1] = right;
                break;
            } // if target return elements

            else if(tempSum > target) right--; //if greater than target decrement from back of array

            else left++; // otherwise increment from front of array
        }

        /* We go through the copy of the list to match the original position which is a and compare it to the copyArray with the index as
        indices[0] and indices[1] */
        for (int i = 0; i < a.length; i++) {
            if (copyArray[indices[0]] == a[i]) {
                indices[0] = i;
                break;
            }
        }

        for (int i = 0; i < a.length; i++) {
            if(copyArray[indices[1]] == a[i]) {
                indices[1] = i;
                break;
            }
        }
        return indices;
    }
}

/* 
//BRUTE FORCE METHOD O(n^2) time complexity
// Has to go through list array multiple times.
public int[] twoSum(int[] nums, int target) {
        int total = 0, i;
        for(i = 0; i < nums.length - 1; i++) {
            for(int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i,j};
                } 
            }
        }
        return new int[]{-1,-1};
    }
} */