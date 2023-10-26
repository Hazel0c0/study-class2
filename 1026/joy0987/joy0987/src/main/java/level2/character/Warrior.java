package level2.character;


import level2.weapon.Sword;
import level2.weapon.Weapon;

public class Warrior extends Character {

    public Warrior() {
        weapon = new Sword();
        type = "전사";
        basicPower = 10;
    }

    public Warrior(Weapon weapon) {
        this.weapon = weapon;
        type = "전사";
        basicPower = 10;
    }
}
