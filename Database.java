package mainPackage;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Database {

    String RESOURCES_PATH = "src/ressources/";
    String DOMINOS_FILE_NAME = "dominos.csv";
    String ligne = "";
    String SEPARATOR = ",";
    String[] cartes;


    int nbTuilesDepart;
    int nbChateaux;
    int nbDominos;
    int nbJoueurs;
    int longueur;

    int scorePlayer1;
    int scorePlayer2;
    int scorePlayer3;
    int scorePlayer4;

    ArrayList<ArrayList<String>> mapPlayer1;
    ArrayList<ArrayList<String>> mapPlayer2;
    ArrayList<ArrayList<String>> mapPlayer3;
    ArrayList<ArrayList<String>> mapPlayer4;


    Map<String, ArrayList> dominos = new HashMap<>();

    public void init(){
        nbJoueurs = 4;

        nbDominos = 48;
        nbChateaux = 4;
        nbTuilesDepart = 4;
        longueur = 5;

        scorePlayer1 = 0;
        scorePlayer2 = 0;
        scorePlayer3 = 0;
        scorePlayer4 = 0;

        try {
            File file = new File(RESOURCES_PATH + DOMINOS_FILE_NAME);

            BufferedReader buff = new BufferedReader(new FileReader(file));

            int i = 0;

            while ((ligne = (buff).readLine()) != null) {
                cartes = ligne.split(SEPARATOR);
                if (i > 0){
                    dominos.put(cartes[4]+"1", new ArrayList<>(Arrays.asList(cartes[0], cartes[1])));
                    dominos.put(cartes[4]+"2", new ArrayList<>(Arrays.asList(cartes[2], cartes[3])));
                }
                i++;
        }
            System.out.println(dominos.entrySet() + " " + (i-1));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        mapPlayer1 = new ArrayList<>(Arrays.asList(
                new ArrayList<String>('o'),
                new ArrayList<String>('o'),
                new ArrayList<String>('o'),
                new ArrayList<String>('o'),
                new ArrayList<String>('o')
                ));

        mapPlayer2 = new ArrayList<>(Arrays.asList(
                new ArrayList<String>('o'),
                new ArrayList<String>('o'),
                new ArrayList<String>('o'),
                new ArrayList<String>('o'),
                new ArrayList<String>('o')
        ));

        mapPlayer3 = new ArrayList<>(Arrays.asList(
                new ArrayList<String>('o'),
                new ArrayList<String>('o'),
                new ArrayList<String>('o'),
                new ArrayList<String>('o'),
                new ArrayList<String>('o')
        ));

        mapPlayer4 = new ArrayList<>(Arrays.asList(
                new ArrayList<String>('o'),
                new ArrayList<String>('o'),
                new ArrayList<String>('o'),
                new ArrayList<String>('o'),
                new ArrayList<String>('o')
        ));

        for (int i = 0; i < longueur; i++){
            for (int j = 0; j < longueur; j++){
                mapPlayer1.get(i).add("o");
                mapPlayer2.get(i).add("o");
                mapPlayer3.get(i).add("o");
                mapPlayer4.get(i).add("o");
            }
        }


    }

}
