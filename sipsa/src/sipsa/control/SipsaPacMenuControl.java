package sipsa.control;

import sipsa.dominio.Pac;
import sipsa.presentacion.escritorio.ReporteVisor;
import sipsa.presentacion.escritorio.SipsaPacMenu;
import sipsa.presentacion.interfaces.IReporte;
import sipsa.presentacion.interfaces.ISipsaPacMenu;

public class SipsaPacMenuControl implements ISipsaPacMenu {

    private Pac pac;

    /**
     * Muestra el formulario Menu Sipsa
     */
    public void mostrarMenu(){

        SipsaPacMenu  sipsaPacMenu = new SipsaPacMenu(this);
        sipsaPacMenu.setVisible(true);
    }


    public void administrarOT() {
        OTControl oTControl = new OTControl();
        oTControl.mostrarAdministrar();
    }

    public void mostrarReporteOTRealizadas() {
        IReporte reporte = ReportesFactoria.getReporteOTRealizadas(this.pac);
        ReporteVisor reporteVisor = new ReporteVisor(reporte);
        reporteVisor.setVisible(true);

    }

    public void mostrarReporteOTPendientes() {
        IReporte reporte = ReportesFactoria.getReporteOTPendientes(this.pac);
        ReporteVisor reporteVisor = new ReporteVisor(reporte);
        reporteVisor.setVisible(true);
    }

    public void mostrarReporteOTVencidas() {
        IReporte reporte = ReportesFactoria.getReporteOTVencidas(this.pac);
        ReporteVisor reporteVisor = new ReporteVisor(reporte);
        reporteVisor.setVisible(true);
    }
}