import java.util.Random;

public class Person {
    private String name;
    private int atk;
    private int def;
    private double hp;
    private String skill;//封装
    //定义角色属性
    String[] cxkSkill = {"%s发动了普通攻击，向%s扔了一个篮球","%s发动技能“只因你太美”，对%s使用了“铁山靠”并伴随着“诶哟你干嘛”的精神攻击"};
    String[] zhSkill = {"%s发动了普通攻击，摆了个帅气的姿势，%s被油了一下","%s发动技能“东八区的先生们”。%s被油得不忍直视"};
    String[] dzSkill = {"%s对%s发动了攻击，鉴定为普攻","%s对%s发动了技能“疫严丁真，鉴定为测你的码”"};
    String[] mySkill = {"%s对%s发动了普通攻击，绽放出独属主角的华丽攻击特效","%s对%s使用了技能“玩梗”，让对方破大防"};
    //定义角色技能
    public Person(){
    }
    public Person(String name,int atk,int def,double hp,String skill){
        this.name = name;
        this.atk = atk;
        this.def = def;
        this.hp = hp;
        this.skill = skill;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAtk() {
        return atk;
    }

    public void setAtk(int atk0) {
        if (atk0 >= 1 && atk0 <=100){
            atk = atk0;
        }
        else {
            System.out.println("输入的攻击力数值过于离谱");
        }
    }//限定攻击力数值范围

    public int getDef() {
        return def;
    }

    public void setDef(int def0) {
        if (def0 >= 1 && def0 <= 100-atk){
            def = def0;
        }
        else {
            System.out.println("输入的防御力数值过于离谱");
        }
    }//限定防御力数值范围

    public double getHp() {
        return hp;
    }

    public void setHp(double hp) {
        this.hp = hp;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public void attack (Person person){//定义战斗方法
        Random r = new Random();
        double hurt = this.getAtk() - person.getDef()/2;
        hurt =hurt < 1 ? 1 : hurt;//设置伤害计算方式，避免出现负伤害
        int index = r.nextInt(cxkSkill.length);
        if (name == "蔡徐坤"){
            setSkill(cxkSkill[index]);
        } else if (name == "张翰") {
            setSkill(zhSkill[index]);
        } else if (name == "丁真") {
            setSkill(dzSkill[index]);
        } else{
            setSkill(mySkill[index]);
        }
        if (getSkill() == dzSkill[0]||getSkill() == cxkSkill[0]||getSkill() == zhSkill[0]||getSkill() == mySkill[0]){
            System.out.printf(this.getSkill()+"，对"+person.getName()+"造成了"+hurt+"点伤害",this.getName(),person.getName());
            System.out.println();
        }else if (getSkill() == dzSkill[1]||getSkill() == cxkSkill[1]||getSkill() == zhSkill[1]||getSkill() == mySkill[1]){
            System.out.printf(this.getSkill()+"，对"+person.getName()+"造成了"+hurt*1.2+"点伤害",this.getName(),person.getName());
            System.out.println();
            hurt = hurt*1.2;
        }//根据选择的敌方角色分配对应的技能

        double remainhp = person.getHp() - hurt;
        remainhp =remainhp < 0 ? 0 : remainhp;//避免出现负生命值
        person.setHp(remainhp);

    }
}
