import java.util.Locale;


public abstract class CombatLoc extends Location{
    protected Enemy enemy;
    protected String item;
    public CombatLoc(Player player, String name, Enemy enemy, String item) {
        super(player);
        this.name = name;
        this.enemy = enemy;
        this.item = item;
    }


    public boolean getLocation(){
        int enemyCount = enemy.enemyCount();
        System.out.println("You are at "+this.getName()+"right now.");
        System.out.println("Caution! There are "+ enemyCount+" "+ enemy.getName()+" here.");
        System.out.println("F<i>ght or f<l>ight?");
        String selectChar = scan.nextLine();
        selectChar = selectChar.toLowerCase();
        if(selectChar.equals("i")){
            if(combat(enemyCount)){
                System.out.println("You defeated all enemies!");
                if(this.item.equals("food") && !player.getInv().isFood()){
                    System.out.println("You won "+this.item);
                    player.getInv().setFood(true);
                }else if(this.item.equals("water") && !player.getInv().isWater()) {
                    System.out.println("You won " + this.item);
                    player.getInv().setWater(true);
                }else if(this.item.equals("firewood") && !player.getInv().isFirewood()) {
                    System.out.println("You won " + this.item);
                    player.getInv().setFood(true);
                }
                return true;
            }
            if(player.getHealth() <=0){
                System.out.println("You died!");
                return false;
            }

        }
        return true;
    }

    public boolean combat(int enemyCount){
        for(int i=0; i<enemyCount; i++){
            int defEnemyHealth = enemy.getHealth();
            playerStats();
            enemyStats();
            while(player.getHealth() >0 && enemy.getHealth() >0){
                System.out.println("F<i>ght or f<l>ight?");
                String selectChar = scan.nextLine();
                selectChar = selectChar.toLowerCase();
                if(selectChar.equals("i")){
                    System.out.println("You hit the "+ enemy.getName());
                    enemy.setHealth(enemy.getHealth()-player.getTotalDmg());
                    afterHit();
                    if(enemy.getHealth() >0) {
                        System.out.println(enemy.getName() + " hit you");
                        player.setHealth(player.getHealth() - (enemy.getDamage() - player.getInv().getArmor()));
                        afterHit();
                    }
                }else{
                    return false;
                }
            }
            if(enemy.getHealth() <player.getHealth()){
                System.out.println("You killed a "+enemy.getName()+"!");
                player.setMoney(player.getMoney()+enemy.getAward());
                System.out.println(enemy.getAward()+" money earned. Total money: "+player.getMoney());
                enemy.setHealth(defEnemyHealth);
            }else{
                return false;
            }
        }
        return true;
    }

    public void playerStats(){
        System.out.println("Player stats\n-------- ");
        System.out.println("Health: "+player.getHealth());
        System.out.println("Damage: "+player.getTotalDmg());
        if(player.getInv().getDamage()>0){
            System.out.println("Weapon: "+player.getInv().getWeaponType());
        }
        if(player.getInv().getArmor()>0){
            System.out.println("Armor: "+player.getInv().getArmorType());
        }
    }

    public void enemyStats(){
        System.out.println();
        System.out.println(enemy.getName()+" stats\n-------");
        System.out.println("Health: "+enemy.getHealth());
        System.out.println("Damage: "+enemy.getDamage());
        System.out.println("Award: "+enemy.getAward());
    }

    public void afterHit(){
        System.out.println("Player health: "+player.getHealth());
        System.out.println(enemy.getName()+" health: "+enemy.getHealth());
    }
}
