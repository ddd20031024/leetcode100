package substring;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MaxSlidingWindow {
    public int[]maxSlidingWindow(int[] nums, int k){
        int n = nums.length;
        if(n==0){
            return null;
        }
        /*
        返回负数：a 排在 b 前面
        返回 0：a 和 b 顺序相等
        返回正数：a 排在 b 后面
         */
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] pair1, int[] pair2) {
                return pair1[0]!=pair2[0]?pair2[0]-pair1[0]:pair2[1]-pair1[1];
            }
        });
        for(int i=0;i<k;i++){
            pq.offer(new int[]{nums[i],i});
        }
        int[] ans = new int[n-k+1];
        ans[0] = pq.peek()[0];
        for(int i=k;i<n;i++){
            pq.offer(new int[]{nums[i],i});
            while(pq.peek()[1]<=i-k){
                pq.poll();
            }
            ans[i-k+1] = pq.peek()[0];
        }
        return ans;
    }
    public static void main(String[] args) {
       int[] nums = {1,3,-1,-3,5,3,6,7};
       MaxSlidingWindow maxSlidingWindow = new MaxSlidingWindow();
        int[] ans = maxSlidingWindow.maxSlidingWindow(nums, 3);
        System.out.println(Arrays.toString(ans));
    }
}
