package Model.Characters;

import Model.ModelWarrior;

public class Paladin extends ModelWarrior{

    public Paladin(String name) {
        super(name + " (Paladin) ", 250, 17, 5, 75, 15, 100);
        startManaRegen(2, 15);
        startStaminaRegen(5, 20);
    }

    @Override
    public void attack_1(ModelWarrior target) {
        if(stamina >= 10){
            stamina -= 10;
            System.out.println(name + "usa tajo mata dragones para atacar a " + target.getName() + " y gasta 10 puntos de stamina.");
            escibirLineaSeparadora();
            target.takeDamage(damage);
            damage = baseDamage;
        }else {
            mensajeInsuficiecia("stamina", "usar el tajo mata dragones");
        }

    }

    @Override
    public void attack_2(ModelWarrior target) {
        if(stamina >= 20 && mana >= 45){
            stamina -= 20;
            mana -= 45;
            System.out.println(name + "usa corte divino para atacar ignorando el bloqueo a " + target.getName() + " y gasta 20 puntos de stamina y 45 puntos de mana.");
            escibirLineaSeparadora();
            target.setBlocked(false);
            target.takeDamage((damage*2));
            damage = baseDamage;
        }else {
            mensajeInsuficiecia("stamina", "usar el tajo mata dragones");
        }
    }

}
