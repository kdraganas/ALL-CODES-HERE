public abstract class Hero extends RPGCharacter {
    private int level;
    
    public Hero(String name, int hp, int type, int level) {
        super(name, hp, type);
        this.level = level;
    }

    //@Override
    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}