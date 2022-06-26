package com.interview.doordash.oa;

import java.util.*;

/**
 * Given a sequence of timestamps & actions of a dasher's activity within a day, we would like to know the active time of the dasher.
 * Idle time is defined as the dasher has NO delivery at hand. (That means all items have been dropped off at this moment and the dasher is just waiting for another pickup) Active time equals total time minus idle time.
 * Below is an example. Dropoff can only happen after pickup. 12:00am means midnight and 12:00pm means noon. All the time is within a day.
 *
 * Timestamp(12h) | Action
 * 8:30am | pickup
 * 9:10am | dropoff
 * 10:20am| pickup
 * 12:15pm| pickup
 * 12:45pm| dropoff
 * 2:25pm | dropoff
 *
 * total time = 2:25pm-8:30am = 355 mins;
 * idle time = 10:20am-9:10am = 70 mins;
 * active time = total time-idle time = 355-70 = 285 mins;
 */
public class GetActiveTime {

    public static void main(String[] args) {
        Activity a1 = new Activity("8:30AM", Action.PICKUP);
        Activity a2 = new Activity("9:10AM", Action.DELIVERY);
        Activity a3 = new Activity("10:20AM", Action.PICKUP);
        Activity a4 = new Activity("12:15PM", Action.DELIVERY);
        Activity a5 = new Activity("12:45PM", Action.PICKUP);
        Activity a6 = new Activity("2:25PM", Action.DELIVERY);
        List<Activity> activityList = Arrays.asList(a1, a2, a3, a4, a5, a6);
        Deque<Activity> stack = new LinkedList<>();
        int activeTime = 0;

        for (Activity activity : activityList) {
            if (activity.action == Action.PICKUP) {
                stack.push(activity);
            } else {
                Activity top = stack.pop();
                if (stack.isEmpty()) {
                    activeTime +=  getMinutes(activity.time) - getMinutes(top.time);
                }
            }
        }
        System.out.println("TOTAL ACTIVE TIME: "+ activeTime);

    }

    static int getMinutes(String time){
        String[] t1arr = time.split(":");
        int t1Hour = Integer.parseInt(t1arr[0]);
        int t1Min = Integer.parseInt(t1arr[1].substring(0, 2));
        String t1Meridian = t1arr[1].substring(2, 4);
        int t1Mins = 0;
        if(t1Meridian.equals("AM") || (t1Meridian.equals("PM") && t1Hour == 12)){
            t1Mins = (60 * t1Hour) + t1Min;
        } else{
            t1Mins = ((12 + t1Hour) * 60) + t1Min;
        }
        return t1Mins;
    }

}

enum Action {
    PICKUP,
    DELIVERY
}

class Activity{
    String time;
    Action action;
    Activity(String time, Action action){
        this.time = time;
        this.action = action;
    }

}


