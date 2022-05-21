

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.*;

public class MatchPlayedperyear {
    public static void main(String[] args) {
        String MatchesFilePath = "/home/deep/Downloads/matches.csv";
        String line = "";
        int count = 0;
        try {
            BufferedReader readFile = new BufferedReader(new FileReader(MatchesFilePath));
            readFile.readLine();
            HashMap<String, Integer> years = new HashMap<String, Integer>();
            while ((line = readFile.readLine()) != null) {
                String[] data = line.split(" ,");
                  System.out.println(data);
                if (years.containsKey(data[1]))
                {
                    years.put(data[1], count += 1);
                }
                  else
                  {

                    years.put(data[1], count = 1);

                }
            }

            System.out.println(years);
        }

           catch (FileNotFoundException e) {
            e.printStackTrace();
        }
               catch (IOException e)

               {

        }
    }
}
