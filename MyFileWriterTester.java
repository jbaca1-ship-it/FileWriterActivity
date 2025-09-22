import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class MyFileWriterTester {
    public static void main(String[] args) {
        testHashFileNormalFiles();
        testHashFileEmptyFiles();
        testHashFileLargeFiles();
        testHashFileSpecialChars();
        testHashFileNonExistent();
    }
    
    public static void testHashFileNormalFiles() {
        // File f = new File("normal");
        String data = "Hello World!";
        String name = "normal.txt";
        try {
            Files.write(Paths.get(name), data.getBytes(StandardCharsets.UTF_8));
            // Files.write(Paths.get("normal"), data.getBytes(StandardCharsets.UTF_8));
        } catch (Exception e) {
            // TODO: handle exception
        }
        System.out.print("Expected: 7f83b1657ff1fc53b92dc18148a1d65dfc2d4b1fa3d677284addd200126d9069\nResult:   ");
        System.out.println(MyFileWriter.hashFile(name));
    }

    public static void testHashFileEmptyFiles() {
        // File f = new File("normal");
        String data = "";
        String name = "empty.txt";
        try {
            Files.write(Paths.get(name), data.getBytes(StandardCharsets.UTF_8));
            // Files.write(Paths.get("normal"), data.getBytes(StandardCharsets.UTF_8));
        } catch (Exception e) {
            // TODO: handle exception
        }
        System.out.print("Expected: e3b0c44298fc1c149afbf4c8996fb92427ae41e4649b934ca495991b7852b855\nResult:   ");
        System.out.println(MyFileWriter.hashFile(name));
    }
    
    public static void testHashFileLargeFiles() {
        // THIS DOESN'T WORK AND IDK WHY
        // File f = new File("normal");
        // String data = "Hello World!";
        String name = "script.txt";
        // try {
        //     Files.write(Paths.get(name), data.getBytes(StandardCharsets.UTF_8));
        //     // Files.write(Paths.get("normal"), data.getBytes(StandardCharsets.UTF_8));
        // } catch (Exception e) {
        //     // TODO: handle exception
        // }
        System.out.print("Expected: bedff2cf7a3d54b4e6ed9720b80e0f3a01df47c1a5737e60016b54caf4bbbad0\nResult:   ");
        System.out.println(MyFileWriter.hashFile(name));
    }

    public static void testHashFileSpecialChars() {
        // File f = new File("normal");
        String data = "😊🤣😊😊😊🤣🤣💕😘😂😁";
        String name = "special.txt";
        try {
            Files.write(Paths.get(name), data.getBytes(StandardCharsets.UTF_8));
            // Files.write(Paths.get("normal"), data.getBytes(StandardCharsets.UTF_8));
        } catch (Exception e) {
            // TODO: handle exception
        }
        System.out.print("Expected: feb38533d12ea354b9912f076ff25420b916098dd37a7c73f963702fa4fb3081\nResult:   ");
        System.out.println(MyFileWriter.hashFile(name));
    }

    public static void testHashFileNonExistent() {
        // File f = new File("normal");
        // String data = "Hello World!";
        String name = "nonexistent.txt";
        // try {
        //     Files.write(Paths.get(name), data.getBytes(StandardCharsets.UTF_8));
        //     // Files.write(Paths.get("normal"), data.getBytes(StandardCharsets.UTF_8));
        // } catch (Exception e) {
        //     // TODO: handle exception
        // }
        System.out.println("Expected: Error");
        System.out.println(MyFileWriter.hashFile(name));
    }
}
