import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


// class Ball {
// 	int counts = 10; // モンスターを捕まえられるボールの数
// }

// class Monster {

// }

// class User {
// 	List<String> userMonster = new ArrayList<String>();
// 	getMonster() {
// 		for(int j=0;j<userMonster.size()+1;j++){
// 			if(this.userMonster[j]==null){
// 				this.userMonster[j]=this.monsters.get(m);
// 				break;
// 			}
// 		}
// 	}
// }


public class MonsterZoo {
	double distance=0.0;//歩いた距離
	int balls=10;//モンスターを捕まえられるボールの数
	int fruits=0;//ぶつけるとモンスターが捕まえやすくなるフルーツ

	//卵は最大9個まで持てる．卵を取得するとeggにtrueが代入され，
	//移動するたびに,eggDistanceに1.0kmずつ加算される．
	//3km移動するとランダムでモンスターが孵る
	double eggDistance[] = new double[9];
	boolean egg[] = new boolean[9];

	//ユーザがGetしたモンスター一覧
	String userMonster[] = new String[100];

	//モンスター図鑑．モンスターの名前とレア度(0.0~9.0)がそれぞれの配列に保存されている
	//レア度が高いほうが捕まえにくい
	List<String> monsters = new ArrayList<String>();
	List<Integer> rarity = new ArrayList<Integer>();

	//呼び出すと1km distanceが増える
	void move(){
		this.distance++;
		for(int i=0;i<this.egg.length;i++){//卵は移動距離が進むと孵化するため，何km移動したかを更新する
			if(this.egg[i]==true){
				this.eggDistance[i]++;
			}
		}

		int flg1 = (int)(Math.random()*10);//0,1の場合はズーstation，7~9の場合はモンスター
		if(flg1<=1){
			System.out.println("ズーstationを見つけた！");
			int b=(int)(Math.random()*3);//ball,fruits,eggがランダムに出る
			int f=(int)(Math.random()*2);
			int e=(int)(Math.random()*2);
			System.out.println("ボールを"+b+"個，"+"フルーツを"+f+"個"+"卵を"+e+"個Getした！");
			this.balls=this.balls+b;
			this.fruits=this.fruits+f;
			if(e>=1){//卵を1つ以上Getしたら
				//egg[]に10個以上卵がない場合は新しい卵データをセットする
				for(int i=0;i<this.eggDistance.length;i++){
					if(this.egg[i]==false){
						this.egg[i]=true;
						this.eggDistance[i]=0.0;
						break;
					}
				}
			}
		}else if(flg1>=7){
			int m = (int)(this.monsters.size()*Math.random());//monstersからランダムにモンスターを出す

			System.out.println(this.monsters.get(m)+"が現れた！");
			for(int i=0;i<3&&this.balls>0;i++){//捕まえる or 3回ボールを投げるまで繰り返す
				int r = (int)(6*Math.random());//0~5までの数字をランダムに返す
				if(this.fruits>0){
					System.out.println("フルーツを投げた！捕まえやすさが倍になる！");
					this.fruits--;
					r = r * 2;
				}
				System.out.println(this.monsters.get(m)+"にボールを投げた");
				this.balls--;
				if(this.rarity.get(m)<=r){//monsterRare[m]の値がr以下の場合
					System.out.println(this.monsters.get(m)+"を捕まえた！");
					for(int j=0;j<userMonster.length;j++){
						if(this.userMonster[j]==null){
							this.userMonster[j]=this.monsters.get(m);
							break;
						}
					}
					break;//ボール投げ終了
				}else{
					System.out.println(this.monsters.get(m)+"に逃げられた！");
				}
			}
		}
		for(int i=0;i<this.egg.length;i++){
			if(this.egg[i]==true&&this.eggDistance[i]>=3){
				System.out.println("卵が孵った！");
				int m = (int)(this.monsters.size()*Math.random());
				System.out.println(this.monsters.get(m)+"が産まれた！");

				for(int j=0;j<userMonster.length;j++){
					if(this.userMonster[j]==null){
						this.userMonster[j]=this.monsters.get(m);
						break;
					}
				}
				this.egg[i]=false;
				this.eggDistance[i]=0.0;
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

	public String[] getUserMonster() {
		return userMonster;
	}

	public void setMonsters(List<String> monsters) {
		this.monsters = monsters;
	}

	public void setRarity(List<Integer> rarity) {
		this.rarity = rarity;
	}
}
