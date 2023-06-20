package devandroid.silva.AppListaCurso.View;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import devandroid.silva.AppListaCurso.Controller.PessoaController;
import devandroid.silva.AppListaCurso.Model.Pessoa;
import devandroid.silva.AppListaCurso.R;

public class MainActivity extends AppCompatActivity {

    PessoaController controller;

    Pessoa pessoa;
    Pessoa outraPessoa;

    String dadosPessoa;
    String dadosOutraPessoa;

    EditText editPrimeiroNome;
    EditText editSobreNome;
    EditText editNomeCurso;
    EditText editTelefoneContato;

    Button btnLimpar;
    Button btnSalvar;
    Button btnFinalizar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        controller = new PessoaController();

        pessoa = new Pessoa();
        pessoa.setPrimeiroNome("Marcio");
        pessoa.setSobreNome("Silva");
        pessoa.setCursoDesejado("Segurança da Informação");
        pessoa.setTelefoneContato("95 99283334");

       editPrimeiroNome = findViewById(R.id.editPrimeiroNome);
       editSobreNome = findViewById(R.id.editSobreNome);
       editNomeCurso = findViewById(R.id.editNomeCurso);
       editTelefoneContato = findViewById(R.id.editTelefoneContato);

       btnLimpar = findViewById(R.id.btnLimpar);
       btnSalvar = findViewById(R.id.btnSalvar);
       btnFinalizar = findViewById(R.id.btnFinalizar);

       editPrimeiroNome.setText(pessoa.getPrimeiroNome());
        editSobreNome.setText(pessoa.getSobreNome());
        editNomeCurso.setText(pessoa.getCursoDesejado());
        editTelefoneContato.setText(pessoa.getTelefoneContato());

        btnLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editPrimeiroNome.setText("");
                editSobreNome.setText("");
                editNomeCurso.setText("");
                editTelefoneContato.setText("");
            }
        });

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              pessoa.setPrimeiroNome(editPrimeiroNome.getText().toString());
              pessoa.setSobreNome(editSobreNome.getText().toString());
              pessoa.setCursoDesejado(editNomeCurso.getText().toString());
              pessoa.setTelefoneContato(editTelefoneContato.getText().toString());
              Toast.makeText(MainActivity.this,"Operação Realizada com Sucesso! "+ pessoa.toString(),Toast.LENGTH_LONG).show();
              controller.salvarPessoa(pessoa);

            }
        });



        btnFinalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"Até Breve",Toast.LENGTH_LONG).show();
                finish();
            }
        });
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