import java.util.ArrayList;
import java.util.concurrent.atomic.LongAdder;

public class Egg {
    public Boolean isBone;
    public final LongAdder distance;
    public Egg(){
        this.isBone = false;
        this.distance = new LongAdder();
    }
    public Monster boneMonster(final ArrayList<Monster> mondex){
        this.isBone=true;
		System.out.println("卵が孵った！");
		int m = (int)(mondex.size()*Math.random());
		System.out.println(mondex.get(m).monsterName+"が産まれた！");
        this.distance.reset();
        return mondex.get(m);
    }
}
