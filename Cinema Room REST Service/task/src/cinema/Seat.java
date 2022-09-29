package cinema;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Seat {
    public int row;
    public int column;
    public int price;

    public Seat(int row, int column) {
        this.row = row;
        this.column = column;
        this.price = row <= 4 ? 10 : 8;
    }

    public Seat() {
    }

    //    public Seat(@JsonProperty("row") int row, @JsonProperty("column") int column) {
//        this.row = row;
//        this.column = column;
//    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }


    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    @Override
    public String toString() {
        return "Seat{" +
                "row=" + row +
                ", column=" + column +
                ", price=" + price +
                '}';
    }
}
