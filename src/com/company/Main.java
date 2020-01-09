package com.company;

public class Main {

    public static void main(String[] args) {
        Caesar cipher = new Caesar();
        System.out.println("Encryption order = " + new String(cipher.encrypt));
        System.out.println("Decryption order = " + new String(cipher.decrypt));
        String secret = "MY CODE IS PLATFORM INDEPENDENT";
        secret = cipher.encrypt(secret);
        System.out.println(" Encryption of String : " + secret);
        secret = cipher.decrypt(secret);
        System.out.println(" Decryption of String : " +secret);
    }
}

class Caesar {
    public static final int ALPHASIZE = 26;
    public static final char[] alpha = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M',
            'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
    protected char[] encrypt = new char[ALPHASIZE];
    protected char[] decrypt = new char[ALPHASIZE];

    public Caesar() {
        for(int i=0; i<ALPHASIZE; i++)
            encrypt[i] = alpha[(i+3)%ALPHASIZE];
        for(int i=0; i<ALPHASIZE; i++)
            decrypt[encrypt[i]-'A'] = alpha[i];
    }

    // Encryption Method
    public String encrypt(String secret) {
        char[] mess = secret.toCharArray();
        for(int i=0; i<mess.length; i++)
            if(Character.isUpperCase(mess[i]))
                mess[i] = encrypt[mess[i]-'A'];
            return new String(mess);
    }

    // Decryption Method
    public String decrypt(String secret) {
        char[] mess = secret.toCharArray();
        for(int i=0; i<ALPHASIZE; i++)
            if(Character.isUpperCase(mess[i]))
                mess[i] = decrypt[mess[i]-'A'];
            return new String(mess);
    }
}
