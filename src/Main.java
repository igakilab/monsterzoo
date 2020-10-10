

public class Main {
	static MonsterZoo pz = new MonsterZoo();
	public static void main(String[] args) {
		pz.balls.add(10);
		setMonsterZukan();

		//1000ミリ秒（1秒）ずつ止まりながらpz.move()を呼び出し続ける
		//手持ちのボールが無くなったら終了
		while(true){
			try {
				Thread.sleep(1000);
				if(pz.balls.longValue()>0){
					pz.move();
					System.out.println("手持ちのボールは"+pz.balls+"個，フルーツは"+pz.fruits+"個");
					System.out.println(String.format("%.1fkm歩いた",(float)pz.distance.longValue()));
				}else{
					break;
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		System.out.println("ボールがなくなった！");
		pz.userGetedMonster.forEach(s -> System.out.println(s.monsterName+"を捕まえた．"));
	}

	//テスト用のモンスターデータを登録するメソッド
	public static void setMonsterZukan(){
		pz.mondex.add(new Monster("イガキン",Double.valueOf(9)));
		pz.mondex.add(new Monster("ナマチュウ",Double.valueOf(3)));
		pz.mondex.add(new Monster("イノウエン",Double.valueOf(1)));
		pz.mondex.add(new Monster("リョージィ",Double.valueOf(2)));
		pz.mondex.add(new Monster("アキモトン",Double.valueOf(5)));
		pz.mondex.add(new Monster("ゴージマ",Double.valueOf(4)));
		pz.mondex.add(new Monster("チュウデン",Double.valueOf(6)));
		pz.mondex.add(new Monster("ヅカホン",Double.valueOf(8)));
		pz.mondex.add(new Monster("ニシムラー",Double.valueOf(7)));
		pz.mondex.add(new Monster("サコーデン",Double.valueOf(2)));
		pz.mondex.add(new Monster("ウッチー",Double.valueOf(5)));
		pz.mondex.add(new Monster("ハヤッシー",Double.valueOf(4)));
		pz.mondex.add(new Monster("キーチー",Double.valueOf(3)));
		pz.mondex.add(new Monster("リョクン",Double.valueOf(1)));
		pz.mondex.add(new Monster("デコポン",Double.valueOf(6)));
		pz.mondex.add(new Monster("カミサン",Double.valueOf(5)));
		pz.mondex.add(new Monster("シスイ",Double.valueOf(1)));
		pz.mondex.add(new Monster("ジョナ",Double.valueOf(7)));
		pz.mondex.add(new Monster("ギダギダ",Double.valueOf(2)));
		pz.mondex.add(new Monster("ミッツー",Double.valueOf(8)));
		pz.mondex.add(new Monster("ゾエサン",Double.valueOf(5)));
		pz.mondex.add(new Monster("キタバー",Double.valueOf(3)));
	}

}
