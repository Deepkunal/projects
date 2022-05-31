import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main
{
    public static void main(String[] args)
    {
        System.out.println("matchPlayedPerYear");
        matchPlayedperYear();

        System.out.println("matchWonByAllTeam");
        matchesWonByAllTeam();

        System.out.println("runScoreByEachPlayer");
        runScoreByEachPlayer();

        System.out.println("topEconomicalBowler");
        topEconomicalBowlers();

        System.out.println("extraRunConcededPerTeam");
        extraRunConcededPerTeam();

    }
    public static void matchPlayedperYear()
    {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");

            System.out.println("Driver loaded");
            Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/IPLPROJECT","root","Deep@12345");

            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery("SELECT seasons, count(*) FROM matches group by seasons;");


            while (rs.next())
            {
                System.out.println(rs.getString(1)+":"+rs.getInt(2));
            }


            System.out.println("matchPlayedPerYear");
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }

    //matchWonByAllTeam

    public static void matchesWonByAllTeam()
    {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");

            System.out.println("Driver loaded");
            Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/IPLPROJECT","root","Deep@12345");

            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery("SELECT winner, count(*) FROM matches group by winner;");


            while (rs.next())
            {
                System.out.println(rs.getString(1)+":"+rs.getInt(2));
            }


        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }

    //extraRunConcededPerTeam

    public static void   extraRunConcededPerTeam()
    {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");

            System.out.println("Driver loaded");
            Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/IPLPROJECT","root","Deep@12345");

            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery("select bowling_team,sum(extra_runs) from delivery where match_id in (select match_id from matches where seasons=\"2017\") group by bowling_team;");


            while (rs.next())
            {
                System.out.println(rs.getString(1)+":"+rs.getInt(2));
            }



        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }

    //runScoredByEachPlayer

    public static void   runScoreByEachPlayer()
    {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");

            System.out.println("Driver loaded");
            Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/IPLPROJECT","root","Deep@12345");

            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery("SELECT batsman,sum(batsman_runs) FROM delivery group by batsman;");


            while (rs.next())
            {
                System.out.println(rs.getString(1)+":"+rs.getInt(2));
            }


        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }

    //  topEconomicalBowlers
    public static void topEconomicalBowlers()
    {

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");

            System.out.println("Driver loaded");
            Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/IPLPROJECT","root","Deep@12345");

            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery("select bowler,sum(total_runs) from delivery where match_id in (select id from matches where seasons=\"2017\") group by bowler;");

            while (rs.next())
            {
                System.out.println(rs.getString(1)+":"+rs.getInt(2));
            }


        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }
}

