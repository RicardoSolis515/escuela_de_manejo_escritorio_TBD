/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Generar;

import com.lowagie.text.*;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import Modelos.Historial;
import java.io.FileOutputStream;
import java.util.List;

public class generar_pdf{

    public static void generarHistorialPDF(List<Historial> lista, String rutaSalida) {
        try {
            Document doc = new Document(PageSize.A4);
            PdfWriter.getInstance(doc, new FileOutputStream(rutaSalida));
            doc.open();

            // TÍTULO
            Paragraph titulo = new Paragraph("Reporte de Cambios de Vehículos\n\n",
                    FontFactory.getFont(FontFactory.HELVETICA_BOLD, 18));
            titulo.setAlignment(Element.ALIGN_CENTER);
            doc.add(titulo);

            // TABLA
            PdfPTable tabla = new PdfPTable(12);
            tabla.setWidthPercentage(100);

            // ENCABEZADOS
            String[] encabezados = { 
                "ID", "Fecha", "NSS", "Nombre", "Paterno", "Materno",
                "Veh. Anterior", "Marca Ant.", "Modelo Ant.",
                "Veh. Nuevo", "Marca Nue.", "Modelo Nue."
            };

            for (String h : encabezados) {
                tabla.addCell(new Phrase(h, FontFactory.getFont(FontFactory.HELVETICA_BOLD, 10)));
            }

            // DATOS
            for (Historial h : lista) {
                tabla.addCell("" + h.getId());
                tabla.addCell(h.getFecha_cambio());
                tabla.addCell(h.getNss());
                tabla.addCell(h.getNombre());
                tabla.addCell(h.getApellidopaterno());
                tabla.addCell(h.getApellidomaterno());
                tabla.addCell(h.getVehiculo_anterior());
                tabla.addCell(h.getMarca_anterior());
                tabla.addCell(h.getModelo_anterior());
                tabla.addCell(h.getVehiculo_nuevo());
                tabla.addCell(h.getMarca_nueva());
                tabla.addCell(h.getModelo_nueva());
            }

            doc.add(tabla);
            doc.close();

            System.out.println("Reporte generado en: " + rutaSalida);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
