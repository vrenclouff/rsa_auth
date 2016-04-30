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
    private int length = 512;

    public KeyMachine(String name){
        generate(name);
    }

    public KeyMachine(int length){
        this.length = length < this.length ? this.length : length;
        generate("test");
    }

    private void generate(String name) {
        BigInteger p, q, n, d, e, x;
        SecureRandom r = new SecureRandom();

        p = BigInteger.probablePrime(length, r);
        q = BigInteger.probablePrime(length, r);
        n = p.multiply(q);

        x = (p.subtract(BigInteger.ONE)).multiply(q.subtract(BigInteger.ONE));

        e = BigInteger.probablePrime(length/2, r);
        while (x.gcd(e). intValue() > 1){
            e = BigInteger.probablePrime(length/2, r);
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

    public Key publicKey(){ return publicKey;}

    public Key privateKey(){ return privateKey;}
}