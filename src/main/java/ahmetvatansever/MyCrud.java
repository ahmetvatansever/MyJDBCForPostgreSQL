package ahmetvatansever;

import java.sql.*;

public class MyCrud {

    Connection connection = null;
    Statement statement = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;

    private final String MYDBURL = "jdbc:postgresql://localhost:5432/postgres";
    private final String MYDBUSER = "postgres";
    private final String MYDBPASS = "123456789";


    private boolean isOpenConnection() {
        try {
            connection = DriverManager.getConnection(MYDBURL, MYDBUSER, MYDBPASS);
            return true;
        }catch (Exception e){
            System.out.println("Hata:" + e);
            return false;
        }
    }

    private boolean isCloseConnection() {
        try {
            resultSet.close();
            preparedStatement.close();
            connection.close();
            return true;
        }catch (Exception e){
            System.out.println("Hata:" + e);
            return false;
        }
    }

    public void myExecuteQuery(String pQuery) throws SQLException {
        if(isOpenConnection()){
            System.out.println("-----------------------------------------------");
            System.out.println("Baglanti acildi.");
            try {
                preparedStatement = connection.prepareStatement(pQuery);
                resultSet = preparedStatement.executeQuery();

                while (resultSet.next()) {
                    System.out.println(resultSet.getInt("id") + " " + resultSet.getString("ad"));
                }

            }catch (Exception e){
                System.out.println(e);
            }finally {
                if (isCloseConnection()){
                    System.out.println("Baglanti kapatildi.");
                };
            }
        }
    }

    public void myExecuteUpdate(String pQuery) throws SQLException {
        if(isOpenConnection()){
            System.out.println("-----------------------------------------------");
            System.out.println("Baglanti acildi.");
            try {
                preparedStatement = connection.prepareStatement(pQuery);
                preparedStatement.executeUpdate();


            }catch (Exception e){
                System.out.println(e + " -----> Query:"+ pQuery);
            }finally {
                if (isCloseConnection()){
                    System.out.println("Baglanti kapatildi.");
                };
            }
        }
    }
}
