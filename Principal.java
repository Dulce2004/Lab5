
/**
 * Esta clase es donde se crea la interacción con el usuario
 * 
 * @author: Dulce Ambrosio - 231143 , sección 20
 * @version: 20/10/2023
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Producto> producto = new ArrayList<>();

        while (true) {
            System.out.println("Bienvenido al menú");
            System.out.println("1. Agregar Producto al Inventario");
            System.out.println("2. Buscar Producto");
            System.out.println("3. Quitar Producto del Inventario");
            System.out.println("4. Listar el producto de una categoría");
            System.out.println("5. Mostrar las ventas actuales");
            System.out.println("6. Mostrar Informe");
            System.out.println("7. Salir");
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("----------------------------------------------------------");
                    System.out.println("INGRESE LOS DATOS QUE SE LE PIDE");
                    System.out.println("Id: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Nombre: ");
                    String nombre = scanner.nextLine();
                    System.out.println("Cantidad Disponible: ");
                    int cantDisponible = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Cantidad Vendidos: ");
                    int cantVendidos = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Estado (Disponible ó No disponible): ");
                    String estado = scanner.nextLine();
                    System.out.println("Precio: ");
                    double precio = scanner.nextDouble();
                    scanner.nextLine();

                    // se agrega el objeto del producto a la lista
                    Producto productos = new Producto(id, nombre, cantDisponible, cantVendidos, estado, precio);
                    producto.add(productos);

                    System.out.println("Qué Categoría es el producto: ");
                    System.out.println("1. Bebidas");
                    System.out.println("2. Snacks");
                    System.out.println("3. Dulces ");
                    System.out.println("4. Ir al menú principal");
                    int opcion2 = scanner.nextInt();

                    if (producto.isEmpty()) {
                        System.out.println("No se han Ingresado productos");
                    } else if (opcion2 == 1) {
                        System.out.println("Mililitros: ");
                        int ml = scanner.nextInt();
                        scanner.nextLine();
                        System.out.println("Tipo (Energética, Con licor, Natural, Aguar pura)");
                        String tipo = scanner.nextLine();

                        Bebida bebida = new Bebida(id, nombre, cantDisponible, cantVendidos, estado, precio, ml, tipo);
                        producto.add(bebida);
                    } else if (opcion2 == 2) {
                        System.out.println("Gramos: ");
                        int gr = scanner.nextInt();
                        scanner.nextLine();
                        System.out.println("Sabor (Barbacoa, Picante, Natural): ");
                        String sabor = scanner.nextLine();
                        System.out.println("Tamaño (Individual, Familiar): ");
                        String tamano = scanner.nextLine();
                        Snack snack = new Snack(id, nombre, cantDisponible, cantVendidos, estado, precio, gr, sabor,
                                tamano);
                        producto.add(snack);
                    } else if (opcion2 == 3) {
                        System.out.println("Tipo (Bombón, Chicle, Dulce): ");
                        String tipo2 = scanner.nextLine();
                        System.out.println("Marca (BonBonBum, Trident,Arcor): ");
                        String marca = scanner.nextLine();
                        Dulce dulce = new Dulce(id, nombre, cantDisponible, cantVendidos, estado, precio, tipo2, marca);
                        producto.add(dulce);
                    } else if (opcion2 == 4) {
                        System.out.println("Dirigiendo al menú principal");
                        break;
                    }
                    Emprendimiento archivoProductos = new Emprendimiento("productos.csv");
                    archivoProductos.escribirProductos(producto);
                    break;
                case 2:
                    System.out.println("----------------------------------------------------------");
                    System.out.println("Ingrese el Id del producto que desea buscar: ");
                    int idBuscar = scanner.nextInt();
                    boolean encontrado = false;
                    for (Producto prod : producto) {
                        if (prod.getId() == idBuscar) {
                            System.out.println("Producto Encontrado: ");
                            System.out.println("ID: " + prod.getId());
                            System.out.println("Nombre: " + prod.getNombre());
                            System.out.println("Cantidad Disponible: " + prod.cantDisponible);
                            System.out.println("Cantidad Vendidos: " + prod.cantVendidos);
                            System.out.println("Estado: " + prod.getEstado());
                            System.out.println("Precio: " + prod.getPrecio());
                            if (prod instanceof Bebida) {
                                Bebida bebida = (Bebida) prod;
                                System.out.println("Mililitros: " + bebida.getMl());
                                System.out.println("Tipo: " + bebida.getTipo());
                            } else if (prod instanceof Snack) {
                                Snack snack = (Snack) prod;
                                System.out.println("Gramos: " + snack.getGr());
                                System.out.println("Sabor: " + snack.getSabor());
                                System.out.println("Tamaño: " + snack.getTamano());
                            } else if (prod instanceof Dulce) {
                                Dulce dulce = (Dulce) prod;
                                System.out.println("Tipo: " + dulce.getTipo2());
                                System.out.println("Marca: " + dulce.getMarca());
                            }
                            encontrado = true;
                            break;

                        }
                    }
                    if (!encontrado) {
                        System.out.println("No se ha encontrado el Id que ingresaste");
                    }
                    break;
                case 3:
                    System.out.println("----------------------------------------------------------");
                    System.out.println("Lista de Productos en el Inventario:");
                    for (Producto prod : producto) {
                        System.out.println("ID: " + prod.getId() + " - Nombre: " + prod.getNombre());
                    }

                    System.out.println("Ingrese el ID del producto que desea eliminar:");
                    int idEliminar = scanner.nextInt();

                    Producto productoAEliminar = null;
                    for (Producto prod : producto) {
                        if (prod.getId() == idEliminar) {
                            productoAEliminar = prod;
                            break;
                        }
                    }

                    if (productoAEliminar != null) {
                        producto.remove(productoAEliminar);
                        System.out.println("Producto eliminado del inventario.");
                    } else {
                        System.out.println("No se encontró un producto con el ID especificado.");
                    }
                    break;
                case 4:
                    System.out.println("----------------------------------------------------------");
                    System.out.println("Ingrese la categoría de la cual desea ver la lista de productos: ");
                    System.out.println("1. Bebidas");
                    System.out.println("2. Snacks");
                    System.out.println("3. Dulces");
                    int opcion3 = scanner.nextInt();

                    if (opcion3 == 1) {
                        System.out.println("Lista de la categoría Bebida");
                        for (Producto prod : producto) {
                            if (prod instanceof Bebida) {
                                Bebida bebida = (Bebida) prod;
                                System.out.println(bebida.toString());
                            }
                        }
                    } else if (opcion3 == 2) {
                        System.out.println("Lista de la categoría Snack: ");
                        for (Producto prod : producto) {
                            if (prod instanceof Snack) {
                                Snack snack = (Snack) prod;
                                System.out.println(snack.toString());
                            }
                        }
                    } else if (opcion3 == 3) {
                        System.out.println("Lista de la categoría Dulce: ");
                        for (Producto prod : producto) {
                            if (prod instanceof Dulce) {
                                Dulce dulce = (Dulce) prod;
                                System.out.println(dulce.toString());
                            }
                        }
                    }
                    break;

                case 5:
                    System.out.println("----------------------------------------------------------");
                    System.out.println("Las ventas actuales son: ");
                    int ventasBebidas = 0;
                    int ventasSnacks = 0;
                    int ventasDulces = 0;

                    for (Producto prod : producto) {
                        if (prod instanceof Bebida) {
                            ventasBebidas += prod.calcularVentas();
                        } else if (prod instanceof Snack) {
                            ventasSnacks += prod.calcularVentas();
                        } else if (prod instanceof Dulce) {
                            ventasDulces += prod.calcularVentas();
                        }
                    }

                    System.out.println("Ventas totales por categoría:");
                    System.out.println("Bebidas: " + ventasBebidas);
                    System.out.println("Snacks: " + ventasSnacks);
                    System.out.println("Dulces: " + ventasDulces);
                    break;

                case 6:
                    System.out.println("----------------------------------------------------------");
                    System.out.println("-----INFORME-----");
                    int totalBebidasVendidas = 0;
                    int totalSnacksVendidos = 0;
                    int totalDulcesVendidos = 0;
                    double totalVentas = 0.0;

                    for (Producto prod : producto) {
                        if (prod instanceof Bebida) {
                            totalBebidasVendidas += prod.getCantVendidos();
                        } else if (prod instanceof Snack) {
                            totalSnacksVendidos += prod.getCantVendidos();
                        } else if (prod instanceof Dulce) {
                            totalDulcesVendidos += prod.getCantVendidos();
                        }
                        totalVentas += prod.getPrecio() * prod.getCantVendidos();
                    }

                    System.out.println("Listado de categorías con el total de productos vendidos:");
                    System.out.println("a. Bebidas - " + totalBebidasVendidas + " (cantidad de productos vendidos)");
                    System.out.println("b. Snacks - " + totalSnacksVendidos + " (cantidad de productos vendidos)");
                    System.out.println("c. Dulces - " + totalDulcesVendidos + " (cantidad de productos vendidos)");

                    // Mostrar el listado de productos por categoría
                    System.out.println("Listado de productos por categoría:");
                    for (Producto prod : producto) {
                        System.out.println(prod.getNombre());
                    }

                    System.out.println("Total de ventas: Q" + totalVentas);
                    System.out.println("Porcentaje por categoría:");
                    System.out.println("a. Bebidas: Q" + (totalBebidasVendidas * 0.12 * totalVentas));
                    System.out.println("b. Snacks: Q" + (totalSnacksVendidos * 0.12 * totalVentas));
                    System.out.println("c. Dulces: Q" + (totalDulcesVendidos * 0.12 * totalVentas));
                    break;

                case 7:
                    System.out.println("----------------------------------------------------------");
                    System.out.println("Cerrando Sistema...");
                    scanner.close();
                    System.exit(0);
                    break;

            }

        }

    }
}