import java.util.ArrayList;

public class Main {
	static MonsterZoo pz = new MonsterZoo();

	public static void main(String[] args) {

		//1000ミリ秒（1秒）ずつ止まりながらpz.move()を呼び出し続ける
		//手持ちのボールが無くなったら終了
		while(true){
			try {
				Thread.sleep(1000);
				if(pz.player.balls.getCount()>0){
					pz.move();
					System.out.println("手持ちのボールは"+pz.player.balls.getCount()+"個，フルーツは"+pz.getFruits()+"個");
					System.out.println(pz.player.distance.getDistance()+"km歩いた．");
				}else{
					break;
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		System.out.println("ボールがなくなった！");

		for(int i=0;i<pz.getUserMonster().length;i++){
			if(pz.getUserMonster()[i]!=null){
				System.out.println(pz.getUserMonster()[i]+"を捕まえた．");
			}
		}
	}

}
