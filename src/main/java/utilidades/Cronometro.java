package utilidades;

public class Cronometro implements Runnable{

    public void run() {
        //logger.info("El cronometro está corriendo");
        Integer minutos = 0, segundos = 0, milesimas = 0;
        String min = "", seg = "", mil = "";
        try {
            while (cronometroActivo) {
                Thread.sleep(4);
                milesimas += 4;
                if (milesimas == 1000) {
                    milesimas = 0;
                    segundos += 1;
                    if (segundos == 60) {
                        segundos = 0;
                        minutos++;
                    }
                }
                if (minutos < 10)
                    min = "0" + minutos;
                else
                    min = minutos.toString();
                if (segundos < 10)
                    seg = "0" + segundos;
                else
                    seg = segundos.toString();

                if (milesimas < 10)
                    mil = "00" + milesimas;
                else if (milesimas < 100)
                    mil = "0" + milesimas;
                else
                    mil = milesimas.toString();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        tiempo = (min + ":" + seg + ":" + mil);
        //logger.info("El cronometro se ha detenido");
    }

    /**
     * Método que inicia el cronometro.
     */
    public void iniciarCronometro() {
       //logger.info("Cronometro iniciado");
        cronometroActivo = true;
        hilo = new Thread(this);
        hilo.start();
    }

    /**
     * Método que detiene el cronometro.
     *
     * @return
     * @throws InterruptedException
     */
    public String pararCronometro()  {

        try {
            cronometroActivo = false;
            Thread.sleep(500);
        } catch (InterruptedException e) {

            e.printStackTrace();
        }
        //logger.info("El cronometro paró en: " + tiempo);
        return tiempo;
    }

    Thread hilo;
    boolean cronometroActivo;
    String tiempo = "00:00:000";
}
