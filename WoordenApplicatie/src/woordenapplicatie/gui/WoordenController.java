package woordenapplicatie.gui;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import java.net.URL;
import java.util.*;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

/**
 * FXML Controller class
 *
 * @author frankcoenen
 */
public class WoordenController implements Initializable {
    
   private static final String DEFAULT_TEXT =   "Een, twee, drie, vier\n" +
                                                "Hoedje van, hoedje van\n" +
                                                "Een, twee, drie, vier\n" +
                                                "Hoedje van papier\n" +
                                                "\n" +
                                                "Heb je dan geen hoedje meer\n" +
                                                "Maak er één van bordpapier\n" +
                                                "Eén, twee, drie, vier\n" +
                                                "Hoedje van papier\n" +
                                                "\n" +
                                                "Een, twee, drie, vier\n" +
                                                "Hoedje van, hoedje van\n" +
                                                "Een, twee, drie, vier\n" +
                                                "Hoedje van papier\n" +
                                                "\n" +
                                                "En als het hoedje dan niet past\n" +
                                                "Zetten we 't in de glazenkas\n" +
                                                "Een, twee, drie, vier\n" +
                                                "Hoedje van papier";
    
    @FXML
    private Button btAantal;
    @FXML
    private TextArea taInput;
    @FXML
    private Button btSorteer;
    @FXML
    private Button btFrequentie;
    @FXML
    private Button btConcordantie;
    @FXML
    private TextArea taOutput;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        taInput.setText(DEFAULT_TEXT);
    }
    
    @FXML
    private void aantalAction(ActionEvent event) {
        String output = "";
         String[] words = DEFAULT_TEXT.split(" |\\\n");
         int wordCount = words.length;

        output += "Aantal woorden: " +wordCount + "\n";


        Set<String> uniqWords = new HashSet<>();

        for(String w : words){
            uniqWords.add(FilterWords(w));
        }



        output += "Aantal Uniq woorden: " + uniqWords.size();

        taOutput.setText(output);
    }

    @FXML
    private void sorteerAction(ActionEvent event) {
        String output = "";
        String[] words = DEFAULT_TEXT.split(" |\\\n");
        Set<String> uniqWords = new TreeSet<>(
            new Comparator<String>() {
                public int compare(String i1,String i2)
                {
                    return i2.compareTo(i1);
                }
            }
        );


        for(String w : words){
            uniqWords.add(FilterWords(w));
        }

        for (String uw : uniqWords){
            output +=  uw +"\n";
        }


        taOutput.setText(output);
    }

    @FXML
    private void frequentieAction(ActionEvent event) {
        String output = "";
        String[] words = DEFAULT_TEXT.split(" |\\\n");
        int wordCount = words.length;

        List<String> uniqWords = new ArrayList<>();
        for(String w : words){
            uniqWords.add(FilterWords(w));
        }

        Map<String, Integer> map = new HashMap<>();
        for (String w : uniqWords) {
            Integer n = map.get(w);
            n = (n == null) ? 1 : ++n;
            map.put(w, n);
        }

        taOutput.setText(map.toString().replace(", ", "\n"));



    }

    @FXML
    private void concordatieAction(ActionEvent event) {
         throw new UnsupportedOperationException("Not supported yet."); 
    }

    public String FilterWords(String word){
        return word.replaceAll("\\W", "");
    }

   
}
