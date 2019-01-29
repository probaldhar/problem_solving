package projects;

public class minimumInRotatedSortedArray {

	public int findMin(int[] nums) {
        return findMinHelper(nums, 0, nums.length - 1);
    }
    
    public int findMinHelper(int arr[], int low, int high) 
    { 
        // array is not rotated at all 
        if ( high < low )
            return arr[0]; 
  
        // only one element left 
        if ( high == low ) 
            return arr[low]; 
  
        // Find mid 
        int mid = (low + high) / 2;
  
        // Check if element (mid+1) is minimum element.
        if ( mid < high && arr[mid+1] < arr[mid] ) 
            return arr[mid+1]; 
  
        // Check if mid itself is minimum element 
        if ( mid > low && arr[mid] < arr[mid - 1] ) 
            return arr[mid]; 
  
        // go left half or right half 
        if ( arr[high] > arr[mid] ) 
            return findMinHelper(arr, low, mid-1); // go left
        
        // go right
        return findMinHelper(arr, mid+1, high); 
    }
	
}
