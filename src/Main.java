import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Main {
	static MonsterZoo pz = new MonsterZoo();

	public static void main(String[] args) {

		setMonsterZukan();

		actionLoop();

		resultOutput();
	}

	//テスト用のモンスターデータを登録するメソッド
	public static void setMonsterZukan(){
		
		List<String> monsters = new ArrayList<>(
			Arrays.asList(
				"イガキン", "ナマチュウ", "イノウエン", "リョージィ", "アキモトン", 
				"ゴージマ", "チュウデン", "ヅカホン", "ニシムラー", "サコーデン", 
				"ウッチー", "ハヤッシー", "キーチー", "リョクン", "デコポン", 
				"カミサン", "シスイ", "ジョナ", "ギダギダ", "ミッツー", 
				"ゾエサン", "キタバー"
			)
		);

		List<Integer> rarity = new ArrayList<>(
			Arrays.asList(
				9, 3, 1, 2, 5, 
				4, 6, 8, 7, 2, 
				5, 4, 3, 1, 6, 
				5, 1, 7, 2, 8, 
				5, 3
			)
		);

		pz.setMonsters(monsters);
		pz.setRarity(rarity);
	}

  // ballsが0になるまでのアクションのループ処理を行うメソッド
	public static void actionLoop() {
		//1000ミリ秒（1秒）ずつ止まりながらpz.move()を呼び出し続ける
		//手持ちのボールが無くなったら終了
		while(true){
			try {
				Thread.sleep(1000);
				if(pz.getBalls()>0){
					pz.move();
					System.out.println("手持ちのボールは"+pz.getBalls()+"個，フルーツは"+pz.getFruits()+"個");
					System.out.println(pz.getDistance()+"km歩いた．");
				}
				if(pz.getBalls()==0) break;
			} catch (InterruptedException e) {
				e.printStackTrace(); // スタックトレース(実行したメソッドの時系列)を出力
			}
		}
	}

  // 結果を出力するメソッド
	public static void resultOutput(){
		System.out.println("ボールがなくなった！");

		for(int i=0;i<pz.getUserMonster().length;i++){
			if(pz.getUserMonster()[i]!=null){
				System.out.println(pz.getUserMonster()[i]+"を捕まえた．");
			}
		}
	}
}
