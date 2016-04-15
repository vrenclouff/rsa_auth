package test;


import app.KeyMachine;
import app.RSA;
import dto.Key;
import dto.PrivateKey;
import dto.PublicKey;

import java.math.BigInteger;
import java.security.SecureRandom;

/**
 * Created by lukas_cerny on 14. 4. 2016.
 */
public class RSATest {

    private BigInteger plane;
    private String publicKey;
    private String privateKey;
    private String name;

    @org.junit.Before
    public void setUp() throws Exception {
        name = "user1";
        plane = BigInteger.probablePrime(256, new SecureRandom());
        KeyMachine machine = new KeyMachine(name);
        publicKey = machine.getPublicKey();
        privateKey = machine.getPrivateKey();
    }

    @org.junit.Test
    public void cipher() throws Exception {
        BigInteger encrypt = RSA.encrypt(new PublicKey(publicKey, name), plane);
        BigInteger decrypt = RSA.decrypt(new PrivateKey(privateKey), encrypt);

        System.out.println(decrypt.compareTo(plane) == 0 ? "true" : "false");
    }

}