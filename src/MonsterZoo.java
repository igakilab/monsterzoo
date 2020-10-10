import java.util.ArrayList;
import java.util.concurrent.atomic.LongAdder;

public class MonsterZoo {
	public final LongAdder distance= new LongAdder();//歩いた距離
	public final LongAdder balls = new LongAdder();//モンスターを捕まえられるボールの数
	public final LongAdder fruits = new LongAdder();//ぶつけるとモンスターが捕まえやすくなるフルーツ

	//卵は最大9個まで持てる．移動するたびに,distanceに1kmずつ加算される．
	//3km移動するとランダムでモンスターが孵る
    final ArrayList<Egg> userHavingEggs = new ArrayList<>();
	//ユーザがGetしたモンスター一覧
	final ArrayList <Monster> userGetedMonster = new ArrayList<>();

	//モンスター図鑑．モンスターの名前とレア度(0.0~9.0)がそれぞれの配列に保存されている
	//レア度が高いほうが捕まえにくい
	final ArrayList <Monster> mondex = new ArrayList<>();

	//呼び出すと1km distanceが増える
	void move(){
		this.distance.increment();
		this.userHavingEggs.stream().filter(i->!i.isBone).forEach(i->i.distance.increment());
		int flg1 = (int)(Math.random()*10);//0,1の場合はズーstation，7~9の場合はモンスター
		if(flg1<=1) this.arriveAtZooStation();
		else if(flg1>=7) this.encountMonster();
		this.userHavingEggs.stream().filter(i->(!i.isBone&&i.distance.longValue()>=3)).forEach(i->{
			this.userGetedMonster.add(i.boneMonster(this.mondex));
		});
	}
	public void arriveAtZooStation(){
		System.out.println("ズーstationを見つけた！");
		final int b=(int)(Math.random()*3);//ball,fruits,eggがランダムに出る
		final int f=(int)(Math.random()*2);
		final int e=(int)(Math.random()*2);
		System.out.println("ボールを"+b+"個，"+"フルーツを"+f+"個"+"卵を"+e+"個Getした！");
		this.balls.add(b);
		this.fruits.add(f);
		if(e>=1) if(userHavingEggs.stream().filter(i->!i.isBone).count()<10)
			this.userHavingEggs.add(new Egg());
	}
	public void encountMonster(){
		int m = (int)(this.mondex.size()*Math.random());//monsterZukanからランダムにモンスターを出す
		System.out.println(this.mondex.get(m).monsterName+"が現れた！");
		for(int i=0;i<3&&this.balls.longValue() >0;i++){//捕まえる or 3回ボールを投げるまで繰り返す
			int r = (int)(6*Math.random());//0~5までの数字をランダムに返す
			if(this.fruits.longValue()>0){
				System.out.println("フルーツを投げた！捕まえやすさが倍になる！");
				this.fruits.decrement();
				r = r * 2;
			}
			System.out.println(this.mondex.get(m).monsterName+"にボールを投げた");
			this.balls.decrement();
			if(this.mondex.get(m).monsterRate<=r){//monsterRare[m]の値がr以下の場合
				System.out.println(this.mondex.get(m).monsterName+"を捕まえた！");
				this.userGetedMonster.add(this.mondex.get(m));
				break;//ボール投げ終了
			}else{
					System.out.println(this.mondex.get(m).monsterName+"に逃げられた！");
				}
			}
	}
}
