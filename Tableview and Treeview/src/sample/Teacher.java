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

    public Teacher(String name, String lastName, int age, int gender)
    {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.gender = gender;
    }

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
