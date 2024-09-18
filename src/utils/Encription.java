package utils;

import java.io.File;
import java.nio.file.Files;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

import javax.crypto.Cipher;

public class Encription {
    public static String encryption(String msg) {
        try {
            // Đọc file chứa public key
            File publicKeyFile = new File("C:/Users/admin/Desktop/Workspace/CuoiKiJava2/ServerApp/keydata/publicKey.rsa");
            byte[] publicKeyBytes = Files.readAllBytes(publicKeyFile.toPath());

            // Tạo public key
            X509EncodedKeySpec spec = new X509EncodedKeySpec(publicKeyBytes);
            KeyFactory factory = KeyFactory.getInstance("RSA");
            PublicKey publicKey = factory.generatePublic(spec);

            // Mã hóa dữ liệu
            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            cipher.init(Cipher.ENCRYPT_MODE, publicKey);
            byte[] encryptedBytes = cipher.doFinal(msg.getBytes());
            String encryptedMessage = Base64.getEncoder().encodeToString(encryptedBytes);
            return encryptedMessage;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
}
