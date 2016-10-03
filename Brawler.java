public class Brawler extends Hero {

    private static final int BASE_ATTACK = 15;
    private static final int ARMOR = 5;

    public Brawler(String name, int hp, int type, int level) {
        super(name, hp, type, level);
    }

    public int attack() {
        return BASE_ATTACK;
    }

    public int takeDamage(int damage) {
        damage -= ARMOR;
        return super.takeDamage(damage);
    }
}