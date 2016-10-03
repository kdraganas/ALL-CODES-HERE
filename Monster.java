public class Monster extends RPGCharacter{
    private int attackDamage;

    public Monster(String name, int hp, int type, int attackDamage) {
        super(name, hp, type);
        this.attackDamage = attackDamage;
    }

    public int attack(){
        return attackDamage;
    }
}