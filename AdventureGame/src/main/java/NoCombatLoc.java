public abstract class NoCombatLoc extends Location {

    NoCombatLoc(Player player, String name) {
        super(player);
        this.name = name;
    }


    public boolean getLocation() {
        return true;
    }
}
