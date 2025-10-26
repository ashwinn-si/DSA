class Bank {
  private long balance[];
  private long count;

  private boolean validateAccount(int account) {
    return account > 0 && account <= count;
  }

  public Bank(long[] balance) {
    this.balance = balance;
    count = this.balance.length;
  }

  public boolean transfer(int account1, int account2, long money) {
    return validateAccount(account1) && validateAccount(account2) && withdraw(account1, money)
        && deposit(account2, money);
  }

  public boolean deposit(int account, long money) {
    if (!validateAccount(account)) {
      return false;
    }
    this.balance[account - 1] += money;
    return true;
  }

  public boolean withdraw(int account, long money) {
    if (!validateAccount(account)) {
      return false;
    }
    long currBalance = this.balance[account - 1];
    if (currBalance >= money) {
      this.balance[account - 1] -= money;
      return true;
    }
    return false;
  }
}
