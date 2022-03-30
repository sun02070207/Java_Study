package Test3;/*
    @description
    @author Serenity
    @create 2022-02-25-21:37
*/

public class Girl {
    private String name;
    public Girl(){

    }
    public Girl(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Girl{" +
                "name='" + name + '\'' +
                '}';
    }
}
