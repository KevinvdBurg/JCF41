package sample;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 * Created by kvdb on 23/03/16.
 */
public class Teacher
{
    public SimpleStringProperty name;
    public SimpleStringProperty lastName;
    public SimpleIntegerProperty age;
    public SimpleIntegerProperty gender;

    public Teacher(String name, String lastName, int age, int gender)
    {
        this.name = new SimpleStringProperty(name);
        this.lastName = new SimpleStringProperty(lastName);
        this.age = new SimpleIntegerProperty(age);
        this.gender = new SimpleIntegerProperty(gender);
    }

    public String getName() {
        return name.get();
    }

    public String getLastName() {
        return lastName.get();
    }

    public int getAge() {
        return age.get();
    }

    public int getGender() {
        return gender.get();
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
