package com.interview.doordash.oa;

import java.util.ArrayDeque;
import java.util.Deque;

public class StreamProcessor {
    private int X;
    Deque<int[]> dq;

    public StreamProcessor(int x) {
        this.X = x;
        dq = new ArrayDeque<>();
    }

    /**
     * set_value(int t, int v):
     *
     * While inserting any value check if the front entry time is less than t - X, if yes erase that entry (keep erasing till this statement is true)
     * Starting from back pop the entries which have value less than v
     * Insert your new entry at end of deque
     * @param t
     * @param v
     */
    void set_value(int t, int v) {
        while (!dq.isEmpty() && dq.peek()[0] < t - X)
            dq.pollFirst();

        while (!dq.isEmpty() && dq.peekLast()[1] < v)
            dq.pollLast();

        dq.add(new int[]{t, v});
    }

    /**
     * While retrieving the maximum value in last X seconds check if the front entry time is less than curr_t - X, if yes erase that entry (keep erasing till this statement is true)
     * Return the value of front entry
     * @param t
     * @return
     */
    int max_value(int t) {
        while (!dq.isEmpty() && dq.peek()[0] < t - X)
            dq.pollFirst();

        if (dq.isEmpty())
            return -1;

        return dq.peek()[1];
    }

    public static void main(String[] args) {
        StreamProcessor sp = new StreamProcessor(5);
        sp.set_value(0, 5);
        sp.set_value(1, 6);
        sp.set_value(2, 4);
        sp.set_value(5, 5);
        sp.set_value(9, 19);
        sp.set_value(15, 4);
        sp.set_value(17, 3);
        sp.set_value(19, 6);
        sp.set_value(20, 4);

        System.out.println(sp.max_value(3));
    }
}
