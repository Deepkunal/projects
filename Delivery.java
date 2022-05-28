package ipl;

public class Delivery
{

    private int match_id;
    private String inning;
    private String batting_team;
    private String bowling_team;
    private String over;
    private String ball;
    private String batsman;

    private String non_striker;
    private String bowler;
    private String is_super_over;

    public int getMatch_id()
    {
        return match_id;
    }

    public void setMatch_id(int match_id)
    {
        this.match_id = match_id;
    }

    public String getInning()
    {
        return inning;
    }

    public void setInning(String inning)
    {
        this.inning = inning;
    }

    public String getBatting_team()
    {
        return batting_team;
    }

    public void setBatting_team(String batting_team)
    {
        this.batting_team = batting_team;
    }

    public String getBowling_team()
    {
        return bowling_team;
    }

    public void setBowling_team(String bowling_team)
    {
        this.bowling_team = bowling_team;
    }

    public String getOver()
    {
        return over;
    }

    public void setOver(String over)
    {
        this.over = over;
    }

    public String getBall()
    {
        return ball;
    }

    public void setBall(String ball)
    {
        this.ball = ball;
    }

    public String getBatsman()
    {
        return batsman;
    }

    public void setBatsman(String batsman)
    {
        this.batsman = batsman;
    }

    public String getNon_string() {
        return non_striker;
    }

    public void setNon_string(String non_string) {
        this.non_striker = non_string;
    }

    public String getBowler() {
        return bowler;
    }

    public void setBowler(String bowler) {
        this.bowler = bowler;
    }

    public String getIs_super_over()
    {
        return is_super_over;
    }

    public void setIs_super_over(String is_super_over)
    {
        this.is_super_over = is_super_over;
    }

    public String getWide_runs()
    {
        return wide_runs;
    }

    public void setWide_runs(String wide_runs)
    {
        this.wide_runs = wide_runs;
    }

    public String getBye_runs()
    {
        return bye_runs;
    }

    public void setBye_runs(String bye_runs)
    {
        this.bye_runs = bye_runs;
    }

    public String getLeg_bye_run() {
        return leg_bye_run;
    }

    public void setLeg_bye_run(String leg_bye_run)
    {
        this.leg_bye_run = leg_bye_run;
    }

    public String getNo_ball_runs()
    {
        return no_ball_runs;
    }

    public void setNo_ball_runs(String no_ball_runs)
    {
        this.no_ball_runs = no_ball_runs;
    }

    public String getPenalty_runs()
    {
        return penalty_runs;
    }

    public void setPenalty_runs(String penalty_runs)
    {
        this.penalty_runs = penalty_runs;
    }

    public String getBats_man_run()
    {
        return bats_man_run;
    }

    public void setBats_man_run(String bats_man_run)
    {
        this.bats_man_run = bats_man_run;
    }

    public String getExtra_runs() {
        return extra_runs;
    }

    public void setExtra_runs(String extra_runs)
    {
        this.extra_runs = extra_runs;
    }

    public String getTotal_runs()
    {
        return total_runs;
    }

    public void setTotal_runs(String total_runs)
    {
        this.total_runs = total_runs;
    }

    private String wide_runs;
    private String bye_runs;
    private String leg_bye_run;
    private String no_ball_runs;
    private String penalty_runs;
    private String bats_man_run;
    private String extra_runs;
    private String total_runs;
}