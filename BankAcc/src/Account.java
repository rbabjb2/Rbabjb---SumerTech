public class Account {
    public int money;
    public boolean premiumAcc;
    public double intrestRate;

    public Account(int money, boolean premiumAcc) {
        this.money = money;
        this.premiumAcc = premiumAcc;
        if (premiumAcc) {
            intrestRate = 0.07;
        } else {
            intrestRate = 0.11;
        }
    }
}
