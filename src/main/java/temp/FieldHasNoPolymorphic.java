package temp;

/**
 * @Desc
 * @Author wuzh
 * @Date 2020/12/10
 */
public class FieldHasNoPolymorphic {
    static class Father {
        public int money = 1;

        public Father() {
            money = 2;
            this.showMeTheMoney();
        }

        public void showMeTheMoney() {
            System.out.println("I am Father, i have $" + this.money);
        }
    }

    static class Son extends Father {
        public int money = 3;

        public Son() {
            money = 4;
            this.showMeTheMoney();
        }

        public void showMeTheMoney() {
            System.out.println("I am Son, i have $" + this.money);
        }
    }

    public static void main(String[] args) {
        Father gay = new Son();
        System.out.println("This gay has $" + gay.money);
    }

    // 输出：
    // I am Son, i have $0
    // I am Son, i have $4
    // This gay has $2
}
