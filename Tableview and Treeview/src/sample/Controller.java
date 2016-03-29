package sample;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.StackPane;

import javax.annotation.Resources;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Controller {

    private ArrayList<School> defaultSchool = new ArrayList<>();

    @FXML
    public TableView<Teacher> tableTeachers;

//    @FXML
//    public StackPane<String> treeSchools;
    @FXML
    public StackPane planeSchools;


    @FXML
    protected void initialize(){
        setUpDefaultSchool();

        TreeItem<String> rootItem = new TreeItem<String> ("Schools");
        rootItem.setExpanded(true);
        for(School school : defaultSchool){
            TreeItem<String> item = new TreeItem<String> (school.getName());
                for (Subject subject : school.getSubjectList()){
                    TreeItem<String> item2 = new TreeItem<String> (subject.getName());
                    for (Teacher teacher : subject.getTeacherList()) {
                        TreeItem<String> item3 = new TreeItem<String> (teacher.getName());
                        item2.getChildren().add(item3);
                    }
                    item.getChildren().add(item2);
                }
            rootItem.getChildren().add(item);
        }

        TreeView<String> tree = new TreeView<String> (rootItem);
        planeSchools.getChildren().add(tree);

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
