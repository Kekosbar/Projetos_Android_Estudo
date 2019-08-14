package script;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Mensagem {

    private String nomeContato;
    private String msm;
    private String hora;

    public Mensagem(String nomeContato, String msm) {
        this.nomeContato = nomeContato;
        this.msm = msm;
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm");
        Date data = Calendar.getInstance().getTime();
        this.hora = dateFormat.format(data);
    }

    public String getNomeContato() {
        return nomeContato;
    }

    public void setNomeContato(String nomeContato) {
        this.nomeContato = nomeContato;
    }

    public String getMsm() {
        return msm;
    }

    public void setMsm(String msm) {
        this.msm = msm;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }
}
