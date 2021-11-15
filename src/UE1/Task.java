package UE1;

import java.io.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.Callable;

public class Task implements Callable<Integer> {
    private int password0;
    private String password1;
    private String password2;
    private String password3;

    /*public Task(String passwordFour) {
        try {
            BufferedReader bf = new BufferedReader(new FileReader("password0"));
            password0 = bf.readLine();
            bf = new BufferedReader(new FileReader("password1"));
            password1 = bf.readLine();
            bf = new BufferedReader(new FileReader("password2"));
            password2 = bf.readLine();
            bf = new BufferedReader(new FileReader("password3"));
            password3 = bf.readLine();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/

    @Override
    public Integer call() throws Exception {
        return 1;
    }

   /*public static String applySha256(String input) {

        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(input.getBytes("UTF-8"));
            StringBuilder hexString = new StringBuilder();
            for (int i = 0; i < hash.length; i++) {
                String hex = Integer.toHexString(0xff & hash[i]);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }*/
}
