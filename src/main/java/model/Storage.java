package src.main.java.model;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Storage {
    private static Storage instance;
    private List<Information> scoreStorage;

    public Storage() {
        scoreStorage = new ArrayList<>();
        loadFromFile();
    }

    public static Storage getInstance() {
        if (instance == null) {
            instance = new Storage();
        }
        return instance;
    }

    public void addUser(Information user) {
        scoreStorage.add(user);
        saveToFile();
    }

    public List<Information> getScoreStorage() {
        return scoreStorage;
    }

    public void updateUser(Information user) {
        for (int i = 0; i < scoreStorage.size(); i++) {
            if (scoreStorage.get(i).getName().equals(user.getName())) {
                scoreStorage.set(i, user);
                break;
            }
        }
        saveToFile();
    }

    private void saveToFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("storage.dat"))) {
            oos.writeObject(scoreStorage);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadFromFile() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("storage.dat"))) {
            scoreStorage = (List<Information>) ois.readObject();
        } catch (FileNotFoundException e) {
            // 文件不存在，这是正常情况，在第一次运行时会发生
            scoreStorage = new ArrayList<>();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Information getUser(String name) {
        for (Information user : scoreStorage) {
            if (user.getName().equals(name)) {
                return user;
            }
        }
        return null;
    }
    public boolean userExists(String name) {
        for (Information user : this.scoreStorage) {
            if (user.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    public List<Information> rank() {
        this.scoreStorage.sort((a, b) -> {
            int scoreCompare = Long.compare(b.getHighestscore(), a.getHighestscore());
            return scoreCompare != 0 ? scoreCompare : a.getName().compareTo(b.getName());
        });

        if (!this.scoreStorage.isEmpty()) {
            this.scoreStorage.get(0).setRank(1);
        }

        for (int i = 1; i < this.scoreStorage.size(); i++) {
            if (this.scoreStorage.get(i).getHighestscore() == this.scoreStorage.get(i - 1).getHighestscore()) {
                this.scoreStorage.get(i).setRank(this.scoreStorage.get(i - 1).getRank());
            } else {
                this.scoreStorage.get(i).setRank(i + 1);
            }
        }
        return this.scoreStorage;
    }

    public boolean ifGetIn(String name, String password) {
        for (Information user : this.scoreStorage) {
            if (user.getName().equals(name) && user.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    public Information findUser(String username) {
        for (Information user : this.scoreStorage) {
            if (user.getName().equals(username)) {
                return user;
            }
        }
        return null;
    }

}
