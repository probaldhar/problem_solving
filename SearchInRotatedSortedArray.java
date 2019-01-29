package projects;

public class SearchInRotatedSortedArray {
	
	public int search(int[] nums, int target) {
        
        if ( nums == null || nums.length == 0 ) 
            return -1;
        
        // search helper
        return searchHelper(nums, target, 0, nums.length - 1);
    }

    public int searchHelper( int[] nums, int target, int low, int high ) {
        // check low & high
        if ( !( low >= 0 && high < nums.length ) ){
            return -1;
        }

        // check boundary case
        if ( low == high ) {
            return nums[low] == target? low : -1;
        } else if ( low > high ){ // left should be always less than right
            return -1;
        }

        // midpoint
        int mid = (low +  high) / 2;
        
        // gotcha!
        if ( nums[mid] == target ) {
            return mid;
        } else if ( nums[low] <= nums[mid] ) {
            // LEFT side is sorted
            if ( target <= nums[mid] && target >= nums[low] ) {
                // target is in the LEFT side of the midpoint
                return searchHelper(nums, target, low, mid - 1);
            } else {
                // target is in the RIGHT side of the midpoint
                return searchHelper(nums, target, mid + 1, high);
            }
        } else {
            // RIGHT side is sorted
            if ( target >= nums[mid] && target <= nums[high] ) {
                // target is in the RIGHT side of the midpoint
                return searchHelper(nums, target, mid + 1, high);
            } else {
                // target is in the LEFT side of the midpoint
                return searchHelper(nums, target, low, mid - 1);
            }
        }
    }
	
}
