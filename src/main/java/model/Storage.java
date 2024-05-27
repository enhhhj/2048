package src.main.java.model;
import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;

public class Storage {
    private List<Information> scoreStorage;

    public Storage(){
        this.scoreStorage=new ArrayList<>();
    }

    public void ScoreStorage(Information information){
        int a=0;
        for(int i=0;i<this.scoreStorage.size();i++){
            if(this.scoreStorage.get(i).getName()==information.getName()){
                information.setGo(true);
            }
        }
        if(information.getPassword().length()<6){
            information.setRun(true);
        }

        if(information.getGo()==false && information.getRun()==false){
            this.scoreStorage.add(information);
        }

    }

    public List<Information> Rank(){
        Comparator<Information> zxy = Comparator.comparing(Information::getHighestscore).thenComparing(Information::getName);
        this.scoreStorage.sort(zxy);
        this.scoreStorage.reversed();
        this.scoreStorage.get(0).setRank(1);
        for(int i=1;i<this.scoreStorage.size();i++){
            if(this.scoreStorage.get(i).getHighestscore()==this.scoreStorage.get(i-1).getHighestscore()){
                this.scoreStorage.get(i).setRank(this.scoreStorage.get(i-1).getRank());
            }else{
                this.scoreStorage.get(i).setRank(i+1);
            }
        }
        return this.scoreStorage;

        //每次弹出排行榜是用Rank方法返回所有用户信息（按照排名）
    }

    public boolean ifGetIn(String name, String password){
        for(int i=1;i<this.scoreStorage.size();i++){
            if(this.scoreStorage.get(i).getName()==name && this.scoreStorage.get(i).getPassword()==password){
                return true;
            }
        }
        return false;

        //本方法用来判断是否登录成功
    }

    public Information getInformation(String name){
        for(int i=1;i<this.scoreStorage.size();i++){
            if(this.scoreStorage.get(i).getName()==name){
                return this.scoreStorage.get(i);
            }
        }
        return this.scoreStorage.get(0);

        //若登录成功 用此方法调用该用户
    }




}
