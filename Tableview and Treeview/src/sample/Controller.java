package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.StackPane;

import javax.annotation.Resources;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Controller {

    //Required attributes for the teachers tableView
    private ObservableList<Teacher> teachers;
    @FXML
    public TableView<Teacher> tableTeachers;
    @FXML
    public TableColumn teacherNameCol;
    @FXML
    public TableColumn teacherLastNameCol;
    @FXML
    public TableColumn teacherAgeCol;
    @FXML
    public TableColumn teacherGenderCol;

    //Required attributes for the schools treeView
    private ArrayList<School> defaultSchool = new ArrayList<>();
    @FXML
    public StackPane planeSchools;


    @FXML
    protected void initialize(){

        //Bind values to the tableView columns
        teacherNameCol.setCellValueFactory(new PropertyValueFactory<Teacher, String>("name"));
        teacherLastNameCol.setCellValueFactory(new PropertyValueFactory<Teacher, String>("lastName"));
        teacherAgeCol.setCellValueFactory(new PropertyValueFactory<Teacher, Integer>("age"));
        teacherGenderCol.setCellValueFactory(new PropertyValueFactory<Teacher, Integer>("gender"));

        //Initialize observableList and bind it to the tableView
        teachers = FXCollections.observableArrayList();
        tableTeachers.setItems(teachers);

        setUpDefaultSchool();

        TreeItem<String> rootItem = new TreeItem<String> ("Schools");
        rootItem.setExpanded(true);
        rootItem.getChildren().setAll();
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
