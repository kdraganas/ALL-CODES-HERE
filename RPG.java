import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class RPG {

    private Random rand = new Random();

    public RPG() {
        this.rand = new Random();
    }

    public String getRandomMonsterName() {
        String[] adjectives = {"PROF.", "LECTURER", "INSTRUCTOR"};
        String[] monsters = {"O-GENESIS", "OXYT-OCIN", "NITRAM"};
        List<String> adjs = Arrays.asList(adjectives);
        List<String> mons = Arrays.asList(monsters);

        return adjs.get(randInt(0, adjs.size() - 1)) + " " + mons.get(randInt(0, mons.size() - 1));
    }

    public int randInt(int min, int max) {
        int randomNum = rand.nextInt((max - min) + 1) + min;
        return randomNum;
    }

    public boolean coinToss(int chance) {
        int hit = randInt(0, 9);

        if(chance == 0)
            if(hit<=6)
                return true;
        if(chance == 1)
                return true;
        if(chance == 2)
            if(hit<=7)
                return true;                  
        return false;
    }

    public void sleep(int ms) {
        try {
            Thread.sleep(ms);
        } 
        catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }

    public boolean duel(RPGCharacter attacker, RPGCharacter defender, int chance, int power) {
        int damage;
    
        if (coinToss(chance)==true) {

            if(power == 1){
                damage = attacker.attack();
                System.out.println(">>> " + attacker.getName() + " ATTACKS and DAMAGES " + defender.getName());
                System.out.println(">>> " + defender.getName() + " LOSES " + damage + " HP");
            }
            else{

                if(attacker.manaFull()){
                    damage = attacker.attack() + 10;
                    System.out.println(">>> " + attacker.getName() + " CAST A SPELL and DAMAGES " + defender.getName()); 
                    System.out.println(">>> " + defender.getName() + " LOSES " + damage + " HP");

                    attacker.setMana(attacker.getMana()-8);
                }
                else{
                    damage = attacker.attack() / 5;
                    System.out.println(">>> " + "NOT ENOUGH MANA");
                    System.out.println(">>> " + defender.getName() + " LOSES " + damage + " HP");
                } 
            }
            sleep(2000);

            int remHp = defender.takeDamage(damage);

            if (remHp <= 0) {
                System.out.println("\n******************************************************************");
                System.out.printf(">>> %s killed %s!\n", attacker.getName(), defender.getName());
                System.out.println("******************************************************************\n");
                return true;
            }
        }
        else {
            System.out.printf(">>> %s EVADED!\n", defender.getName());
        }

        return false;
    }

    public static void main(String[] args) {
        RPG rpg = new RPG();

        Scanner sc = new Scanner(System.in);
        String name = "";
        int level = 1, flag = 0, choice1 = 0;

        System.out.println("\n~~~~~~~~~~~~~~~oOo~~~~~~~~~~~~~~~\n WELCOME HERO TO PENAPPLE ALPINES\n~~~~~~~~~~~~~~~oOo~~~~~~~~~~~~~~~\n");
        
        do{
            System.out.println("MENU:\n\t1 - STORY/ABOUT\n\t2 - START\n\t3 - EXIT\n");
            choice1 = sc.nextInt();

            if(choice1 == 2){
                System.out.println("WHAT'S YOUR NAME?\t");
                name = sc.next();
                System.out.println("\nHELLO THERE " + name + "!\n");

                System.out.println("WHERE WOULD YOU LIKE TO ENROLL?\n ACADEMIES:\n\t1 - MYSTIC PEAK\n\t2 - SACRED GATE\n\t3 - HIPPO CAMPUS\n");
                int choice2=0;

                RPGCharacter hero = new Brawler("MERCHANT", 1, -1, -1); 
                RPGCharacter villain = new Brawler("MERCHANT", 1, -1, -1);

                do{
                    choice2 = sc.nextInt();
                    if(choice2<0 || choice2>3)
                        System.out.println("ERROR 22: ACADEMY_NOT_FOUND\n");
                }while(choice2<0 || choice2>3);

                String[] school = {"MYSTIC PEAK", "SACRED GATE", "HIPPO CAMPUS"};

                do{
                    int mons = rpg.randInt(1,3);

                    if (mons == 1){
                        villain = new Monster(rpg.getRandomMonsterName()+" of Pen-dora", 120, 0, 10);
                    }
                    if (mons == 2){
                        villain = new Monster(rpg.getRandomMonsterName()+" of NApple-eon", 100, 0, 15);
                    }
                    if(mons == 3){
                        villain = new Monster(rpg.getRandomMonsterName()+" of Ananass Confucius", 80, 0, 20);
                    }

                    System.out.println("\n~~~~~~~~~~~~~~~~~~~~~oOo~~~~~~~~~~~~~~~~~~~~oOo~~~~~~~~~~~~~~~~~~~");
                    System.out.println("\t\t      ====== GAME START =====");
                    System.out.println(  "~~~~~~~~~~~~~~~~~~~~~oOo~~~~~~~~~~~~~~~~~~~~oOo~~~~~~~~~~~~~~~~~~~");
                    
                    if (choice2  == 1){
                        name  = "BRAWLER " + name;
                        hero = new Brawler(name, 90, 0, level);
                        System.out.println("Name: " + hero.getName() + "\nAcademy: " + school[choice2-1] + "\nHP: " + hero.getHp() + "\nMANA: " + hero.getMana());
                    }
                    if (choice2 == 2){
                        name = "ARCHER " + name;
                        hero = new Archer(name, 80, 1, level);
                        System.out.println("Name: " + hero.getName() + "\nAcademy: " + school[choice2-1] + "\nHP: " + hero.getHp() + "\nMANA: " + hero.getMana()); 
                    }
                    if (choice2 == 3){
                        name = "SHAMAN " + name;
                        hero = new Shaman(name, 100, 2, level);
                        System.out.println("Name: " + hero.getName() + "\nAcademy: " + school[choice2-1] + "\nHP: " + hero.getHp() + "\nMANA: " + hero.getMana()); 
                    }                

                    System.out.printf("\n%s", hero);
                    System.out.printf(" Mana: " + hero.getMana() + "\n");
                    System.out.printf("%s\n", villain);
                   
                    int count = 0;
                    while (true) {
                        System.out.println(  "\n==================================================================");
                        System.out.println("                           ROUND " + ++count);
                       
                        //HERO'S TURN
                        System.out.println(    "------------------------------------------------------------------");
                        System.out.println("ATTACK: 1 - USE ARSENAL     2 - USE MANA");
                                        
                        int pwr;
                        do{
                            pwr = sc.nextInt();
                            if(pwr<1 || pwr>2)
                                System.out.println("ERROR 123: INPUT_INVALID");
                        }while(pwr<1 || pwr>2);   

                        System.out.println(    "------------------------------------------------------------------");
                        System.out.println(  "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n"); 

                        boolean heroVsMonster = rpg.duel(hero, villain, hero.type(), pwr);

                        if (heroVsMonster) {
                            System.out.println("YOU WIN!\n");
                            level++;
                            break;
                        }

                        System.out.printf("\n%s", hero);
                        System.out.printf(" Mana: " + hero.getMana() + "\n");
                        System.out.printf("%s\n\n", villain);

                        //MONSTER'S TURN
                        if(count % 5 == 0)
                            pwr = 2;
                        else
                            pwr = 1;
                        boolean monsterVsHero = rpg.duel(villain, hero, 1, pwr);

                        if (monsterVsHero) {
                            System.out.println("YOU LOSE!\n");
                            break;
                        }

                        System.out.printf("\n%s", hero);
                        System.out.printf(" Mana: " + hero.getMana() + "\n");
                        System.out.printf("%s\n", villain);

                        System.out.println(  "\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

                        if(hero.manaFull() == false)
                            hero.setMana(hero.getMana()+2);
                        System.out.println(  "\n==================================================================");
                    }

                    System.out.printf("%s Mana: %d\n%s\n", hero, hero.getMana(), villain);

                    System.out.println("\nWOULD YOU LIKE TO CONINUE YOUR QUEST?\n\t0 - YES\n\t1 - NO\n");

                    do{
                        flag = sc.nextInt();
                        if(flag<0 || flag>1)
                            System.out.println("ERROR 123: INPUT_INVALID");
                    }while(flag<0 || flag>1);
                }while(flag == 0);    
            }

            if(choice1 == 1){
                System.out.println("\nMYSTIC PEAK. SACRED GATE. HIPPO CAMPUS.\n\nLong ago, the three academies stood together in harmony.\nThen, everything changed when the TEACHERS attacked.\nOnly the HERO, from one of the academies, could defeat them.\nBut when the world needed him most, he vanished. A hundred years passed we discovered the new hero, YOU.\nAnd although your skills are great, you have a lot to learn before you're ready to save anyone.\nBut I believe YOU can save the world.\n");
                System.out.println("\nDONE?  1 - YES");

                int choice4;
                do{
                    choice4 = sc.nextInt();
                }while(choice4<0 || choice4>9);
                System.out.println();
            }
        }while(flag == 0 && choice1 != 3);            
        System.out.println("\nFAREWELL!");            
    }
}