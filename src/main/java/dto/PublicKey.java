package dto;

import utils.LocateString;

import java.math.BigInteger;

/**
 * Created by lukas_cerny on 13. 4. 2016.
 */
public class PublicKey implements Key {

    private static String SSH_RSA = "ssh-rsa ";
    private static String DOMAIN = "@locale";
    private static String SEPARATOR = ":";

    private String name;
    private BigInteger e;
    private BigInteger n;

    public PublicKey(BigInteger e, BigInteger n, String name){
        this.e = e;
        this.n = n;
        this.name = name;
    }

    public PublicKey(String key, String name){
        if (name == null || name.isEmpty()){
            throw new NullPointerException(LocateString.getValue("error.key.noName"));
        }
        if (key == null || key.isEmpty()){
            throw  new NullPointerException(LocateString.getValue("error.key.noKey"));
        }

        key = key.trim();

        String number = key.substring(SSH_RSA.length(), key.length() - (name.length() + DOMAIN.length()));
        String [] vk = number.split(SEPARATOR);
        try{
            this.e = new BigInteger(vk[0]);
            this.n = new BigInteger(vk[1]);
        }catch (NumberFormatException e){
            System.err.println(LocateString.getValue("error.key.dontCreate"));
            this.n = BigInteger.ONE;
            this.e = BigInteger.ONE;
        }
    }

    @Override
    public BigInteger getN(){
        return n;
    }

    @Override
    public BigInteger getDE(){
        return e;
    }

    public String toString(){
        return  SSH_RSA+e.toString()+SEPARATOR+n.toString()+name+DOMAIN;
    }

}
