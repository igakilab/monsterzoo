import java.util.ArrayList;

public class MonsterZoo {
	double distance=0.0;//歩いた距離
	int balls=10;//モンスターを捕まえられるボールの数
	int fruits=0;//ぶつけるとモンスターが捕まえやすくなるフルーツ

	//卵は最大9個まで持てる．卵を取得するとeggにtrueが代入され，
	//移動するたびに,eggDistanceに1.0kmずつ加算される．
	//3km移動するとランダムでモンスターが孵る
    ArrayList<Egg> userHavingEggs = new ArrayList<>();
	//ユーザがGetしたモンスター一覧
	ArrayList <Monster> userGetedMonster = new ArrayList<>();

	//モンスター図鑑．モンスターの名前とレア度(0.0~9.0)がそれぞれの配列に保存されている
	//レア度が高いほうが捕まえにくい
	ArrayList <Monster> mondex = new ArrayList<>();

	//呼び出すと1km distanceが増える
	void move(){
		this.distance++;
		this.userHavingEggs.stream().filter(i->!i.isBone).forEach(i->i.distance++);

		int flg1 = (int)(Math.random()*10);//0,1の場合はズーstation，7~9の場合はモンスター
		if(flg1<=1){
			this.arriveAtZooStation();
		}else if(flg1>=7){
			this.encountMonster();
		}
		this.userHavingEggs.stream().filter(i->(!i.isBone&&i.distance>=3.0)).forEach(i->{
			this.userGetedMonster.add(i.boneMonster(this.mondex));
		});

	}
	public void arriveAtZooStation(){
		System.out.println("ズーstationを見つけた！");
		int b=(int)(Math.random()*3);//ball,fruits,eggがランダムに出る
		int f=(int)(Math.random()*2);
		int e=(int)(Math.random()*2);
		System.out.println("ボールを"+b+"個，"+"フルーツを"+f+"個"+"卵を"+e+"個Getした！");
		this.balls=this.balls+b;
		this.fruits=this.fruits+f;
		if(e>=1){//卵を1つ以上Getしたら
			//egg[]に10個以上卵がない場合は新しい卵データをセットする
			if(userHavingEggs.stream().filter(i->!i.isBone).count()<10)
				this.userHavingEggs.add(new Egg());
		}
	}
	public void encountMonster(){
		int m = (int)(this.mondex.size()*Math.random());//monsterZukanからランダムにモンスターを出す
		System.out.println(this.mondex.get(m).monsterName+"が現れた！");
		for(int i=0;i<3&&this.balls>0;i++){//捕まえる or 3回ボールを投げるまで繰り返す
			int r = (int)(6*Math.random());//0~5までの数字をランダムに返す
			if(this.fruits>0){
				System.out.println("フルーツを投げた！捕まえやすさが倍になる！");
				this.fruits--;
				r = r * 2;
			}
			System.out.println(this.mondex.get(m).monsterName+"にボールを投げた");
			this.balls--;
			if(this.mondex.get(m).monsterRate<=r){//monsterRare[m]の値がr以下の場合
				System.out.println(this.mondex.get(m).monsterName+"を捕まえた！");
				this.userGetedMonster.add(this.mondex.get(m));
				break;//ボール投げ終了
			}else{
					System.out.println(this.mondex.get(m).monsterName+"に逃げられた！");
				}
			}
	}
	public double getDistance() {
		return distance;
	}

	public int getBalls() {
		return balls;
	}

	public int getFruits() {
		return fruits;
	}
}
