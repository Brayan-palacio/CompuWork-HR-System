package com.compuwork.modelo;

import java.util.ArrayList;
import java.util.List;

public class Departamento {
    private static int contador = 1;  // Generador de IDs automáticos
    private int id;
    private String nombre;
    private List<Empleado> empleados;

    // Constructor: cada departamento nuevo recibe un ID único
    public Departamento(String nombre) {
        this.id = contador++;
        this.nombre = nombre;
        this.empleados = new ArrayList<>();
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    // Setter para nombre (el ID no cambia nunca)
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Gestión de empleados en el departamento
    public List<Empleado> getEmpleados() {
        return empleados;
    }

    public void agregarEmpleado(Empleado e) {
        if (!empleados.contains(e)) {
            empleados.add(e);
        }
    }

    public void eliminarEmpleado(int idEmpleado) {
        empleados.removeIf(e -> e.getId() == idEmpleado);
    }

    // Representación en texto (muy útil para JComboBox y depuración)
    @Override
    public String toString() {
        return nombre + " (ID: " + id + ")";
    }
}
