package model;

/**
 * Created by Serg on 18.09.2017.
 */
public class Loads extends Entity<Integer>{

    private Integer time;
    private String load;

    public Loads() {
    }

    public Loads(Integer time, String load) {
        this.time = time;
        this.load = load;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public String getLoad() {
        return load;
    }

    public void setLoad(String load) {
        this.load = load;
    }

    @Override
    public String toString() {
        return "Loads{" +
                "id=" + super.getId() +
                ", time=" + time +
                ", load=" + load +
                '}';
    }
}
