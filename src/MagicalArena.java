public class MagicalArena {
    private final Player player1;
    private final Player player2;

    public MagicalArena(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public void startFight() {
        while (player1.getHealth() > 0 && player2.getHealth() > 0) {
            Player attacker = player1.getHealth() <= player2.getHealth() ? player1 : player2;
            Player defender = attacker == player1 ? player2 : player1;

            int attackRoll = attacker.rollAttackDice();
            int defendRoll = defender.rollDefendDice();

            int damage = attacker.getAttack() * attackRoll;
            int defense = defender.getStrength() * defendRoll;
            int netDamage = Math.max(damage - defense, 0);

            defender.reduceHealth(netDamage);

            System.out.printf("%s attacks with roll %d (damage %d) - %s defends with roll %d (defense %d) - %s health reduced to %d%n",
                    attacker == player1 ? "Player 1" : "Player 2", attackRoll, damage,
                    defender == player1 ? "Player 1" : "Player 2", defendRoll, defense,
                    defender == player1 ? "Player 1" : "Player 2", defender.getHealth());
        }

        System.out.println(player1.getHealth() > 0 ? "Player 1 wins!" : "Player 2 wins!");
    }
}
