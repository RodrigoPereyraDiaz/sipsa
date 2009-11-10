package sipsa.control;

import javax.swing.table.TableModel;
import sipsa.presentacion.interfaces.IReporte;

public class ReportesFactoria {

    public static IReporte getReporteOTPendientes(TableModel datos) {
        Reporte reporte = new Reporte();
        reporte.setNombre("Ordenes de Trabajo Pendientes");
        reporte.setDatos(datos);
        return reporte;
    }

    public static IReporte getReporteOTRealizadas(TableModel datos) {
        Reporte reporte = new Reporte();
        reporte.setNombre("Ordenes de Trabajo Realizadas");
        reporte.setDatos(datos);
        return reporte;
    }

    public static IReporte getReporteOTVencidas(TableModel datos) {
        Reporte reporte = new Reporte();
        reporte.setNombre("Ordenes de Trabajo Vencidas");
        reporte.setDatos(datos);
        return reporte;
    }
}
