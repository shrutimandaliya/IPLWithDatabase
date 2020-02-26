import java.sql.*;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {
//        JDBCConnection jd=new JDBCConnection();
//        jd.connection();
        numOfMatchesPlayedPerYear();
        numOfMatchesWonByTeams();
        extraRunsConcededPerTeamIn2016();
        topEconomicalBowlersIn2015();
    }

    public static void numOfMatchesPlayedPerYear() throws SQLException {
        Connection con = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/ipl",
                "shruti", "root");
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("select season,count(season)from matches group by season order by season");
        while (rs.next()) {
            System.out.print(rs.getString(1) + "= " + rs.getInt(2) + ",");
        }
        System.out.println();
        con.close();
    }

    public static void numOfMatchesWonByTeams() throws SQLException {
        Connection con = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/ipl",
                "shruti", "root");
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("select winner,count(winner)from matches group by winner");
        while (rs.next()) {
            System.out.print(rs.getString(1) + "= " + rs.getInt(2) + ",");
        }
        con.close();
        System.out.println();
    }

    public static void extraRunsConcededPerTeamIn2016() throws SQLException {
        Connection con = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/ipl",
                "shruti", "root");
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("select bowling_team,sum(cast(extra_runs as int)) from deliveries " +
                "where match_id in (select id from matches where season=' 2016 ') group by bowling_team;");
        while (rs.next()) {
            System.out.print(rs.getString(1) + "= " + rs.getInt(2) + ",");
        }
        con.close();
        System.out.println();
    }

    public static void topEconomicalBowlersIn2015() throws SQLException {
        Connection con = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/ipl",
                "shruti", "root");
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("select over.bowler,over.total_runs/ball_count.ball as ave\n" +
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
                "limit 1\n");
        while (rs.next()) {
            System.out.print(rs.getString(1) + "= " + rs.getInt(2) + ",");
        }
        con.close();
    }
}
