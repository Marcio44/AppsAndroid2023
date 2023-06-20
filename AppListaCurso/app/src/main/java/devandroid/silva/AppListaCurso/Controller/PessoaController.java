package devandroid.silva.AppListaCurso.Controller;

import android.util.Log;

import androidx.annotation.NonNull;

import devandroid.silva.AppListaCurso.Model.Pessoa;

public class PessoaController {

    public PessoaController(){}


    @NonNull
    @Override
    public String toString() {
        Log.d("MVC_Controller","Controller Iniciada...");
        return super.toString();
    }

    public void salvarPessoa(Pessoa pessoa) {

        Log.i("MVC Controller","Salvo com sucesso "+pessoa.toString());
    }
}
