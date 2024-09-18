import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        try{
            String createQuery = "create table school(id int, name varchar(50), age int);";
            String updateQuery = "insert into school(id, name, age) values(?, ?, ?)";
            String readQuery = "select * from school";
            String deleteQuery = "delete from school where id = 1";

            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/world",
                    "root", "aditya1234");

            Execution obj = new Execution();
            obj.create(connection, createQuery);
            obj.update(connection, updateQuery, 1, "ram", 50);
            obj.read(connection, readQuery);
            obj.delete(connection, deleteQuery);



        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}