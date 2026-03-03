class Main implements Runnable {

    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("Child Thread: " + i);
        }
    }

    public static void main(String[] args) {

        Main task = new Main();
        Thread t1 = new Thread(task);
        t1.start();   // starts new thread

        for (int i = 1; i <= 5; i++) {
            System.out.println("Main Thread: " + i);
        }
    }
}