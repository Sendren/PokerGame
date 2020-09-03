import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class PokerManager {
    // 创建牌组集合
    ArrayList<Poker> pokers = new ArrayList<>();

    // 创建牌组并洗牌
    public void createPoker(){
        System.out.println("- - - - - - - - - - 开始创建扑克牌！- - - - - - - - - -");

        for(int i=0; i < Constant.DOTS.length; i++){
            //遍历2-A
            String dot = Constant.DOTS[i];
            for(int j=0;j<Constant.TYPE.length;j++){
                //遍历 四种花色
                PokerType type = Constant.TYPE[j];
                //添加牌到牌组中
                pokers.add(new Poker(type,dot));
            }
        }
        System.out.println("- - - - - - - - - - 扑克牌创建成功！- - - - - - - - - -");
        System.out.println("- - - - - - - - - - 开始洗牌！- - - - - - - - - - - -");
        // 打乱集合顺序
        Collections.shuffle(pokers);
        System.out.println("- - - - - - - - - - 洗牌结束！- - - - - - - - - - - -");
    }

    // 发牌
    public void dealCards(ArrayList<Player> players){
        System.out.println("------------------开始发牌------------------");

        for(Player player:players){
            //从玩家集合中分别取出玩家来拿牌
            for(int j=0; j<player.pokerT.length; j++){
                //因为顺序已经打乱，每次获取第一张即可
                player.pokerT[j] = pokers.get(0);
                //取完即删，不会获得重复扑克牌
                pokers.remove(0);
            }
            System.out.println("- - - -> 玩家：\"" + player.getName() + "\" 已拿牌");
        }
    }

    //打印牌的信息
    public void showCards(ArrayList<Player> players){
        System.out.println("---------->玩家各自的手牌为：");
        for (Player player:
             players) {
            System.out.println("---->"+player.getName()+ Arrays.toString(player.pokerT));
        }
    }

    //比较两张牌的大小，并返回大的那个
    public Poker comparePoke(Poker p1, Poker p2){
//        System.out.println(Arrays.asList(Constant.DOTS).indexOf(p1.getDot())+"\n"+Arrays.asList(Constant.DOTS).indexOf(p1.getDot()));
        // 按2-A的索引取大小
        if(Arrays.asList(Constant.DOTS).indexOf(p1.getDot()) > Arrays.asList(Constant.DOTS).indexOf(p2.getDot())){

            return p1;
        }
        // 同上
        else if(Arrays.asList(Constant.DOTS).indexOf(p1.getDot()) < Arrays.asList(Constant.DOTS).indexOf(p2.getDot())) return p2;
        //按花色取大小，黑红梅方，ID依次变小
        else
            if (p1.getType().getId() > p2.getType().getId()) return p1;
            else return p2;
    }

    //输出两个玩家各自手中最大的牌，并进行比较，得出胜者
    public void maxPoker(ArrayList<Player> players){
        // 创建一个数组来保存2个玩家最大值
        Poker[] pokerArr = new Poker[2];
        for (int i=0;i<players.size(); i++){
            Player player = players.get(i);
            //取得其一最大值
            Poker p = comparePoke(player.pokerT[0], player.pokerT[1]);
            // 添加进数组
            pokerArr[i] = p;
            // 打印2个玩家的手牌信息
            System.out.println("----->玩家：" + player.getName()+"最大的手牌为："+p.toString());
        }
        //对比2个最大值得到最终最大扑克牌
        Poker winPoker = comparePoke(pokerArr[0], pokerArr[1]);
        for (Player player:players){
            //属于哪个玩家的，就是谁获胜
            if(Arrays.asList(player.pokerT).contains(winPoker)){  //这里由于winPoker和player.pokerT是同个对象，所以可以直接用contains，不需要重写equal方法。
                System.out.println("------->玩家："+ player.getName()+"获胜！");
            }
        }
    }
}

