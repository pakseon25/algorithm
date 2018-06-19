class ShortestUnsortedContinuousSubarray {
    public int findUnsortedSubarray(int[] nums) {
        if (nums.length < 2) {
            return 0;
        }
        else if (nums.length == 2) {
            if (nums[0] <= nums[1]) {
                return 0;
            }
            else {
                return 2;
            }
        }
        
        int len = nums.length;
        
        int left = -1;
        int right = -1;
        for (int i = 1;i < len;i++) {
            if (nums[i-1] > nums[i]) {
                left = i-1;
                break;
            }
        }
        
        for (int i = len - 2;i >= 0;i--) {
            if (nums[i] > nums[i+1]) {
                right = i+1;
                break;
            }
        }
        
        // System.out.println(left + "," + right);
        if (left == -1 && right == -1) {
            return 0;
        }

        int min = nums[left];
        int max = nums[left];
        for (int i = left;i <= right;i++) {
            if (nums[i] < min) {
                min = nums[i];
            }
            
            if (nums[i] > max) {
                max = nums[i];
            }
        }
        
        // System.out.println("min, max = " + min + ", " + max);
        int leftExt = left;
        for (int i = 0;i < left;i++) {
            if (nums[i] > min) {
                leftExt = i;
                break;
            }
        }
        
        int rightExt = right;
        for (int i = len-1;i > right;i--) {
            if (nums[i] < max) {
                rightExt = i;
                break;
            }
        }
        
        // System.out.println("el, er = " + leftExt + ", " + rightExt);
        
        
        return rightExt - leftExt + 1;
    }
}