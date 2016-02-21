package graphs;

/**
 * Created by ksama on 2/17/2016.
 */
public class CourseSchedule {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] result = new int[numCourses];
        for(int i=0;i<prerequisites.length;i++){
           result[prerequisites[i][0]]++;
        }
        return new int[1];
    }
}
