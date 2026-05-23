//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package src.main.java.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class GridNumber implements Serializable {
    private static final long serialVersionUID = 1L;
    private final int X_COUNT ;
    private final int Y_COUNT;
    private int[][] numbers;
    private int[][] laststep;
    private int steps;
    private int scores;
    private int lastscore;
    private boolean If;
    static Random random = new Random();
    private int[][] grid;

    private int toolestimate2;
    private int toolchangenumber;
    private int changenumber;
    private ArrayList<Integer> change;
    private int change_x;
    private int change_y;



    public GridNumber(int xCount, int yCount) {
        this.X_COUNT = xCount;
        this.Y_COUNT = yCount;
        this.numbers = new int[this.X_COUNT][this.Y_COUNT];
        this.laststep = new int[this.X_COUNT][this.Y_COUNT];
        this.grid=new int[X_COUNT][Y_COUNT];
        this.initialNumbers();
        this.steps = 0;
    }

    public static GridNumber fromString1(String gameState) {
        GridNumber gridNumber = new GridNumber(4, 4); // 确保正确初始化 grid 数组
        String[] values = gameState.split(",");
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                gridNumber.grid[i][j] = Integer.parseInt(values[i * 4 + j]);
            }
        }
        return gridNumber;
    }

    public static GridNumber fromString2(String gameState) {
        GridNumber gridNumber = new GridNumber(5, 5); // 确保正确初始化 grid 数组
        String[] values = gameState.split(",");
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                gridNumber.grid[i][j] = Integer.parseInt(values[i * 4 + j]);
            }
        }
        return gridNumber;
    }

    public static GridNumber fromString3(String gameState) {
        GridNumber gridNumber = new GridNumber(6, 6); // 确保正确初始化 grid 数组
        String[] values = gameState.split(",");
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                gridNumber.grid[i][j] = Integer.parseInt(values[i * 4 + j]);
            }
        }
        return gridNumber;
    }

    public void initialNumbers() {
        int p;
        int a;
        for(p = 0; p < this.numbers.length; ++p) {
            for(a = 0; a < this.numbers[p].length; ++a) {
                this.numbers[p][a] = 0;
            }
        }

        for(p = 0; p < this.laststep.length; ++p) {
            for(a = 0; a < this.laststep[p].length; ++a) {
                this.laststep[p][a] = 0;
            }
        }

        p = random.nextInt(2) + 2;
        a = random.nextInt(this.numbers.length) + 0;
        int b = random.nextInt(this.numbers[a].length) + 0;
        int c = random.nextInt(2) + 1;
        this.numbers[a][b] = c;

        for(int i = 0; i < p - 1; ++i) {
            while(this.numbers[a][b] != 0) {
                a = random.nextInt(this.numbers.length) + 0;
                b = random.nextInt(this.numbers[a].length) + 0;
            }

            int d = random.nextInt(2) + 1;
            this.numbers[a][b] = d;
        }

        this.If = false;
        this.toolestimate2=0;
        this.toolchangenumber=0;
        this.change = new ArrayList<>();
        this.change_x=0;
        this.change_y=0;
        this.lastscore=0;
    }

    public void moveRight() {
        int kk=0;
        int[][] A = new int[this.X_COUNT][this.Y_COUNT];

        int i;
        int a;
        for(i = 0; i < A.length; ++i) {
            for(a = 0; a < A[i].length; ++a) {
                A[i][a] = this.numbers[i][a];
            }
        }

        for(i = 0; i < this.numbers.length; ++i) {
            int[] newRow = new int[this.numbers[i].length];
            ArrayList<Integer> news = new ArrayList();
            ArrayList<Integer> news1 = new ArrayList();

            int m;
            for(m = 0; m < this.numbers[i].length; ++m) {
                newRow[m] = this.numbers[i][m];
            }

            for(m = this.numbers[i].length - 1; m >= 0; --m) {
                if (newRow[m] != 0) {
                    news.add(newRow[m]);
                }
            }

            int k;
            if (news.size() > 1) {
                m = 0;

                while(true) {
                    if (m >= news.size() - 1) {
                        if ((Integer)news.get(news.size() - 1) != 0) {
                            news1.add((Integer)news.get(news.size() - 1));
                        }
                        break;
                    }

                    if (news.get(m) == news.get(m + 1)) {
                        news1.add(1 + (Integer)news.get(m));
                        if((Integer)news.get(m)==8){
                            this.toolestimate2++;
                            this.toolchangenumber++;
                        }
                        k = 1;

                        for(int s = 0; s < 1 + (Integer)news.get(m); ++s) {
                            k *= 2;
                        }

                        this.scores += k;
                        kk+=k;
                        news.set(m, 0);
                        news.set(m + 1, 0);
                    }

                    if (news.get(m) != news.get(m + 1) && (Integer)news.get(m) != 0) {
                        news1.add((Integer)news.get(m));
                    }

                    ++m;
                }
            }

            if (news.size() == 1) {
                news1.add((Integer)news.get(0));
            }

            m = this.numbers[i].length - news1.size();

            for(k = 0; k < m; ++k) {
                news1.add(0);
            }

            for(k = 0; k < this.numbers[i].length; ++k) {
                this.numbers[i][k] = (Integer)news1.get(this.numbers[i].length - k - 1);
            }
        }

        i = 0;

        int b;
        for(a = 0; a < A.length; ++a) {
            for(b = 0; b < A[a].length; ++b) {
                if (A[a][b] == this.numbers[a][b]) {
                    ++i;
                }
            }
        }

        if (i < this.X_COUNT * this.Y_COUNT) {
            this.If = false;
            ++this.steps;
            this.lastscore=kk;

            for(a = 0; a < this.laststep.length; ++a) {
                for(b = 0; b < this.laststep[a].length; ++b) {
                    this.laststep[a][b] = A[a][b];
                }
            }

            a = random.nextInt(this.numbers.length) + 0;
            b = random.nextInt(this.numbers[a].length) + 0;
            int c;
            if (this.numbers[a][b] == 0) {
                c = random.nextInt(2) + 1;
                this.numbers[a][b] = c;
            } else {
                while(this.numbers[a][b] != 0) {
                    a = random.nextInt(this.numbers.length) + 0;
                    b = random.nextInt(this.numbers[a].length) + 0;
                }

                c = random.nextInt(2) + 1;
                this.numbers[a][b] = c;
            }
        } else {
            this.If = true;
        }

    }

    public void moveLeft() {
        int kk=0;
        int[][] A = new int[this.X_COUNT][this.Y_COUNT];

        int i;
        int a;
        for(i = 0; i < A.length; ++i) {
            for(a = 0; a < A[i].length; ++a) {
                A[i][a] = this.numbers[i][a];
            }
        }

        for(i = 0; i < this.numbers.length; ++i) {
            int[] newRow = new int[this.numbers[i].length];
            ArrayList<Integer> news = new ArrayList();
            ArrayList<Integer> news1 = new ArrayList();

            int m;
            for(m = 0; m < this.numbers[i].length; ++m) {
                newRow[m] = this.numbers[i][m];
            }

            for(m = 0; m < this.numbers[i].length; ++m) {
                if (newRow[m] != 0) {
                    news.add(newRow[m]);
                }
            }

            int k;
            if (news.size() > 1) {
                m = 0;

                while(true) {
                    if (m >= news.size() - 1) {
                        if ((Integer)news.get(news.size() - 1) != 0) {
                            news1.add((Integer)news.get(news.size() - 1));
                        }
                        break;
                    }

                    if (news.get(m) == news.get(m + 1)) {
                        news1.add(1 + (Integer)news.get(m));
                        if((Integer)news.get(m)==8){
                            this.toolestimate2++;
                            this.toolchangenumber++;
                        }
                        k = 1;

                        for(int s = 0; s < 1 + (Integer)news.get(m); ++s) {
                            k *= 2;
                        }

                        this.scores += k;
                        kk+=k;
                        news.set(m, 0);
                        news.set(m + 1, 0);
                    }

                    if (news.get(m) != news.get(m + 1) && (Integer)news.get(m) != 0) {
                        news1.add((Integer)news.get(m));
                    }

                    ++m;
                }
            }

            if (news.size() == 1) {
                news1.add((Integer)news.get(0));
            }

            m = this.numbers[i].length - news1.size();

            for(k = 0; k < m; ++k) {
                news1.add(0);
            }

            for(k = 0; k < this.numbers[i].length; ++k) {
                this.numbers[i][k] = (Integer)news1.get(k);
            }
        }

        i = 0;

        int b;
        for(a = 0; a < A.length; ++a) {
            for(b = 0; b < A[a].length; ++b) {
                if (A[a][b] == this.numbers[a][b]) {
                    ++i;
                }
            }
        }

        if (i < this.X_COUNT * this.Y_COUNT) {
            this.If = false;
            ++this.steps;
            this.lastscore=kk;

            for(a = 0; a < this.laststep.length; ++a) {
                for(b = 0; b < this.laststep[a].length; ++b) {
                    this.laststep[a][b] = A[a][b];
                }
            }

            a = random.nextInt(this.numbers.length) + 0;
            b = random.nextInt(this.numbers[a].length) + 0;
            int c;
            if (this.numbers[a][b] == 0) {
                c = random.nextInt(2) + 1;
                this.numbers[a][b] = c;
            } else {
                while(this.numbers[a][b] != 0) {
                    a = random.nextInt(this.numbers.length) + 0;
                    b = random.nextInt(this.numbers[a].length) + 0;
                }

                c = random.nextInt(2) + 1;
                this.numbers[a][b] = c;
            }
        } else {
            this.If = true;
        }

    }

    public void moveUp() {
        int kk=0;
        int[][] A = new int[this.X_COUNT][this.Y_COUNT];

        int i;
        int a;
        for(i = 0; i < A.length; ++i) {
            for(a = 0; a < A[i].length; ++a) {
                A[i][a] = this.numbers[i][a];
            }
        }

        for(i = 0; i < this.numbers[0].length; ++i) {
            int[] newRow = new int[this.numbers[0].length];
            ArrayList<Integer> news = new ArrayList();
            ArrayList<Integer> news1 = new ArrayList();

            int m;
            for(m = 0; m < this.numbers[0].length; ++m) {
                newRow[m] = this.numbers[m][i];
            }

            for(m = 0; m < this.numbers[0].length; ++m) {
                if (newRow[m] != 0) {
                    news.add(newRow[m]);
                }
            }

            int k;
            if (news.size() > 1) {
                m = 0;

                while(true) {
                    if (m >= news.size() - 1) {
                        if ((Integer)news.get(news.size() - 1) != 0) {
                            news1.add((Integer)news.get(news.size() - 1));
                        }
                        break;
                    }

                    if (news.get(m) == news.get(m + 1)) {
                        news1.add(1 + (Integer)news.get(m));
                        if((Integer)news.get(m)==8){
                            this.toolestimate2++;
                            this.toolchangenumber++;
                        }
                        k = 1;

                        for(int s = 0; s < 1 + (Integer)news.get(m); ++s) {
                            k *= 2;
                        }

                        this.scores += k;
                        kk+=k;
                        news.set(m, 0);
                        news.set(m + 1, 0);
                    }

                    if (news.get(m) != news.get(m + 1) && (Integer)news.get(m) != 0) {
                        news1.add((Integer)news.get(m));
                    }

                    ++m;
                }
            }

            if (news.size() == 1) {
                news1.add((Integer)news.get(0));
            }

            m = this.numbers[i].length - news1.size();

            for(k = 0; k < m; ++k) {
                news1.add(0);
            }

            for(k = 0; k < this.numbers[i].length; ++k) {
                this.numbers[k][i] = (Integer)news1.get(k);
            }
        }

        i = 0;

        int b;
        for(a = 0; a < A.length; ++a) {
            for(b = 0; b < A[a].length; ++b) {
                if (A[a][b] == this.numbers[a][b]) {
                    ++i;
                }
            }
        }

        if (i < this.X_COUNT * this.Y_COUNT) {
            this.If = false;
            ++this.steps;
            this.lastscore=kk;

            for(a = 0; a < this.laststep.length; ++a) {
                for(b = 0; b < this.laststep[a].length; ++b) {
                    this.laststep[a][b] = A[a][b];
                }
            }

            a = random.nextInt(this.numbers.length) + 0;
            b = random.nextInt(this.numbers[a].length) + 0;
            int c;
            if (this.numbers[a][b] == 0) {
                c = random.nextInt(2) + 1;
                this.numbers[a][b] = c;
            } else {
                while(this.numbers[a][b] != 0) {
                    a = random.nextInt(this.numbers.length) + 0;
                    b = random.nextInt(this.numbers[a].length) + 0;
                }

                c = random.nextInt(2) + 1;
                this.numbers[a][b] = c;
            }
        } else {
            this.If = true;
        }

    }

    public void moveDown() {
        int kk=0;
        int[][] A = new int[this.X_COUNT][this.Y_COUNT];

        int i;
        int a;
        for(i = 0; i < A.length; ++i) {
            for(a = 0; a < A[i].length; ++a) {
                A[i][a] = this.numbers[i][a];
            }
        }

        for(i = 0; i < this.numbers.length; ++i) {
            int[] newRow = new int[this.numbers[0].length];
            ArrayList<Integer> news = new ArrayList();
            ArrayList<Integer> news1 = new ArrayList();

            int m;
            for(m = 0; m < this.numbers[0].length; ++m) {
                newRow[m] = this.numbers[m][i];
            }

            for(m = this.numbers[0].length - 1; m >= 0; --m) {
                if (newRow[m] != 0) {
                    news.add(newRow[m]);
                }
            }

            int k;
            if (news.size() > 1) {
                m = 0;

                while(true) {
                    if (m >= news.size() - 1) {
                        if ((Integer)news.get(news.size() - 1) != 0) {
                            news1.add((Integer)news.get(news.size() - 1));
                        }
                        break;
                    }

                    if (news.get(m) == news.get(m + 1)) {
                        news1.add(1 + (Integer)news.get(m));
                        if((Integer)news.get(m)==8){
                            this.toolestimate2++;
                            this.toolchangenumber++;
                        }
                        k = 1;

                        for(int s = 0; s < 1 + (Integer)news.get(m); ++s) {
                            k *= 2;
                        }

                        this.scores += k;
                        kk+=k;
                        news.set(m, 0);
                        news.set(m + 1, 0);
                    }

                    if (news.get(m) != news.get(m + 1) && (Integer)news.get(m) != 0) {
                        news1.add((Integer)news.get(m));
                    }

                    ++m;
                }
            }

            if (news.size() == 1) {
                news1.add((Integer)news.get(0));
            }

            m = this.numbers[0].length - news1.size();

            for(k = 0; k < m; ++k) {
                news1.add(0);
            }

            for(k = 0; k < this.numbers[i].length; ++k) {
                this.numbers[k][i] = (Integer)news1.get(this.numbers[i].length - k - 1);
            }
        }

        i = 0;

        int b;
        for(a = 0; a < A.length; ++a) {
            for(b = 0; b < A[a].length; ++b) {
                if (A[a][b] == this.numbers[a][b]) {
                    ++i;
                }
            }
        }

        if (i < this.X_COUNT * this.Y_COUNT) {
            this.If = false;
            ++this.steps;
            this.lastscore=kk;

            for(a = 0; a < this.laststep.length; ++a) {
                for(b = 0; b < this.laststep[a].length; ++b) {
                    this.laststep[a][b] = A[a][b];
                }
            }

            a = random.nextInt(this.numbers.length) + 0;
            b = random.nextInt(this.numbers[a].length) + 0;
            int c;
            if (this.numbers[a][b] == 0) {
                c = random.nextInt(2) + 1;
                this.numbers[a][b] = c;
            } else {
                while(this.numbers[a][b] != 0) {
                    a = random.nextInt(this.numbers.length) + 0;
                    b = random.nextInt(this.numbers[a].length) + 0;
                }

                c = random.nextInt(2) + 1;
                this.numbers[a][b] = c;
            }
        } else {
            this.If = true;
        }

    }

    public boolean iftoolestimate2(){
        if(toolestimate2==0){
            return true;
            //弹出没有该道具的提醒框
        }else{

            return false;
            //使用了一个道具
        }

    }
