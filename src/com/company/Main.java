package com.company;
import java.io.*;
import java.util.Scanner;

public class Main {
    private final static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        Caesar cipher = new Caesar();
        System.out.println("Encryption order = " + new String(cipher.encrypt));
        System.out.println("Decryption order = " + new String(cipher.decrypt));
        System.out.println("Enter File location: *.txt file containing UpperCase letters =");
        String fileName = in.nextLine();
        try {
            BufferedInputStream bis = new BufferedInputStream(new FileInputStream(fileName));
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(fileName));
            String secret = cipher.encrypt(bis);
            System.out.println(" Encryption of file values : " + secret);
            byte[] b = secret.getBytes();
            bos.write(b);
            secret = cipher.decrypt(bis);
            System.out.println(" Decryption of file values : " + secret);
            b = secret.getBytes();
            bos.write(b);
        } catch (Exception e) {
            System.out.println(" File not found. Write a correct file location");
            main(args);
        }
    }
}

class Caesar {
    public static final int ALPHASIZE = 26;
    public static final char[] alpha = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M',
            'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
    protected char[] encrypt = new char[ALPHASIZE];
    protected char[] decrypt = new char[ALPHASIZE];

    public Caesar() {
        for (int i = 0; i < ALPHASIZE; i++)
            encrypt[i] = alpha[(i) % ALPHASIZE];
        for (int i = 0; i < ALPHASIZE; i++)
            decrypt[encrypt[i] - 'A'] = alpha[i];
    }

    // Encryption Method
    public String encrypt(BufferedInputStream secret) {
        char[] mess = secret.toString().toCharArray();
        for (int i = 0; i < mess.length; i++)
            if (Character.isUpperCase(mess[i]))
                mess[i] = encrypt[mess[i] - 'A'];
        return new String(mess);
    }

    // Decryption Method
    public String decrypt(BufferedInputStream secret) {
        char[] mess = secret.toString().toCharArray();
        for (int i = 0; i < ALPHASIZE; i++)
            if (Character.isUpperCase(mess[i]))
                mess[i] = decrypt[mess[i] - 'A'];
        return new String(mess);
    }
}
