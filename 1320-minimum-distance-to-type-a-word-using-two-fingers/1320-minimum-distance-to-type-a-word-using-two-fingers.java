class Solution {
    int d(int a,int b){
        if(a==-1||b==-1) return 0;
        int x1=a/6,y1=a%6,x2=b/6,y2=b%6;
        return Math.abs(x1-x2)+Math.abs(y1-y2);
    }

    public int minimumDistance(String w) {
        int[][] dp=new int[27][27];
        for(int i=0;i<27;i++)
            for(int j=0;j<27;j++)
                dp[i][j]=1000000;

        dp[26][26]=0;

        for(char c:w.toCharArray()){
            int cur=c-'A';
            int[][] ndp=new int[27][27];
            for(int i=0;i<27;i++)
                for(int j=0;j<27;j++)
                    ndp[i][j]=1000000;

            for(int i=0;i<27;i++){
                for(int j=0;j<27;j++){
                    int val=dp[i][j];
                    if(val==1000000) continue;

                    ndp[cur][j]=Math.min(ndp[cur][j],val+d(i==26?-1:i,cur));
                    ndp[i][cur]=Math.min(ndp[i][cur],val+d(j==26?-1:j,cur));
                }
            }
            dp=ndp;
        }

        int res=1000000;
        for(int i=0;i<27;i++)
            for(int j=0;j<27;j++)
                res=Math.min(res,dp[i][j]);

        return res;
    }
}