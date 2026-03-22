class Solution {
    boolean eq(int[][] a,int[][] b){
        int n=a.length;
        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++)
                if(a[i][j]!=b[i][j]) return false;
        return true;
    }

    void rot(int[][] a){
        int n=a.length;
        for(int i=0;i<n;i++)
            for(int j=i;j<n;j++){
                int t=a[i][j];
                a[i][j]=a[j][i];
                a[j][i]=t;
            }
        for(int i=0;i<n;i++)
            for(int j=0;j<n/2;j++){
                int t=a[i][j];
                a[i][j]=a[i][n-1-j];
                a[i][n-1-j]=t;
            }
    }

    public boolean findRotation(int[][] mat,int[][] target){
        for(int k=0;k<4;k++){
            if(eq(mat,target)) return true;
            rot(mat);
        }
        return false;
    }
}