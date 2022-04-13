public class Multithreading {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());

        Thread thread = new Thread(new DownloadFileTask());
        thread.start();

        System.out.println(Thread.currentThread().getName());

    }
}