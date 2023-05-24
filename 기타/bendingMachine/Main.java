import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        BendingMachine myBendingMachine = new BendingMachine();
        List<Stuff> stuffs = new ArrayList<>();
        stuffs.add(new Stuff("콜라",800, 10));
        stuffs.add(new Stuff("사이다",1000, 10));
        stuffs.add(new Stuff("휴지",1500, 10));
        stuffs.add(new Stuff("김치찌개",5000, 10));
        myBendingMachine.addStuffs(stuffs);

        boolean isEnd = false;
        while(!isEnd){
            System.out.println(myBendingMachine.print());
            String[] cmd = br.readLine().split(" ");
            switch (cmd[0]){
                case "end":
                    isEnd = true;
                    break;
                case "money":
                    myBendingMachine.insertMoney(Integer.parseInt(cmd[1]));
                    break;
                case "click":
                    if(myBendingMachine.clickItem(cmd[1])){
                        System.out.println(cmd[1] + "이/가 나옵니다.");
                    }
                    else
                        System.out.println(cmd[1] + "을/를 뽑을 수 없습니다.");
                    break;
                case "return":
                    int change = myBendingMachine.returnCharge();
                    System.out.println(change + "원을 반환하였습니다.");
                    break;
                case "add":
                    myBendingMachine.addStuff(new Stuff(cmd[1], Integer.parseInt(cmd[2])));
                    break;
                default:
                    break;
            }
        }

        br.close();
    }
}
