package sample;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * Created by kvdb on 23/03/16.
 */
public class Teacher
{
    public SimpleStringProperty name;
    public SimpleStringProperty lastName;
    public SimpleIntegerProperty age;
    public SimpleIntegerProperty gender;
    public ImageView image;

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
        return name + " " + lastName;
    }
}
