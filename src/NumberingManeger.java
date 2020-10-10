import java.util.ArrayList;

class NumberingManeger{

  Integer balls= new Integer(10);//モンスターを捕まえられるボールの数
  Integer fruits=new Integer(0);//ぶつけるとモンスターが捕まえやすくなるフルーツ
  Double distance=new Double(0.0);//歩いた距離
  

  // public void add_balls(int n){
  //   balls = balls + n;
  // }

  public void sub_ball(){
    balls--;
  }

  public void add(int n, int j){
    this.fruits = this.fruits + n;
    this.balls = this.balls + j;
  }

  public void sub_fruits(){
    this.fruits--;
  }

  public void add_distance(){
    this.distance++;
  }

  public Double get_distance(){
    return this.distance;
  }

  public Integer get_balls(){
    return this.balls;
  }

  public Integer get_fruits(){
    return this.fruits;
  }
}


  // static EggsTimesandCountParameters eggs_times_and_count_parameters = new EggsTimesandCountParameters();















//オペレータに使えるかもなので残す。
//   void ball_and_fruit_and_egg_get(){
//     System.out.println("ズーstationを見つけた！");
//     int b=(int)(Math.random()*3);//ball,fruits,eggがランダムに出る
//     int f=(int)(Math.random()*2);
//     int e=(int)(Math.random()*2);
//     System.out.println("ボールを"+b+"個，"+"フルーツを"+f+"個"+"卵を"+e+"個Getした！");
//     balls=balls+b;
//     fruits=fruits+f;
//     if(e>=1){//卵を1つ以上Getしたら
//       //egg[]に10個以上卵がない場合は新しい卵データをセットする
//       eggs_times_and_count_parameters.eggs_get_stack();
//       // for(int i=0;i<this.eggDistance.length;i++){
//       //   if(this.egg[i]==false){
//       //     this.egg[i]=true;
//       //     this.eggDistance[i]=0.0;
//       //     break;
//       //   }
//       // }
//     }
//   }
//   void waking_area(){
//     eggs_times_and_count_parameters.egg_warm_up();
//     distance++;
//   }
//
//   void ball_cheak(){
//     if (balls<0) {
//       return true;
//     }
//     return false;
//   }
//
//   void log_printer(){
//     System.out.println("手持ちのボールは"+balls+"個，フルーツは"+fruits+"個"); //ここ2行はlogprinter(仮)
//     System.out.println(pz.getDistance()+"km歩いた．");																		 //とすることで三種の変数
//   }
//
//   Boolean throw_fruits(){
//     if (fruits>0) {
//       return true;
//       fruits--;
//     }
//     // System.out.println("フルーツがなかった!!");
//     return false;
//   }
//
//   Boolean throw_balls(){
//     balls--;
//   }
//
//   void current_ball_count(){
//     return balls;
//   }
// }
