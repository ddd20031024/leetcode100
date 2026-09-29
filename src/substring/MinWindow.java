package substring;

public class MinWindow {
    public String minWindow(String s,String t){
        if(s==null||t==null||s.length()<t.length()){
            return "";
        }
        int[] need = new int[128];
        for(char c:t.toCharArray()){
            need[c]++;
        }
        int left=0,right=0;
        //最小字串长度
        int minLength = Integer.MAX_VALUE;
        int needCount = t.length();
        //最小字符串的起始位置
        int start = 0;
        while(right<s.length()){
            char charArray = s.charAt(right);

            if(need[charArray]>0){
                //说明符合
                needCount--;
            }
            //负数表示多余该字符
            need[charArray]--;
            right++;
            //所需字符已全部找到
            while(needCount==0){
                int temp=right -left;
                //更新最短字串
                if(minLength>temp){
                    minLength=temp;
                    start=left;
                }
                char charLeft = s.charAt(left);
                //所需字符加1
                need[charLeft]++;
                if(need[charLeft]>0){
                    //说明所需字符缺少
                    needCount++;
                }
                left++;
           }
        }

        return minLength == Integer.MAX_VALUE ? "" : s.substring(start, start + minLength);
        }

    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        MinWindow minWindow = new MinWindow();
        String ans = minWindow.minWindow(s, t);
        System.out.println(ans);
    }
}


