package mainPackage;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Jouer {
	
	static ArrayList<String> roi = new ArrayList<String>();
	Random rand = new Random(); 



    /**
     *
     * @param database
     * @param scanner
     */

    public static void init(Database database, Scanner scanner){
    	
    	// initialisation des plateaux
    	for (int i = 1; i <= database.nbJoueurs; i++) {
    		database.mapPlayer[i][3][3] = 500; 
    	}
    	
    	// initialisation des rois
    	if (database.nbJoueurs == 2) {
    		roi.add("rouge");
    		roi.add("rouge");
    		roi.add("bleu");
    		roi.add("bleu");
    	} else if (database.nbJoueurs == 3) {
    		roi.add("rouge");
    		roi.add("bleu");
    		roi.add("vert");
    	} else {
    		roi.add("rouge");
    		roi.add("bleu");
    		roi.add("vert");
    		roi.add("jaune");
    	}		
    			 			
    	//initialisation du jeux de domino
    	database.nbDominos = database.nbDominos - 12*(4-database.nbJoueurs);
    	
    	
    	//
    	int nombreAleatoire = rand.nextInt();
    }
    
    public static void play(Database database, Scanner scanner){
    	
    }

}
