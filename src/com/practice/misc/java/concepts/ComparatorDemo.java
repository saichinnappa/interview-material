package com.practice.misc.java.concepts;

import java.util.*;
import java.util.stream.Collectors;

public class ComparatorDemo {

    public static void main(String[] args) {

        Football player1 = new Football("a", 1);
        Football player2 = new Football("c", 2);
        Football player3 = new Football("b", 3);
        Football player4 = new Football("a", 4);
        List<Football> footballList = Arrays.asList(player1, player2, player3, player4);

        System.out.println("## RANKS ##");
        int[] footballs = footballList.stream()
                .mapToInt(f -> f.getRank())
                .toArray();
        for(int football : footballs){
            System.out.println(football);
        }

        System.out.println("## NAMES ##");
        List<String> list = Arrays.asList("a", "b", "c");
        String[] sArr = list.stream().toArray(String[]::new);
        for(String s : sArr){
            System.out.println(s);
        }


        // sort by name
        footballList.sort(Comparator.comparing(Football::getName));
        System.out.println(footballList);

        //sort by rank
        footballList.sort(Comparator.comparing(Football::getRank));
        System.out.println(footballList);

        // sort by rank if name is same
        footballList.sort(new PlayerComparator());
        System.out.println(footballList);

    }

}

class PlayerComparator implements Comparator<Football>{
    @Override
    public int compare(Football o1, Football o2){
        if(o1.name.equals(o2.name))
            return Integer.compare(o2.rank, o1.rank);
        return o1.name.compareTo(o2.name);
    }
}


class Football {
    String name;
    int rank;

    Football(String name, int rank) {
        this.name = name;
        this.rank = rank;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    @Override
    public String toString() {
        return "Football{" +
                "name='" + name + '\'' +
                ", rank=" + rank +
                '}';
    }
}
