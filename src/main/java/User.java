public class User {
    double hp, dmg;
    String name = "Timmy Tough Knuckles";

    // note 2 self. update manually.
    // there is ZERO chance i am gonna encapsulate this with methods.
    User(Difficulty diff) {
        switch(diff) {
            case EASY -> {
                hp = 120;
                dmg = 22;
            }
            case MEDIUM -> {
                hp = 100;
                dmg = 20;
            }
            case HARD -> {
                hp = 85;
                dmg = 18;
            }
        }
    }
}
