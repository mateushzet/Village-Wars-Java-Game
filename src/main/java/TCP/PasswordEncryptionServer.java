package TCP;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.util.Base64;

public class PasswordEncryptionServer {

    private static SecretKey key;

    public static SecretKey getKey() {
        return key;
    }

    public PasswordEncryptionServer() throws Exception{

        // Generate a secret key for encryption and decryption
        key = KeyGenerator.getInstance("AES").generateKey();

//        String encryptedPassword = encrypt(originalPassword);
//        System.out.println("Encrypted password: " + encryptedPassword);
//
//        String decryptedPassword = decrypt(encryptedPassword);
//        System.out.println("Decrypted password: " + decryptedPassword);
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
