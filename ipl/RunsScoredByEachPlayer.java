package ipl;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;

public class RunsScoredByEachPlayer
{
    public static void main(String[] args)
    {
 //here declare variable of csv file
        String deliveriesFilePath = "/home/deep/Downloads/deliveries.csv";
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

                 System.out.println(data[0]);

                if (("1").contains(data[0]))
                {
                    System.out.println(data[6]);
                    if (batsmanRuns.containsKey(data[6]))
                    {
                        batsmanRuns.put(data[6], batsmanRuns.get(data[6]) + Integer.parseInt(data[15]));
                    }
                    else
                    {
                        batsmanRuns.put(data[6], Integer.parseInt(data[15]) );
                    }
                }
                else
                {
                    continue;
                }

            }
//print player name and run(hashmap)as batsmanRun ->key & run->value
            System.out.println(batsmanRuns);
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        } catch (IOException e) {

        }

    }
}
