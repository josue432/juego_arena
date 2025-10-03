package Model.Characters;

import Model.ModelWarrior;

public class Boxeador extends ModelWarrior {

    public Boxeador(String name) {
        super(name + " (Boxeador)", 200, 13, 25, 100, 16, 100);
        startManaRegen(2, 20);
        startStaminaRegen(10, 15);
    }

    @Override
    public void attack_1(ModelWarrior target) {
        if(stamina >= 10){
            stamina -= 10;
            System.out.println(name + "uso gancho derecho para atacar a " + target.getName());
            escibirLineaSeparadora();
            target.takeDamage(damage);
            System.out.println(name + "uso gancho izquierdo para atacar a " + target.getName());
            escibirLineaSeparadora();
            target.takeDamage(damage);
            System.out.println("boxeador gasto 10 puntos de stamina");
            damage = baseDamage;
        }else {
            mensajeInsuficiecia("stamina", "usar gancho derecho y gancho izquierdo");
        }
    }

    @Override
    public void attack_2(ModelWarrior target) {
        if(stamina >= 55){
            stamina -= 55;
            System.out.println(name + "uso KNOCKOUT para derribar a " + target.getName() + " y gasto 55 puntos de stamina");
            escibirLineaSeparadora();
            target.takeDamage(damage);
            target.setStamina(0);
            damage = baseDamage;
        }else {
            mensajeInsuficiecia("stamina", "usar KNOCKOUT");
        }
    }

}
