public class Account {
    public int money;
    public boolean premiumAcc;
    public double intrestRate;

    public Account(boolean premiumAcc, int money) {
        this.money = money;
        this.premiumAcc = premiumAcc;
        if (premiumAcc) {
            intrestRate = 0.07;
        } else {
            intrestRate = 0.11;
        }
    }

    public String getPremiumAcc() {
        if (premiumAcc == true) {
            return "true";
        } else {
            return "false";
        }
    }
}
