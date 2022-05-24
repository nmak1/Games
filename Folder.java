import java.io.*;
import java.util.Arrays;
import java.util.List;

import static java.lang.String.valueOf;

public class Folder {


    public static void main(String[] args) {

        List<File> dirName = Arrays.asList(new File("D://документы коля//IdeaProjects//Games//res")
                , new File("D://документы коля//IdeaProjects//Games//savegames")
                , new File("D:\\документы коля\\IdeaProjects\\Games\\temp")
                , new File("D:\\документы коля\\IdeaProjects\\Games\\src")
                , new File("D:\\документы коля\\IdeaProjects\\Games\\src\\main")
                , new File("D:\\документы коля\\IdeaProjects\\Games\\src\\test")
                , new File("D:\\документы коля\\IdeaProjects\\Games\\res\\drawables")
                , new File("D:\\документы коля\\IdeaProjects\\Games\\res\\vectors")
                , new File("D:\\документы коля\\IdeaProjects\\Games\\res\\icons"));
        List<File> fileList = Arrays.asList(
                new File("D:\\документы коля\\IdeaProjects\\Games\\src\\main\\Main.java"),
                new File("D:\\документы коля\\IdeaProjects\\Games\\src\\main\\Utils.java"),
                new File("D:\\документы коля\\IdeaProjects\\Games\\temp\\temp.txt"));


        StringBuilder sb = new StringBuilder();

        dirName.stream().forEach(dir -> {
            if (dir.mkdirs()) sb.append("Каталог " + dir + " создан\n");
            else sb.append("Каталог " + dir + " не создан\n");

        });


        fileList.stream().forEach(file -> {
            try {
                if (file.createNewFile()) sb.append("Файл " + file + " создан\n");
                else sb.append("Файл " + file + " не создан\n");
            } catch (IOException ex) {
                sb.append(ex.getMessage() + '\n');

            }
        });
        try (FileWriter log = new FileWriter("D:\\документы коля\\IdeaProjects\\Games\\temp\\temp.txt", false)) {
            log.write(sb.toString());
            log.flush();
        } catch (IOException ex) {
            sb.append(ex.getMessage() + '\n');
        }
        try (BufferedReader br = new BufferedReader(new FileReader("D:\\документы коля\\IdeaProjects\\Games\\temp\\temp.txt"))) {
            String s;
            while ((s = br.readLine()) != null) System.out.println(s);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}












