import java.util.ArrayList;
import java.util.List;

public class ArenaUnidad3 {
    public static void main(String[] args) {
        System.out.println("=== Arena de Guerreros (Pelea hasta la muerte) ===");

        // Héroes personalizados: nombre, vida, ataque, probabilidad de esquivar
        List<Heroe> heroes = new ArrayList<>();
        heroes.add(new Heroe("Abraham", 100, 10, 15));
        heroes.add(new Heroe("Kristian", 100, 10, 15));
        heroes.add(new Heroe("Josue", 100, 10, 15));

        // Enemigos personalizados: nombre, vida, ataque
        List<Enemigo> enemigos = new ArrayList<>();
        enemigos.add(new Enemigo("Ogro", 100, 20));
        enemigos.add(new Enemigo("Golem", 100, 20));
        enemigos.add(new Enemigo("Dragón", 100, 20));

        // Batalla hasta que un equipo muera
        while (hayVivos(heroes) && hayVivos(enemigos)) {
            System.out.println("\n Turno de los ENEMIGOS");
            TurnoEnemigos turnoE = new TurnoEnemigos(heroes, enemigos);
            turnoE.start();
            try { turnoE.join(); } catch (InterruptedException e) {}

            if (!hayVivos(heroes)) break;

            System.out.println("\n Turno de los HEROES");
            TurnoHeroes turnoH = new TurnoHeroes(heroes, enemigos);
            turnoH.start();
            try { turnoH.join(); } catch (InterruptedException e) {}
        }

        // Resultado final
        if (hayVivos(heroes)) {
            System.out.println("\n Los héroes ganaron la batalla!");
        } else {
            System.out.println("\n Los enemigos han derrotado a los héroes...");
        }

        System.out.println("Fin de la simulación.");
    }

    private static boolean hayVivos(List<? extends Personaje> lista) {
        for (Personaje p : lista) {
            if (p.isAlive()) return true;
        }
        return false;
    }
}
