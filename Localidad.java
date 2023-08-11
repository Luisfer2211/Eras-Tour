public class Localidad {
    private int localidadID;
    private String nombre;
    private int precio;
    private int capacidad;
    private int boletosVendidos;

    // Constructor
    public Localidad(int localidadID, String nombre, int precio, int capacidad) {
        this.localidadID = localidadID;
        this.nombre = nombre;
        this.precio = precio;
        this.capacidad = capacidad;
        this.boletosVendidos = 0;
    }

    // Métodos para verificar espacio, validar precio y vender boletos
    public boolean hayEspacio() {
        return boletosVendidos < capacidad;
    }

    public boolean validarPrecio(int presupuesto) {
        return precio <= presupuesto;
    }

    public void venderBoletos(int cantidad) {
        boletosVendidos += cantidad;
    }

    // Getters para las propiedades
    public int getLocalidadID() {
        return localidadID;
    }

    public String getNombre() {
        return nombre;
    }

    public int getPrecio() {
        return precio;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public int getBoletosVendidos() {
        return boletosVendidos;
    }
}
