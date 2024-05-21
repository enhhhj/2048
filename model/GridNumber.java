package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class GridNumber {
    private final int X_COUNT;
    private final int Y_COUNT;

    private int[][] numbers;

    static Random random = new Random();

    public GridNumber(int xCount, int yCount) {
        this.X_COUNT = xCount;
        this.Y_COUNT = yCount;
        this.numbers = new int[this.X_COUNT][this.Y_COUNT];
        this.initialNumbers();
    }

    public void initialNumbers() {
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers[i].length; j++) {
                //todo: update generate numbers method
                numbers[i][j] = random.nextInt(2) == 0 ? 1 : 0;
            }
        }
    }
    //todo: finish the method of four direction moving.
    public void moveRight() {
        for (int i =0; i<numbers.length; i++) {
            int[] newRow = new int[numbers[i].length];
            ArrayList<Integer> news = new ArrayList<>();
            ArrayList<Integer> news1 = new ArrayList<>();
            for(int m =0; m<numbers[i].length; m++){
                newRow[m]=numbers[i][m];
            }

            for(int u=numbers[i].length-1;u>=0;u--){
            if(newRow[u]!=0){
                news.add(newRow[u]);
            }}

            if(news.size() >1){
            for(int m=0;m<news.size()-1;m++){
                if(news.get(m)==news.get(m+1)){
                    news1.add(2*news.get(m));
                    news.set(m,0);
                    news.set(m+1,0);
                }
                if(news.get(m)!=news.get(m+1)&&news.get(m)!=0) {
                    news1.add(news.get(m));
                }}if(news.get(news.size()-1)!=news.get(news.size()-2))
                    news1.add(news.get(news.size()-1));
                                }
            if(news.size()==1){news1.add(news.get(0));}


            int r=numbers[i].length-news1.size();
            for(int c=0;c<r;c++)
            {
                news1.add(0);
            }

            for(int n=0;n<numbers[i].length;n++)
            {numbers[i][n]=news1.get(numbers[i].length-n-1);
          }}}


    public void moveLeft() {
        for (int i =0; i<numbers.length; i++) {
            int[] newRow = new int[numbers[i].length];
            ArrayList<Integer> news = new ArrayList<>();
            ArrayList<Integer> news1 = new ArrayList<>();
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
                        news.set(m,0);
                        news.set(m+1,0);
                    }
                    if(news.get(m)!=news.get(m+1)&&news.get(m)!=0) {
                        news1.add(news.get(m));
                    }}if(news.get(news.size()-1)!=news.get(news.size()-2))
                    news1.add(news.get(news.size()-1));
            }
            if(news.size()==1){news1.add(news.get(0));}


            int r=numbers[i].length-news1.size();
            for(int c=0;c<r;c++)
            {
                news1.add(0);
            }

            for(int n=0;n<numbers[i].length;n++)
            {numbers[i][n]=news1.get(n);
            }}}

    public void moveUp() {
        for (int i =0; i<numbers[0].length; i++) {
            int[] newRow = new int[numbers[0].length];
            ArrayList<Integer> news = new ArrayList<>();
            ArrayList<Integer> news1 = new ArrayList<>();
            for(int m =0; m<numbers[0].length; m++){
                newRow[m]=numbers[m][i];
            }

            for(int u=0;u<numbers[0].length;u++){
                if(newRow[u]!=0){
                    news.add(newRow[u]);
                }}

            if(news.size() >1){
                for(int m=0;m<news.size()-1;m++){
                    if(news.get(m)==news.get(m+1)){
                        news1.add(2*news.get(m));
                        news.set(m,0);
                        news.set(m+1,0);
                    }
                    if(news.get(m)!=news.get(m+1)&&news.get(m)!=0) {
                        news1.add(news.get(m));
                    }}if(news.get(news.size()-1)!=news.get(news.size()-2))
                    news1.add(news.get(news.size()-1));
            }
            if(news.size()==1){news1.add(news.get(0));}


            int r=numbers[i].length-news1.size();
            for(int c=0;c<r;c++)
            {
                news1.add(0);
            }

            for(int n=0;n<numbers[i].length;n++)
            {numbers[n][i]=news1.get(n);
            }}}

    public void moveDown() {
        for (int i =0; i<numbers.length; i++) {
            int[] newRow = new int[numbers[0].length];
            ArrayList<Integer> news = new ArrayList<>();
            ArrayList<Integer> news1 = new ArrayList<>();
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
                        news.set(m,0);
                        news.set(m+1,0);
                    }
                    if(news.get(m)!=news.get(m+1)&&news.get(m)!=0) {
                        news1.add(news.get(m));
                    }}if(news.get(news.size()-1)!=news.get(news.size()-2))
                    news1.add(news.get(news.size()-1));
            }
            if(news.size()==1){news1.add(news.get(0));}


            int r=numbers[0].length-news1.size();
            for(int c=0;c<r;c++)
            {
                news1.add(0);
            }

            for(int n=0;n<numbers[i].length;n++)
            {numbers[n][i]=news1.get(numbers[i].length-n-1);
            }}}











    public int getNumber(int i, int j) {
        return numbers[i][j];
    }

    public void printNumber() {
        for (int[] line : numbers) {
            System.out.println(Arrays.toString(line));
        }
    }
}
