import java.sql.*;

public class Main implements Utility {
    public static void main(String[] args) throws SQLException {

        numOfMatchesPlayedPerYear(QUERY1);
        numOfMatchesWonByTeams(QUERY2);
        extraRunsConcededPerTeamIn2016(QUERY3);
        topEconomicalBowlersIn2015(QUERY4);
    }

    public static void numOfMatchesPlayedPerYear(String QUERY1) throws SQLException {

        Connection con=connection();
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(QUERY1);

        while (rs.next()) {
            System.out.print(rs.getString(1) + "= " + rs.getInt(2) + ",");
        }
        con.close();
        System.out.println();
    }

    public static void numOfMatchesWonByTeams(String QUERY2) throws SQLException {

        Connection con=connection();
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(QUERY2);
        while (rs.next()) {
            System.out.print(rs.getString(1) + "= " + rs.getInt(2) + ",");
        }
        con.close();
        System.out.println();
    }

    public static void extraRunsConcededPerTeamIn2016(String QUERY3) throws SQLException {

        Connection con=connection();
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(QUERY3);
        while (rs.next()) {
            System.out.print(rs.getString(1) + "= " + rs.getInt(2) + ",");
        }
        con.close();
        System.out.println();
    }

    public static void topEconomicalBowlersIn2015(String QUERY4) throws SQLException {

        Connection con=connection();
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(QUERY4);
        while (rs.next()) {
            System.out.print(rs.getString(1) + "= " + rs.getInt(2) + ",");
        }
        con.close();
    }

    public static Connection connection() throws SQLException {

        Connection con = DriverManager.getConnection(URL,USERNAME,PASSWORD);
        return con;

    }
}
