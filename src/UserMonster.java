import java.util.ArrayList;

public class UserMonster {
  private ArrayList<String> monsters = new ArrayList<String>();

  public String get(Integer i) {
    return this.monsters.get(i);
  }

  public Integer size() {
    return this.monsters.size();
  }

  public void add(String str) {
    this.monsters.add(str);
  }
}
