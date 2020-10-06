import java.util.ArrayList;

public class MonsterZukan {
  private ArrayList<Monster> zukan = new ArrayList<Monster>();

  public MonsterZukan() {
    this.setMonsterZukan();
  }

  public Integer size() {
    return this.zukan.size();
  }

  public Monster get(Integer i) {
    return this.zukan.get(i);
  }

  private void setMonsterZukan() {
    this.zukan.add(new Monster("イガキン", 9));
    this.zukan.add(new Monster("ナマチュウ", 3));
		this.zukan.add(new Monster("イノウエン", 1));
		this.zukan.add(new Monster("リョージィ", 2));
		this.zukan.add(new Monster("アキモトン", 5));
		this.zukan.add(new Monster("ゴージマ", 4));
		this.zukan.add(new Monster("チュウデン", 6));
		this.zukan.add(new Monster("ヅカホン", 8));
		this.zukan.add(new Monster("ニシムラー", 7));
		this.zukan.add(new Monster("サコーデン", 2));
		this.zukan.add(new Monster("ウッチー", 5));
		this.zukan.add(new Monster("ハヤッシー", 4));
		this.zukan.add(new Monster("キーチー", 3));
		this.zukan.add(new Monster("リョクン", 1));
		this.zukan.add(new Monster("デコポン", 6));
		this.zukan.add(new Monster("カミサン", 5));
		this.zukan.add(new Monster("シスイ", 1));
		this.zukan.add(new Monster("ジョナ", 7));
		this.zukan.add(new Monster("ギダギダ", 2));
		this.zukan.add(new Monster("ミッツー", 8));
		this.zukan.add(new Monster("ゾエサン", 5));
		this.zukan.add(new Monster("キタバー", 3));
  }
}
