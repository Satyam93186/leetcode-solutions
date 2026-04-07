class Robot {
    int w,h,x,y,d,p;
    String[] ds={"East","North","West","South"};

    public Robot(int width,int height){
        w=width;
        h=height;
        x=0;
        y=0;
        d=0;
        p=2*(w+h)-4;
    }

    public void step(int num){
        num%=p;
        if(num==0 && x==0 && y==0){
            d=3;
            return;
        }

        while(num-- > 0){
            if(d==0){
                if(x+1<w) x++;
                else{
                    d=1;
                    y++;
                }
            }
            else if(d==1){
                if(y+1<h) y++;
                else{
                    d=2;
                    x--;
                }
            }
            else if(d==2){
                if(x-1>=0) x--;
                else{
                    d=3;
                    y--;
                }
            }
            else{
                if(y-1>=0) y--;
                else{
                    d=0;
                    x++;
                }
            }
        }
    }

    public int[] getPos(){
        return new int[]{x,y};
    }

    public String getDir(){
        return ds[d];
    }
}