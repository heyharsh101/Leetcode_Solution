class Solution {
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        
        int aStart = getDays(arriveAlice);
        int aEnd = getDays(leaveAlice);
        int bStart = getDays(arriveBob);
        int bEnd = getDays(leaveBob);

        int start = Math.max(aStart, bStart);
        int end = Math.min(aEnd, bEnd);

        return Math.max(0, end-start+1);
        
    }
    public int getDays(String date){
        int[] days = {0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334};

        int month = Integer.parseInt(date.substring(0, 2));
        int day = Integer.parseInt(date.substring(3, 5));

        // int total = day;

        // for(int i=0; i<month-1; i++){
        //     total += days[i];
        // }
        return days[month - 1]+day;
    }
}