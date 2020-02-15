package shape;

public abstract class Shape {
    private static final String DEFAULT_COLOR = "black";
    private String color;
    public String name;


    public abstract void draw();

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }


}
