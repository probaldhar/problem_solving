package projects;

public class binarySearch {
	public int search(int[] nums, int target) {
        return searchHelper(nums, 0, nums.length - 1, target);
    }
    
    public int searchHelper(int arr[], int low, int high, int target) 
    { 
        if ( high < low )
            return -1;
  
        // Find mid 
        int mid = (low + high) / 2;
        
        if ( arr[mid] == target )
            return mid;
  
        // go left half or right half 
        if ( arr[mid] > target) 
            return searchHelper(arr, low, mid-1, target); // go left
        else
            // go right
            return searchHelper(arr, mid+1, high, target); 
    }
}
