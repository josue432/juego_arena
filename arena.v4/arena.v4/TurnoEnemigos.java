import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

class TurnoEnemigos extends Thread {
    private List<Heroe> heroes;
    private List<Enemigo> enemigos;
    private Random random = new Random();

    public TurnoEnemigos(List<Heroe> heroes, List<Enemigo> enemigos) {
        this.heroes = heroes;
        this.enemigos = enemigos;
    }

    @Override
    public void run() {
        for (Enemigo enemigo : enemigos) {
            if (!enemigo.isAlive()) continue;

            // Filtrar héroes vivos
            List<Heroe> heroesVivos = heroes.stream()
                    .filter(Heroe::isAlive)
                    .collect(Collectors.toList());

            if (!heroesVivos.isEmpty()) {
                // Elegir héroe aleatorio
                Heroe objetivo = heroesVivos.get(random.nextInt(heroesVivos.size()));

                // Atacar al héroe elegido
                enemigo.attack(objetivo);
            }

            try {
                Thread.sleep(500); // pequeña pausa entre ataques
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
