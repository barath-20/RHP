class Main extends Thread {

    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("Thread 1: " + i);
        }
    }

    public static void main(String[] args) {

        Main t1 = new Main();
        t1.start();

        for (int i = 1; i <= 5; i++) {
            System.out.println("Thread 2: " + i);
        }
    }
}