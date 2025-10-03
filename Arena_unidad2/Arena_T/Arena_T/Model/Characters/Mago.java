package Model.Characters;

import Model.ModelWarrior;

public class Mago extends ModelWarrior{

    public Mago(String name) {
        super(name + " (Mago) ", 200, 20, 15, 150, 5, 75);
        startManaRegen(5, 10);
        startStaminaRegen(2, 20);
    }

    @Override
    public void attack_1(ModelWarrior target) {
        if(stamina >= 5 && mana >= 10){
            stamina -= 5;
            mana -= 10;
            System.out.println(name + "usa magic punch para atacar a " + target.getName() + " y a gastado 5 puntos de stamina y 10 puntos de mana");
            escibirLineaSeparadora();
            target.takeDamage(damage);
            damage = baseDamage;
        }else{
            mensajeInsuficiecia("stamina y/o mana", "usar magic punch");
        }
    }

    @Override
    public void attack_2(ModelWarrior target) {
        if(stamina >= 30 && mana >= 100){
            stamina -= 30;
            mana -= 100;
            System.out.println(name + "usa toque drenador para atacar y roba todo el mana a " + target.getName() + " y a gastado 30 de stamina y 100 de mana");
            escibirLineaSeparadora();
            target.takeDamage((damage - (baseDamage/2)));
            target.setMana(0);
            stamina = maxStamina;
            damage = baseDamage;
        }else {
            mensajeInsuficiecia("stamina y/o mana", "usar toque drenador");
        }
    }

}
