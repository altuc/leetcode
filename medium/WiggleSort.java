public class Solution1 {
    public void wiggleSort(int[] nums) {
        if(nums == null || nums.length < 2) {
            return;
        }
        for(int i = 0; i < nums.length - 1; i++) {
            for(int j = i + 1; j < nums.length; j++) {
                if(i % 2 == 0) {
                    if(nums[j] < nums[i]) {
                        int temp = nums[i];
                        nums[i] = nums[j];
                        nums[j] = temp;
                    }
                } else {
                    if(nums[j] > nums[i]) {
                        int temp = nums[i];
                        nums[i] = nums[j];
                        nums[j] = temp;
                    }
                }
            }
        }
    }
}

public class Solution2 {
    public void wiggleSort(int[] nums) {
        if(nums == null || nums.length < 2) {
            return;
        }
        for(int i = 0; i < nums.length - 1; i++) {
            if(i % 2 == 0 && nums[i] > nums[i + 1]) {
                swap(nums, i, i + 1);
            }
            if(i % 2 != 0 && nums[i] < nums[i + 1]) {
                swap(nums, i, i + 1);
            }
        }
    }
    
    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
