import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Execution {
    public void create(Connection connection, String sql){
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            int rs = preparedStatement.executeUpdate();
            if(rs == 0){
                System.out.println("Table Created!!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void update(Connection connection, String sql, int id, String name, int age){
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, id);
            preparedStatement.setString(2,name);
            preparedStatement.setInt(3,age);

            preparedStatement.executeUpdate();

            System.out.println("Records added!");
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void read(Connection connection, String sql){
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                int age = resultSet.getInt(3);

                System.out.println(id +" "+ name +" "+ age);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void delete(Connection connection, String sql){
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.executeUpdate();
            System.out.println("Record deleted!");
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
