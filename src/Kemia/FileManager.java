package Kemia;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileManager {

    private static String header = "";
    List<Entity> chemical = new ArrayList<Entity>();

    public List<Entity> fileRead(String fileName){
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(fileName), "windows-1250"));
            header = br.readLine();
            while (br.ready()){
                String row = br.readLine();
                String[] rowData = row.split(";");
                Entity entity = new Entity(
                        rowData[0],
                        rowData[1],
                        rowData[2],
                        Integer.parseInt(rowData[3]),
                        rowData[4]
                );
                chemical.add(entity);
            }
            br.close();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return chemical;
    }

}
