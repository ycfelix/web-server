package com.felix.webserver.service;

import com.felix.webserver.model.Student;
import com.felix.webserver.repository.StudentRepository;
import com.felix.webserver.repository.model.StudentEntity;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

import javax.crypto.Cipher;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.security.KeyFactory;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private ObjectConversionService objectConversionService;

    public Student create(Student student) {
        StudentEntity entity = objectConversionService.convert(student);
        return objectConversionService.convert(studentRepository.save(entity));

    }

    public StudentEntity update(StudentEntity student) {
        return studentRepository.customUpdate(student);
    }

    public List<StudentEntity> retrieve() {
        return studentRepository.findAll();
    }

    public void getFile(Long id, HttpServletResponse response) {
        String content = "abcdevgc";
        String s = "abc/s/c/123124-23123/a.csv";
        response.setHeader(HttpHeaders.CONTENT_DISPOSITION,String.format("attachment; filename= \"%s\"",s));
        try(OutputStream outputStream = response.getOutputStream()) {
            outputStream.write(content.getBytes());
            outputStream.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void decrypt() throws Exception {
        var MAX_ENCRYPT_BLOCK = 245;
        var publicKey = readPublicKey(new File("F:\\programming\\java ex\\webserver\\src\\main\\resources\\public_key.pem"));
        var privateKey = readPrivateKey(new File("F:\\programming\\java ex\\webserver\\src\\main\\resources\\private_key.pem"));

        Cipher encrypt=Cipher.getInstance("RSA");
        Cipher decrypt=Cipher.getInstance("RSA");
        decrypt.init(Cipher.DECRYPT_MODE, privateKey);
        var msg = "w9y$B&E)H@McQfTjWnZr4u7x!A%C*F-JaNdRgUkXp2s5v8y/B?E(G+KbPeShVmYq3t6w9z$C&F)J@McQfTjWnZr4u7x!A%D*G-KaPdRgUkXp2s5v8y/B?E(H+MbQeThW";
        encrypt.init(Cipher.ENCRYPT_MODE, publicKey);

        byte[] data = msg.getBytes(StandardCharsets.UTF_8);
        var enBytes = encrypt.doFinal(data);
        System.out.println(new String(Base64.encodeBase64(enBytes)));
        String decryptedMessage = new String(decrypt.doFinal(enBytes), StandardCharsets.UTF_8);
        System.out.println(decryptedMessage);
    }

    public static RSAPrivateKey readPrivateKey(File file) throws Exception {
        String key = new String(Files.readAllBytes(file.toPath()), Charset.defaultCharset());

        String privateKeyPEM = key
                .replace("-----BEGIN PRIVATE KEY-----", "")
                .replaceAll(System.lineSeparator(), "")
                .replace("-----END PRIVATE KEY-----", "");

        byte[] encoded = Base64.decodeBase64(privateKeyPEM);

        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(encoded);
        return (RSAPrivateKey) keyFactory.generatePrivate(keySpec);
    }

    public static RSAPublicKey readPublicKey(File file) throws Exception {
        String key = new String(Files.readAllBytes(file.toPath()), Charset.defaultCharset());

        String publicKeyPEM = key
                .replace("-----BEGIN PUBLIC KEY-----", "")
                .replaceAll(System.lineSeparator(), "")
                .replace("-----END PUBLIC KEY-----", "");

        byte[] encoded = Base64.decodeBase64(publicKeyPEM);

        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(encoded);
        return (RSAPublicKey) keyFactory.generatePublic(keySpec);
    }
}
