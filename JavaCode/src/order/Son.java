package order;

public class Son extends Father {
    int i = 20;

    {
        draw();
        System.out.println("son {} draw"+i);
    }

    public Son() {
//        i = 1;
//        draw();
        super();
    }


    void draw() {
        System.out.println("son draw" +i);
    }

    public static void main(String[] args) {
        Son son = new Son();
    }
}
