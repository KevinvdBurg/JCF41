package sample;

/**
 * Created by kvdb on 23/03/16.
 */
public class Teacher
{
    private String name;
    private String lastName;
    private int age;
    private int gender;

    @Override
    public String toString()
    {
        return "Teacher{" +
                "name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                '}';
    }
}
