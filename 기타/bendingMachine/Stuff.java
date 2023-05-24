
class Stuff{
    private String name;
    private int price;
    private int count;

    public Stuff(String name, int price, int count){
        this.name = name;
        this.price = price;
        this.count = count;
    }

    public Stuff(String name, int count){
        this.name = name;
        this.price = 0;
        this.count = count;
    }

    public int add(int count){
        this.count += count;
        return this.count;
    }

    public int minus(){
        return --this.count;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getCount() {
        return count;
    }
}