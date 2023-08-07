import java.sql.*;

public class Sql {
    public static void main(String[] args) {
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/info", "root", "abs1231231234");
            System.out.println(con);
            Statement statement = con.createStatement();
            String create_table = "CREATE TABLE IF NOT EXISTS info (Id INT PRIMARY KEY, name VARCHAR(20), age INT)";
            String insert_values = "INSERT IGNORE info (id, name, age) VALUES(1, 'nick', 15),(2, 'mike', 17),(3, 'json', 18)";
            String truncate_table = "TRUNCATE TABLE info";
            statement.executeUpdate(create_table);
            System.out.println("Таблица успешно создана");
            statement.executeUpdate(truncate_table);
            System.out.println("Таблица успешно отчищенна");
            statement.executeUpdate(insert_values);
            System.out.println("Данные успешно занесены в таблицу");
            ResultSet select_from = statement.executeQuery("SELECT * FROM info");
            System.out.println("Данные из таблицы");
            while(select_from.next()) {
                int id = select_from.getInt(1);
                String name = select_from.getString(2);
                int age = select_from.getInt(3);
                System.out.println(id + ". " + name + " " + age);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}