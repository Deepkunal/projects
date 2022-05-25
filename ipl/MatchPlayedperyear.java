package ipl;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class MatchPlayedperyear
{
    public static void main(String[] args)
    {
 //here declare variable of scv file.
        String MatchesFilePath = "/home/deep/Downloads/matches.csv";
        String line = "";
        int count = 0;


        try
        {
            BufferedReader readFile = new BufferedReader(new FileReader(MatchesFilePath));
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
                }
                else
                {
                    years.put(data[1], count = 1);
                }
            }
 //printing year(hashmap)as year->key & no of game->value
            System.out.println(years);
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        } catch (IOException e) {

        }
    }
}
