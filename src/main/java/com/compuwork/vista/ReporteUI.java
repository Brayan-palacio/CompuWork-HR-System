package com.compuwork.vista;

import com.compuwork.controlador.DepartamentoController;
import com.compuwork.controlador.EmpleadoController;
import com.compuwork.modelo.Departamento;
import java.awt.BorderLayout;
import javax.swing.*;

public class ReporteUI extends JFrame {

    private EmpleadoController empleadoController;
    private DepartamentoController departamentoController;
    private JTextArea areaReportes;
    private MainUI mainUI; // referencia al menú principal

    public ReporteUI(EmpleadoController empleadoController, DepartamentoController departamentoController, MainUI mainUI) {
        this.empleadoController = empleadoController;
        this.departamentoController = departamentoController;
        this.mainUI = mainUI;
        initComponents();
    }

    private void initComponents() {
        setTitle("Reportes - CompuWork");
        setSize(500, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        areaReportes = new JTextArea();
        areaReportes.setEditable(false);
        add(new JScrollPane(areaReportes), BorderLayout.CENTER);

        JPanel panelBotones = new JPanel();

        JButton btnGenerar = new JButton("Generar Reporte");
        btnGenerar.addActionListener(e -> generarReporte());
        panelBotones.add(btnGenerar);

        JButton btnVolver = new JButton("Volver");
        btnVolver.addActionListener(e -> volverAMenu());
        panelBotones.add(btnVolver);

        add(panelBotones, BorderLayout.SOUTH);
    }

    private void generarReporte() {
        StringBuilder sb = new StringBuilder();
        sb.append("📊 Reporte de Departamentos y Empleados\n\n");

        for (Departamento d : departamentoController.getDepartamentos()) {
            long total = empleadoController.listarEmpleados().stream()
                    .filter(e -> e.getDepartamento() != null && e.getDepartamento().getId() == d.getId())
                    .count();

            sb.append("Departamento: ").append(d.getNombre())
                    .append("  → Empleados: ").append(total)
                    .append("\n");
        }

        sb.append("\nTotal empleados registrados: ").append(empleadoController.listarEmpleados().size());

        areaReportes.setText(sb.toString());
    }

    private void volverAMenu() {
        this.dispose();
        mainUI.setVisible(true);
    }
}
