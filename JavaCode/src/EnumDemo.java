public class EnumDemo {
    public static void main(String[] args) {
        Size s = Size.LARGE;
        Size s2 = Size.valueOf("SMALL");
        System.out.println(s);
        System.out.println(s2);
        System.out.println(s.getId());

        //改变id并不会改变枚举的值
        s.setId(10);
        System.out.println(s.getId());
    }
}

enum Size {
    SMALL("小", 10), MEDIUM("中", 20), LARGE("大", 30);

    private String s;
    private int id;

    private Size(String s, int id) {
        this.s = s;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setS(String s) {
        this.s = s;
    }

    public String getS() {
        return s;
    }

    public static Size fromAbbr(String s) {
        for (Size size : Size.values()) {
            if (size.getS().equals(s)) {
                return size;
            }
        }
        return null;
    }
}