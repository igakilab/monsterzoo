import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.concurrent.atomic.AtomicInteger;

public class Egg {
  private ArrayList<Double> egg = new ArrayList<Double>();
  
  public Integer count() {
    return this.egg.size();
  }

  public void walk() {
    AtomicInteger i = new AtomicInteger();
    this.egg.forEach(v -> this.egg.set(i.getAndIncrement(), v+=1.0));
  }

  public void add() {
    this.egg.add(0.0);
  }

  public Integer hatching () {
    Integer hatchingEgg = this.egg.stream().filter(v -> v.equals(3.0)).collect(Collectors.toList()).size();
    this.egg.removeIf(v -> v.equals(3.0));
    return hatchingEgg;
  }
}
