public class Player {
  private Double distance;
  private Integer balls;

  public Player() {
    this.distance = 0.0;
    this.balls = 10;
  }

  public void addBall(Integer num) {
    this.balls += num;
  }
  public void decrementBall() {
    this.balls -= 1;
  }
  public Integer getBall() {
    return this.balls;
  }

  public void incrementDistance() {
    this.distance += 1;
  }
  public Double getDistance() {
    return this.distance;
  }
}