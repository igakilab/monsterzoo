public class Main {
	static MonsterZoo pz = new MonsterZoo();

	public static void main(String[] args) {

		//1000ミリ秒（1秒）ずつ止まりながらpz.move()を呼び出し続ける
		//手持ちのボールが無くなったら終了
		while(true){
			try {
				Thread.sleep(1000);
				if(pz.balls.count()>0){
					pz.move();
					System.out.println("手持ちのボールは"+pz.balls.count()+"個，フルーツは"+pz.fruits.count()+"個");
					System.out.println(pz.distance.get()+"km歩いた．");
				}else{
					break;
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		System.out.println("ボールがなくなった！");

		for(int i=0;i<pz.userMonster.size();i++){
			if(pz.userMonster.get(i)!=null){
				System.out.println(pz.userMonster.get(i)+"を捕まえた．");
			}
		}
	}

}
