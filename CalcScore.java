package mainPackage;

import java.util.ArrayList;
import java.util.Arrays;

public class CalcScore {

    public static void play(Database database){
        ArrayList<ArrayList<String>> list = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            list.add(new ArrayList<>());
            list.get(i).add("y");
            list.get(i).add("y");
            list.get(i).add("d");
            list.get(i).add("i");
            list.get(i).add("j");
        }

        /*list.get(0).set(4, "y");
        list.get(4).set(2, "y");
        list.get(1).set(3, "y");
        list.get(2).set(3, "y");
        list.get(3).set(3, "y");
        list.get(2).set(2, "y");*/

        for (int i = 0; i < 5; i++) {
            System.out.println(list.get(i));
        }

        System.out.println(score(list));

        for (int i = 0; i < 5; i++) {
            System.out.println(list.get(i));
        }
    }

    /**
     * Fct qui calcule le score d'un joueur.
     * @param map
     * @return
     */

    public static int score(ArrayList<ArrayList<String>> map) {

        int score = 0;
        int[] sc;

        for (int i = 0; i < map.size(); i++) {
            for (int j = 0; j < map.get(0).size(); j++) {
                if (not(map.get(i).get(j).equals("aa"))){
                    System.out.println(map.get(i).get(j) + " - " + (sc = calcScore(map,i,j,1, 0))[0]);
                    score += sc[1] * sc[0];
                }
            }
        }

        return score;
    }

    /**
     * fct qui retroune faux si la condition est vraie et inversement.
     * @param bool
     * @return not bool
     */

    public static boolean not(boolean bool) {
        if (bool){
            return false;
        }else{

            return true;
        }
    }

    /**
     * Calcul le score groupe par groupe
     * @param map
     * @param i
     * @param j
     * @param score
     * @return score d'un type.
     */

    public static int[] calcScore(ArrayList<ArrayList<String>> map, int i, int j, int score, int couronnes) {
        int[] calcul;
        String value = map.get(i).get(j);
        map.get(i).set(j, "aa");

        try {
            if (map.get(i).get(j+1).equals(value)) {
                calcul = calcScore(map,i,j+1,score+1, couronnes + 1);
                score = calcul[0];
                couronnes = calcul[1];
            }
        }catch(IndexOutOfBoundsException e){ }

        try {
            if (map.get(i+1).get(j).equals(value)) {
                calcul = calcScore(map,i+1,j,score+1, couronnes + 1);
                score = calcul[0];
                couronnes = calcul[1];

            }
        }catch(IndexOutOfBoundsException e){ }

        try {
            if (map.get(i).get(j-1).equals(value)) {
                calcul = calcScore(map,i,j-1,score+1, couronnes + 1);
                score = calcul[0];
                couronnes = calcul[1];
            }
        }catch(IndexOutOfBoundsException e){ }

        try {
            if (map.get(i-1).get(j).equals(value)) {
                calcul = calcScore(map,i-1,j,score+1, couronnes + 1);
                score = calcul[0];
                couronnes = calcul[1];
            }
        }catch(IndexOutOfBoundsException e){ }

        return new int[]{score, couronnes};

    }

}