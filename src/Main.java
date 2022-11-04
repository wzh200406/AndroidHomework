import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请依次输入你的角色的名称、攻击力、防御力：（攻击力与防御力之和至多为100）");
        Person player01 = new Person();
        player01.setName(sc.nextLine());
        player01.setAtk(sc.nextInt());
        player01.setDef(sc.nextInt());//输入角色数值
        player01.setHp(100);
        player01.setSkill(player01.getSkill());
        System.out.println("请输入敌方英雄编号：\n1 蔡徐坤\n2 张翰\n3 丁真");
        int choice = sc.nextInt();
        Person player02 = new Person();
        if (choice == 1){
            player02 = new Person("蔡徐坤",40,60,100, player02.getSkill());
        } else if (choice == 2) {
            player02 = new Person("张翰",20,70,100, player02.getSkill());
        } else if (choice == 3) {
            player02 = new Person("丁真",50,40,90, player02.getSkill());
        }//选定敌方英雄

        while (true){//进行战斗循环
            player01.attack(player02);
            if (player02.getHp() == 0){
                System.out.println("这个敌人就是逊的啦，拜托，你很弱欸，现在知道谁是老大了吼");//设置战胜提示
                break;
            }
            player02.attack(player01);
            if (player01.getHp() == 0){
                System.out.println("如果早知道战败也会被...");//设置战败提示
                break;
            }
        }
    }
}