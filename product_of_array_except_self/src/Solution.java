public class Solution {

  public int[] productExceptSelf(int[] nums) {
    var result = new int[nums.length];

    int roll = 1;
    for (int i = 0; i < nums.length; i++) {
      result[i] = roll;
      roll = roll * nums[i];
    }

    roll = 1;
    for (int i = nums.length-1; i >= 0; i--) {
      result[i] = roll * result[i];
      roll = roll * nums[i];
    }
    return result;
  }
}
