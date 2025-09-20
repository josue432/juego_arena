import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

class TurnoHeroes extends Thread {
    private List<Heroe> heroes;
    private List<Enemigo> enemigos;
    private Random random = new Random();

    public TurnoHeroes(List<Heroe> heroes, List<Enemigo> enemigos) {
        this.heroes = heroes;
        this.enemigos = enemigos;
    }

    @Override
    public void run() {
        for (Heroe heroe : heroes) {
            if (!heroe.isAlive()) continue;

            // Filtrar enemigos vivos
            List<Enemigo> enemigosVivos = enemigos.stream()
                    .filter(Enemigo::isAlive)
                    .collect(Collectors.toList());

            if (!enemigosVivos.isEmpty()) {
                // Elegir enemigo aleatorio
                Enemigo objetivo = enemigosVivos.get(random.nextInt(enemigosVivos.size()));

                // Atacar al objetivo
                heroe.attack(objetivo);
            }

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
