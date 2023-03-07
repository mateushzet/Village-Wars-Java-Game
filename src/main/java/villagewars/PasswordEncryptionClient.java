package villagewars;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import java.util.Base64;

public class PasswordEncryptionClient {

    private static SecretKey key;

    public static void setKey(SecretKey key) {
        PasswordEncryptionClient.key = key;
    }

    public static String encrypt(String password) throws Exception {

        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] encryptedPasswordBytes = cipher.doFinal(password.getBytes());
        return Base64.getEncoder().encodeToString(encryptedPasswordBytes);

    }

    public static String decrypt(String encryptedPassword) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, key);
        byte[] encryptedPasswordBytes = Base64.getDecoder().decode(encryptedPassword);
        byte[] decryptedPasswordBytes = cipher.doFinal(encryptedPasswordBytes);
        return new String(decryptedPasswordBytes);
    }
}
