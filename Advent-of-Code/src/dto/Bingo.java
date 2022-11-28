package dto;

public class Bingo {

    private String number;

    private boolean marked;

    public Bingo(String number) {
        this.number = number;
        this.marked = false;
    }

    public String getNumber() {
        return number;
    }

    public boolean isMarked() {
        return this.marked;
    }

    public void setMarked() {
        this.marked = true;
    }

    @Override
    public String toString() {
        return "Bingo{" +
                "number='" + number + '\'' +
                ", marked=" + marked +
                '}';
    }
}
