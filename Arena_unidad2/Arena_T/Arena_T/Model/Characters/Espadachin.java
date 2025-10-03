package Model.Characters;

import Model.ModelWarrior;

public class Espadachin extends ModelWarrior{

    public Espadachin(String name) {
        super(name + " (Espadachin) ", 200, 10, 8, 100, 100, 10);
        startManaRegen(5, 20);
        startStaminaRegen(5, 20);
    }

    @Override
    public synchronized void attack_1(ModelWarrior target) {
        if( stamina >= 5){
            stamina -= 5;
            System.out.println(name + "usa corte rapido para atacar a " + target.getName() + " y gasta 5 puntos de stamina.");
            escibirLineaSeparadora();
            target.takeDamage(damage);
            damage = baseDamage;
        }else {
            mensajeInsuficiecia("stamina", "usar corte rapido");
        }    
    }

    @Override
    public synchronized void attack_2(ModelWarrior target) {
        if(stamina >= 10){
            stamina -= 10;
            System.out.println(name + "usa estocada para atacar a " + target.getName() + " y gasta 10 puntos de stamina.");
            escibirLineaSeparadora();
            target.takeDamage((damage*2));
            damage = baseDamage;
        }else {
            mensajeInsuficiecia("stamina", "usar estocada");
        }
    }
}
