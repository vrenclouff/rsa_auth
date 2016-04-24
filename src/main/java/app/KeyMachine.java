package app;

import dto.*;
import dto.Key;
import dto.PrivateKey;
import dto.PublicKey;

import java.math.BigInteger;
import java.security.*;


/**
 * Created by lukas_cerny on 3. 4. 2016.
 */
public class KeyMachine {

    private Key publicKey;
    private Key privateKey;

    public KeyMachine(String name){
        generate(name);
    }

    private void generate(String name) {
        BigInteger p, q, n, d, e, x;
        SecureRandom r = new SecureRandom();

        p = BigInteger.probablePrime(512, r);
        q = BigInteger.probablePrime(512, r);
        n = p.multiply(q);

        x = (p.subtract(BigInteger.ONE)).multiply(q.subtract(BigInteger.ONE));

        e = BigInteger.probablePrime(256, r);
        while (x.gcd(e). intValue() > 1){
            e = BigInteger.probablePrime(256, r);
        }

        d = e.modInverse(x);

        this.privateKey = new PrivateKey(d, n);
        this.publicKey = new PublicKey(e, n, name);

    }

    public String getPublicKey() {
        return publicKey.toString();
    }

    public String getPrivateKey() {
        return privateKey.toString();
    }
}