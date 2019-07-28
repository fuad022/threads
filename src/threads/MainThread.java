package threads;

import java.util.LinkedList;

public class MainThread {
    static final LinkedList<Integer> originalBigList = new LinkedList<>();

    public static void main(String[] arg) {
        new AddingThread().start();
        new RemovalThread().start();
    }
}
