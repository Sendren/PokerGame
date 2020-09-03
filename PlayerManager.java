import java.util.ArrayList;
import java.util.Scanner;

// 玩家管理器
public class PlayerManager {
    // 创建玩家集合
    ArrayList<Player> players = new ArrayList<>();

    // 创建两个玩家
    public void createTwoPlayer(){
        Scanner in = new Scanner(System.in);

        for(int i=1;i<3;i++){
            System.out.println("--------请输入第"+i+"个玩家的姓名---------");
            String name = in.next();
            // 添加玩家到集合中
            players.add(new Player(name));
        }
        in.close();
    }
}
