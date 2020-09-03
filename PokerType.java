// 设置扑克牌类型
public class PokerType {
    private final String pic;
    private final int id;

    public PokerType(String pic, int id){
        this.pic = pic;
        this.id = id;
    }
    // 定义四个花色的构造器
    public static final PokerType SPADES = new PokerType("黑桃",4);
    public static final PokerType HEARTS = new PokerType("红桃",3);
    public static final PokerType CLUBS = new PokerType("梅花",2);
    public static final PokerType DIAMOND = new PokerType("方块",1);

    public int getId() {
        return id;
    }

    public String getPic() {
        return pic;
    }
}
