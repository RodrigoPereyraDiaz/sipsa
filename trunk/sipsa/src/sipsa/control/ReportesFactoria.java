package sipsa.control;

import sipsa.dominio.Pac;
import sipsa.presentacion.interfaces.IReporte;

class ReportesFactoria {

    static IReporte getReporteOTPendientes() {
        OTControl oTControl = new OTControl();
        Reporte reporte = new Reporte();
        reporte.setNombre("Ordenes de Trabajo Pendientes");
        reporte.setDatos(oTControl.getOTPendientes());
        return reporte;
    }

    static IReporte getReporteOTRealizadas() {
        OTControl oTControl = new OTControl();
        Reporte reporte = new Reporte();
        reporte.setNombre("Ordenes de Trabajo Realizadas");
        reporte.setDatos(oTControl.getOTRealizadas());
        return reporte;
    }

    static IReporte getReporteOTVencidas() {
        OTControl oTControl = new OTControl();
        Reporte reporte = new Reporte();
        reporte.setNombre("Ordenes de Trabajo Vencidas");
        reporte.setDatos(oTControl.getOTVencidas());
        return reporte;
    }

        static IReporte getReporteOTPendientes(Pac pac) {
        OTControl oTControl = new OTControl();
        Reporte reporte = new Reporte();
        reporte.setNombre("Ordenes de Trabajo Pendientes");
        reporte.setDatos(oTControl.getOTPendientes(pac.getCuit()));
        return reporte;
    }

    static IReporte getReporteOTRealizadas(Pac pac) {
        OTControl oTControl = new OTControl();
        Reporte reporte = new Reporte();
        reporte.setNombre("Ordenes de Trabajo Realizadas");
        reporte.setDatos(oTControl.getOTRealizadas(pac.getCuit()));
        return reporte;
    }

    static IReporte getReporteOTVencidas(Pac pac) {
        OTControl oTControl = new OTControl();
        Reporte reporte = new Reporte();
        reporte.setNombre("Ordenes de Trabajo Vencidas");
        reporte.setDatos(oTControl.getOTVencidas(pac.getCuit()));
        return reporte;
    }
}
