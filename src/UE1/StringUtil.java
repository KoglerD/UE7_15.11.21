package UE1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.*;

public class StringUtil {

    public static void main(String[] args) {
        int coreCount = Runtime.getRuntime().availableProcessors();
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(coreCount);
        System.out.println(applySha256("AABBCC"));


        String solution = "";
        try {
            //solution = fourLetters();
            solution = sixUpperCaseLetters();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println(solution);
        executor.shutdown();
    }

    public static String fourLetters() throws ExecutionException, InterruptedException {
        int coreCount = Runtime.getRuntime().availableProcessors();
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(coreCount);
        String[] allLetters = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};

        Future<String> result = executor.submit((Callable<String>) () -> {
            String password = "";
            for (int i = 0; i < allLetters.length; i++) {
                for (int j = 0; j < allLetters.length; j++) {
                    for (int k = 0; k < allLetters.length; k++) {
                        for (int l = 0; l < allLetters.length; l++) {
                            password = allLetters[i]+allLetters[j]+allLetters[k]+allLetters[l];
                            if (applySha256(password).equals(new BufferedReader(new FileReader("passwordFour.txt")).readLine())){
                                return password;
                            }
                        }
                    }
                }
            }
            return "Password not Found";
        });
        return result.get();
    }

    public static String sixUpperCaseLetters() throws ExecutionException, InterruptedException {
        int coreCount = Runtime.getRuntime().availableProcessors();
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(coreCount);
        String[] allLetters = {"A", "B", "C", "D", "E", "F", "G", "G", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "P", "X", "Y", "Z"};

        Future<String> result = executor.submit((Callable<String>) () -> {
            String password = "";
            for (int i = 0; i < allLetters.length; i++) {
                for (int j = 0; j < allLetters.length; j++) {
                    for (int k = 0; k < allLetters.length; k++) {
                        for (int l = 0; l < allLetters.length; l++) {
                            for (int m = 0; m < allLetters.length; m++) {
                                for (int n = 0; n < allLetters.length; n++) {
                                    password = allLetters[i]+allLetters[j]+allLetters[k]+allLetters[l]+allLetters[m]+allLetters[n];
                                    if (applySha256(password).equals(new BufferedReader(new FileReader("passwordSixUppercase.txt")).readLine())){
                                        return password;
                                    }
                                }
                            }
                        }
                    }
                }
            }
            return "Password not Found";
        });
        return result.get();
    }

    public static String applySha256(String input) {
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
    }

/*Future<String> result = new CompletableFuture<>();
        String[] allLetters = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
        result = executor.submit((Callable<String>) () -> {
            String password = "";
            for (int i = 0; i < allLetters.length; i++) {
                for (int j = 0; j < allLetters.length; j++) {
                    for (int k = 0; k < allLetters.length; k++) {
                        for (int l = 0; l < allLetters.length; l++) {
                            password = allLetters[i]+allLetters[j]+allLetters[k]+allLetters[l];
                            if (applySha256(password).equals(new BufferedReader(new FileReader("passwordFour.txt")).readLine())){
                                return password;
                            }
                        }
                    }
                }
            }
            return "Password not Found";
        });*/
}
