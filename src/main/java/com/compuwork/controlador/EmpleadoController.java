package com.compuwork.controlador;

import com.compuwork.modelo.Empleado;
import java.util.ArrayList;
import java.util.List;

public class EmpleadoController {

    private static EmpleadoController instance;
    private final List<Empleado> empleados;
    private int ultimoId;

    public EmpleadoController() {
        empleados = new ArrayList<>();
        ultimoId = 0;
    }

    public static EmpleadoController getInstance() {
        if (instance == null) {
            instance = new EmpleadoController();
        }
        return instance;
    }

    public void agregarEmpleado(Empleado e) {
        ultimoId++;
        e.setId(ultimoId);
        empleados.add(e);
    }

    public List<Empleado> listarEmpleados() {
        return new ArrayList<>(empleados);
    }

    public void eliminarEmpleado(int id) {
        empleados.removeIf(emp -> emp.getId() == id);
    }

    public void actualizarEmpleado(Empleado e) {
        for (int i = 0; i < empleados.size(); i++) {
            if (empleados.get(i).getId() == e.getId()) {
                empleados.set(i, e);
                return;
            }
        }
    }

    public Empleado buscarEmpleado(int id) {
        for (Empleado emp : empleados) {
            if (emp.getId() == id) return emp;
        }
        return null;
    }
}
