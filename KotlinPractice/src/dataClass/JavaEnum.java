package dataClass;

public class JavaEnum {
    enum State implements Runnable{
        Idle(0){
            @Override
            public void run() {
                System.out.println("run for idle");
            }
        }, Busy(1){
            @Override
            public void run() {
                System.out.println("run for busy");
            }
        };
        int idd;

        State(int idd) {
            this.idd = idd;
        }
    }

    public static void main(String[] args) {
        System.out.println(State.Idle.name());
        System.out.println(State.Idle.ordinal());
    }
}
