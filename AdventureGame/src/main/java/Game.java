import java.util.Scanner;

public class Game {
    Player player;
    Location location;
    Scanner scan = new Scanner(System.in);

    public void login(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome to the Adventure Game!");
        System.out.println("Enter your name: ");
        String pName = scan.nextLine();
        player = new Player(pName);
        player.selectCh();
        start();
    }

    public void start() {
        while (true) {
            System.out.println();
            System.out.println("====================");
            System.out.println("Select a location: ");
            System.out.println("(1) Safe House: No enemies, heal up.");
            System.out.println("(2) Cave: Zombie hazard.");
            System.out.println("(3) Forest: Vampire hazard.");
            System.out.println("(4) River: Bear hazard.");
            System.out.println("(5) Tool Store: Buy weapons and armors.");
            System.out.print("Location: ");
            int selectLoc = scan.nextInt();
            while (selectLoc < 1 || selectLoc > 5) {
                System.out.println("Enter a valid choice:");
                selectLoc = scan.nextInt();
            }

            switch (selectLoc) {
                case 1:
                    location = new SafeHouse(player);
                    break;
                case 2:
                    location = new Cave(player);
                    break;
                case 3:
                    location = new Forest(player);
                    break;
                case 4:
                    location = new River(player);
                    break;
                case 5:
                    location = new ToolStore(player);
                    break;
                default:
                    location = new SafeHouse(player);
            }

            if(location.getClass().getName().equals("Safe House")){
                if(player.getInv().isFood() && player.getInv().isWater() && player.getInv().isFirewood()){
                    System.out.println("Congratulations! You win!");
                    break;
                }
            }
            if(!location.getLocation()){
                System.out.println("Game Over!");
                break;
            }
        }
    }
}
