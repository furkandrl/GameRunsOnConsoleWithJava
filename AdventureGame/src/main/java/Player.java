import java.util.Scanner;

public class Player {


    private int damage,
                health,
                money,
                baseHealth;
    private String name, cType;
    private Inventory inv;
    Scanner scan = new Scanner(System.in);
    public Player(String name) {
        this.name = name;
        this.inv = new Inventory();
    }

    public void selectCh(){
        switch(chMenu()){
            case 1:
                initPlayer("Samurai", 5, 21, 15);
                break;
            case 2:
                initPlayer("Archer", 7, 18, 20);
                break;
            case 3:
                initPlayer("Knight", 8, 24, 5);
                break;
            default:
                setcType("Samurai");
                break;
        }
        System.out.println("Character: "+getcType()+" selected.");
    }

    public int chMenu(){
        System.out.println("Select a character type: ");
        System.out.println("(1) Samurai \t Damage: 5 \t Health: 21 \t Money:15");
        System.out.println("(2) Archer  \t Damage: 7 \t Health: 18 \t Money:20");
        System.out.println("(3) Knight  \t Damage: 8 \t Health: 24 \t Money:5");
        System.out.println("Your choice: ");
        int chId = scan.nextInt();

        while(chId <1 || chId >3 ){
            System.out.println("Enter a valid choice:");
            chId = scan.nextInt();
        }
        return chId;
    }

    public int getTotalDmg(){
        return this.getDamage()+this.getInv().getDamage();
    }
    public void initPlayer(String cType, int dmg, int hlth, int mny){
        setcType(cType);
        setDamage(dmg);
        setHealth(hlth);
        setMoney(mny);
        setBaseHealth(hlth);
    }
    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getcType() {
        return cType;
    }

    public void setcType(String cType) {
        this.cType = cType;
    }

    public Inventory getInv() {
        return inv;
    }

    public void setInv(Inventory inv) {
        this.inv = inv;
    }

    public int getBaseHealth() {
        return baseHealth;
    }

    public void setBaseHealth(int baseHealth) {
        this.baseHealth = baseHealth;
    }
}
