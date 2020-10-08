public class ZooStation {
  public ZooStation(Player player) {
    System.out.println("ズーstationを見つけた！");
    Integer ballStatus   = (int)(Math.random() * 3);
    Integer fruitsStatus = (int)(Math.random() * 3);
    Integer eggStatus    = (int)(Math.random() * 3);
    System.out.println("ボールを"+ballStatus+"個，"+"フルーツを"+fruitsStatus+"個"+"卵を"+eggStatus+"個Getした！");
    player.balls.add(ballStatus);
    player.fruits.add(fruitsStatus);
    if (eggStatus >= 1 && player.egg.count() < 10) {
      player.egg.add();
    }
  }
}