public class Player {
    private int health;
    private final int strength;
    private final int attack;

    public Player(int health, int strength, int attack) {
        this.health = health;
        this.strength = strength;
        this.attack = attack;
    }

    public int getHealth() {
        return health;
    }

    public void reduceHealth(int amount) {
        this.health = Math.max(this.health - amount, 0);
    }

    public int rollAttackDice() {
        return (int) (Math.random() * 6) + 1;
    }

    public int rollDefendDice() {
        return (int) (Math.random() * 6) + 1;
    }

    public int getAttack() {
        return attack;
    }

    public int getStrength() {
        return strength;
    }
}
