
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class ExtraRunsConcededPerTeam {
    public static void main(String[] args) {
        String MatchesFilePath = "/home/deep/Downloads/matches.csv";
        String DeliveriesFilePath = "/home/deep/Downloads/deliveries.csv";
        String line = "";
        int count = 0;
        try {
            BufferedReader readFirstFile = new BufferedReader(new FileReader(MatchesFilePath));
            readFirstFile.readLine();
            BufferedReader readSecondFile = new BufferedReader(new FileReader(DeliveriesFilePath));
            readSecondFile.readLine();
            ArrayList<String> idList = new ArrayList<String>();
            ArrayList<String> teams = new ArrayList<String>();
            HashMap<String, Integer> extraRuns = new HashMap<String, Integer>();
            while ((line = readFirstFile.readLine()) != null) {
                String[] data = line.split(",");
//                System.out.println((data[1]));
                if (data[1].contains("2016")) {
//                        System.out.println(data[1]);
                    idList.add(data[0]);
                }
            }
            while ((line = readSecondFile.readLine()) != null) {
                String[] data2 = line.split(",");
//                System.out.println(data2[0]);
                if (idList.contains(data2[0])) {
                    if (extraRuns.containsKey(data2[3])) {
                        extraRuns.put(data2[3], extraRuns.get(data2[3]) + Integer.parseInt(data2[16]));
                    } else {
                        extraRuns.put(data2[3], Integer.parseInt(data2[16]));
                    }
                }

            }
            System.out.println(extraRuns);
//            System.out.println(id.get(0));


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {

        }
    }
}

