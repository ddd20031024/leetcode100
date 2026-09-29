package TwoPointers;

import static java.lang.Integer.max;

public class Trap
{
    public int trap(int []height){
        int right = height.length -1;
        int left =0;
        int leftMax=height[0];
        int rightMax=height[right];
        int ans=0;
        /*
        思路就是利用相对高度差，因为左边当左边最高的地方低于右边最高的地方，且最高的地方高于
        当前指针指向的地方，那么一定会有个高度差，且为leftmax-当前节点高度;右边同理
         */
        while(left<right){
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);
            if(rightMax>leftMax){
                ans = ans + (leftMax-height[left]);
                left++;
            }else{
                ans= ans + (rightMax-height[right]);
                right--;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
       int []height = {0,1,0,2,1,0,1,3,2,1,2,1};
       Trap trap = new Trap();
        int ans = trap.trap(height);
        System.out.println(ans);
    }
}
