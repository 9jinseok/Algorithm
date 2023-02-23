class Solution_1 {
    public int solution(String[] bakery_schedule, String current_time, int k) {
        int res = -1;

        int cur = 0;
        String[] tmp = current_time.split(":");
        cur += Integer.parseInt(tmp[0]) * 60 + Integer.parseInt(tmp[1]);

        for(int i = 0 ; i < bakery_schedule.length ; i++){
            String[] schedule = bakery_schedule[i].split(" ");
            tmp = schedule[0].split(":");
            int num = Integer.parseInt(schedule[1]);
            int time = Integer.parseInt(tmp[0]) * 60 + Integer.parseInt(tmp[1]);
            if(time >= cur){
                k -= num;
                if(k <= 0 ){
                    res = time - cur;
                    break;
                }
            }
        }

        return res;
    }
}