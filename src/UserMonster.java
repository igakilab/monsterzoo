import java.util.ArrayList;

public class UserMonster {
  private ArrayList<String> monsters;

  public UserMonster() {
    this.monsters = new ArrayList<String>();
  }

  public String get(Integer i) {
    return this.monsters.get(i);
  }

  public Integer size() {
    return this.monsters.size();
  }

  public void set(Integer i, String str) {
    this.monsters.set(i, str);
  }
}
