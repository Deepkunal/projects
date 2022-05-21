import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class TopEconomicalBowlers {
    public static void main(String[] args) {
        String MatchesFilePath = "/home/deep/Downloads/matches.csv";
        String DeliveriesFilePath = "/home/deep/Downloads/deliveries.csv";
        String line = "";
        try {
            BufferedReader readFirstFile = new BufferedReader(new FileReader(MatchesFilePath));
            readFirstFile.readLine();
            BufferedReader readSecondFile = new BufferedReader(new FileReader(DeliveriesFilePath));
            readSecondFile.readLine();
            ArrayList<String> idList = new ArrayList<String>();
            ArrayList<String> teams = new ArrayList<String>();
            HashMap<String, Integer> runs = new HashMap<String, Integer>();
            HashMap<String, Integer> overs = new HashMap<String, Integer>();
            HashMap<String, Float> economy = new HashMap<String, Float>();
            ArrayList<Float> sortedEconomyValues = new ArrayList<Float>();
            LinkedHashMap<String, Float> topEconomyBowlers = new LinkedHashMap<>();
            while ((line = readFirstFile.readLine()) != null) {
                String[] data = line.split(",");
//                System.out.println(Arrays.toString(data));
                if (data[1].contains("2015")) {
//                    System.out.println(i);
                    idList.add((data[0]));
                }
            }
            while ((line = readSecondFile.readLine()) != null) {
                String[] data2 = line.split(",");
//                System.out.println(Arrays.toString(data2));
                if (idList.contains((data2[0]))) {
                    if (runs.containsKey(data2[8])) {
                        runs.put(data2[8], runs.get(data2[8]) + Integer.parseInt(data2[17]));
                    } else {
                        runs.put(data2[8], Integer.parseInt(data2[17]));
                    }
                }
                if (idList.contains(data2[0])) {
                    if (data2[5].contains("6")) {
                        if (overs.containsKey(data2[8])) {
                            overs.put(data2[8], overs.get(data2[8]) + 1);
                        } else {
                            overs.put(data2[8], 1);
                        }
                    }

                }
            }
            for (String val : overs.keySet()) {
//    System.out.println(runs.get(val)/overs.get(val));
                if (runs.containsKey(val)) {
//                    System.out.println(runs.get(val) + " " + overs.get(val));
                    economy.put(val, runs.get(val).floatValue() / overs.get(val).floatValue());
//                    System.out.println(economy);
//


                }
            }
            for (Float a : economy.values()) {
                sortedEconomyValues.add(a);
            }


            Collections.sort(sortedEconomyValues);
            for (Float e : sortedEconomyValues) {
                for (String bowlers : economy.keySet()) {
                    if (economy.get(bowlers) == e) {
//                        System.out.println(bowlers + " " + e);
                        topEconomyBowlers.put(bowlers, e);
                    }

                }
                if (topEconomyBowlers.size() == 10) {
                    break;
                }
            }

            System.out.println(topEconomyBowlers);

//            System.out.println(runs.size()+" "+overs.size());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {

        }
    }
}
