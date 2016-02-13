package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by ksama on 2/12/2016.
 */
public class InsertInterval {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        int index = Collections.binarySearch(intervals, newInterval, new IntervalComparator());
        if(index <0) {
            int lastIndex = -index - 2;
            if (lastIndex!=-1 &&intervals.get(lastIndex).end >= newInterval.start) {
                intervals.get(lastIndex).end = Math.max(intervals.get(lastIndex).end,newInterval.end);
                index = lastIndex;
            } else {
                intervals.add(lastIndex+1, newInterval);
                index = lastIndex+1;
            }

        }else{
            Interval found = intervals.get(index);
            if(found.end<newInterval.end){
                found.end = newInterval.end;
            }else{
                return intervals;
            }
        }


        while(index <intervals.size()-1 && intervals.get(index).end >= intervals.get(index+1).start){
            if(intervals.get(index).end >intervals.get(index+1).end ){
                intervals.remove(index+1);
            }else{
                intervals.get(index).end = intervals.get(index+1).end;
                intervals.remove(index+1);
                return intervals;
            }
        }
        return intervals;
    }

    public static class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }

        @Override
        public String toString() {
            return "Interval{" +
                    "start=" + start +
                    ", end=" + end +
                    '}';
        }
    }

    public class IntervalComparator implements Comparator<Interval>{

        @Override
        public int compare(Interval i1, Interval i2) {
            return i1.start-i2.start;
        }
    }

    public static void main(String[] args){
        ArrayList<Interval> intervals = new ArrayList<Interval>();
        intervals.add(new Interval(3,6));
        intervals.add(new Interval(7,8));
        intervals.add(new Interval(9,20));
        Interval newInterval = new Interval(1,2);
        List<Interval> merged = new InsertInterval().insert(intervals, newInterval);
        for(Interval interval:merged){
            System.out.println(interval);
        }
    }
}
