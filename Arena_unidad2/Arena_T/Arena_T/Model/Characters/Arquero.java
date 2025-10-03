package Model.Characters;

import Model.ModelWarrior;

public class Arquero extends ModelWarrior{

    public Arquero(String name) {
        super(name + " (Arquero) ", 150, 15, 25, 150, 8, 100);
        startManaRegen(8, 20);
        startStaminaRegen(5, 20);
    }

    @Override
    public synchronized void attack_1(ModelWarrior target) {
        if(stamina >= 5){
            stamina -= 5;
            System.out.println(name + "uso tiro certero para atacar a " + target.getName() + " y gasto 5 de stamina.");
            escibirLineaSeparadora();
            target.takeDamage(damage);
            damage = baseDamage;
        }else {
            mensajeInsuficiecia("stamina", "usar tiro certero");
        }
    }

    @Override
    public void attack_2(ModelWarrior target) {
        if(stamina >= 15 && mana >= 10){
            stamina -= 15;
            mana -= 10;
            System.out.println(name + " uso triple lanzamiento para atacar a " + target.getName() + " y gasto 15 de stamina y 10 de mana");
            escibirLineaSeparadora();
            for(int i = 0; i < 3; i++){
                System.out.println("Ataque flecha " + (i + 1));
                target.takeDamage(baseDamage);
            }
            damage = baseDamage;
        }else {
            mensajeInsuficiecia("stamina y/o mana", "usar triple lanzamiento");
        }
    }


}
