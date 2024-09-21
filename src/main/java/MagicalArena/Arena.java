package MagicalArena;

public class Arena {
    private Player playerA;
    private Player playerB;
    private Dice dice;

    public Arena(Player playerA, Player playerB) {
        this.playerA = playerA;
        this.playerB = playerB;
        this.dice = new Dice();
    }

    public void startFight() {
        while (playerA.isAlive() && playerB.isAlive()) {
            if (playerA.getHealth() <= playerB.getHealth()) {
                attack(playerA, playerB);
            } else {
                attack(playerB, playerA);
            }
        }

        if (!playerA.isAlive()) {
            System.out.println("Player A has died. Player B wins!");
        } else {
            System.out.println("Player B has died. Player A wins!");
        }
    }

    private void attack(Player attacker, Player defender) {
        int attackRoll = dice.roll();
        int defendRoll = dice.roll();

        int attackDamage = attacker.getAttack() * attackRoll;
        int defendDamage = defender.getStrength() * defendRoll;

        int damageToDefender = Math.max(0, attackDamage - defendDamage);
        defender.reduceHealth(damageToDefender);

        System.out.printf("Attacker rolls %d, Defender rolls %d. Damage to defender: %d. Defender's health: %d%n",
                attackRoll, defendRoll, damageToDefender, defender.getHealth());
    }
}