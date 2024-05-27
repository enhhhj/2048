//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package src.main.java.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class GridNumber {
    private final int X_COUNT;
    private final int Y_COUNT;
    private int[][] numbers;
    private int[][] laststep;
    private int steps;
    private int scores;
    private boolean If;
    static Random random = new Random();

    public GridNumber(int xCount, int yCount) {
        this.X_COUNT = xCount;
        this.Y_COUNT = yCount;
        this.numbers = new int[this.X_COUNT][this.Y_COUNT];
        this.laststep = new int[this.X_COUNT][this.Y_COUNT];
        this.initialNumbers();
        this.steps = 0;
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
    }

    public void moveRight() {
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
                        k = 1;

                        for(int s = 0; s < 1 + (Integer)news.get(m); ++s) {
                            k *= 2;
                        }

                        this.scores += k;
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
                        k = 1;

                        for(int s = 0; s < 1 + (Integer)news.get(m); ++s) {
                            k *= 2;
                        }

                        this.scores += k;
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
                        k = 1;

                        for(int s = 0; s < 1 + (Integer)news.get(m); ++s) {
                            k *= 2;
                        }

                        this.scores += k;
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
                        k = 1;

                        for(int s = 0; s < 1 + (Integer)news.get(m); ++s) {
                            k *= 2;
                        }

                        this.scores += k;
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
}
