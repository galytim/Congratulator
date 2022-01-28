import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class MySQLAction
{
    private static String username = "root";
    private static String password = "G8c5s1g8c5s1";
    private static String URL = "jdbc:mysql://localhost:3306/myshema";

    public static void createTable() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");

    try(Connection connection = DriverManager.getConnection(URL,username,password) ; Statement statement = connection.createStatement())
    {
        statement.executeUpdate( "CREATE TABLE IF NOT EXISTS list  (id INT NOT NULL  PRIMARY KEY auto_increment,name VARCHAR(80) NOT NULL,year INT NOT NULL, month INT NOT NULL, day INT NOT NULL);");
        System.out.println("Таблица создана");
        }catch (SQLException exception){
        System.out.println("Произошла ошибка");
    }
    }
    public static void dropTable() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
            try(Connection connection = DriverManager.getConnection(URL,username,password) ; Statement statement = connection.createStatement())
            {
                statement.executeUpdate( "DROP TABLE if EXISTS list");
                System.out.println("Таблица была удалена");
            }catch (SQLException exception){
                System.out.println("Произошла ошибка");
            }
        }
    public static void insert(Person person) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        try (Connection connection = DriverManager.getConnection(URL, username, password); Statement statement = connection.createStatement()) {
            statement.executeUpdate("INSERT INTO list (name,year,month,day) values('" + person.getName() + "'," + person.getYear() + "," + person.getMonth() + "," + person.getDay() + ");");
            System.out.println("Запись добавлена в талбицу");

        }catch (SQLException exception){
            System.out.println("Произошла ошибка");
        }
    }
    public static void delete() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        try (Connection connection = DriverManager.getConnection(URL, username, password);Statement statement = connection.createStatement()) {
            System.out.println("Введите id для удаления: ");
            int id = IO.readInt();
            statement.executeUpdate("DELETE FROM list WHERE id = "+id+";");
            System.out.println("Запись удалена");
        }catch (SQLException exception){
            System.out.println("Произошла ошибка");
        }

    }
    public static void updateName() throws SQLException, ClassNotFoundException, IOException {
        Class.forName("com.mysql.jdbc.Driver");
        try (Connection connection = DriverManager.getConnection(URL, username, password);Statement statement = connection.createStatement()) {
            System.out.println("Введите id для редактирования");
            int id = IO.readInt();
            System.out.println("Введите имя");
            statement.executeUpdate("UPDATE list SET name = '"+IO.readString()+"' WHERE id = "+id+";");
            System.out.println("ФИО обновлено");
        }catch (SQLException exception){
            System.out.println("Произошла ошибка");
        }

    }
    public static void updateDate() throws SQLException, ClassNotFoundException, IOException {
        Class.forName("com.mysql.jdbc.Driver");

        try (Connection connection = DriverManager.getConnection(URL, username, password);Statement statement = connection.createStatement()) {
            System.out.println("Введите id для редактирования");
            int id = IO.readInt();
            System.out.println("Введите день");
            int day = IO.readInt();
            System.out.println("Введите месяц");
            int month = IO.readInt();
            System.out.println("Введите год");
            int year = IO.readInt();
            statement.executeUpdate("UPDATE list SET day = "+day+" WHERE id ="+id+";");
            statement.executeUpdate("UPDATE list SET month = "+month+" WHERE id ="+id+";");
            statement.executeUpdate("UPDATE list SET year = "+year+" WHERE id ="+id+";");
            System.out.println("Дата обновлена");
        }catch (SQLException exception){
            System.out.println("Произошла ошибка");
        }

    }
    public static void showAllList() throws SQLException, ClassNotFoundException, IOException {
        Class.forName("com.mysql.jdbc.Driver");

        try (Connection connection = DriverManager.getConnection(URL, username, password); Statement statement = connection.createStatement()) {
            ResultSet rs = statement.executeQuery("Select * FROM list");
            List <Person> list = new ArrayList<>();
            while (rs.next()) {
                Person person = new Person();
                person.setId(rs.getInt("id"));
                person.setDay(rs.getInt("day"));
                person.setMonth(rs.getInt("month"));
                person.setYear(rs.getInt("year"));
                person.setName(rs.getString("name"));

                System.out.printf(person.toString());
                list.add(person);
            }
        if(list.size()==0){
            System.out.println("Таблица пуста, добавьте запись");
        }else {
            System.out.println("Ближайшие дни рождения:");
            System.out.printf("%1s %20s %20s %10s %10s", "Id", "ФИО", "День", "Месяц", "Год");
            System.out.println();
            for (int j = 0; j <list.size();j++  )
                System.out.println(list.get(j).toString());
        }

    } catch (SQLException exception) {
            System.out.println("Произошла ошибка");
        }

   }    public static void showSoonList() throws SQLException, ClassNotFoundException, IOException {
        Class.forName("com.mysql.jdbc.Driver");

        try (Connection connection = DriverManager.getConnection(URL, username, password);Statement statement = connection.createStatement()) {
            ResultSet rs = statement.executeQuery("Select * FROM list");
            List <Person> list = new ArrayList<>();

            while (rs.next()){
                int id = rs.getInt("id");
                int day = rs.getInt("day");
                int month = rs.getInt("month");
                int year = rs.getInt("year");
                String name = rs.getString("name");
                Calendar calendar =  Calendar.getInstance();

                int curDay = calendar.get(Calendar.DAY_OF_MONTH);
                int curMonth =  calendar.get(Calendar.MONTH);
                if(day >= curDay && day <=curDay+7 && curMonth+1 == month ){

                Person person = new Person();
                person.setId(id);
                person.setDay(day);
                person.setMonth(month);
                person.setYear(year);
                person.setName(name);

                list.add(person);
            }}
                if(list.size()==0){
                    System.out.println("Сегодня нет дней рождений");
                }else {
                    System.out.println("Ближайшие дни рождения:");
                    System.out.printf("%1s %20s %20s %10s %10s", "Id", "ФИО", "День", "Месяц", "Год");
                    System.out.println();
                    for (int j = 0; j <list.size();j++  )
                        System.out.println(list.get(j).toString());
                }


        }catch (SQLException exception){
            System.out.println("Произошла ошибка");
        }

    }
}




