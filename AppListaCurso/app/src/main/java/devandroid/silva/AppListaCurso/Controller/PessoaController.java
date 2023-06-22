package devandroid.silva.AppListaCurso.Controller;

import android.content.SharedPreferences;
import android.util.Log;

import androidx.annotation.NonNull;

import devandroid.silva.AppListaCurso.Model.Pessoa;
import devandroid.silva.AppListaCurso.View.MainActivity;

public class PessoaController {

    //recurso disponivel no android para armazenar dados - sharedPreferences
    SharedPreferences preferences;

    public static final String NOME_PREFERENCES = "pref_listavip";

    // listaVip public para acesso em qualquer lugar do código
    SharedPreferences.Editor listaVip;

    public PessoaController(MainActivity mainActivity){

        //instanciando um sharedPreferences para salvar informações
        preferences = mainActivity.getSharedPreferences("NOME_PREFERENCES",0);
        listaVip = preferences.edit();
    }


    @NonNull
    @Override
    public String toString() {
        Log.d("MVC_Controller","Controller Iniciada...");
        return super.toString();
    }

    //salvando os dados no sharedPreferences
    public void salvarPessoa(Pessoa pessoa) {

        Log.i("MVC Controller","Salvo com sucesso "+pessoa.toString());


        listaVip.putString("primeiroNome",pessoa.getPrimeiroNome());
        listaVip.putString("sobreNome",pessoa.getSobreNome());
        listaVip.putString("cursoDesejado",pessoa.getCursoDesejado());
        listaVip.putString("telefoneContato",pessoa.getTelefoneContato());
        listaVip.apply();
    }

    public Pessoa buscarPessoa(Pessoa pessoa){

        //Utilizando o sharedPreferences para recuperar os dados salvo no arquivo NOME_PREFERENCES.xml
        pessoa.setPrimeiroNome(preferences.getString("primeiroNome","NA"));
        pessoa.setSobreNome(preferences.getString("sobreNome","NA"));
        pessoa.setCursoDesejado(preferences.getString("cursoDesejado","NA"));
        pessoa.setTelefoneContato(preferences.getString("telefoneContato","NA"));

        return pessoa;
    }

    //método utilizado para limpar o arquivo NOME_PREFERENCES.xml do sharedPreferences
    public void limparPessoa(){

        listaVip.clear();
        listaVip.apply();
    }
}
