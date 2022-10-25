public class StatusSetAndGet{
    public static void setMonsterZukan(MonsterZoo pz, String zukanNumber, String monsterName){
        pz.monsterZukan[Integer.parseInt(zukanNumber)] = monsterName;
    }
    public static void setMonsterRare(MonsterZoo pz, String zukanNumber, String monsterRare){
        pz.monsterRare[Integer.parseInt(zukanNumber)] = Double.parseDouble(monsterRare);
    }
    public double getDistance(MonsterZoo pz){
        return pz.distance;
    }
    public int getBalls(MonsterZoo pz){
        return pz.balls;
    }
    public int getFruits(MonsterZoo pz){
        return pz.fruits;
    }
    public String[] getUserMonster(MonsterZoo pz){
        return pz.userMonster;
    }
}
