class Personaje {
    protected String name;
    protected int hp;
    protected int attackPower;
    protected int maxHp;

    public Personaje(String name, int hp, int attackPower) {
        this.name = name;
        this.hp = hp;
        this.attackPower = attackPower;
        this.maxHp = hp; // el máximo se fija según el inicial
    }

    public synchronized boolean isAlive() {
        return hp > 0;
    }

    public synchronized int getHp() {
        return hp;
    }

    public synchronized String getName() {
        return name;
    }

    public synchronized void takeDamage(int amount, String attacker) {
        if (!isAlive()) return;

        hp -= amount;
        if (hp < 0) hp = 0;

        System.out.println(attacker + " hace " + amount + " de daño a " + name + ". Vida restante: " + hp);
    }

    public synchronized void attack(Personaje target) {
        if (this.isAlive() && target.isAlive()) {
            target.takeDamage(attackPower, this.name);
        }
    }
}
