package up.edu.br.exemplocrud;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class CadastroPessoaActivity extends AppCompatActivity {

    private EditText Nome;
    private EditText CPF;
    private EditText Logradouro;
    private EditText NumeroCasa;
    private EditText CEP;
    private EditText Bairro;
    private EditText Cidade;
    private EditText Estado;
    private EditText NumeroTelefone;
    private EditText DDD;
    private EditText TipoTelefone;
    private PessoaDAO pessoaDAO;
    private Pessoa pessoa = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_aluno);

        Nome = findViewById(R.id.editNome);
        CPF = findViewById(R.id.editCpf);
        Logradouro = findViewById(R.id.editLogradouro);
        NumeroCasa = findViewById(R.id.editNumCasa);
        CEP = findViewById(R.id.editCEP);
        Bairro = findViewById(R.id.editBairro);
        Cidade = findViewById(R.id.editCidade);
        Estado = findViewById(R.id.editEstado);
        NumeroTelefone = findViewById(R.id.editTelefone);
        DDD = findViewById(R.id.editDDD);
        TipoTelefone = findViewById(R.id.editTipoTelefone);

        pessoaDAO = new PessoaDAO(this);
        Intent it = getIntent();
        if (it.hasExtra("pessoa")){
            pessoa = (Pessoa) it.getSerializableExtra("pessoa");
            Nome.setText(pessoa.getNome());
            CPF.setText(pessoa.getCpf());
            Logradouro.setText(pessoa.getLogradouro());
            NumeroCasa.setText(pessoa.getNumeroCasa().toString());
            CEP.setText(pessoa.getCEP().toString());
            Bairro.setText(pessoa.getBairro());
            Cidade.setText(pessoa.getCidade());
            Estado.setText(pessoa.getEstado());
            NumeroTelefone.setText(pessoa.getNumeroTelefone().toString());
            DDD.setText(pessoa.getDDD().toString());
            TipoTelefone.setText(pessoa.getTipoTelefone());
        }
    }

    public void salvar(View view){

        if (pessoa == null) {
            pessoa = new Pessoa();
            pessoa.setNome(Nome.getText().toString());
            pessoa.setCpf(CPF.getText().toString());
            pessoa.setLogradouro(Logradouro.getText().toString());
            pessoa.setNumeroCasa(Integer.parseInt(NumeroCasa.getText().toString()));
            pessoa.setCEP(Integer.parseInt(CEP.getText().toString()));
            pessoa.setBairro(Bairro.getText().toString());
            pessoa.setCidade(Cidade.getText().toString());
            pessoa.setEstado(Estado.getText().toString());
            pessoa.setNumeroTelefone(Integer.parseInt(NumeroTelefone.getText().toString()));
            pessoa.setDDD(Integer.parseInt(DDD.getText().toString()));
            pessoa.setTipoTelefone(TipoTelefone.getText().toString());

            long id = pessoaDAO.inserir(pessoa);
            Toast.makeText(this, "Pessoa inserida com o ID " + id, Toast.LENGTH_SHORT).show();
        } else {
            pessoa.setNome(Nome.getText().toString());
            pessoa.setCpf(CPF.getText().toString());
            pessoa.setLogradouro(Logradouro.getText().toString());
            pessoa.setNumeroCasa(Integer.parseInt(NumeroCasa.getText().toString()));
            pessoa.setCEP(Integer.parseInt(CEP.getText().toString()));
            pessoa.setBairro(Bairro.getText().toString());
            pessoa.setCidade(Cidade.getText().toString());
            pessoa.setEstado(Estado.getText().toString());
            pessoa.setNumeroTelefone(Integer.parseInt(NumeroTelefone.getText().toString()));
            pessoa.setDDD(Integer.parseInt(DDD.getText().toString()));
            pessoa.setTipoTelefone(TipoTelefone.getText().toString());

            pessoaDAO.atualizar(pessoa);
            Toast.makeText(this, "Dados atualizados", Toast.LENGTH_SHORT).show();
        }
    }
}