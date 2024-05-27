package src.main.java.model;
import java.util.ArrayList;
import java.util.List;

public class Information {

    private String name;
    private String password;
    private long highestscore;
    private long rank;
    private boolean Go;
    private boolean Run;

    private long [][] record;

    private static List<Information> users = new ArrayList<>();


    public  Information(String name, String password){
        this.name = name;
        this.password = password;
        this.highestscore = 0;
        this.rank = 0;
        this.Go=true;
        this.Run=true;
        //每次创建新的账号时 Information player = new Information；
    }
    public static void addUser(Information user) {
        users.add(user);
    }
    public static boolean userExists(String name) {
        for (Information user : users) {
            if (user.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }
    public void setRecord(long [][] record){
        this.record=record;
    }

    public long [][] getRecord(){
        return this.record;
    }


    public void Renovate(long score){
        if(this.highestscore<score){
            this.highestscore=score;
        }

        //每次结束一次游戏（失败结束或者成功结束或者关掉不保存？） player.Renovate 刷新一下最高分

    }

    public void setRank(long rank){
        this.rank=rank;
    }

    public void setGo(boolean go){
        this.Go=go;
    }

    public boolean getGo() {
        return Go;

        //Go如果是true 成功创建 如果是false 创建失败 弹出重名提示
    }

    public void setRun(boolean run){
        this.Run=run;
    }

    public boolean getRun(){
        return this.Run;

        //Run如果是true 成功创建 如果是false 创建失败 弹出密码太短提示
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
