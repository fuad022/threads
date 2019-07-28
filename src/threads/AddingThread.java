package threads;

public class AddingThread extends Thread {
    @Override
    public void run() {

        System.out.println("Adding thread started");
        int ctr = 0;

        while (true) {
            if (MainThread.originalBigList.size() < 100) {

                ctr++;
                synchronized (MainThread.originalBigList) {
                    MainThread.originalBigList.add(ctr);
                }
                System.out.println("Added number: " + ctr);

                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            } else {
                try {
                    System.out.println("List size is full = " + MainThread.originalBigList.size()
                            + ". Stop add. Wait 5 sec...");
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
