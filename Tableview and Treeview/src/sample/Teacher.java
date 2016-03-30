package sample;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.ArrayList;

/**
 * Created by kvdb on 23/03/16.
 */
public class Teacher implements Nameable
{
    private SimpleStringProperty name;
    private SimpleStringProperty lastName;
    private SimpleIntegerProperty age;
    private SimpleIntegerProperty gender;
    private ImageView image;
    
    public Teacher(String name, String lastName, int age, int gender) {
        this.name = new SimpleStringProperty(name);
        this.lastName = new SimpleStringProperty(lastName);
        this.age = new SimpleIntegerProperty(age);
        this.gender = new SimpleIntegerProperty(gender);

        this.image = new ImageView();
        this.image.setImage(new Image("http://www.nltimes.nl/wp-content/uploads/2014/06/teacher.jpg"));
        this.image.setFitWidth(135);
        this.image.setFitHeight(60);
    }

    public String getName() {
        return name.get();
    }

    @Override
    public ArrayList<Teacher> getTeachers()
    {
        ArrayList teacher = new ArrayList();
        teacher.add(this);
        return teacher;
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

    public ImageView getImage() {
        return image;
    }

    @Override
    public String toString()
    {
        return name.get();
    }
}
