package com.compuwork.modelo;

import java.util.ArrayList;
import java.util.List;

public class Departamento {
    private static int contador = 1;
    private int id;
    private String nombre;
    private List<Empleado> empleados;

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

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

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

    @Override
    public String toString() {
        return nombre + " (ID: " + id + ")";
    }
}
