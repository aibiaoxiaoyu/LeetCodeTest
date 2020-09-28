import java.util.concurrent.Callable;

public class FuncParam<T> {
    public static MyInterface myInterface = (p1, p2) -> {
        return p2 + p1;
    };

    private static void action(int i, Callable<Integer> func) {
        try {
            System.out.println(i + func.call());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static void action(int i, MyInterface func) {
        System.out.println(i + func.doSomething(1, "2"));
    }

    public static void main(String[] args) {
        int a = 10;
        action(a, new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                return a * a;
            }
        });
        action(a, myInterface);
    }

    @FunctionalInterface
    public interface MyInterface {
        String doSomething(int param1, String param2);
    }


}
