import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Main {
    public static StringBuilder stringBuilder = new StringBuilder();


    public static void createDir(String path) {
        File tempFile = new File("E:/Games/" + path);
        boolean isCreated = tempFile.mkdirs();

        stringBuilder.append("Try to created folder " + path + ". Is Created: ");
        if (isCreated == true) {
            stringBuilder.append("Папка успешно создана." + "\n");
        } else {
            stringBuilder.append("Что-то пошло не так" + "\n");
        }
    }

    public static void createFile(String path) throws IOException {
        File tempFile = new File("E:/Games/" + path);
        boolean isCreated = false;
        stringBuilder.append("Try to create file" + path + " Is Created: ");
        try {
            isCreated = tempFile.createNewFile();
            if (isCreated) {
                stringBuilder.append("Фаил удачно создан" + "\n");
            } else {
                stringBuilder.append("Что-то пошло не так" + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
            stringBuilder.append("Exception when file created.\n");
            stringBuilder.append(e.getMessage() + "\n");
        }
    }

    public static void fileWriter(String path) {
        try (FileWriter writer = new FileWriter("E:/Games/" + path)) {
            writer.write(stringBuilder.toString());
            writer.flush();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        List<String> address = new ArrayList();
        address.add("src");
        address.add("res");
        address.add("savegames");
        address.add("temp");
        address.add("src/main");
        address.add("src/test");
        address.add("res/drawables");
        address.add("res/vectors");
        address.add("res/icons");
        for (String paht : address) {
            createDir(paht);
        }


        createFile("src/main/Main.java");
        createFile("src/main/Utils.java");
        createFile("temp/text.txt");
        fileWriter("temp/text.txt");


    }
}