
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class RunsScoredByEachPlayer {
    public static void main(String[] args) {
        String deliveriesFilePath = "/home/deep/Downloads/deliveries.csv";
        String line = "";
        try {
            BufferedReader readFile = new BufferedReader(new FileReader(deliveriesFilePath));
            readFile.readLine();
            LinkedHashMap<String, Integer> batsmanRuns = new LinkedHashMap<>();
            ArrayList<String> batsman = new ArrayList<>();
            while ((line = readFile.readLine()) != null) {
                String[] data = line.split(",");
       System.out.println(data[0]);
                if (("1").contains(data[0])) {
                    System.out.println(data[6]);
                    if (batsmanRuns.containsKey(data[6])) {
                        batsmanRuns.put(data[6], batsmanRuns.get(data[6]) + Integer.parseInt(data[15]));
                    } else {
                        batsmanRuns.put(data[6], Integer.parseInt(data[15]) );
                    }
                }else {
                    continue;
                }

            }
            System.out.println(batsmanRuns);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {

        }

    }
}
