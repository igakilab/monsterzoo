import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class MondexReader{
    public static void readMondex(String path, MonsterZoo pz, StatusSetAndGet status){
        try{
            File mondexfile = new File(path);
            BufferedReader br = new BufferedReader(new FileReader(mondexfile));
            String line = br.readLine();
            while (line != null){
                String[] line_parse = spliter(line, ",", pz);
                status.setMonsterZukan(pz, line_parse[0], line_parse[1]);
                status.setMonsterRare(pz, line_parse[0], line_parse[2]);
                line = br.readLine();
            }
            br.close();
        } catch (IOException e){
            System.out.println(e);
        
        }
    }

    static String[] spliter(String line, String split_char, MonsterZoo pz){
        return line.split(split_char);
    }

}
