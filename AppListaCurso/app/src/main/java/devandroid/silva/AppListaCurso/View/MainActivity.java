package devandroid.silva.AppListaCurso.View;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import devandroid.silva.AppListaCurso.Controller.CursoController;
import devandroid.silva.AppListaCurso.Controller.PessoaController;
import devandroid.silva.AppListaCurso.Model.Pessoa;
import devandroid.silva.AppListaCurso.R;

public class MainActivity extends AppCompatActivity {

    PessoaController controller;
    CursoController cursoController;
    Pessoa pessoa;
    String dadosPessoa;
    String dadosOutraPessoa;

    List<String> listaCurso;

    EditText editPrimeiroNome;
    EditText editSobreNome;
    EditText editNomeCurso;
    EditText editTelefoneContato;

    Button btnLimpar;
    Button btnSalvar;
    Button btnFinalizar;
    Spinner spinner;
    List<Pessoa> listaPessoa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);

        pessoa = new Pessoa();
        controller = new PessoaController(MainActivity.this);

        //listaPessoa = controller.listarPessoa();

        controller.buscarPessoa(pessoa);

//        Pessoa alteracao = listaPessoa.get(1);
//
//        alteracao.setPrimeiroNome("Eva Carolina");
//        alteracao.setSobreNome("Silva");
//        alteracao.setTelefoneContato("(95) 99745-5678");
//        alteracao.setCursoDesejado("Java");
//
//        controller.alterarPessoa(alteracao);
//
//        controller.deletarPessoa(1);

        cursoController = new CursoController();
        listaCurso = cursoController.dadosParaSpinner();

        editPrimeiroNome = findViewById(R.id.editPrimeiroNome);
        editSobreNome = findViewById(R.id.editSobreNome);
        editNomeCurso = findViewById(R.id.editNomeCurso);
        editTelefoneContato = findViewById(R.id.editTelefoneContato);

        btnLimpar = findViewById(R.id.btnLimpar);
        btnSalvar = findViewById(R.id.btnSalvar);
        btnFinalizar = findViewById(R.id.btnFinalizar);
        spinner = findViewById(R.id.spinner);

        editPrimeiroNome.setText(pessoa.getPrimeiroNome());
        editSobreNome.setText(pessoa.getSobreNome());
        editNomeCurso.setText(pessoa.getCursoDesejado());
        editTelefoneContato.setText(pessoa.getTelefoneContato());


        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,
                cursoController.dadosParaSpinner());
        adapter.setDropDownViewResource(android.R.layout.simple_list_item_1);
        spinner.setAdapter(adapter);

        btnLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editPrimeiroNome.setText("");
                editSobreNome.setText("");
                editNomeCurso.setText("");
                editTelefoneContato.setText("");

                controller.limparPessoa();
            }
        });

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pessoa.setPrimeiroNome(editPrimeiroNome.getText().toString());
                pessoa.setSobreNome(editSobreNome.getText().toString());
                pessoa.setCursoDesejado(editNomeCurso.getText().toString());
                pessoa.setTelefoneContato(editTelefoneContato.getText().toString());
                Toast.makeText(MainActivity.this, "Operação Realizada com Sucesso! " + pessoa.toString(), Toast.LENGTH_LONG).show();

                controller.salvarPessoa(pessoa);

            }
        });


        btnFinalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Até Breve", Toast.LENGTH_LONG).show();
                finish();
            }
        });

        spinner. setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {

                String selectedItem = adapterView.getItemAtPosition(position).toString();
                editNomeCurso.setText(selectedItem);

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

                if (editNomeCurso.getText().equals("Nenhum")) {
                    editNomeCurso.setError("Escolha o Curso Desejado!");
                    editNomeCurso.requestFocus();
                }


            }
        });




        dadosPessoa = pessoa.getPrimeiroNome();
        dadosPessoa = pessoa.getSobreNome();
        dadosPessoa = pessoa.getCursoDesejado();
        dadosPessoa = pessoa.getTelefoneContato();

        Log.i("POOAndroid", pessoa.toString());

    }
}