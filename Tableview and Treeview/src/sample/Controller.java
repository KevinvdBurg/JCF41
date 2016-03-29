package sample;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;

import javax.annotation.Resources;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Controller {

    private ArrayList<School> defaultSchool = new ArrayList<>();

    @FXML
    public TableView<Teacher> tableTeachers;

    @FXML
    public TreeView<School> treeSchools;


    @FXML
    protected void initialize(){
        School fontysAlgemeen = new School("Fontys Algemeen", "Eindhoven");
        TreeItem<School> root = new TreeItem<School>(fontysAlgemeen);
        root.setExpanded(true);


        for (School school : defaultSchool){
            TreeItem<School> tiSchool = new TreeItem<>();
            tiSchool.setValue(school);
            root.getChildren().add(tiSchool);
        }

        treeSchools.setRoot(root);

    }

    private void setUpDefaultSchool(){
        School fontysTilburg = new School("Fontys Tilburg", "Tilburg");
        School fontysEindhoven = new School("Fontys Eindhoven", "Eindhoven");

        Subject jcf = new Subject("JCF");

        Teacher hmls = new Teacher("Bjorn", "Hamels", 18, 1);
        Teacher beer = new Teacher("Patick", "de Beer", 45, 1);
        jcf.addTeacherToSubject(hmls);
        jcf.addTeacherToSubject(beer);

        fontysTilburg.addSubjectToSchool(jcf);
        fontysEindhoven.addSubjectToSchool(jcf);

        defaultSchool.add(fontysTilburg);
        defaultSchool.add(fontysEindhoven);

    }

}
