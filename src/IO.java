import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class IO {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public static int readInt(){
        int i = 0;
        boolean t = true;

        while (t == true)
            try {
                i = Integer.parseInt(reader.readLine());
                t = false;
            } catch (NumberFormatException e) {
                System.out.println("введите ЧИСЛО");
            } catch (IOException e) {
                e.printStackTrace();
            }
        return i;
    }
    public static String readString() throws IOException {
        return reader.readLine();
    }
    public static Person readPerson() throws IOException {
        Person person = new Person();
        System.out.println("Введите ФИО");
        person.setName(IO.readString());
        System.out.println("Введите день");
        person.setDay(IO.readInt());
        System.out.println("Введите месяц");
        person.setMonth(IO.readInt());
        System.out.println("Введите год");
        person.setYear(IO.readInt());

        return person;
    }
}
