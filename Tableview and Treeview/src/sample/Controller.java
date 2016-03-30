package sample;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
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
    @FXML
    public TableColumn teacherImageCol;

    //Required attributes for the schools treeView
    private ArrayList<School> defaultSchool = new ArrayList<>();
    @FXML
    public StackPane planeSchools;


    @FXML
    protected void initialize(){
        School fontysAlgemeen= new School("Fontys Algemeen", "Tilburg");
        //Bind values to the tableView columns
        teacherNameCol.setCellValueFactory(new PropertyValueFactory<Teacher, String>("name"));
        teacherLastNameCol.setCellValueFactory(new PropertyValueFactory<Teacher, String>("lastName"));
        teacherAgeCol.setCellValueFactory(new PropertyValueFactory<Teacher, Integer>("age"));
        teacherGenderCol.setCellValueFactory(new PropertyValueFactory<Teacher, Integer>("gender"));
        teacherImageCol.setCellValueFactory(new PropertyValueFactory<Teacher, ImageView>("image"));

        //Initialize observableList and bind it to the tableView
        teachers = FXCollections.observableArrayList();
        tableTeachers.setItems(teachers);



        setUpDefaultSchool();

        //createted the root of the Treeview
        TreeItem<Nameable> rootItem = new TreeItem<> (fontysAlgemeen);
        rootItem.setExpanded(true); //made so that the root is expanded automatich
        //loop though the defaultschool to fill in the treeview
        for(School school : defaultSchool){
            TreeItem<Nameable> item = new TreeItem<> (school);
                for (Subject subject : school.getSubjectList()){
                    TreeItem<Nameable> item2 = new TreeItem<> (subject);
                    item.getChildren().add(item2);
                }
            rootItem.getChildren().add(item);
        }

        //Creates the treeview and adds it to the StackPlane
        TreeView<Nameable> tree = new TreeView<> (rootItem);
        planeSchools.getChildren().add(tree);

        //Adds a listener to the treeview so it knows what item is selected
        tree.getSelectionModel().selectedItemProperty().addListener( new ChangeListener() {

            @Override
            public void changed(ObservableValue observable, Object oldValue,
                                Object newValue) {

                TreeItem<Nameable> selectedItem = (TreeItem<Nameable>) newValue;
                teachers.setAll(selectedItem.getValue().getTeachers()); // sets the teachers to the tableview
            }

        });
    }

    /*
    *
    * Sets all the default schools with all the subjects and teachers
    *
     */
    private void setUpDefaultSchool(){
        School fontysTilburg = new School("Fontys Tilburg", "Tilburg");
        School fontysEindhoven = new School("Fontys Eindhoven", "Eindhoven");

        Subject jcf = new Subject("JCF");
        Subject gso = new Subject("GSO");
        Subject pts4 = new Subject("PTS4");

        Teacher hmls = new Teacher("Bjorn", "Hamels", 18, 1);
        Teacher beer = new Teacher("Patick", "de Beer", 45, 1);

        Teacher mols = new Teacher("Erik", "Mols", 53, 2);
        Teacher roij = new Teacher("Jacques", "de Roij", 23, 1);

        Teacher burg = new Teacher("Kevin", "van der Burg", 23, 2);
        Teacher drost = new Teacher("Martin", "Drost", 22, 1);

        jcf.addTeacherToSubject(hmls);
        jcf.addTeacherToSubject(beer);

        gso.addTeacherToSubject(mols);
        gso.addTeacherToSubject(roij);

        pts4.addTeacherToSubject(burg);
        pts4.addTeacherToSubject(drost);

        fontysTilburg.addSubjectToSchool(jcf);
        fontysTilburg.addSubjectToSchool(gso);
        fontysEindhoven.addSubjectToSchool(jcf);
        fontysEindhoven.addSubjectToSchool(pts4);

        defaultSchool.add(fontysTilburg);
        defaultSchool.add(fontysEindhoven);

    }

}
