package core;

/**
 * Class used for storing userinfo and managing user balance.
 */

public class UserInfo {
    public String username;
    public String password;
    public int balance;

    /**
     * This method is only to be used by DEALER. all players needs username and
     * password to create a user.
     */
    public UserInfo(String username) {
        this.username = username;
    }

    public UserInfo(String username, String password) {
        this.username = username;
        this.password = password;
        this.balance = 10000;
    }

    public UserInfo() {
        super();
    }

    /**
     * Sets the players balance
     * 
     * @param int balance
     * @throws IllegalArgumentException if balance < 0
     */
    public void setBalance(int balance) throws IllegalArgumentException {
        if (balance < 0) {
            throw new IllegalArgumentException("Balance must be positive.");
        } else {
            this.balance = balance;
        }
    }

    /**
     * Value cannot be greater than players balance.
     *
     * @param value to remove from the value
     * @throws IllegalArgumentException if value is greater than players balance
     */
    public void removeFromBalance(int value) throws IllegalArgumentException {
        if (value > balance) {
            throw new IllegalArgumentException("Value to be removed cannot be greater than the players balance.");
        } else {
            this.balance -= value;
        }
    }

    /**
     * Value must be positive.
     *
     * @param value to add to the balance
     * @throws IllegalArgumentException if value < 0
     */
    public void addToBalance(int value) throws IllegalArgumentException {
        if (value < 0) {
            throw new IllegalArgumentException("Value to be added must be positive.");
        } else {
            this.balance += value;
        }
    }

    public int getBalance() {
        return balance;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

}
