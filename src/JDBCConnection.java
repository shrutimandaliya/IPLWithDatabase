import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.*;

public class JDBCConnection {

    private static final int ID_INDEX =0 ;
    private static final int SEASON_INDEX = 1;
    private static final int CITY_INDEX = 2;
    private static final int DATE_INDEX = 3;
    private static final int TEAM1_INDEX = 4;
    private static final int TEAM2_INDEX = 5;
    private static final int TOSS_WINNER_INDEX = 6;
    private static final int TOSS_DECISION_INDEX = 7;
    private static final int RESULT_INDEX = 8;
    private static final int DL_APPLIED_INDEX = 9;
    private static final int WINNER_INDEX = 10;
    private static final int WIN_BY_RUN_INDEX = 11;
    private static final int WIN_BY_WICKETS_INDEX = 12;
    private static final int PLAYER_OF_MATCH_INDEX = 13;
    private static final int VENUE_INDEX = 14;
    private static final int UMPIRE1_INDEX = 15;
    private static final int UMPIRE2_INDEX = 16;


    private static final int MATCH_ID_INDEX = 0;
    private static final int INNING_INDEX = 1;
    private static final int BATTING_TEAM_INDEX = 2;
    private static final int BOWLING_TEAM_INDEX = 3;
    private static final int OVER_INDEX = 4;
    private static final int BALL_INDEX = 5;
    private static final int BATSMAN_INDEX = 6;
    private static final int NON_STRIKER_INDEX = 7;
    private static final int BOWLER_INDEX = 8;
    private static final int IS_SUPER_OVER_INDEX = 9;
    private static final int WIDE_RUNS_INDEX = 10;
    private static final int BYE_RUNS_INDEX = 11;
    private static final int LEG_BYE_RUNS_INDEX = 12;
    private static final int NO_BALL_INDEX = 13;
    private static final int PENALTY_RUNS_INDEX = 14;
    private static final int BATSMAN_RUNS_INDEX = 15;
    private static final int EXTRA_RUNS_INDEX = 16;
    private static final int TOTAL_RUNS_INDEX = 17;
    private static final int PLAYER_DISMISSED_INDEX = 18;
    private static final int DISSMISSAL_KIND_INDEX = 19;
    private static final int FIELDER_INDEX = 20;

    public void connection(){

//        try{
//            Connection con=DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/ipl",
//                    "shruti","root");
//            String filePath= "matches.csv";
//            BufferedReader fileReader = new BufferedReader(new FileReader(filePath));
//
//
//            String firstLine = fileReader.readLine();
//
//            String line = "";
//            while ((line = fileReader.readLine()) != null) {
//
////                System.out.println(line);
//                String[] row = line.replaceAll(","," , ")
//                        .split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
//                String query="insert into matches values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
//
//                PreparedStatement ps=con.prepareStatement(query);
//
//                ps.setString(1,row[ID_INDEX]);
//                ps.setString(2,row[SEASON_INDEX]);
//                ps.setString(3,row[CITY_INDEX]);
//                ps.setString(4,row[DATE_INDEX]);
//                ps.setString(5,row[TEAM1_INDEX]);
//                ps.setString(6,row[TEAM2_INDEX]);
//                ps.setString(7,row[TOSS_WINNER_INDEX]);
//                ps.setString(8,row[TOSS_DECISION_INDEX]);
//                ps.setString(9,row[RESULT_INDEX]);
//                ps.setString(10,row[DL_APPLIED_INDEX]);
//                ps.setString(11,row[WINNER_INDEX]);
//                ps.setString(12,row[WIN_BY_RUN_INDEX]);
//                ps.setString(13,row[WIN_BY_WICKETS_INDEX]);
//                ps.setString(14,row[PLAYER_OF_MATCH_INDEX]);
//                ps.setString(15,row[VENUE_INDEX]);
//                ps.setString(16,row[UMPIRE1_INDEX]);
//                ps.setString(17,row[UMPIRE2_INDEX]);
//                ps.setString(18,"");
//
//                ps.executeUpdate();
//
//            }
//            System.out.println("Success");
//
//        }catch (Exception e)
//        {
//           e.printStackTrace();
//        }

     try{
         Connection con=DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/ipl",
                 "shruti","root");
         String filePath= "deliveries.csv";
         BufferedReader fileReader = new BufferedReader(new FileReader(filePath));


         String firstLine = fileReader.readLine();

         String line = "";
         while ((line = fileReader.readLine()) != null) {

//                System.out.println(line);
             String[] row = line.replaceAll(",", " , ")
                     .split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
             String query = "insert into deliveries values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

             PreparedStatement ps = con.prepareStatement(query);
             ps.setString(1,row[MATCH_ID_INDEX]);
             ps.setString(2,row[INNING_INDEX]);
             ps.setString(3,row[BATTING_TEAM_INDEX]);
             ps.setString(4,row[BOWLING_TEAM_INDEX]);
             ps.setString(5,row[OVER_INDEX]);
             ps.setString(6,row[BALL_INDEX]);
             ps.setString(7,row[BATSMAN_INDEX]);
             ps.setString(8,row[NON_STRIKER_INDEX]);
             ps.setString(9,row[BOWLER_INDEX]);
             ps.setString(10,row[IS_SUPER_OVER_INDEX]);
             ps.setString(11,row[WIDE_RUNS_INDEX]);
             ps.setString(12,row[BYE_RUNS_INDEX]);
             ps.setString(13,row[LEG_BYE_RUNS_INDEX]);
             ps.setString(14,row[NO_BALL_INDEX]);
             ps.setString(15,row[PENALTY_RUNS_INDEX]);
             ps.setString(16,row[BATSMAN_RUNS_INDEX]);
             ps.setString(17,row[EXTRA_RUNS_INDEX]);
             ps.setString(18,row[TOTAL_RUNS_INDEX]);
             ps.setString(19,row[PLAYER_DISMISSED_INDEX]);
             ps.setString(20,row[DISSMISSAL_KIND_INDEX]);
             ps.setString(21,row[FIELDER_INDEX]);
             ps.executeUpdate();
         }
         System.out.println("Success");

     }catch (Exception e)
     {
//         System.out.println("Exception");
         e.printStackTrace();
     }
    }


}





