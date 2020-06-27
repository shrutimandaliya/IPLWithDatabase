package com.mountblue;

import static com.mountblue.Utility.*;
import java.sql.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws SQLException {

        outPut(numOfMatchesPlayedPerYear(QUERY1));
        outPut(numOfMatchesWonByTeams(QUERY2));
        outPut(extraRunsConcededPerTeamIn2016(QUERY3));
        outPut(topEconomicalBowlersIn2015(QUERY4));
    }

    public static LinkedHashMap<String, Integer> numOfMatchesPlayedPerYear(String QUERY1) throws SQLException {

        LinkedHashMap<String,Integer>  totalMatches=new LinkedHashMap<String,Integer>();
        Connection con=connection();
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(QUERY1);

        while (rs.next()) {
            totalMatches.put(rs.getString(1),rs.getInt(2));
        }
        return totalMatches;



    }

    public static LinkedHashMap<String,Integer> numOfMatchesWonByTeams(String QUERY2) throws SQLException {

        LinkedHashMap<String,Integer>  winnigMatch=new LinkedHashMap<String,Integer>();

        Connection con=connection();
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(QUERY2);
        while (rs.next()) {
            winnigMatch.put(rs.getString(1),rs.getInt(2));
        }
        return winnigMatch;
    }

    public static LinkedHashMap<String, Integer> extraRunsConcededPerTeamIn2016(String QUERY3) throws SQLException {

        LinkedHashMap<String,Integer>  extraRuns=new LinkedHashMap<String,Integer>();

        Connection con=connection();
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(QUERY3);
        while (rs.next()) {
            extraRuns.put(rs.getString(1),rs.getInt(2));
        }
        return extraRuns;
    }

    public static LinkedHashMap<String, Integer> topEconomicalBowlersIn2015(String QUERY4) throws SQLException {

        LinkedHashMap<String,Integer>  economicalBowlers=new LinkedHashMap<String,Integer>();

        Connection con=connection();
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(QUERY4);
        while (rs.next()) {
            economicalBowlers.put(rs.getString(1),rs.getInt(2));
        }
        return economicalBowlers;
    }

    public static Connection connection() throws SQLException {

        Connection con = DriverManager.getConnection(URL,USERNAME,PASSWORD);
        return con;
    }

    public static void outPut(LinkedHashMap map) throws SQLException {
        for (Object key:map.keySet())
        {
            System.out.print(key+"= "+map.get(key));
        }
        System.out.println();
    }
}
