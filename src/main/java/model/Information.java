package src.main.java.model;
import java.util.ArrayList;

public class Information {

    private String name;
    private String password;
    private long highestscore;
    private long rank;
    private boolean Go;
    private boolean Run;
    private long [][] record;

    public  Information(String name, String password, int x, int y){
        this.name = name;
        this.password = password;
        this.highestscore = 0;
        this.rank = 0;
        this.Go=false;
        this.Run=false;
        this.record=new long[x][y];
        for(int i=0;i<this.record.length;i++){
            for(int j=0;j<this.record[i].length;j++){
                this.record[i][j]=0;
            }
        }

        //每次创建新的账号时 Information player = new Information；
    }

    public void setRecord(long [][] record){
        for(int i=0;i<this.record.length;i++){
            for(int j=0;j<this.record[i].length;j++){
                this.record[i][j]=record[i][j];
            }
        }

        //保存进度
    }

    public boolean ifrecord(){
        int a=0;
        for(int i=0;i<this.record.length;i++) {
            for (int j = 0; j < this.record[i].length; j++) {
                if(this.record[i][j]==0){
                    a++;
                }
            }
        }
        if(a==this.record.length*this.record[0].length){
            return true;
            //弹出没有记录的提醒框
        }else{
            return false;
        }
    }
    public long [][] getRecord(){
        return this.record;

        //调用记录
    }


    public void Renovate(long score){
        if(this.highestscore<score){
            this.highestscore=score;
        }

        //每次结束一次游戏（失败结束或者成功结束或者关掉不保存？） player.Renovate 刷新一下最高分

    }



    public void setGo(boolean go){
        this.Go=go;

        //判断是否重名
    }

    public boolean getGo() {
        return Go;

        //Go如果是true 成功创建 如果是false 创建失败 弹出重名提示
    }

    public void setRun(boolean run){
        this.Run=run;

        //判断密码长度是否符合
    }

    public boolean getRun(){
        return this.Run;

        //Run如果是true 成功创建 如果是false 创建失败 弹出密码太短提示
    }

    public void setRank(long rank){
        this.rank=rank;
    }

    public long getRank(){
        return this.rank;
    }

    public String getName(){
        return this.name;
    }

    public String getPassword(){
        return this.password;
    }

    public long getHighestscore(){
        return this.highestscore;
    }

}
