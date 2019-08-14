package com.example.root.asynctask;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.ProgressBar;
import android.widget.TextView;

public class Assincrona extends AsyncTask <Void, Void, Void>{

    private int progress;
    private final String LOG = "script";
    private TextView txt;
    private ProgressBar progressBar;

    public Assincrona(TextView txt, ProgressBar progressBar) {
        this.txt = txt;
        this.progressBar = progressBar;
    }

    @Override
    protected Void doInBackground(Void... voids) {
        Log.i(LOG, "Iniciou tarefa");
        for(progress=0; progress < 100; progress++){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            publishProgress();
        }
        return null;
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        txt.setText(progress+" %");
        progressBar.setProgress(progress);
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        Log.i(LOG, "Fim da tarefa");
    }
}
