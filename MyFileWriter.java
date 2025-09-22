import java.io.*;
import java.nio.file.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.nio.charset.StandardCharsets;

public class MyFileWriter {
    public static void main(String[] args) {
        // String data = "Hello, World!";
        // String fileName1 = "example.txt";
        // String fileName2 = "example2.txt";
        // String fileName3 = "example3.txt";
        // String fileName4 = "example4.txt";
        // String fileName5 = "example5.txt";

        // // 1. Using FileWriter
        // try (FileWriter writer = new FileWriter(fileName1)) {
        // writer.write(data);
        // } catch (IOException e) {
        // e.printStackTrace();
        // }

        // // 2. Using BufferedWriter
        // try (BufferedWriter bufferedWriter = new BufferedWriter(new
        // FileWriter(fileName2))) {
        // bufferedWriter.write(data);
        // } catch (IOException e) {
        // e.printStackTrace();
        // }

        // // 3. Using FileOutputStream
        // try (FileOutputStream outputStream = new FileOutputStream(fileName3)) {
        // outputStream.write(data.getBytes());
        // } catch (IOException e) {
        // e.printStackTrace();
        // }

        // // 4. Using BufferedOutputStream
        // try (BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new
        // FileOutputStream(fileName4))) {
        // bufferedOutputStream.write(data.getBytes());
        // } catch (IOException e) {
        // e.printStackTrace();
        // }

        // // 5. Using Files (java.nio.file)
        // try {
        // // Files.write(Paths.get(fileName5), data.getBytes(StandardCharsets.UTF_8));
        // } catch (IOException e) {
        // e.printStackTrace();
        // }

        // generateHiddenFile();
        // generateHiddenFolder();
        printFileSize("fortnitesigma.txt");
    }

    public static void generateHiddenFile() {
        String name = fileNameGenerator();
        try {
            Files.write(Paths.get("." + name), "Password".getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void generateHiddenFolder() {
        String name = fileNameGenerator();
        try {
            Path filePath = Paths.get(".classifish");
            Files.write(filePath.resolve(Paths.get(name)),
                    "Password".getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String fileNameGenerator() {
        StringBuilder toStr = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            toStr.append((char) ((Math.random() * 94 + Math.random() * 25) * 128));
        }
        return toStr.append("_secret_password.txt").toString();
    }

    private static void printFileSize(String... fileNames) {
        long totalSize = 0;
        for (String fileName : fileNames) {
            File file = new File(fileName);
            if (file.exists()) {
                totalSize += file.length();
            }
        }
        System.out.println("Total size of all files: " + totalSize + " bytes");
    }

    public static String toString(File file) {
        return file.toString();
    }

    public static String hashFile(String path) {
        File testFile = new File(path);

        if (!testFile.exists()) {
            throw new IllegalArgumentException("No such file exists.");
        }
        // System.out.println(testFile.getAbsolutePath());
        try {
            byte[] bytes = Files.readAllBytes(Paths.get(path));
            // Normalize to ensure consistent hashes across OSes:
            // - Decode as UTF-8
            // - Strip UTF-8 BOM if present
            // - Normalize CRLF / CR to LF
            String content = new String(bytes, StandardCharsets.UTF_8);
            if (!content.isEmpty() && content.charAt(0) == '\uFEFF') {
                content = content.substring(1);
            }
            content = content.replace("\r\n", "\n").replace("\r", "\n");
            byte[] normalizedBytes = content.getBytes(StandardCharsets.UTF_8);
            // System.out.println(Files.readString(Paths.get(path)));
            MessageDigest mDigest = MessageDigest.getInstance("SHA-256");
            byte[] hashedBytes = mDigest.digest(normalizedBytes);
            StringBuilder hashedString = new StringBuilder();
            for (byte b : hashedBytes) {
                String hexB = Integer.toHexString(0xff & b);
                if (hexB.length() == 1) {
                    hashedString.append("0");
                }
                hashedString.append(hexB);
            }
            return hashedString.toString();
        } catch (IOException e) {
            System.out.println("Cannot read from path.");
            return null;
        } catch (NoSuchAlgorithmException e) {
            System.out.println("You should never get this error. Contact my at maguilar1@hwemail.com if this happens.");
            return null;
        }
    }
}
