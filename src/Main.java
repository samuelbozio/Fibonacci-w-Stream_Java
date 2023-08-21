import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        String path = "C:\\Windows\\Temp\\votos.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {

            Map<String, Integer> map = new HashMap<>();
            String line = br.readLine();


            while (line != null) {

                String[] fields = line.split(",");

                String nome = fields[0];
                Integer votos = Integer.parseInt(fields[1]);

                if (map.get(nome) == null) {
                    map.put(nome, votos);
                } else map.put(nome, votos + map.get(nome));

                line = br.readLine();
            }

            for (String key : map.keySet()) {
                System.out.println(key + " " + map.get(key));
            }


        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}