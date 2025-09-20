import java.util.Random;

class Esquivar {
    private Random random = new Random();
    private int probabilidad; // configurable

    public Esquivar(int probabilidad) {
        this.probabilidad = probabilidad;
    }

    public boolean intentarEsquivar() {
        return random.nextInt(100) < probabilidad;
    }
}
