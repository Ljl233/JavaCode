package order;

public class Father {
    static final int a = 0;
    int i = 10;

    {
        draw();
        System.out.println("father {} draw"+i);

    }

    public Father() {
        i = 2;
        draw();
    }

    void draw() {
//        System.out.println("father draw" + i);
    }
}
