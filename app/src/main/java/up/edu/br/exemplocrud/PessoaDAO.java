package up.edu.br.exemplocrud;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class PessoaDAO {

    private Conexao conexao;
    private SQLiteDatabase banco;

    public PessoaDAO(Context context){
        conexao = new Conexao(context);
        banco = conexao.getWritableDatabase();
    }

    public long inserir(Pessoa pessoa){
        ContentValues values = new ContentValues();
        values.put("Nome", pessoa.getNome());
        values.put("CPF", pessoa.getCpf());
        values.put("Logradouro", pessoa.getLogradouro());
        values.put("NumeroCasa", pessoa.getNumeroCasa());
        values.put("CEP", pessoa.getCEP());
        values.put("Bairro", pessoa.getBairro());
        values.put("Cidade", pessoa.getCidade());
        values.put("Estado", pessoa.getEstado());
        values.put("NumeroTelefone", pessoa.getNumeroTelefone());
        values.put("DDD", pessoa.getDDD());
        values.put("TipoTelefone", pessoa.getTipoTelefone());
        return banco.insert("pessoa", null, values);
    }

    public List<Pessoa> obterTodos(){

        List<Pessoa> pessoas = new ArrayList<>();
        Cursor cursor = banco.query("pessoa", new String[]{"Id", "Nome", "CPF", "Logradouro", "NumeroCasa", "CEP", "Bairro", "Cidade", "Estado", "NumeroTelefone", "DDD", "TipoTelefone"},
                null, null, null, null, null);
        while (cursor.moveToNext()){
            Pessoa p = new Pessoa();
            p.setId(cursor.getInt(0));
            p.setNome(cursor.getString(1));
            p.setCpf(cursor.getString(2));
            p.setLogradouro(cursor.getString(3));
            p.setNumeroCasa(cursor.getInt(4));
            p.setCEP(cursor.getInt(5));
            p.setBairro(cursor.getString(6));
            p.setCidade(cursor.getString(7));
            p.setEstado(cursor.getString(8));
            p.setNumeroTelefone(cursor.getInt(9));
            p.setDDD(cursor.getInt(10));
            p.setTipoTelefone(cursor.getString(11));

            pessoas.add(p);
        }
        return pessoas;
    }

    public void excluir(Pessoa pessoa){
        banco.delete("pessoa", "Id = ?", new String[]{pessoa.getId().toString()} );
    }

    public void atualizar(Pessoa pessoa){
        ContentValues values = new ContentValues();
        values.put("Nome", pessoa.getNome());
        values.put("CPF", pessoa.getCpf());
        values.put("Logradouro", pessoa.getLogradouro());
        values.put("NumeroCasa", pessoa.getNumeroCasa());
        values.put("CEP", pessoa.getCEP());
        values.put("Bairro", pessoa.getBairro());
        values.put("Cidade", pessoa.getCidade());
        values.put("Estado", pessoa.getEstado());
        values.put("NumeroTelefone", pessoa.getNumeroTelefone());
        values.put("DDD", pessoa.getDDD());
        values.put("TipoTelefone", pessoa.getTipoTelefone());

        banco.update("pessoa", values, "Id = ?", new String[]{pessoa.getId().toString()});
    }
}