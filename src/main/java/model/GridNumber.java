package src.main.java.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class GridNumber {
    private final int X_COUNT;
    private final int Y_COUNT;

    private long [][] numbers;

    private int steps;

    static Random random = new Random();

    public GridNumber(int xCount, int yCount) {
        this.X_COUNT = xCount;
        this.Y_COUNT = yCount;
        this.numbers = new long[this.X_COUNT][this.Y_COUNT];
        this.initialNumbers();
        this.steps=0;
    }

    public void initialNumbers() {
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers[i].length; j++) {
                this.numbers[i][j]=0;
            }
        }
        int p = random.nextInt(2)+2;
        int a = random.nextInt(numbers.length) + 0;
        int b = random.nextInt(numbers[a].length) + 0;
        int c = random.nextInt(2) + 1;
        if(c==1){
            numbers[a][b] = 2;
        }else{
            numbers[a][b] = 4;
        }
        for(int i=0;i<p-1;i++){
            while(numbers[a][b]!=0){
                a = random.nextInt(numbers.length) + 0;
                b = random.nextInt(numbers[a].length) + 0;
            }
            int d =random.nextInt(2) + 1;
            if(d==1){
                this.numbers[a][b] = 2;
            }else{
                this.numbers[a][b] = 4;
            }
        }
                //todo: update generate numbers method
    }


    //todo: finish the method of four direction moving.
    public void moveRight() {
        long [][] A = new long [this.X_COUNT][this.Y_COUNT];
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[i].length; j++) {
                A[i][j]=this.numbers[i][j];
            }
        }
        for (int i =0; i<numbers.length; i++) {
            long [] newRow = new long[numbers[i].length];
            ArrayList<Long> news = new ArrayList<>();
            ArrayList<Long> news1 = new ArrayList<>();
            for(int m =0; m<numbers[i].length; m++){
                newRow[m]=numbers[i][m];
            }

            for(int u=numbers[i].length-1;u>=0;u--){
            if(newRow[u]!=0){
                news.add(newRow[u]);
            }}

            if(news.size()>1){
                for(int m=0;m<news.size()-1;m++){
                    if(news.get(m)==news.get(m+1)){
                        news1.add(2*news.get(m));
                        long t=0;
                        news.set(m,t);
                        news.set(m+1,t);
                    }
                    if(news.get(m)!=news.get(m+1) && news.get(m)!=0 ) {
                        news1.add(news.get(m));
                    }
                }
                if(news.get(news.size()-1)!=0){
                    news1.add(news.get(news.size()-1));
                }
            }
            if(news.size()==1){
                news1.add(news.get(0));
            }
            int r=numbers[i].length-news1.size();
            for(int c=0;c<r;c++)
            {
                long t = 0;
                news1.add(t);
            }
            for(int n=0;n<numbers[i].length;n++) {
                numbers[i][n]=news1.get(numbers[i].length-n-1);
            }
        }
        int count =0;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[i].length; j++) {
                if(A[i][j]==this.numbers[i][j]){
                    count++;
                }
            }
        }
        if(count<this.X_COUNT*this.Y_COUNT) {
            this.steps++;
            int a = random.nextInt(numbers.length) + 0;
            int b = random.nextInt(numbers[a].length) + 0;
            if(numbers[a][b]==0){
                int c =random.nextInt(2) + 1;
                if(c==1){
                    numbers[a][b] = 2;
                }else{
                    numbers[a][b] = 4;
                }
            }else{
                while(numbers[a][b]!=0){
                    a = random.nextInt(numbers.length) + 0;
                    b = random.nextInt(numbers[a].length) + 0;
                }
                int c =random.nextInt(2) + 1;
                if(c==1){
                    this.numbers[a][b] = 2;
                }else{
                    this.numbers[a][b] = 4;
                }
            }
        }
    }

    public void moveLeft() {
        long [][] A = new long[this.X_COUNT][this.Y_COUNT];
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[i].length; j++) {
                A [i][j]=this.numbers[i][j];
            }
        }
        for (int i =0; i<numbers.length; i++) {
            long[] newRow = new long[numbers[i].length];
            ArrayList<Long> news = new ArrayList<>();
            ArrayList<Long> news1 = new ArrayList<>();
            for(int m =0; m<numbers[i].length; m++){
                newRow[m]=numbers[i][m];
            }

            for(int u=0;u<numbers[i].length;u++){
                if(newRow[u]!=0){
                    news.add(newRow[u]);
                }}

            if(news.size() >1){
                for(int m=0;m<news.size()-1;m++){
                    if(news.get(m)==news.get(m+1)){
                        news1.add(2*news.get(m));
                        long t=0;
                        news.set(m,t);
                        news.set(m+1,t);
                    }
                    if(news.get(m)!=news.get(m+1)&&news.get(m)!=0) {
                        news1.add(news.get(m));
                    }
                }
                if(news.get(news.size()-1)!=0){
                    news1.add(news.get(news.size()-1));
                }
            }
            if(news.size()==1){
                news1.add(news.get(0));
            }


            int r=numbers[i].length-news1.size();
            for(int c=0;c<r;c++)
            {
                long t=0;
                news1.add(t);
            }

            for(int n=0;n<numbers[i].length;n++)
            {numbers[i][n]=news1.get(n);
            }
        }
        int count =0;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[i].length; j++) {
                if(A[i][j]==this.numbers[i][j]){
                    count++;
                }
            }
        }
        if(count<this.X_COUNT*this.Y_COUNT) {
            //steps++;
            int a = random.nextInt(numbers.length) + 0;
            int b = random.nextInt(numbers[a].length) + 0;
            if(numbers[a][b]==0){
                int c =random.nextInt(2) + 1;
                if(c==1){
                    numbers[a][b] = 2;
                }else{
                    numbers[a][b] = 4;
                }
            }else{
                while(numbers[a][b]!=0){
                    a = random.nextInt(numbers.length) + 0;
                    b = random.nextInt(numbers[a].length) + 0;
                }
                int c =random.nextInt(2) + 1;
                if(c==1){
                    numbers[a][b] = 2;
                }else{
                    numbers[a][b] = 4;
                }
            }
        }
    }

    public void moveUp() {
        long [][] A = new long[this.X_COUNT][this.Y_COUNT];
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[i].length; j++) {
                A [i][j]=this.numbers[i][j];
            }
        }
        for (int i =0; i<numbers[0].length; i++) {
            long[] newRow = new long[numbers[0].length];
            ArrayList<Long> news = new ArrayList<>();
            ArrayList<Long> news1 = new ArrayList<>();
            for(int m =0; m<numbers[0].length; m++){
                newRow[m]=numbers[m][i];
            }

            for(int u=0;u<numbers[0].length;u++){
                if(newRow[u]!=0){
                    news.add(newRow[u]);
                }}

            if(news.size() >1) {
                for (int m = 0; m < news.size() - 1; m++) {
                    if (news.get(m) == news.get(m + 1)) {
                        news1.add(2 * news.get(m));
                        long t=0;
                        news.set(m, t);
                        news.set(m + 1, t);
                    }
                    if (news.get(m) != news.get(m + 1) && news.get(m) != 0) {
                        news1.add(news.get(m));
                    }
                }
                if (news.get(news.size() - 1) != 0) {
                    news1.add(news.get(news.size() - 1));
                }
            }
            if(news.size()==1){news1.add(news.get(0));}


            int r=numbers[i].length-news1.size();
            for(int c=0;c<r;c++) {
                long t=0;
                news1.add(t);
            }

            for(int n=0;n<numbers[i].length;n++) {
                numbers[n][i]=news1.get(n);
            }
        }
        int count =0;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[i].length; j++) {
                if(A[i][j]==this.numbers[i][j]){
                    count++;
                }
            }
        }
        if(count<this.X_COUNT*this.Y_COUNT) {
            //steps++;
            int a = random.nextInt(numbers.length) + 0;
            int b = random.nextInt(numbers[a].length) + 0;
            if(numbers[a][b]==0){
                int c =random.nextInt(2) + 1;
                if(c==1){
                    numbers[a][b] = 2;
                }else{
                    numbers[a][b] = 4;
                }
            }else{
                while(numbers[a][b]!=0){
                    a = random.nextInt(numbers.length) + 0;
                    b = random.nextInt(numbers[a].length) + 0;
                }
                int c =random.nextInt(2) + 1;
                if(c==1){
                    numbers[a][b] = 2;
                }else{
                    numbers[a][b] = 4;
                }
            }
        }
    }

    public void moveDown() {
        long [][] A = new long[this.X_COUNT][this.Y_COUNT];
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[i].length; j++) {
                A [i][j]=this.numbers[i][j];
            }
        }
        for (int i =0; i<numbers.length; i++) {
            long[] newRow = new long[numbers[0].length];
            ArrayList<Long> news = new ArrayList<>();
            ArrayList<Long> news1 = new ArrayList<>();
            for(int m =0; m<numbers[0].length; m++){
                newRow[m]=numbers[m][i];
            }

            for(int u=numbers[0].length-1;u>=0;u--){
                if(newRow[u]!=0){
                    news.add(newRow[u]);
                }}

            if(news.size() >1){
                for(int m=0;m<news.size()-1;m++){
                    if(news.get(m)==news.get(m+1)){
                        news1.add(2*news.get(m));
                        long t=0;
                        news.set(m,t);
                        news.set(m+1,t);
                    }
                    if(news.get(m)!=news.get(m+1)&&news.get(m)!=0) {
                        news1.add(news.get(m));
                    }}if(news.get(news.size() - 1) != 0)
                    news1.add(news.get(news.size()-1));
            }
            if(news.size()==1){news1.add(news.get(0));}


            int r=numbers[0].length-news1.size();
            for(int c=0;c<r;c++)
            {
                long t=0;
                news1.add(t);
            }

            for(int n=0;n<numbers[i].length;n++)
            {numbers[n][i]=news1.get(numbers[i].length-n-1);
            }
        }
        int count =0;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[i].length; j++) {
                if(A[i][j]==this.numbers[i][j]){
                    count++;
                }
            }
        }
        if(count<this.X_COUNT*this.Y_COUNT) {
            steps++;
            int a = random.nextInt(numbers.length) + 0;
            int b = random.nextInt(numbers[a].length) + 0;
            if(numbers[a][b]==0){
                int c =random.nextInt(2) + 1;
                if(c==1){
                    numbers[a][b] = 2;
                }else{
                    numbers[a][b] = 4;
                }
            }else{
                while(numbers[a][b]!=0){
                    a = random.nextInt(numbers.length) + 0;
                    b = random.nextInt(numbers[a].length) + 0;
                }
                int c =random.nextInt(2) + 1;
                if(c==1){
                    numbers[a][b] = 2;
                }else{
                    numbers[a][b] = 4;
                }
            }
        }
    }

    public int getSteps(){
        return this.steps;
    }

    public boolean ifsuccess(){
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers[i].length; j++) {
                if(this.numbers[i][j]==2048){
                    return true;
                    //游戏结束 弹出胜利
                }
            }
        }
        return false;
        //游戏继续
    }

    public boolean iffailure(){
        int a =0;
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers[i].length; j++) {
                if (this.numbers[i][j] == 0) {
                    return false;
                }
            }
        }

        for (int i = 1; i < numbers.length-1; i++) {
            for (int j = 1; j < numbers[i].length-1; j++) {
                if(this.numbers[i][j]!=this.numbers[i-1][j] && this.numbers[i][j]!=this.numbers[i+1][j] && this.numbers[i][j]!=this.numbers[i][j-1] && this.numbers[i][j]!=this.numbers[i][j+1]){
                    a++;
                }
            }
        }
        for (int i = 0; i < numbers.length-1; i++) {
            if(this.numbers[i][0]!=this.numbers[i+1][0]){
                a++;
            }
        }
        for (int i = 0; i < numbers.length-1; i++) {
            if(this.numbers[i][this.numbers[i].length-1]!=this.numbers[i+1][this.numbers[i+1].length-1]){
                a++;
            }
        }
        for (int i = 0; i < numbers[0].length-1; i++) {
            if(this.numbers[0][i]!=this.numbers[0][i+1]){
                a++;
            }
        }
        for (int i = 0; i < numbers[this.numbers.length-1].length-1; i++) {
            if(this.numbers[this.numbers.length-1][i]!=this.numbers[this.numbers.length-1][i+1]){
                a++;
            }
        }
        if(a==this.X_COUNT*this.Y_COUNT){
            //游戏结束 弹出失败
            return true;
        }else{
            //游戏继续
            return false;
        }


    }




    public long getNumber(int i, int j) {
        return numbers[i][j];
    }

    public void printNumber() {
        for (long[] line : numbers) {
            System.out.println(Arrays.toString(line));
        }
    }
}
