package ipl;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class TopEconomicalBowlers
{
    public static void main(String[] args)
    {
 //here declare variable of both csv file.
        String matchesFilePath = "/home/deep/Downloads/matches.csv";
        String deliveriesFilePath = "/home/deep/Downloads/deliveries.csv";
        String line = "";


        try
        {
            BufferedReader readFirstFile = new BufferedReader(new FileReader(matchesFilePath));
            readFirstFile.readLine();
            BufferedReader readSecondFile = new BufferedReader(new FileReader(deliveriesFilePath));
            readSecondFile.readLine();
            ArrayList<String> idList = new ArrayList<String>();
            ArrayList<String> teams = new ArrayList<String>();
            HashMap<String, Integer> runs = new HashMap<String, Integer>();
            HashMap<String, Integer> overs = new HashMap<String, Integer>();
            HashMap<String, Float> economy = new HashMap<String, Float>();
            ArrayList<Float> sortedEconomyValues = new ArrayList<Float>();
            LinkedHashMap<String, Float> topEconomyBowlers = new LinkedHashMap<>();


//checked match file is empty or not
            while ((line = readFirstFile.readLine()) != null)
            {
                String[] data = line.split(",");
              //  System.out.println(Arrays.toString(data));
                if (data[1].contains("2015"))
                {
                  //  System.out.println(data);
                    idList.add((data[0]));
                }
            }
//checked delivery file is empty or not
            while ((line = readSecondFile.readLine()) != null)
            {
                String[] data2 = line.split(",");

                //  System.out.println(Arrays.toString(data2));

                if (idList.contains((data2[0])))
                {
                    if (runs.containsKey(data2[8]))
                    {
                        runs.put(data2[8], runs.get(data2[8]) + Integer.parseInt(data2[17]));
                    } else
                    {
                        runs.put(data2[8], Integer.parseInt(data2[17]));
                    }
                }
                if (idList.contains(data2[0]))
                {
                    if (data2[5].contains("6"))
                    {
                        if (overs.containsKey(data2[8]))
                        {
                            overs.put(data2[8], overs.get(data2[8]) + 1);
                        }
                        else
                        {
                            overs.put(data2[8], 1);
                        }
                    }

                }
            }
            for (String val : overs.keySet())
            {
                System.out.println(runs.get(val)/overs.get(val));
                if (runs.containsKey(val)) {
                    System.out.println(runs.get(val) + " " + overs.get(val));
                    economy.put(val, runs.get(val).floatValue() / overs.get(val).floatValue());
                    System.out.println(economy);

                }
            }
            for (Float a : economy.values())
            {
                sortedEconomyValues.add(a);
            }

            Collections.sort(sortedEconomyValues);
            for (Float e : sortedEconomyValues)
            {
                for (String bowlers : economy.keySet())
                {
                    if (economy.get(bowlers) == e)
                    {
                        System.out.println(bowlers + " " + e);
                        topEconomyBowlers.put(bowlers, e);
                    }

                }
                if (topEconomyBowlers.size() == 10) {
                    break;
                }
            }
// here print bowler name and economy(hashmap) as bowler name->key and economy ->value
            System.out.println(topEconomyBowlers);

        } catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (IOException e) {

        }
    }
}
