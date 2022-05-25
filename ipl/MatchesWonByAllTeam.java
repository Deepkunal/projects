package ipl;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

class MatchesWonAllTeam
{
    public static void main(String[] args)
    {
 //here declare variable of scv file
        String matchesFilePath = "/home/deep/Downloads/matches.csv";
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
                 //
               System.out.println(data[10]);
                 if (data[10].isEmpty())
                 {
                       System.out.println(data[10] + "data");
                         continue;
                }
                  else if (teams.containsKey(data[10]))
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
        catch(IOException e)
        {

        }
    }
}
