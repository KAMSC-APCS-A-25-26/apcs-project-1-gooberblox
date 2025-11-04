import java.util.Scanner;

public class Fight {
    String name;
    double baseHp, baseDmg, relativeDamage, hp, dmg;
    Difficulty diff;
    Scanner input = new Scanner(System.in); // IDGAF, SMD.

    Fight(String fighter, int health, int damage, Difficulty difficulty) {
        name = fighter;
        baseHp = health;
        baseDmg = damage;
        diff = difficulty;

        // determine difficulty
        switch (diff) {
            case EASY -> {
                hp = baseHp * 0.8;   // weaker enemies
                dmg = baseDmg * 0.8;
            }
            case MEDIUM -> {
                hp = baseHp;
                dmg = baseDmg;
            }
            case HARD -> {
                hp = baseHp * 1.3;   // stronger enemies
                dmg = baseDmg * 1.3;
            }
        }
    }

    boolean fight(User player) {
        System.out.println(player.name + " encounters " + name + " (" + diff + ")!");

        double playerHp = player.hp;
        double playerDmg = player.dmg;
        while (playerHp > 0 && hp > 0) {
            System.out.println("\nYour HP: " + (int) playerHp + " | Enemy HP: " + (int) hp);
            System.out.println("Choose an action: [1] Attack  [2] Block  [3] Dodge");
            System.out.print("> ");

            int choice = getPlayerChoice();

            // Player’s turn
            switch (choice) {
                case 1 -> { // ATTACK
                    double damage = playerDmg * (0.8 + Math.random() * 0.4);
                    hp -= damage;
                    System.out.printf("You strike the %s for %.1f damage!%n", name, damage);
                }
                case 2 -> { // BLOCK
                    System.out.println("You brace for impact! Damage taken will be halved this turn.");
                }
                case 3 -> { // DODGE
                    System.out.println("You prepare to dodge the next attack!");
                }
                default -> {
                    System.out.println("❓ You hesitate and lose your turn!");
                }
            }

            // Check if enemy is dead before it attacks
            if (hp <= 0) {
                System.out.println("You defeated the " + name + "!");
                return true;
            }

            // Enemy’s turn
            double enemyAttack = dmg * (0.8 + Math.random() * 0.4);
            boolean enemyHits = Math.random() > 0.35; // 80% hit chance

            if (enemyHits) {
                if (choice == 2) { // Blocked
                    enemyAttack /= 2;
                    System.out.printf("You block some of the attack, taking %.1f damage!%n", enemyAttack);
                } else if (choice == 3 && Math.random() < 0.5) { // Successful dodge
                    System.out.println("You dodged the attack!");
                    enemyAttack = 0;
                } else {
                    System.out.printf("The %s hits you for %.1f damage!%n", name, enemyAttack);
                }
            } else {
                System.out.println("The enemy misses their attack!");
                enemyAttack = 0;
            }

            playerHp -= enemyAttack;
            if (playerHp <= 0) {
                System.out.println("You were defeated by " + name + "...");
                return false;
            }
        }

        return false;
    }

    int getPlayerChoice() {
        while(true) {
            try{
                int choice = input.nextInt();
                if (choice >= 1 && choice <= 3) return choice;
                System.out.print("Invalid option. Enter 1, 2, or 3: ");
            } catch (NumberFormatException e) {
                System.out.print("Enter a valid number (1–3): ");
            }

        }
    }
}
