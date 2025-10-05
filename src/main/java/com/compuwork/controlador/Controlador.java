package com.compuwork.controlador;

import com.compuwork.modelo.Empleado;
import com.compuwork.modelo.Departamento;
import java.util.ArrayList;

public class Controlador {
    private static Controlador instance;

    private ArrayList<Empleado> empleados = new ArrayList<>();
    private ArrayList<Departamento> departamentos = new ArrayList<>();

    private Controlador() {
    }

    public static Controlador getInstance() {
        if (instance == null) {
            instance = new Controlador();
        }
        return instance;
    }

    // -------------------- EMPLEADOS --------------------
    public void agregarEmpleado(Empleado e) {
        empleados.add(e);
    }

    public void eliminarEmpleado(int id) {
        empleados.removeIf(e -> e.getId() == id);
    }

    public ArrayList<Empleado> getEmpleados() {
        return empleados;
    }

    public void actualizarEmpleado(Empleado emp) {
        for (int i = 0; i < empleados.size(); i++) {
            if (empleados.get(i).getId() == emp.getId()) {
                empleados.set(i, emp);
                return;
            }
        }
    }

    // -------------------- DEPARTAMENTOS --------------------
    public void agregarDepartamento(Departamento d) {
        departamentos.add(d);
    }

    public ArrayList<Departamento> getDepartamentos() {
        return departamentos;
    }

    public void eliminarDepartamento(int id) {
        departamentos.removeIf(d -> d.getId() == id);
    }
}
