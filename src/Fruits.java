public class Fruits {
  private Integer count;

  public Fruits() {
    this.count = 0;
  }

  public Integer count() {
    return this.count;
  }

  public void add(Integer num) {
    this.count += num;
  }

  public void decrement() {
    this.count -= 1;
  }
}
