import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Localidad localidad1 = new Localidad(1, "Localidad 1", 100, 20);
        Localidad localidad5 = new Localidad(5, "Localidad 5", 500, 20);
        Localidad localidad10 = new Localidad(10, "Localidad 10", 1000, 20);
        Comprador comprador = null;

        while (true) {
            System.out.println("Menú:");
            System.out.println("1. Nuevo comprador");
            System.out.println("2. Nueva solicitud de boletos");
            System.out.println("3. Consultar disponibilidad total");
            System.out.println("4. Consultar disponibilidad individual");
            System.out.println("5. Reporte de caja");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    // Crear un nuevo comprador
                    System.out.print("Nombre del comprador: ");
                    String nombre = scanner.next();
                    System.out.print("Email del comprador: ");
                    String email = scanner.next();
                    System.out.print("Cantidad de boletos deseados: ");
                    int boletosDeseados = scanner.nextInt();
                    System.out.print("Presupuesto máximo: ");
                    int presupuestoMaximo = scanner.nextInt();
                    comprador = new Comprador(nombre, email, boletosDeseados, presupuestoMaximo);
                    System.out.println("Comprador creado con éxito.");
                    break;

                case 2:
                    if (comprador != null) {
                        if (comprador.puedeComprar()) {
                            System.out.println("Seleccione una localidad:");
                            System.out.println("1. Localidad 1");
                            System.out.println("5. Localidad 5");
                            System.out.println("10. Localidad 10");
                            int localidadSeleccionada = scanner.nextInt();
                            Localidad localidadActual = null;
                            int cantidadPosible = 0;

                            switch (localidadSeleccionada) {
                                case 1:
                                    localidadActual = localidad1;
                                    cantidadPosible = comprador.calcularBoletosPosibles(localidad1.getCapacidad());
                                    break;
                                case 5:
                                    localidadActual = localidad5;
                                    cantidadPosible = comprador.calcularBoletosPosibles(localidad5.getCapacidad());
                                    break;
                                case 10:
                                    localidadActual = localidad10;
                                    cantidadPosible = comprador.calcularBoletosPosibles(localidad10.getCapacidad());
                                    break;
                                default:
                                    System.out.println("Opción inválida.");
                                    break;
                            }

                            if (localidadActual != null) {
                                System.out.print("Cantidad de boletos a comprar (máx. " + cantidadPosible + "): ");
                                int cantidadCompra = scanner.nextInt();
                                if (cantidadCompra <= cantidadPosible) {
                                    if (localidadActual.validarPrecio(comprador.getPresupuestoMaximo())) {
                                        localidadActual.venderBoletos(cantidadCompra);
                                        comprador.comprarBoletos(cantidadCompra);
                                        System.out.println("Boletos comprados exitosamente.");
                                    } else {
                                        System.out.println("El precio excede el presupuesto del comprador.");
                                    }
                                } else {
                                    System.out.println("Cantidad inválida.");
                                }
                            }
                        } else {
                            System.out.println("El comprador ya ha adquirido la cantidad deseada de boletos.");
                        }
                    } else {
                        System.out.println("No se ha creado un comprador.");
                    }
                    break;

                case 3:
                    System.out.println("Disponibilidad total:");
                    System.out.println("Localidad 1: Vendidos " + localidad1.getBoletosVendidos() + ", Disponibles " + (localidad1.getCapacidad() - localidad1.getBoletosVendidos()));
                    System.out.println("Localidad 5: Vendidos " + localidad5.getBoletosVendidos() + ", Disponibles " + (localidad5.getCapacidad() - localidad5.getBoletosVendidos()));
                    System.out.println("Localidad 10: Vendidos " + localidad10.getBoletosVendidos() + ", Disponibles " + (localidad10.getCapacidad() - localidad10.getBoletosVendidos()));
                    break;

                case 4:
                    if (comprador != null) {
                        System.out.println("Seleccione una localidad:");
                        System.out.println("1. Localidad 1");
                        System.out.println("5. Localidad 5");
                        System.out.println("10. Localidad 10");
                        int localidadSeleccionada = scanner.nextInt();
                        Localidad localidadActual = null;

                        switch (localidadSeleccionada) {
                            case 1:
                                localidadActual = localidad1;
                                break;
                            case 5:
                                localidadActual = localidad5;
                                break;
                            case 10:
                                localidadActual = localidad10;
                                break;
                            default:
                                System.out.println("Opción inválida.");
                                break;
                        }

                        if (localidadActual != null) {
                            System.out.println("Localidad " + localidadActual.getLocalidadID() + ": Vendidos " +
                                    localidadActual.getBoletosVendidos() + ", Disponibles " +
                                    (localidadActual.getCapacidad() - localidadActual.getBoletosVendidos()));
                        }
                    } else {
                        System.out.println("No se ha creado un comprador.");
                    }
                    break;

                case 5:
                    int ingresosTotales = (localidad1.getBoletosVendidos() * localidad1.getPrecio()) +
                            (localidad5.getBoletosVendidos() * localidad5.getPrecio()) +
                            (localidad10.getBoletosVendidos() * localidad10.getPrecio());
                    System.out.println("Reporte de caja:");
                    System.out.println("Ingresos totales: $" + ingresosTotales);
                    break;

                case 6:
                    System.out.println("Saliendo del programa.");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Opción inválida.");
                    break;
            }
        }
    }
}
