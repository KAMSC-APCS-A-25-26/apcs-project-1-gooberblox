import java.io.IOException;
import java.util.Scanner;

public class TextAdventure {
    private static void printWithBreak(String output, long millis) throws InterruptedException {
        System.out.println(output);
        Thread.sleep(millis);
    }


    String[] sbuf;
    private static void clearScreen() throws IOException, InterruptedException {
        new ProcessBuilder("clear").inheritIO().start().waitFor();
    }

    public static void main(String[] args) throws InterruptedException, IOException {
        Scanner scan = new Scanner(System.in);
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
        System.out.println("You are Timmy Tough Knuckles,an aspiring boxer who began his career after his hooker girlfriend left him.");
        Thread.sleep(1000);
        System.out.println("What difficulty do you want? (Easy, Medium, Hard) ");
        String diff = scan.next();
        /*
            String originalString = "hello world";
    String upperCaseString = originalString.toUpperCase();
    use this part and then use valueOf() on the enum with the uppercase
         */
        // scene one
        printWithBreak("You arrive to a back alley, where you meet Conner Chan",500);
        printWithBreak("He pees all over you, and says \"boy what the hell boy\"",500);
`       Fight connorFight = new Fight("Conner Chan",150,10, Difficulty.EASY);

    }

}
