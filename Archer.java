public class Archer extends Hero {

    private static final int BASE_ATTACK = 10;
    private static final int ARMOR = 5;

    public Archer(String name, int hp, int type, int level) {
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