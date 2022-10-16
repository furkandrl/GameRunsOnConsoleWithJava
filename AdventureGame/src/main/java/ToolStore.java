public class ToolStore extends NoCombatLoc{

    ToolStore(Player player) {
        super(player, "Tool Store");
    }

    public boolean getLocation(){
        System.out.println("Money: "+player.getMoney());
        System.out.println("(1) Weapons");
        System.out.println("(2) Armors");
        System.out.println("(3) Exit");
        System.out.println("Your choice: ");
        int selectTool = scan.nextInt();
        int selectItemID;
        switch (selectTool){
            case 1:
                selectItemID = weaponMenu();
                buyWeapon(selectItemID);
                break;
            case 2:
                selectItemID = armorMenu();
                buyArmor(selectItemID);
                break;
            case 3:

                break;
            default:
                break;
        }
        return true;
    }

    public int weaponMenu(){
        System.out.println("(1) Pistol\t Damage: 2, Price: 25");
        System.out.println("(2) Sword\t Damage: 3, Price: 35");
        System.out.println("(3) Shotgun\t  Damage: 7, Price: 45");
        System.out.println("(4) Exit");
        System.out.println("Your choice: ");
        int selectItemID = scan.nextInt();
        return selectItemID;
    }

    public void buyWeapon(int selectItemID){
        int damage=0, price=0;
        String weaponName=null;

            switch (selectItemID){
                case 1:
                    damage = 2;
                    weaponName="Pistol";
                    price = 25;
                    break;
                case 2:
                    damage = 3;
                    weaponName="Sword";
                    price = 35;
                    break;
                case 3:
                    damage = 7;
                    weaponName="Shotgun";
                    price = 45;
                    break;
                case 4:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid entry.");
            }
            if (price>0) {
                if (player.getMoney() >= price) {
                    player.getInv().setDamage(damage);
                    player.getInv().setWeaponType(weaponName);
                    player.setMoney(player.getMoney() - price);
                    System.out.println("You bought a " + player.getInv().getWeaponType() + ". You have damage of " + player.getTotalDmg()+ ".");
                    System.out.println("Your money left: " + player.getMoney());
                } else {
                    System.out.println("Insufficient money.");
                }
            }
    }

    public int armorMenu(){
        System.out.println("(1) Light Armor\t Armor: 1, Price: 15");
        System.out.println("(2) Middle Armor\t Armor: 3, Price: 25");
        System.out.println("(3) Heavy Armor\t  Armor: 5, Price: 40");
        System.out.println("(4) Exit");
        System.out.println("Your choice: ");
        int selectItemID = scan.nextInt();
        return selectItemID;
    }

    public void buyArmor(int selectItemID){
        int armor=0, price=0;
        String armorName=null;

        switch (selectItemID){
            case 1:
                armor = 1;
                armorName="Light Armor";
                price = 15;
                break;
            case 2:
                armor = 3;
                armorName="Middle Armor";
                price = 25;
                break;
            case 3:
                armor = 5;
                armorName="Heavy Armor";
                price = 40;
                break;
            case 4:
                System.out.println("Exiting...");
                break;
            default:
                System.out.println("Invalid entry.");
        }
        if (price>0) {
            if (player.getMoney() >= price) {
                player.getInv().setArmor(armor);
                player.getInv().setArmorType(armorName);
                player.setMoney(player.getMoney() - price);
                System.out.println("You bought a " + player.getInv().getArmorType() + ". You armor of " + player.getInv().getArmor()+ ".");
                System.out.println("Your money left: " + player.getMoney());
            } else {
                System.out.println("Insufficient money.");
            }
        }
    }
}
