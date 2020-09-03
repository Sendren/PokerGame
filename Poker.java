// 扑克牌基本属性
public class Poker {
    private final PokerType type;
    private final String dot;

    public  Poker(PokerType type, String dot){
        this.type = type;
        this.dot = dot;
    }
    // 重写toString，直接打印 花色+点数
    public String toString(){
        return this.type.getPic() + this.dot;
    }

    public PokerType getType() {
        return type;
    }

    public String getDot() {
        return dot;
    }
}
