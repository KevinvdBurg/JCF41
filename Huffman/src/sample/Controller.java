package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

import java.util.*;
import java.util.stream.Stream;

public class Controller {
    public String text = "Lollipop jelly beans jelly apple pie. Fruitcake biscuit caramels lollipop pudding croissant. " +
            "Gingerbread tiramisu wafer cake jelly beans dessert jelly beans chocolate cake. Powder ice cream apple pie " +
            "sesame snaps gummi bears sweet caramels croissant. Wafer jelly carrot cake pie powder caramels soufflé " +
            "icing bonbon. Powder gummies carrot cake bonbon cheesecake tiramisu macaroon.";
    @FXML
    public Button btnFrequency;
    @FXML
    public Button btnFrequencySort;
    @FXML
    public TextArea taOutput;


    @FXML
    public void getFrequency(ActionEvent actionEvent) {

        //Split all the characters into a Array
        char[] letters = text.toCharArray();

        Huffman huffman = new Huffman(letters);
        huffman.getNodes();

        Map<Character, Integer> map = huffman.getMap();


        for(Knot knot : huffman.getNodes()){
            System.out.println(knot.letter + " : " + knot.frequentie);
        }

        //--------Sort in Desc order--------\\
        //Object[] a = huffman.getSortedMap();

//        for (Map.Entry<Character, Integer> entry : huffman.getSortedMap().entrySet())
//        {
//            System.out.println(entry.getKey() + "/" + entry.getValue());
//        }
    }
}


