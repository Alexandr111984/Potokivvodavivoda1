import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class Main {

    public static void createDir(String path, StringBuilder stringBuilder) {
        File tempFile = new File("E:/Games/" + path);
        stringBuilder.append("Try to created folder " + path + ". Is Created: ");
        boolean isCreated = tempFile.mkdirs();
        stringBuilder.append(isCreated + "\n");
    }

    public static void createFile(String path, StringBuilder stringBuilder) throws IOException {
        File tempFile = new File("E:/Games/" + path);
        stringBuilder.append("Try to create file" + path + " Is Created: ");
        boolean isCreated = false;
        try {
            isCreated = tempFile.createNewFile();
            stringBuilder.append(isCreated + "\n");
        } catch (IOException e) {
            e.printStackTrace();
            stringBuilder.append("Exception when file created.\n");
            stringBuilder.append(e.getMessage() + "\n");
        }
    }

    public static void FileWriter(String path, StringBuilder stringBuilder) {
        try (FileWriter writer = new FileWriter("E:/Games/" + path)) {
            writer.write(stringBuilder.toString());
            writer.flush();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {

        StringBuilder stringBuilder = new StringBuilder();

        createDir("src", stringBuilder);
        createDir("res", stringBuilder);
        createDir("savegames", stringBuilder);
        createDir("temp", stringBuilder);
        createDir("src/main", stringBuilder);
        createDir("src/test", stringBuilder);
        createDir("res/drawables", stringBuilder);
        createDir("res/vectors", stringBuilder);
        createDir("res/icons", stringBuilder);

        createFile("src/main/Main.java", stringBuilder);
        createFile("src/main/Utils.java", stringBuilder);
        createFile("temp/text.txt", stringBuilder);
        FileWriter("temp/text.txt", stringBuilder);


    }
}