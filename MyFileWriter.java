import java.io.*;
import java.nio.file.*;
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
        //     writer.write(data);
        // } catch (IOException e) {
        //     e.printStackTrace();
        // }

        // // 2. Using BufferedWriter
        // try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName2))) {
        //     bufferedWriter.write(data);
        // } catch (IOException e) {
        //     e.printStackTrace();
        // }

        // // 3. Using FileOutputStream
        // try (FileOutputStream outputStream = new FileOutputStream(fileName3)) {
        //     outputStream.write(data.getBytes());
        // } catch (IOException e) {
        //     e.printStackTrace();
        // }

        // // 4. Using BufferedOutputStream
        // try (BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(fileName4))) {
        //     bufferedOutputStream.write(data.getBytes());
        // } catch (IOException e) {
        //     e.printStackTrace();
        // }

        // // 5. Using Files (java.nio.file)
        // try {
        //     Files.write(Paths.get(fileName5), data.getBytes(StandardCharsets.UTF_8));
        // } catch (IOException e) {
        //     e.printStackTrace();
        // }

        // generateHiddenFile();
        // generateHiddenFolder();
        printFileSize("fortnitesigma.txt");
    }

    public static void generateHiddenFile() {
        String name = fileNameGenerator();
        try {
            Files.write(Paths.get("."+name), "Password".getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void generateHiddenFolder() {
        String name = fileNameGenerator();
        try {
            Path filePath = Paths.get(
                    ".classifish");
            Files.write(filePath.resolve(Paths.get(name)), "Password".getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static String fileNameGenerator() {
        StringBuilder toStr = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            toStr.append((char) ((Math.random()*94+Math.random()*25) * 128));
        }
        return toStr.append("_secret_password.txt").toString();
    }

    private static void printFileSize(String fileName) {
        File file = new File(fileName);
        if (file == null || !file.exists()) {
            throw new IllegalArgumentException();
        }
        System.out.println(file.length());
    }
}
