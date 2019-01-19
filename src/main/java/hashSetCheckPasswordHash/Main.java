package hashSetCheckPasswordHash;

import com.google.common.hash.Hasher;
import com.google.common.hash.Hashing;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.HashSet;
import java.util.Set;

import static java.nio.charset.StandardCharsets.UTF_8;

public class Main {
    private static final String expectedHash = "2ab774d722dcfe76ba6c27ed656af575"; //password "tYKe"

    public static void main(String[] args) {
        Long startTime = System.currentTimeMillis();
        Set<String> usedPasswords = new HashSet();
        while (true) {
            String password = RandomStringUtils.randomAlphabetic(1, 5);
            if (usedPasswords.add(password)) {
                Hasher hasher = Hashing.md5().newHasher();
                String hash = hasher.putString(password, UTF_8).hash().toString();
                if (expectedHash.equals(hash)) {
                    System.out.printf("Passord: %s%n",password);
                    Long totalTime = System.currentTimeMillis() - startTime;
                    System.out.printf("Hash per second: %d", usedPasswords.size()/(totalTime/1000));
                    break;
                }
//                System.out.printf("%s -> %s%n", password, hash);
            }
        }
    }
}
