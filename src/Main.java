import java.util.ArrayList;

public class Main {
	static MonsterZoo pz = new MonsterZoo();

	public static void main(String[] args) {

		setMonsterZukan();

		//1000ミリ秒（1秒）ずつ止まりながらpz.move()を呼び出し続ける
		//手持ちのボールが無くなったら終了
		while(true){
			try {
				// move_and_log_and_result_printer();
				Thread.sleep(1000);
				if (isball()){
					break;
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public static Boolean isball(){
		if (pz.getBalls() <= 0){
			resultprinter();
			return true;
		}
		move_and_log_and_result_printer();
		return false;
	}

	public static void move_and_log_and_result_printer(){
		// Thread.sleep(1000);
		if(pz.getBalls()>0){
			pz.move();
			current_situation_printer();
		}
	}

	public static void current_situation_printer(){
		System.out.println("手持ちのボールは"+pz.getBalls()+"個，フルーツは"+pz.getFruits()+"個");
		System.out.println(pz.getDistance()+"km歩いた．");
	}

	public static void resultprinter(){
		System.out.println("ボールがなくなった！");

		for(int i=0;i<pz.getUserMonster().length;i++){
			if(pz.getUserMonster()[i]!=null){
				System.out.println(pz.getUserMonster()[i]+"を捕まえた．");
			}
		}
	}

	//テスト用のモンスターデータを登録するメソッド
	public static void setMonsterZukan(){
		// String tempMonster[] = new String[22];
		// double monster_rare[] = new double[22];
		ArrayList<String> monster_type = new ArrayList<String>();
		ArrayList<Integer> monster_rare = new ArrayList<Integer>();
		monster_type.add("イガキン");	monster_rare.add(9);
		monster_type.add("ナマチュウ");	monster_rare.add(3);
		monster_type.add("イノウエン");	monster_rare.add(1);
		monster_type.add("リョージィ");	monster_rare.add(2);
		monster_type.add("アキモトン");	monster_rare.add(5);
		monster_type.add("ゴージマ");	monster_rare.add(4);
		monster_type.add("チュウデン");	monster_rare.add(6);
		monster_type.add("ヅカホン");	monster_rare.add(8);
		monster_type.add("ニシムラー");	monster_rare.add(7);
		monster_type.add("サコーデン");	monster_rare.add(2);
		monster_type.add("ウッチー");	monster_rare.add(5);
		monster_type.add("ハヤッシー");	monster_rare.add(4);
		monster_type.add("キーチー");	monster_rare.add(3);
		monster_type.add("リョクン");	monster_rare.add(1);
		monster_type.add("デコポン");	monster_rare.add(6);
		monster_type.add("カミサン");	monster_rare.add(5);
		monster_type.add("シスイ");	monster_rare.add(1);
		monster_type.add("ジョナ");	monster_rare.add(7);
		monster_type.add("ギダギダ");	monster_rare.add(2);
		monster_type.add("ミッツー");	monster_rare.add(8);
		monster_type.add("ゾエサン");	monster_rare.add(5);
		monster_type.add("キタバー");	monster_rare.add(3);

		pz.setMonsterZukan(monster_type);
		pz.setMonsterRare(monster_rare);
	}

}
