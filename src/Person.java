import javax.print.attribute.standard.MediaSize;
import java.util.Calendar;

public class Person {
    private String name;
    private int day;
    private int month;
    private int year;
    private int id;


    public void setId(int id) {this.id = id;}
    public void setName(String name) {this.name = name;}
    public void setDay(int day) {this.day = day;}
    public void setMonth(int month) {this.month = month;}
    public void setYear(int year) {this.year = year;}
    public int getId() {
        return id;
    }
    public String getName() {return name;}
    public int getDay() {return day;}
    public int getMonth() {return month;}
    public int getYear() {return year;}

    public Person(String name, int day, int month, int year) {
        this.name = name;
        this.day = day;
        this.month = month;
        this.year = year;
    }
    public Person(){
        name = "";
        day = 0;
        month = 0;
        year = 0;
    }

    @Override
    public String toString() {
        return String.format("%1d %20s %20d %10d %10d\n",id,name,day,month,year);
    }
}
