package com.compuwork.modelo;

public class Empleado {
    private int id;
    private String nombre;
    private String apellido;
    private String tipo;
    private Departamento departamento;

    // Constructor
    public Empleado(int id, String nombre, String apellido, String tipo) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.tipo = tipo;
    }

    public Empleado(int id, String nombre, String apellido, String tipo, Departamento departamento) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.tipo = tipo;
        this.departamento = departamento;
    }

    // Getters y Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getApellido() { return apellido; }
    public void setApellido(String apellido) { this.apellido = apellido; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public Departamento getDepartamento() { return departamento; }
    public void setDepartamento(Departamento departamento) { this.departamento = departamento; }
}
