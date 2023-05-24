import java.util.ArrayList;
import java.util.List;

class BendingMachine{
    List<Stuff> stuffList;
    int charge;

    public BendingMachine(){
        stuffList = new ArrayList<>();
        charge = 0;
    }

    public void addStuffs(List<Stuff> stuffs){
        stuffList.addAll(stuffs);
    }

    public void addStuff(Stuff newStuff){
        boolean chk = false;
        for(Stuff stuff : stuffList){
            if(stuff.getName().equals(newStuff.getName())){
                chk = true;
                stuff.add(newStuff.getCount());
            }
        }
        if(!chk){
            stuffList.add(newStuff);
        }
    }

    public String print(){
        StringBuilder sb = new StringBuilder();
        for(Stuff stuff : stuffList){
            sb.append("name : ").append(stuff.getName()).append(", ");
            sb.append("price : ").append(stuff.getPrice()).append(", ");
            sb.append("available : ");
            if(charge >= stuff.getPrice() && stuff.getCount() > 0)
                sb.append("O\n");
            else
                sb.append("X\n");
        }

        sb.append("현재 투입 금액 : ").append(charge);

        return sb.toString();
    }

    public int insertMoney(int money){
        charge += money;
        return charge;
    }

    public boolean clickItem(String name){
        for(Stuff stuff : stuffList){
            if(stuff.getName().equals(name)){
                if(charge >= stuff.getPrice() && stuff.getCount() > 0) {
                    charge -= stuff.getPrice();
                    stuff.minus();
                    return true;
                }
                break;
            }
        }
        return false;
    }

    public int returnCharge(){
        int ret = charge;
        charge = 0;
        return ret;
    }

}
