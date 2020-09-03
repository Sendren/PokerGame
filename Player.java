public class Player {
    private final String name;
    // 每个玩家2张牌，用数组保存
    public Poker[] pokerT = new Poker[2];

    public Player(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
