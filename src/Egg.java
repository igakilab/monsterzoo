import java.util.ArrayList;

public class Egg {
    public Boolean isBone;
    public Double distance;
    public Egg(){
        this.isBone = false;
        this.distance = 0.0;
    }
    public Monster boneMonster(ArrayList<Monster> mondex){
        if(this.distance>=3.0){
            this.isBone=true;
			System.out.println("卵が孵った！");
			int m = (int)(mondex.size()*Math.random());
			System.out.println(mondex.get(m).monsterName+"が産まれた！");
            this.distance=0.0;
            return mondex.get(m);
        } else {
            return null;
        }
    }
}
