class Heroe extends Personaje {
    private Esquivar esquivar;

    public Heroe(String name, int hp, int attackPower, int probEsquivar) {
        super(name, hp, attackPower);
        this.esquivar = new Esquivar(probEsquivar);
    }

    @Override
    public synchronized void takeDamage(int amount, String attacker) {
        if (!isAlive()) return;

        if (esquivar.intentarEsquivar()) {
            hp += 5;
            if (hp > maxHp) hp = maxHp;
            System.out.println( name + " esquiva el ataque de " + attacker+ " y recupera 5 de vida. Vida actual: " + hp);
        } else {
            super.takeDamage(amount, attacker);
        }
    }

}
