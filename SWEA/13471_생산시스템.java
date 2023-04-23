import java.util.*;

class UserSolution_13471_생산시스템 {
    int L, M;
    Product[] lines = new Product[500];
    Queue<Product>[] ques = new Queue[500];
    boolean[] tools = new boolean[500];
    PriorityQueue<Integer> updateTimes = new PriorityQueue<>();
    Map<Integer, Integer> status = new HashMap<>();

    void init(int L, int M) {
        this.L = L;
        this.M = M;
        updateTimes.clear();
        status.clear();
        Arrays.fill(tools, false);

        for(int i = 0 ; i < L ; i++){
            ques[i] = new ArrayDeque<Product>();
            lines[i] = new Product(-1, -1, -1);
        }
    }

    int request(int tStamp, int pId, int mLine, int eId, int mTime) {
        while(!updateTimes.isEmpty() && updateTimes.peek() < tStamp)
            process(updateTimes.poll());

        ques[mLine].add(new Product(pId, eId, mTime));
        status.put(pId, 1);
        updateTimes.add(tStamp);

        if(updateTimes.peek() == tStamp)
            process(updateTimes.poll());

        return lines[mLine].pid;
    }

    int status(int tStamp, int pId) {
        while(!updateTimes.isEmpty() && updateTimes.peek() <= tStamp)
            process(updateTimes.poll());

        return status.getOrDefault(pId, 0);
    }

    void process(int tStamp){
        for(int i = 0 ; i < L ; i++){
            if(lines[i].pid == -1)
                continue;
            if(lines[i].time == tStamp){
                tools[lines[i].eid] = false;
                status.put(lines[i].pid, 3);
                lines[i].pid = -1;
            }
        }

        for(int i = 0 ; i < L ; i++){
            if(lines[i].pid == -1 && !ques[i].isEmpty() && !tools[ques[i].peek().eid]){
                Product p = ques[i].poll();
                p.time += tStamp;
                lines[i] = p;
                updateTimes.add(p.time);
                tools[p.eid] = true;
                status.put(p.pid, 2);
            }
        }
    }

    class Product{
        int pid;
        int eid;
        int time;

        public Product(int pid, int eid, int time){
            this.pid = pid;
            this.eid = eid;
            this.time = time;
        }
    }
}