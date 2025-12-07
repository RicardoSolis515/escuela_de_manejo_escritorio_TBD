/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Generar;

/**
 *
 * @author Usuario
 */
import Controladores.kmDAO;
import java.util.Map;
    import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;

public class generar_grafica {

    public static void mostrarGrafica() {

        // Obtener datos
        Map<String, Integer> datos = new kmDAO().obtenerKilometrosPorInstructor();

        // Dataset
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        for (Map.Entry<String, Integer> entry : datos.entrySet()) {
            dataset.addValue(entry.getValue(), "Kilómetros Recorridos", entry.getKey());
        }

        // Crear gráfica
        JFreeChart chart = ChartFactory.createBarChart(
                "Kilómetros recorridos por instructor",
                "Instructor",
                "Kilómetros",
                dataset
        );

        // Mostrar en una ventana Swing
        ChartPanel panel = new ChartPanel(chart);
        javax.swing.JFrame ventana = new javax.swing.JFrame("Reporte de Kilómetros");
        ventana.setDefaultCloseOperation(javax.swing.JFrame.DISPOSE_ON_CLOSE);
        ventana.setSize(900, 600);
        ventana.add(panel);
        ventana.setVisible(true);
    }

}
