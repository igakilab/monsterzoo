import java.util.ArrayList;

public class Main {
	static MonsterZoo pz = new MonsterZoo();

	public static void main(String[] args) {

		setMonsterZukan();

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

	//テスト用のモンスターデータを登録するメソッド
	public static void setMonsterZukan(){
		ArrayList<Monster> monsterList = new ArrayList<Monster>();
		monsterList.add(new Monster("イガキン", 9));
		monsterList.add(new Monster("ナマチュウ", 3));
		monsterList.add(new Monster("イノウエン", 1));
		monsterList.add(new Monster("リョージィ", 2));
		monsterList.add(new Monster("アキモトン", 5));
		monsterList.add(new Monster("ゴージマ", 4));
		monsterList.add(new Monster("チュウデン", 6));
		monsterList.add(new Monster("ヅカホン", 8));
		monsterList.add(new Monster("ニシムラー", 7));
		monsterList.add(new Monster("サコーデン", 2));
		monsterList.add(new Monster("ウッチー", 5));
		monsterList.add(new Monster("ハヤッシー", 4));
		monsterList.add(new Monster("キーチー", 3));
		monsterList.add(new Monster("リョクン", 1));
		monsterList.add(new Monster("デコポン", 6));
		monsterList.add(new Monster("カミサン", 5));
		monsterList.add(new Monster("シスイ", 1));
		monsterList.add(new Monster("ジョナ", 7));
		monsterList.add(new Monster("ギダギダ", 2));
		monsterList.add(new Monster("ミッツー", 8));
		monsterList.add(new Monster("ゾエサン", 5));
		monsterList.add(new Monster("キタバー", 3));

		pz.setMonsterList(monsterList);
	}

}
