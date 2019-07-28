package threads;

import java.util.EmptyStackException;

public class RemovalThread extends Thread {
    @Override
    public void run() {
        System.out.println("RemovalThread started");

        while (true) {
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
//            System.out.println("originalBigList before removing size " + ArraylistTest.originalBigList.size());
            Integer llpop = null;
            try {
                synchronized (MainThread.originalBigList) {
                    llpop = MainThread.originalBigList.pop();
                }
            } catch (EmptyStackException ignored) {
            }

            if (llpop != null) {
                System.out.println("Number " + llpop + " removed");
            } else {
                System.out.println("List size is empty. Wait...");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
//            System.out.println("originalBigList after remove list size: " + ArraylistTest.originalBigList.size());

        }
    }
}
