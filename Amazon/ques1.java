package Amazon;
import java.util.*;
public class ques1 {
    public static void print(String[] arr){
        for(String a : arr){
            System.out.print(a + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        // String timePoints[] = {"12:12","00:13"};
        // Arrays.sort(timePoints);
        // int min = 99999;
        // for(int i = 0;i<timePoints.length-1;i++){
        //     String firstTime =  timePoints[i];
        //     String secondTime =  timePoints[i+1];
        //     // List<String> first = new ArrayList<>();
        //     // List<String> second = new ArrayList<>();
        //     // System.out.println(firstTime);
        //     String first[] = new String[2];
        //     String second[] = new String[2];
        //     first = firstTime.split(":");
        //     second = secondTime.split(":");
        //     // print(first);
        //     // print(second);
        //     if(first[0].equals("00")){
        //         first[0] = "23";
        //     }
        //     if(first[1].equals("00")){
        //         first[1] = "60";
        //     }
        //     if(second[0].equals("00")){
        //         second[0] = "23";
        //     }
        //     if(second[1].equals("00")){
        //         second[1] = "60";
        //     }
        //     if(first[1].equals("60") && !(first[0].equals("00")) && !(first[0].equals("23"))){
        //         System.out.println(Integer.parseInt(first[0]));
        //         first[0] = Integer.toString(Integer.parseInt(first[0]) - 1);
        //     }
        //     if(second[1].equals("60") && !(second[0].equals("00")) && !(second[0].equals("23"))){
        //         System.out.println(Integer.parseInt(second[0]));

        //         second[0] = Integer.toString(Integer.parseInt(second[0]) - 1);
        //     }
        //     print(first);
        //     print(second);
        //     int min1 = (Integer.parseInt(first[0]) * 60) + Integer.parseInt(first[1]);
        //     int min2 = (Integer.parseInt(second[0]) * 60) + Integer.parseInt(second[1]);
        //     System.out.println(min1 - min2);
        //     min = Math.min(min, Math.abs(min1 - min2));
        // }
        // System.out.println(min);
        List<String> timePoints = new ArrayList<>();
        timePoints.add("23:59");
        timePoints.add("00:00");
        int[] minutes = new int[timePoints.size()];
        for (int i = 0; i < timePoints.size(); i++) {
            String time = timePoints.get(i);
            int h = Integer.parseInt(time.substring(0, 2));
            int m = Integer.parseInt(time.substring(3));
            minutes[i] = h * 60 + m;
        }
        Arrays.sort(minutes);
        int minTime = Integer.MAX_VALUE;
        for (int i = 0; i < minutes.length - 1; i++) {
            minTime = Math.min(minTime, (minutes[i + 1] - minutes[i]));
        }
        System.out.println(Math.min(minTime, 24 * 60 - minutes[minutes.length - 1] + minutes[0]));
    }
}
// timePoints = ["00:00","23:59","00:00"]