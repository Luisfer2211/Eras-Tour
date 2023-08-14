public class Comprador {
    private String nombre;
    private String email;
    private int boletosDeseados;
    private int presupuestoMaximo;
    private int boletosComprados;

    // Constructor
    public Comprador(String nombre, String email, int boletosDeseados, int presupuestoMaximo) {
        this.nombre = nombre;
        this.email = email;
        this.boletosDeseados = boletosDeseados;
        this.presupuestoMaximo = presupuestoMaximo;
        this.boletosComprados = 0;
    }

    // Métodos para verificar si puede comprar y calcular boletos posibles
    public boolean puedeComprar() {
        return boletosComprados < boletosDeseados;
    }

    public int calcularBoletosPosibles(int capacidad) {
        int boletosPosibles = Math.min(boletosDeseados - boletosComprados, capacidad);
        return boletosPosibles;
    }

    // Método para comprar boletos
    public void comprarBoletos(int cantidad) {
        boletosComprados += cantidad;
    }

    // Getters para las propiedades
    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }

    public int getBoletosDeseados() {
        return boletosDeseados;
    }

    public int getPresupuestoMaximo() {
        return presupuestoMaximo;
    }

    public int getBoletosComprados() {
        return boletosComprados;
    }
}
