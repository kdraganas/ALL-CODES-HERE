public abstract class RPGCharacter {
    private String name;
    private int hp;
    private int mana;
    private int type;


    public RPGCharacter(String name, int hp, int type) {
        this.name = name;
        this.hp = hp;
        this.type = type;
        if(type ==  2)
            this.mana = 30;
        else
            this.mana = 20;
    }

    public abstract int attack();

    public boolean isAlive() {
        return hp > 0 ? true : false;
    }

    public boolean manaFull(){
        if(mana >= 8)
            return true;
        return false;
    }

    public int takeDamage(int damage) {
        hp -= damage;
        return hp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public int getHp() {
        if(hp<0)
            hp = 0;
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getMana(){
        return mana;
    }

    public void setMana(int manna){
        mana = manna; 
    }

    //@Override
    public String toString() {
        if(hp<0)
            hp = 0;
        return "Name: " + name + ", HP: " + hp;
    }

     public int type() {
        return type; 
    }
}