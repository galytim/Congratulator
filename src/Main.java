import java.io.IOException;
import java.sql.SQLException;


public class Main {
    public static void main(String[] args) throws IOException, SQLException, ClassNotFoundException {
        int i;
        boolean t = true;
        MySQLAction.showSoonList();

        while (t == true) {
            System.out.println();
            System.out.println();
            System.out.println("Выберите действие:");

            System.out.println("0 - Создать таблицу");
            System.out.println("1 - Показать весь список");
            System.out.println("2 - Показать ближайшие дни рождения");
            System.out.println("3 - Добавить запись");
            System.out.println("4 - Удалить запись");
            System.out.println("5 - Редактировать запись");
            System.out.println("6 - Удалить таблицу");
            System.out.println("7-9 - Выйти");
            System.out.println();

            i = IO.readInt();

            switch (i) {
                case 0:
                    MySQLAction.createTable();
                    break;
                case 1:
                    MySQLAction.showAllList();
                    break;
                case 2:
                    MySQLAction.showSoonList();
                    break;
                case 3:
                    MySQLAction.insert(IO.readPerson());
                    MySQLAction.showAllList();
                    break;
                case 4:
                    MySQLAction.delete();
                    MySQLAction.showAllList();
                    break;
                case 5:
                int o = 0;
                    System.out.println("1 - редактировать ФИО");
                    System.out.println("2 - редактировать дату");
                    System.out.println("3-9 - Выйти");
                    o = IO.readInt();
                       if(o == 1) MySQLAction.updateName();
                       else if(o == 2) MySQLAction.updateDate();
                       else break;
                    MySQLAction.showAllList();
                       break;
                case 6:
                    MySQLAction.dropTable(); break;
                default:
                    t = false;
                    break;


            }

        }
    }}

