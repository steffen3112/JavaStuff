import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class FileStreamer {

    public static void main(String[] args) {

        try {
            List<String> directories = Files.lines(Paths.get("C:\\Users\\sschwarz\\Downloads\\Zuckerbrot & Peitsche 2018 Planung.txt"))
                                                                    .map(String::toUpperCase)
                                                                    .collect(Collectors.toList());
            System.out.println(directories);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
