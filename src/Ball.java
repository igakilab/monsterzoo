public class Ball {
  private Integer count;
  public Ball() {
    this.count = 10;
  }

  public void add(Integer num) {
    this.count += num;
  }

  public void decrement() {
    this.count -= 1;
  }

  public Integer getCount() {
    return this.count;
  }
}
