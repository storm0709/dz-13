import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBReader {
    private final static String URL="jdbc:postgresql://localhost:5432/postgres";
    private final static String USER_NAME="postgres";
    private final static String USER_PASSWORD="postgres";
    private final static String QUERY_SELECT_ALL="select * from dataprovider";
    private final static String QUERY_SELECT_BY_ID="select * from dataprovider where id=?";
    private final static String QUERY_INSERT="insert into dataprovider values (?,?,?)";
    private final static String QUERY_UPDATE="update dataprovider set ageData=?, lastName=? where id=?";
    private final static String QUERY_DELETE="delete from dataprovider where id=?";
    public static List<Data> getAgeFromDB(){
        List<Data> ageData = new ArrayList<>();

       try (Connection connection = DriverManager.getConnection(URL, USER_NAME, USER_PASSWORD)){
           PreparedStatement preparedStatement = connection.prepareStatement(QUERY_SELECT_ALL);
           ResultSet resultSet = preparedStatement.executeQuery();
           while (resultSet.next()){
               Data data = new Data(resultSet.getInt("ageData"), resultSet.getString("lastName"));
               ageData.add(data);
               System.out.println("The Age data is "+resultSet.getInt("ageData")+" The Last name is "
                       +resultSet.getString("lastName"));
           }

       }catch(SQLException exception){
           throw new RuntimeException(String.format("Please check connection string "+"URL [%s]"
                   +" name [%s]"+" pass [%s]", URL, USER_NAME, USER_PASSWORD));

       }
       return ageData;
    }

    public static List<Data> getAgeFromDBById(int id){
        List<Data> ageData = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(URL, USER_NAME, USER_PASSWORD)){
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY_SELECT_BY_ID);
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Data data = new Data(resultSet.getInt("ageData"), resultSet.getString("lastName"));
                ageData.add(data);
                System.out.println("The Age data is "+resultSet.getInt("ageData")+" The Last name is "
                        +resultSet.getString("lastName"));
            }

        }catch(SQLException exception){
            throw new RuntimeException(String.format("Please check connection string "+"URL [%s]"
                    +" name [%s]"+" pass [%s]", URL, USER_NAME, USER_PASSWORD));

        }
        return ageData;
    }
    public static void insertAgeToDB(int id, int ageData, String lastName){
        try (Connection connection = DriverManager.getConnection(URL, USER_NAME, USER_PASSWORD)){
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY_INSERT);
            preparedStatement.setInt(1, id);
            preparedStatement.setInt(2, ageData);
            preparedStatement.setString(3, lastName);
            preparedStatement.executeUpdate();

        }catch(SQLException exception){
            throw new RuntimeException(String.format("Please check connection string "+"URL [%s]"
                    +" name [%s]"+" pass [%s]", URL, USER_NAME, USER_PASSWORD));

        }
    }
    public static void updateAgeInDB(int id, int ageData, String lastName){
        try (Connection connection = DriverManager.getConnection(URL, USER_NAME, USER_PASSWORD)){
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY_UPDATE);
            preparedStatement.setInt(1, ageData);
            preparedStatement.setString(2, lastName);
            preparedStatement.setInt(3, id);
            preparedStatement.executeUpdate();

        }catch(SQLException exception){
            throw new RuntimeException(String.format("Please check connection string "+"URL [%s]"
                    +" name [%s]"+" pass [%s]", URL, USER_NAME, USER_PASSWORD));

        }
    }
    public static void deleteAgeFromDB(int id){
        try (Connection connection = DriverManager.getConnection(URL, USER_NAME, USER_PASSWORD)){
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY_DELETE);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

        }catch(SQLException exception){
            throw new RuntimeException(String.format("Please check connection string "+"URL [%s]"
                    +" name [%s]"+" pass [%s]", URL, USER_NAME, USER_PASSWORD));

        }
    }

    public static void main(String[] args) {
//        insertAgeToDB(7,70, "70");
//        updateAgeInDB(7,90, "John");
        deleteAgeFromDB(7);
//        getAgeFromDBById(5);
//        getAgeFromDB();
    }
}
