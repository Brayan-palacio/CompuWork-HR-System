package com.compuwork.controlador;

import com.compuwork.modelo.Departamento;
import java.util.ArrayList;
import java.util.List;

public class DepartamentoController {

    private static DepartamentoController instance;
    private final List<Departamento> departamentos;
    private int ultimoId;

    public DepartamentoController() {
        departamentos = new ArrayList<>();
        ultimoId = 0;
    }

    public static DepartamentoController getInstance() {
        if (instance == null) {
            instance = new DepartamentoController();
        }
        return instance;
    }

    public void agregarDepartamento(String nombre) {
        Departamento d = new Departamento(nombre);
        departamentos.add(d);
    }

    public void eliminarDepartamento(int id) {
        departamentos.removeIf(d -> d.getId() == id);
    }

    public List<Departamento> getDepartamentos() {
        return new ArrayList<>(departamentos);
    }

    public Departamento buscarDepartamento(int id) {
        for (Departamento d : departamentos) {
            if (d.getId() == id) return d;
        }
        return null;
    }

    public void actualizarDepartamento(Departamento dep) {
        for (int i = 0; i < departamentos.size(); i++) {
            if (departamentos.get(i).getId() == dep.getId()) {
                departamentos.set(i, dep);
                return;
            }
        }
    }
}
