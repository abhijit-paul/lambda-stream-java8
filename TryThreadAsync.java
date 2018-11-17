public class TryThreadAsync {
    public static void printAsyncLine2() {
        System.out.println("Hello async line 4");
    }

    public static void main(String[] args)  {
        System.out.println("Hello sync line");
        Thread th = new Thread(new Runnable() {
            public void run()   {
                System.out.println("Hello async line");
            }
        });
        Thread th2 = new Thread(() -> System.out.println("Hello async line 2"));

        Thread th3 = new Thread(() -> {
            System.out.println("Hello async line 3");
        });

        Thread th4 = new Thread(TryThreadAsync::printAsyncLine2);

        th.start();
        th2.start();
        th3.start();
        th4.start();

        System.out.println("Hello sync line 2");

        //Invokedynamic..
    }
}