package up.edu.br.exemplocrud;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SearchView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class ListarPessoasActivity extends AppCompatActivity {

    private ListView listView;
    private PessoaDAO pessoaDAO;
    private List<Pessoa> pessoas;
    private List<Pessoa> pessoasFiltradas = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_alunos);

        listView = findViewById(R.id.listViewAlunos);
        pessoaDAO = new PessoaDAO(this);
        pessoas = pessoaDAO.obterTodos();
        pessoasFiltradas.addAll(pessoas);
        // ArrayAdapter<Aluno> adaptador = new ArrayAdapter<Aluno>(this, android.R.layout.simple_list_item_1, alunosFiltrados);
        PessoaAdapter adaptador = new PessoaAdapter(this, pessoasFiltradas);
        listView.setAdapter(adaptador);

        registerForContextMenu(listView);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater i = getMenuInflater();
        i.inflate(R.menu.menu_principal, menu);

        SearchView sv = (SearchView) menu.findItem(R.id.app_bar_search).getActionView();
        sv.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                procuraAluno(s);
                return false;
            }
        });
        return true;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater i = getMenuInflater();
        i.inflate(R.menu.menu_contexto, menu);
    }

    public void procuraAluno(String nome){
        pessoasFiltradas.clear();
        for (Pessoa p : pessoas) {
            if(p.getNome().toLowerCase().contains(nome.toLowerCase())){
                pessoasFiltradas.add(p);
            }
            listView.invalidateViews();
        }
    }

    public void cadastrar(MenuItem item){
        Intent it = new Intent(this, CadastroPessoaActivity.class);
        startActivity(it);
    }

    public void excluir(MenuItem item){
        AdapterView.AdapterContextMenuInfo menuInfo = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();

        final Pessoa pessoaExcluir = pessoasFiltradas.get(menuInfo.position);

        AlertDialog dialog = new AlertDialog.Builder(this)
                .setTitle("Atenção")
                .setMessage("Excluir a Pessoa?")
                .setNegativeButton("NÃO", null)
                .setPositiveButton("SIM", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        pessoasFiltradas.remove(pessoaExcluir);
                        pessoas.remove(pessoaExcluir);
                        pessoaDAO.excluir((pessoaExcluir));
                        listView.invalidateViews();
                    }
                }).create();
        dialog.show();
    }

    public void atualizar(MenuItem item) {
        AdapterView.AdapterContextMenuInfo menuInfo = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();

        final Pessoa pessoaAtualizar = pessoasFiltradas.get(menuInfo.position);
        Intent it = new Intent(this, CadastroPessoaActivity.class);
        it.putExtra("pessoa", pessoaAtualizar);
        startActivity(it);
    }

    @Override
    public void onResume(){
        super.onResume();
        pessoas = pessoaDAO.obterTodos();
        pessoasFiltradas.clear();
        pessoasFiltradas.addAll(pessoas);
        listView.invalidateViews();
    }
}