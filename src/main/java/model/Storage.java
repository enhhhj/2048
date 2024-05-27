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
                information.setGo(false);
            }
        }
        if(information.getPassword().length()<6){
            information.setRun(false);
        }

        if(information.getGo()==true && information.getRun()==true){
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




}
