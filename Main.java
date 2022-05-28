package ipl;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class Main
{

    public static void main(String[] args)
    {
        String matchesFilePath = "/home/deep/Downloads/matches.csv";
        String deliveriesFilePath = "/home/deep/Downloads/deliveries.csv";
        System.out.println("Match played per year");
        System.out.println("===============================================");
        matchPlayedPerYear(matchesFilePath);
        System.out.println();
        System.out.println("Match Won By All Team");
        System.out.println("===============================================");
        matchesWonByAllTeam(matchesFilePath);
        System.out.println();
        System.out.println("Extra Run Conceded per Team");
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++");
        extraRunConcededPerTeam(deliveriesFilePath, matchesFilePath);
        System.out.println();
        System.out.println("Run score By each player");
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++");
        runScoreByEachPlayer(deliveriesFilePath);
        System.out.println();
        System.out.println("Top Economical Bowlers");
        System.out.println("**************************************************");
        topEconomicalBowlers(deliveriesFilePath, matchesFilePath);
        System.out.println("**************************************************");

    }


    //ExtraRunConcededperteam
    public static void extraRunConcededPerTeam(String deliveriesFilePath, String matchesFilePath)
    {

        String line = "";


        try
        {
            BufferedReader readFile = new BufferedReader(new FileReader(deliveriesFilePath));
            readFile.readLine();
            LinkedHashMap<String, Integer> batsmanRuns = new LinkedHashMap<>();
            ArrayList<String> batsman = new ArrayList<>();


//here checked delivery of first line is empty or not

            while ((line = readFile.readLine()) != null)
            {
                String[] data = line.split(",");

               // System.out.println(data[0]);

                if (("1").contains(data[0]))
                {
                    //System.out.println(data[6]);
                    if (batsmanRuns.containsKey(data[6]))
                    {
                        batsmanRuns.put(data[6], batsmanRuns.get(data[6]) + Integer.parseInt(data[15]));
                    }
                    else
                    {
                        batsmanRuns.put(data[6], Integer.parseInt(data[15]));
                    }
                }
                else
                {
                    continue;
                }

            }
//print player name and run(hashmap)as batsmanRun ->key & run->value
            System.out.println(batsmanRuns);
        } catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch
        (IOException e)
        {

        }
    }


    //MatchWonByAllTeam
    public static void matchesWonByAllTeam(String matchesFilePath)
    {
        String line = "";
        int count = 0;
        try
        {
            BufferedReader readFile = new BufferedReader(new FileReader(matchesFilePath));
            readFile.readLine();
            HashMap<String, Integer> teams = new HashMap<String, Integer>();


//here checked match file is empty or not

            while ((line = readFile.readLine()) != null)
            {
                String[] data = line.split(",");

                //System.out.println(data[10]);
                if (data[10].isEmpty())
                {
                    //System.out.println(data[10] + "data");
                    continue;
                } else if (teams.containsKey(data[10]))
                {
                    teams.put(data[10], teams.get(data[10]) + 1);
                }
                else
                {
                    teams.put(data[10], count = 1);

                }

            }
            System.out.println(teams);

        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();

        }
        catch (IOException e)
        {

        }
    }

//match played per year
    public static void matchPlayedPerYear(String matchesFilePath)
    {


        String line = "";
        int count = 0;


        try
        {
            BufferedReader readFile = new BufferedReader(new FileReader(matchesFilePath));
            readFile.readLine();
            HashMap<String, Integer> years = new HashMap<String, Integer>();


//here i checked match file is empty or not
            while ((line = readFile.readLine()) != null)
            {
                String[] data = line.split(",");
                //System.out.println(data);
                if (years.containsKey(data[1]))
                {
                    years.put(data[1], count += 1);
                } else {
                    years.put(data[1], count = 1);
                }
            }
            //printing year(hashmap)as year->key & no of game->value
            System.out.println(years);
        } catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (IOException e) {

        }
    }

    //TopEconomicalBowlers
    public static void topEconomicalBowlers(String deliveriesFilePath, String matchesFilePath) {

        String line = "";


        try {
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
            while ((line = readFirstFile.readLine()) != null) {
                String[] data = line.split(",");
                //  System.out.println(Arrays.toString(data));
                if (data[1].contains("2015")) {
                    //  System.out.println(data);
                    idList.add((data[0]));
                }
            }
//checked delivery file is empty or not
            while ((line = readSecondFile.readLine()) != null) {
                String[] data2 = line.split(",");

                //  System.out.println(Arrays.toString(data2));

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
                //System.out.println(runs.get(val) / overs.get(val));
                if (runs.containsKey(val)) {
                    //System.out.println(runs.get(val) + " " + overs.get(val));
                    economy.put(val, runs.get(val).floatValue() / overs.get(val).floatValue());
                    //System.out.println(economy);

                }
            }
            for (Float a : economy.values()) {
                sortedEconomyValues.add(a);
            }

            Collections.sort(sortedEconomyValues);
            for (Float e : sortedEconomyValues) {
                for (String bowlers : economy.keySet()) {
                    if (economy.get(bowlers) == e) {
                        //System.out.println(bowlers + " " + e);
                        topEconomyBowlers.put(bowlers, e);
                    }

                }
                if (topEconomyBowlers.size() == 10) {
                    break;
                }
            }
// here print bowler name and economy(hashmap) as bowler name->key and economy ->value
            System.out.println(topEconomyBowlers);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {

        }

    }

    //runscorebyeachplayer
    public static void runScoreByEachPlayer(String deliveriesFilePath) {
        String line = "";


        try {
            BufferedReader readFile = new BufferedReader(new FileReader(deliveriesFilePath));
            readFile.readLine();
            LinkedHashMap<String, Integer> batsmanRuns = new LinkedHashMap<>();
            ArrayList<String> batsman = new ArrayList<>();


//here checked delivery of first line is empty or not

            while ((line = readFile.readLine()) != null) {
                String[] data = line.split(",");

                //System.out.println(data[0]);

                if (("1").contains(data[0])) {
                    //System.out.println(data[6]);
                    if (batsmanRuns.containsKey(data[6])) {
                        batsmanRuns.put(data[6], batsmanRuns.get(data[6]) + Integer.parseInt(data[15]));
                    } else {
                        batsmanRuns.put(data[6], Integer.parseInt(data[15]));
                    }
                } else {
                    continue;
                }

            }
//print player name and run(hashmap)as batsmanRun ->key & run->value
            System.out.println(batsmanRuns);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {

        }

    }
}


