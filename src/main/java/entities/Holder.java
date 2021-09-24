package entities;

public class Holder {
    private int id;
    private String holderName;

    public Holder(int id, String holderName) {
        this.id = id;
        this.holderName = holderName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHolderName() {
        return holderName;
    }

    public void setHolderName(String holderName) {
        this.holderName = holderName;
    }
}
