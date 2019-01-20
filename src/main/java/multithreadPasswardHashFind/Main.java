package multithreadPasswardHashFind;

import com.google.common.hash.Hashing;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.*;

import static java.nio.charset.StandardCharsets.UTF_8;

public class Main {

    //private static final String expectedHash = "dbdb989b83497e3c5332ea388096dc7a";
    private static final String expectedHash = Hashing.md5().newHasher().putString("scrt", UTF_8).hash().toString();
    private static volatile boolean found = false;
    private static int threads = 0;
    private static Set<String> usedPasswords = new HashSet<>();
    private static final int MAX_THREADS = 8;
    private static final Object lock = new Object();

    public static void main(String[] args) throws InterruptedException {
        System.out.printf("hash: %s%n",expectedHash );
        long startTime = System.currentTimeMillis();

        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < MAX_THREADS; i++) {
            Thread thread = new Thread(new HashRunnnable());
            thread.setName("HashGenerator " + i);
            thread.start();
            threads.add(thread);
        }

        for (Thread thread : threads) {
            thread.join();
        }

        long executionTime = System.currentTimeMillis() - startTime;
        System.out.printf("Hash per second: %d", usedPasswords.size() / (executionTime / 1000));
    }

    private static class HashRunnnable implements Runnable {


        @Override
        public void run() {
            while (!found) {
                String password = RandomStringUtils.randomAlphabetic(3, 5);
                boolean addedItem;
                synchronized (lock) {
                    addedItem = usedPasswords.add(password);
                }
                if (!addedItem) {
                    String hash = Hashing.md5().newHasher().putString(password, UTF_8).hash().toString();
//                System.out.printf("%s %n", hash);
                    if (expectedHash.equals(hash)) {
                        found = true;
                        System.out.printf("%s%n", password);
                    }
                }
            }
        }
    }
}
