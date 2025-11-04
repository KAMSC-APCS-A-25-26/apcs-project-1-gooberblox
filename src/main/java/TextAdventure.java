import java.io.IOException;
import java.util.Scanner;

public class TextAdventure {
    static Scanner scan = new Scanner(System.in);
    private static void printWithBreak(String output, long millis) throws InterruptedException {
        System.out.println(output);
        Thread.sleep(millis);
    }


    String[] sbuf;
    private static void clearScreen() throws IOException, InterruptedException {
        new ProcessBuilder("clear").inheritIO().start().waitFor();
    }

    static int getInput(String input, int len) {
        int output;
        while(true) {
            System.out.println(input);
            output = scan.nextInt();
            if(output < 0 || output > len) {
                System.out.println("BAD.");
                continue;
            }
            return output;
        }
    }
    public static void main(String[] args) throws InterruptedException, IOException {
        int choice; // dummy var for all the menu choices.

        gameState state = new gameState();
        System.out.println("                                                                                                                                                                                                                                                                                                      \n" +
                " _________________  ____      ______  _______        ______  _______    _____      _____        _________________       _____     ____   ____       _____     ____   ____        ____    ____  _____   ______    ____   ____       _____    ____    ____   ____             ______            ______  \n" +
                "/                 \\|    |    |      \\/       \\      |      \\/       \\  |\\    \\    /    /|      /                 \\ ____|\\    \\   |    | |    |  ___|\\    \\   |    | |    |      |    |  |    ||\\    \\ |\\     \\  |    | |    |  ___|\\    \\  |    |  |    | |    |        ___|\\     \\       ___|\\     \\ \n" +
                "\\______     ______/|    |   /          /\\     \\    /          /\\     \\ | \\    \\  /    / |      \\______     ______//     /\\    \\  |    | |    | /    /\\    \\  |    | |    |      |    |  |    | \\\\    \\| \\     \\ |    | |    | /    /\\    \\ |    |  |    | |    |       |     \\     \\     |    |\\     \\\n" +
                "   \\( /    /  )/   |    |  /     /\\   / /\\     |  /     /\\   / /\\     ||  \\____\\/    /  /         \\( /    /  )/  /     /  \\    \\ |    | |    ||    |  |____| |    |_|    |      |    | /    //  \\|    \\  \\     ||    | |    ||    |  |    ||    | /    // |    |       |     ,_____/|    |    |/____/|\n" +
                "    ' |   |   '    |    | /     /\\ \\_/ / /    /| /     /\\ \\_/ / /    /| \\ |    /    /  /           ' |   |   '  |     |    |    ||    | |    ||    |    ____ |    .-.    |      |    |/ _ _//    |     \\  |    ||    | |    ||    |  |____||    |/ _ _//  |    |  ____ |     \\--'\\_|/ ___|    \\|   | |\n" +
                "      |   |        |    ||     |  \\|_|/ /    / ||     |  \\|_|/ /    / |  \\|___/    /  /              |   |      |     |    |    ||    | |    ||    |   |    ||    | |    |      |    |\\    \\'    |      \\ |    ||    | |    ||    |   ____ |    |\\    \\'  |    | |    ||     /___/|  |    \\    \\___|/ \n" +
                "     /   //        |    ||     |       |    |  ||     |       |    |  |      /    /  /              /   //      |\\     \\  /    /||    | |    ||    |   |_,  ||    | |    |      |    | \\    \\    |    |\\ \\|    ||    | |    ||    |  |    ||    | \\    \\  |    | |    ||     \\____|\\ |    |\\     \\    \n" +
                "    /___//         |____||\\____\\       |____|  /|\\____\\       |____|  /     /____/  /              /___//       | \\_____\\/____/ ||\\___\\_|____||\\ ___\\___/  /||____| |____|      |____|  \\____\\   |____||\\_____/||\\___\\_|____||\\ ___\\/    /||____|  \\____\\ |____|/____/||____ '     /||\\ ___\\|_____|   \n" +
                "   |`   |          |    || |    |      |    | / | |    |      |    | /     |`    | /              |`   |         \\ |    ||    | /| |    |    || |   /____ / ||    | |    |      |    |   |    |  |    |/ \\|   ||| |    |    || |   /____/ ||    |   |    ||    |     |||    /_____/ || |    |     |   \n" +
                "   |____|          |____| \\|____|      |____|/   \\|____|      |____|/      |_____|/               |____|          \\|____||____|/  \\|____|____| \\|___|    | / |____| |____|      |____|   |____|  |____|   |___|/ \\|____|____| \\|___|    | /|____|   |____||____|_____|/|____|     | / \\|____|_____|   \n" +
                "     \\(              \\(      \\(          )/         \\(          )/            )/                    \\(               \\(    )/        \\(   )/     \\( |____|/    \\(     )/          \\(       )/      \\(       )/      \\(   )/     \\( |____|/   \\(       )/    \\(    )/     \\( |_____|/     \\(    )/     \n" +
                "      '               '       '          '           '          '             '                      '                '    '          '   '       '   )/        '     '            '       '        '       '        '   '       '   )/       '       '      '    '       '    )/         '    '      \n" +
                "                                                                                                                                                      '                                                                              '                                         '                      ");
        Thread.sleep(1000);
        System.out.println("You are Timmy Tough Knuckles, a street fighter who's hooker girlfriend just left him.");
        Thread.sleep(1000);
        Difficulty diff;
        while(true) {
            System.out.println("What difficulty do you want? (Easy, Medium, Hard) ");
            String s = scan.next().toUpperCase();
            try {
                diff = Difficulty.valueOf(s);
            } catch (IllegalArgumentException e) {
                System.out.println("didn't pick an option. bad boy.");
                continue;
            }
            // freaky control flow bullshit that i HATE
            break;
        }
        User user = new User(diff);
        /*
            String originalString = "hello world";
    String upperCaseString = originalString.toUpperCase();
    use this part and then use valueOf() on the enum with the uppercase
         */
        // scene one
        printWithBreak("You arrive to a back alley, where you meet Conner Chan",500);
        printWithBreak("He pees all over you, and says \"hey, you're the guy who's girl i stole\"",500);

        while(true) {
            System.out.println("DO YOU: \n1. Fight him\n2. Walk away\n3. Teach him the ways of zen");
            choice = scan.nextInt();
            if(choice < 0 || choice >3) {
                System.out.println("brother pick one through three");
            } else {
                break;
            }
        }
        switch (choice) {
            case 1 -> {
                // beat his ass.
                Fight connorFight = new Fight("Conner Chan",150,10, diff);
                if(connorFight.fight(user)) {
                    // beat him
                    System.out.println("You have beaten THE Conner Chan, drunken brawler.");
                    state.beatConner = true;
                    state.fightsWon++;
                } else {
                    System.out.println("You were beaten by Conner, and you leave, a shell of the man you once were.");
                    state.beatConner = false;
                    state.fightsLost++;
                }

            }
            case 2 -> {
                System.out.println("You walk away, weirded out and covered in pee, but unscathed.");
                state.fightsIgnored++;
            }
            case 3 -> {
                printWithBreak("You explain to him the zen ways, and he responds \"sure dude, whatever you say\"",500);
                state.zenScore++;
            }
        }

        // scene 2.
        printWithBreak("You wake up in the middle of the night to your friend banging on your door.",500);
        printWithBreak("You answer the door and he says \"yo dude, theres a big fight" +
                "out tonight.\n i heard your EX is gonna be there. why not show up?\"",750);
        printWithBreak("You reluctantly agree, and head down to the spot.\n" +
                "When you arrive, the ring is packed.",250);
        printWithBreak("Your friend tells you he's got to see someone, but you're up next to fight.",500);

        // these loops will be the bane of my existence
        while(true) {
            System.out.println("DO YOU: \n1. Fight him\n2. Return home to meditate and practice your zen");
            choice = scan.nextInt();
            if(choice < 0 || choice >3) {
                System.out.println("brother pick one through two");
            } else {
                break;
            }
        }
        if(choice == 1) {
            // fight johnny
            Fight fight = new Fight("Johnny", 110, 20, diff);
            if (fight.fight(user)) {
                System.out.println("You beat Johnny, leaving your hooker ex impressed, as she watches from the crowd");
                state.beatJohnny = true;
                state.fightsWon++;
            } else {
                System.out.println("You lose to Johnny, leaving your hooker ex laughing at you.");
                state.beatJohnny = false;
                state.fightsLost++;
            }
        } else {
            System.out.println("You profess your commitment to meditation, leaving the entire crowd confused.\n\n\n" +
                    "You head home to burn incense and meditate.");
            state.zenScore++;
        }
        Thread.sleep(500);
        // scene 3. training arc.
        System.out.println("You start to think to yourself one day, \"hmm, maybe I should train for" +
                "this fighting stuff... \nOR I could meditate more... \nOR i could just eat pizza.\"");
        switch(
                getInput("Do you:\n1. Train yourself.\n2. Meditate\n3. Do nothing",3)
        ) {
            case 1 -> {
                System.out.println("You have a crazy training arc, and you get hella strong.");
                System.out.println("+15hp, +3dmg");
                user.hp+=15; user.dmg+=3;
            }
            case 2 -> {
                System.out.println("You instead opt to meditate, getting closes to true nirvana.");
                state.zenScore++;
            }
            case 3 -> System.out.println("You do NOTHING. you laze ball");
        }

        // scene 4. real big important spot.
            printWithBreak("A few weeks later, you recieve two letters in the mail. One is from" +
                    "the National LiveLeak Boxing Compeition, and the other is from the Zen Society of America.",1000);
            printWithBreak("You open both letters. The boxing competition promises life-changing money to " +
                    "whoever wins the competition, and the Zen Society wants you to come to a meditation sesh.",1000);
            switch(
                    getInput("Do you:\n1. Begin your professional streetfighting career\n2. Join the Zen Society.",2)
            ) {
            case 1 -> {
                state.choseFighting = true;
                System.out.println("You choose to pursue your fighting career.\nYou take the first flight to the vegas to start preparing.");
                printWithBreak("You only have three fights to prove yourself. You spend lots of time preparing your moves.",1500);
                printWithBreak("You gain 10 HP and 3 damage.",500);
                user.hp+=10; user.dmg+=3;
                System.out.println("░▒▓████████▓▒░▒▓█▓▒░░▒▓██████▓▒░░▒▓█▓▒░░▒▓█▓▒░▒▓████████▓▒░       ░▒▓██████▓▒░░▒▓███████▓▒░░▒▓████████▓▒░        \n" +
                        "░▒▓█▓▒░      ░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░  ░▒▓█▓▒░          ░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░               \n" +
                        "░▒▓█▓▒░      ░▒▓█▓▒░▒▓█▓▒░      ░▒▓█▓▒░░▒▓█▓▒░  ░▒▓█▓▒░          ░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░               \n" +
                        "░▒▓██████▓▒░ ░▒▓█▓▒░▒▓█▓▒▒▓███▓▒░▒▓████████▓▒░  ░▒▓█▓▒░          ░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░▒▓██████▓▒░          \n" +
                        "░▒▓█▓▒░      ░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░  ░▒▓█▓▒░          ░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░               \n" +
                        "░▒▓█▓▒░      ░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░  ░▒▓█▓▒░          ░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░      ░▒▓██▓▒░ \n" +
                        "░▒▓█▓▒░      ░▒▓█▓▒░░▒▓██████▓▒░░▒▓█▓▒░░▒▓█▓▒░  ░▒▓█▓▒░           ░▒▓██████▓▒░░▒▓█▓▒░░▒▓█▓▒░▒▓████████▓▒░▒▓██▓▒░ \n" +
                        "                                                                                                                 \n" +
                        "                                                                                                                 ");
                Fight fight = new Fight("Bobby Brass Knuckles",150,20,diff);
                if(fight.fight(user)) {
                    printWithBreak("After a hard fought battle, you continue to the next fight.",750);
                    state.fightsWon++;
                } else {
                    state.fightsLost++;
                    printWithBreak("After losing the battle, you left the championship defeated, and headed home.",750);
                    break;
                }
                System.out.println("░        ░░        ░░░      ░░░  ░░░░  ░░        ░░░░░░░░        ░░  ░░░░  ░░░      ░░\n" +
                        "▒  ▒▒▒▒▒▒▒▒▒▒▒  ▒▒▒▒▒  ▒▒▒▒▒▒▒▒  ▒▒▒▒  ▒▒▒▒▒  ▒▒▒▒▒▒▒▒▒▒▒▒▒▒  ▒▒▒▒▒  ▒  ▒  ▒▒  ▒▒▒▒  ▒\n" +
                        "▓      ▓▓▓▓▓▓▓  ▓▓▓▓▓  ▓▓▓   ▓▓        ▓▓▓▓▓  ▓▓▓▓▓▓▓▓▓▓▓▓▓▓  ▓▓▓▓▓        ▓▓  ▓▓▓▓  ▓\n" +
                        "█  ███████████  █████  ████  ██  ████  █████  ██████████████  █████   ██   ██  ████  █\n" +
                        "█  ████████        ███      ███  ████  █████  ██████████████  █████  ████  ███      ██\n" +
                        "                                                                                      ");
                fight = new Fight("The Exterminator",150,30,diff);
                if(fight.fight(user)) {
                    printWithBreak("You are relieved to move onto the championship final, and go to your room to celebrate",1000);

                }
            }
            case 2 -> {

            }
        }

        // ending scenarios
        if(state.fightsWon>=4 && state.choseFighting) {
            System.out.println("In the end, you ended up as a professional boxer, making all the money" +
                    "you could ask for.\nYou live out the rest of your life in lavish houses with all the money you could" +
                    "ask for.");
            Thread.sleep(500);
        }
        if(state.fightsWon<4 && state.choseFighting) {
            System.out.println("Your boxing career never really took off, and you never became as" +
                    "popular as you hoped to.\nYou ended up working at amazon, stocking shelves.");
        }
        // secret ending
        if(state.zenScore == 7 && state.choseZen) {
            System.out.println("After a long night of doing a LOT of acid, you think back" +
                    "on your life, and just how zen you have truly become.\nYou decide to fly to" +
                    "India to live in a temple with monks for the rest of your life.\nYou never throw" +
                    "another punch again.");
            System.out.println("Secret ending unlocked! You are truly zen.");
        }
        System.out.println("            )                )  (      \n" +
                "  *   )  ( /(             ( /(  )\\ )   \n" +
                "` )  /(  )\\()) (     (    )\\())(()/(   \n" +
                " ( )(_))((_)\\  )\\    )\\  ((_)\\  /(_))  \n" +
                "(_(_())  _((_)((_)  ((_)  _((_)(_))_   \n" +
                "|_   _| | || || __| | __|| \\| | |   \\  \n" +
                "  | |   | __ || _|  | _| | .` | | |) | \n" +
                "  |_|   |_||_||___| |___||_|\\_| |___/  \n" +
                "                                       ");

    }


}
