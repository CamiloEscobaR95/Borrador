package utilidades;


public class MetodosGenericos {
    Evidencias evidencias = new Evidencias();
    private int contador = 0;


    public MetodosGenericos() {
        super();
    }


    public void tomaEvidencia(String detalle) {
        try {
            Thread.sleep(1000);
            evidencias.capturaDispositivo(detalle);
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void tomaEvidenciaPC(String strDetalle) {
        try {
            Thread.sleep(500);
            evidencias.capturaDispositivoPC(strDetalle);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
