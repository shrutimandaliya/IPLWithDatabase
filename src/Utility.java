interface Utility {

    public String URL="jdbc:postgresql://127.0.0.1:5432/ipl";
    public String USERNAME="shruti";
    public String PASSWORD="root";

    public String QUERY1="select season,count(season)from matches group by season order by season";
    public String QUERY2="select winner,count(winner)from matches group by winner";
    public String QUERY3="select bowling_team,sum(cast(extra_runs as int)) from deliveries " +
            "where match_id in (select id from matches where season=' 2016 ') group by bowling_team;";
    public String QUERY4="select over.bowler,over.total_runs/ball_count.ball as ave\n" +
            "from(select bowler,sum(cast(total_runs as numeric)) as total_runs\n" +
            "\t\tfrom deliveries\n" +
            "\t\twhere match_id in(select id from matches where season=' 2015 ')group by bowler) as over,\n" +
            "\t(select bowler,count(ball)/6 as ball\n" +
            "\t\tfrom deliveries\n" +
            "\t\twhere match_id in(select id from matches where season=' 2015 ' ) and noball_runs=' 0 ' and " +
            "wide_runs=' 0 '\n" +
            "\t\tgroup by bowler) as ball_count\n" +
            "where over.bowler=ball_count.bowler \n" +
            "order by ave\n" +
            "limit 1\n";

}
