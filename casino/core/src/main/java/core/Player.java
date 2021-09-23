public class Player {
    private String name;
    private int balance;


    public Player(String name){
        if(name.isBlank()){
            throw new IllegalArgumentException("Player name cannot be blank.");
        }
        this.name = name;
    }

    public Player(String name, int balance){
        super(name);
        if(balance<=0){
            throw new IllegalArgumentException("Player balance must be positive.");
        }
        this.balance=balance;
    }


    public string getName(){
        return this.name;
    }

    public int getBalance(){
        return this.balance;
    }


    public updateBalance() {
        //todo
    }

}
