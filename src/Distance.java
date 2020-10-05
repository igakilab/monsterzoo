public class Distance {
  private Double distance;
  public Distance() {
    this.distance = 0.0;
  }

  public void increment() {
    this.distance += 1;
  }
  public Double getDistance() {
    return this.distance;
  }
}
