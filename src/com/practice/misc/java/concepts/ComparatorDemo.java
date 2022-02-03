package com.practice.misc.java.concepts;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ComparatorDemo {

    public static void main(String[] args) {
        Football player1 = new Football("a", 1);
        Football player2 = new Football("c", 2);
        Football player3 = new Football("b", 3);
        List<Football> list = new ArrayList<>();
        list.add(player1);
        list.add(player2);
        list.add(player3);
        list.sort(new PlayerComparator());

        Comparator<Football> byName = Comparator.comparing(Football::getName);
        list.sort(byName);

        Comparator<Football> byRank = Comparator.comparing(Football::getRank);
        list.sort(byRank);

        Comparator<Football> footballComparator = Comparator.comparingInt(Football::getRank);

        list.sort(footballComparator);

        System.out.println(list);
    }

}

class PlayerComparator implements Comparator<Football> {

    @Override
    public int compare(Football o1, Football o2) {
        if (o1.rank > o2.rank)
            return 1;
        else if (o1.rank < o2.rank)
            return -1;
        return 0;
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
