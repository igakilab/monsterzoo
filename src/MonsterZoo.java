public class MonsterZoo {
	final Player player = new Player();

	//卵は最大9個まで持てる．卵を取得するとeggにtrueが代入され，
	//移動するたびに,eggDistanceに1.0kmずつ加算される．
	//3km移動するとランダムでモンスターが孵る
	double eggDistance[] = new double[9];
	boolean egg[] = new boolean[9];

	//モンスター図鑑．モンスターの名前とレア度(0.0~9.0)がそれぞれの配列に保存されている
	//レア度が高いほうが捕まえにくい
	MonsterZukan monsters = new MonsterZukan();

	//呼び出すと1km distanceが増える
	void move(){
		this.player.distance.increment();
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
			this.player.balls.add(b);
			this.player.fruits.add(f);
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
			int m = (int)(this.monsters.size()*Math.random());//monsterListからランダムにモンスターを出す
			System.out.println(this.monsters.get(m).name+"が現れた！");
			for(int i=0;i<3&&this.player.balls.getCount()>0;i++){//捕まえる or 3回ボールを投げるまで繰り返す
				int r = (int)(6*Math.random());//0~5までの数字をランダムに返す
				if(this.player.fruits.getCount()>0){
					System.out.println("フルーツを投げた！捕まえやすさが倍になる！");
					this.player.fruits.decrement();
					r = r * 2;
				}
				System.out.println(this.monsters.get(m).name+"にボールを投げた");
				this.player.balls.decrement();
				if(this.monsters.get(m).rate<=r){//monsterRare[m]の値がr以下の場合
					System.out.println(this.monsters.get(m).name+"を捕まえた！");
					for(int j=0;j<this.player.userMonster.size();j++){
						if(this.player.userMonster.get(j)==null){
							this.player.userMonster.set(j, this.monsters.get(m).name);
							break;
						}
					}
					break;//ボール投げ終了
				}else{
					System.out.println(this.monsters.get(m).name+"に逃げられた！");
				}
			}
		}
		for(int i=0;i<this.egg.length;i++){
			if(this.egg[i]==true&&this.eggDistance[i]>=3){
				System.out.println("卵が孵った！");
				int m = (int)(this.monsters.size()*Math.random());
				System.out.println(this.monsters.get(m).name+"が産まれた！");

				for(int j=0;j<this.player.userMonster.size();j++){
					if(this.player.userMonster.get(j)==null){
						this.player.userMonster.set(j, this.monsters.get(m).name);
						break;
					}
				}
				this.egg[i]=false;
				this.eggDistance[i]=0.0;
			}
		}
	}

}
