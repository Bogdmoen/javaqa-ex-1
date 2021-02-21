package ru.netology.domain;

public class TShirt extends Product{
    private String colour;
    private String size;

    public TShirt(int id, String name, int price, String colour, String size) {
        super(id, name, price);
        this.colour = colour;
        this.size = size;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }
}