public void dis2(){
        for(int i=0;i<this.numbers.length;i++){
            for(int j=0;j<this.numbers[i].length;j++){
                if(this.numbers[i][j]==1){
                    this.numbers[i][j]=0;
                }
            }
        }
        toolestimate2--;
    }

    public boolean iftoolchangenumber() {
        if (toolchangenumber == 0) {
            return true;
            //弹出没有该道具的提醒框
        } else {
            return false;
            //弹出该道具的使用框（输入要改的位置）
        }
    }
    public boolean usetoolchangenumber(int x, int y){
        if(this.numbers[x][y]<=6 && this.numbers[x][y]>=1){
            this.change_x=x;
            this.change_y=y;
            return true;
            //弹出改数字框 change数组
        }else
            return false;
        //弹出该格子不可更改的提醒框
    }

    public void setchangenumber(int a){
        changenumber=a;
    }
    public boolean dotoolchangenumber(){
        if(changenumber!=2 && changenumber!=4 && changenumber!=8 && changenumber!=16 && changenumber!=32 && changenumber!=64){
            return false;
            //弹出不可更改为该数的提醒框
        }
        if(changenumber==this.numbers[change_x][change_y]){
            return false;
            //弹出不可更改为该数的提醒框
        }
        this.numbers[change_x][change_y]=changenumber;
        this.toolchangenumber--;
        return true;
        //成功更改
    }
