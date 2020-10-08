public class MonsterZoo {
	// public Ball balls = new Ball();
	// public Distance distance = new Distance();
	// public Fruits fruits = new Fruits();
	// public UserMonster userMonster = new UserMonster();
	// private Egg egg = new Egg();
	public Player player = new Player();

	//モンスター図鑑．モンスターの名前とレア度(0.0~9.0)がそれぞれの配列に保存されている
	//レア度が高いほうが捕まえにくい
	MonsterZukan monsters = new MonsterZukan();

	//呼び出すと1km distanceが増える
	void move(){
		player.distance.increment();
		player.egg.walk();

		int flg1 = (int)(Math.random()*10);//0,1の場合はズーstation，7~9の場合はモンスター
		if(flg1<=1){
			ZooStation zooStation = new ZooStation();
			System.out.println("ズーstationを見つけた！");
			int b=(int)(Math.random()*3);//ball,fruits,eggがランダムに出る
			int f=(int)(Math.random()*2);
			int e=(int)(Math.random()*2);
			System.out.println("ボールを"+b+"個，"+"フルーツを"+f+"個"+"卵を"+e+"個Getした！");
			player.balls.add(b);
			player.fruits.add(f);
			if(e>=1){//卵を1つ以上Getしたら
				//egg[]に10個以上卵がない場合は新しい卵データをセットする
				if (player.egg.count() < 10) {
					player.egg.add();
				}
			}
		}else if(flg1>=7){
			int m = (int)(this.monsters.size()*Math.random());//monsterListからランダムにモンスターを出す
			System.out.println(this.monsters.get(m).name+"が現れた！");
			for(int i=0;i<3&&player.balls.count()>0;i++){//捕まえる or 3回ボールを投げるまで繰り返す
				int r = (int)(6*Math.random());//0~5までの数字をランダムに返す
				if(player.fruits.count()>0){
					System.out.println("フルーツを投げた！捕まえやすさが倍になる！");
					player.fruits.decrement();
					r = r * 2;
				}
				System.out.println(this.monsters.get(m).name+"にボールを投げた");
				player.balls.decrement();
				if(this.monsters.get(m).rate<=r){//monsterRare[m]の値がr以下の場合
					System.out.println(this.monsters.get(m).name+"を捕まえた！");
					player.monster.add(this.monsters.get(m).name);
					break;//ボール投げ終了
				}else{
					System.out.println(this.monsters.get(m).name+"に逃げられた！");
				}
			}
		}

		for (int i=0; i<player.egg.hatching(); i++) {
			System.out.println("卵が孵った！");
			int m = (int)(this.monsters.size()*Math.random());
			System.out.println(this.monsters.get(m).name + "が産まれた！");
			player.monster.add(this.monsters.get(m).name);
		}
	}

}
