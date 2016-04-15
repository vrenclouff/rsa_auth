package app;

import dto.Key;

import java.math.BigInteger;

/**
 * Created by lukas_cerny on 13. 4. 2016.
 */
public class RSA {

    public static BigInteger encrypt(Key key, BigInteger msg){
        return msg.modPow(key.getDE(), key.getN());
    }

    public static BigInteger decrypt(Key key, BigInteger msg){
        return msg.modPow(key.getDE(), key.getN());
    }

}