public void change(){
    this.numbers[change_x][change_y]=changenumber;
    this.toolchangenumber--;
}

    public int getSteps() {
        return this.steps;
    }

    public int getScores() {
        return this.scores;
    }

    public boolean ifMove() {
        return this.If;
    }

    public void Withdraw() {
        for(int i = 0; i < this.numbers.length; ++i) {
            for(int j = 0; j < this.numbers[i].length; ++j) {
                this.numbers[i][j] = this.laststep[i][j];
            }
        }
        this.steps--;
        this.scores-=this.lastscore;


    }

    public boolean ifsuccess() {
        for(int i = 0; i < this.numbers.length; ++i) {
            for(int j = 0; j < this.numbers[i].length; ++j) {
                if (this.numbers[i][j] == 11) {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean iffailure() {
        int a = 0;

        int i;
        int j;
        for(i = 0; i < this.numbers.length; ++i) {
            for(j = 0; j < this.numbers[i].length; ++j) {
                if (this.numbers[i][j] == 0) {
                    return false;
                }
            }
        }

        for(i = 1; i < this.numbers.length - 1; ++i) {
            for(j = 1; j < this.numbers[i].length - 1; ++j) {
                if (this.numbers[i][j] != this.numbers[i - 1][j] && this.numbers[i][j] != this.numbers[i + 1][j] && this.numbers[i][j] != this.numbers[i][j - 1] && this.numbers[i][j] != this.numbers[i][j + 1]) {
                    ++a;
                }
            }
        }

        for(i = 0; i < this.numbers.length - 1; ++i) {
            if (this.numbers[i][0] != this.numbers[i + 1][0]) {
                ++a;
            }
        }

        for(i = 0; i < this.numbers.length - 1; ++i) {
            if (this.numbers[i][this.numbers[i].length - 1] != this.numbers[i + 1][this.numbers[i + 1].length - 1]) {
                ++a;
            }
        }

        for(i = 0; i < this.numbers[0].length - 1; ++i) {
            if (this.numbers[0][i] != this.numbers[0][i + 1]) {
                ++a;
            }
        }

        for(i = 0; i < this.numbers[this.numbers.length - 1].length - 1; ++i) {
            if (this.numbers[this.numbers.length - 1][i] != this.numbers[this.numbers.length - 1][i + 1]) {
                ++a;
            }
        }

        if (a == this.X_COUNT * this.Y_COUNT) {
            return true;
        } else {
            return false;
        }
    }

    public long getNumber(int i, int j) {
        return (long)this.numbers[i][j];
    }

    public void printNumber() {
        int[][] var1 = this.numbers;
        int var2 = var1.length;

        for(int var3 = 0; var3 < var2; ++var3) {
            int[] line = var1[var3];
            System.out.println(Arrays.toString(line));
        }

    }
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                sb.append(grid[i][j]);
                if (i < 3 || j < 3) {
                    sb.append(",");
                }
            }
        }
        return sb.toString();
    }
}
