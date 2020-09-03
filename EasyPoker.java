public class EasyPoker {
    public static void main(String[] args) {
        //构建牌组管理器
        PokerManager PokerM = new PokerManager();
        //构建玩家管理器
        PlayerManager PlayerM = new PlayerManager();
        //创建牌组
        PokerM.createPoker();
        //创建玩家
        PlayerM.createTwoPlayer();
        //欢迎用语
        for (Player player:PlayerM.players
             ) {
            System.out.println("----->欢迎玩家："+player.getName());
        }
        //玩家拿牌
        PokerM.dealCards(PlayerM.players);
        //打印玩家的牌
        PokerM.showCards(PlayerM.players);
        //输出玩家手中最大的牌,得到胜利者
        PokerM.maxPoker(PlayerM.players);
    }
}
