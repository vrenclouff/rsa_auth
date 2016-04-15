package dto;

import utils.LocateString;

import java.math.BigInteger;

/**
 * Created by lukas_cerny on 13. 4. 2016.
 */
public class PrivateKey implements Key {

    private static String SEPARATOR = ":";

    private BigInteger d;
    private BigInteger n;

    public PrivateKey(BigInteger d, BigInteger n){
        this.d = d;
        this.n = n;
    }

    public PrivateKey(String key){
        if (key == null || key.isEmpty()){
            throw new NullPointerException(LocateString.getValue("error.key.noName"));
        }

        String [] pk = key.split(SEPARATOR);

        try {
            this.d = new BigInteger(pk[0]);
            this.n = new BigInteger(pk[1]);
        }catch (NumberFormatException e){
            System.err.println(LocateString.getValue("error.key.dontCreate"));
            this.d = BigInteger.ZERO;
            this.n = BigInteger.ZERO;
        }
    }

    @Override
    public BigInteger getN(){
        return n;
    }

    @Override
    public BigInteger getDE(){
        return d;
    }

    public String toString(){
        return d.toString()+SEPARATOR+n.toString();
    }
}
