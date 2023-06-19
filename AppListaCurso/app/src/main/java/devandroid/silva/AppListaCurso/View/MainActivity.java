package devandroid.silva.AppListaCurso.View;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import devandroid.silva.AppListaCurso.Model.Pessoa;
import devandroid.silva.AppListaCurso.R;

public class MainActivity extends AppCompatActivity {

    Pessoa pessoa;
    Pessoa outraPessoa;

    String dadosPessoa;
    String dadosOutraPessoa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pessoa = new Pessoa();
        pessoa.setPrimeiroNome("Marcio");
        pessoa.setSobreNome("Silva");
        pessoa.setCursoDesejado("Segurança da Informação");
        pessoa.setTelefoneContato("95 99283334");

        dadosPessoa = pessoa.getPrimeiroNome();
        dadosPessoa = pessoa.getSobreNome();
        dadosPessoa = pessoa.getCursoDesejado();
        dadosPessoa = pessoa.getTelefoneContato();

        outraPessoa = new Pessoa();
        outraPessoa.setPrimeiroNome("Marco");
        outraPessoa.setSobreNome("Silva");
        outraPessoa.setCursoDesejado("Redes de Computadores");
        outraPessoa.setTelefoneContato("95 983546870");

        dadosOutraPessoa = outraPessoa.getPrimeiroNome();
        dadosOutraPessoa  = outraPessoa.getSobreNome();
        dadosOutraPessoa  = outraPessoa.getCursoDesejado();
        dadosOutraPessoa  = outraPessoa.getTelefoneContato();

        Log.i("POOAndroid",pessoa.toString());
        Log.i("POOAndroid",outraPessoa.toString());

    }
}