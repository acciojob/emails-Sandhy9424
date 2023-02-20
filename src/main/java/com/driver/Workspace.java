package com.driver;

import org.apache.commons.lang3.tuple.Pair;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Workspace extends Gmail{

    private ArrayList<Meeting> calendar; // Stores all the meetings

    public Workspace(String emailId) {
        // The inboxCapacity is equal to the maximum value an integer can store.
        super(emailId,Integer.MAX_VALUE);
         calendar=new ArrayList<>();
    }

    public void addMeeting(Meeting meeting){
        //add the meeting to calendar
        calendar.add(meeting);
    }

    public int findMaxMeetings(){
//         find the maximum number of meetings you can attend
//         1. At a particular time, you can be present in at most one meeting
//         2. If you want to attend a meeting, you must join it at its start time and leave at end time.
//         Example: If a meeting ends at 10:00 am, you cannot attend another meeting starting at 10:00 am
            double [][]t=new double[calendar.size()][2];
            for(int i=0;i< calendar.size();i++){
                String st=calendar.get(i).getStartTime().toString();
                String se=calendar.get(i).getEndTime().toString();
                t[i][0]=Double.valueOf(st.substring(0,2))+Double.valueOf(st.substring(3))/100;
                //System.out.println(t[i][0]);
                t[i][1]=Double.valueOf(se.substring(0,2))+Double.valueOf(se.substring(3))/100;
            }
            Arrays.sort(t,(a,b)->Double.compare(a[1],b[1]));
           int c=0;
           Double pe=Double.MAX_VALUE;
           for(int i=0;i<t.length;i++){
               if(t[i][0]<pe){
                   c++;
                   pe=t[i][1];
               }
           }
           return c;
         }
    }
