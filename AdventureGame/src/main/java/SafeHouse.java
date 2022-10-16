public class SafeHouse extends NoCombatLoc{

    public SafeHouse(Player player) {
        super(player, "Safe House");
    }

    @Override
    public boolean getLocation() {
        player.setHealth(player.getBaseHealth());
        System.out.println("You are in safe house.");
        System.out.println("You healed up.");
        return true;
    }
}
