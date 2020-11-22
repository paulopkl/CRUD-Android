package up.edu.br.exemplocrud;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class PessoaAdapter extends BaseAdapter {

    private List<Pessoa> pessoas;
    private Activity activity;

    public PessoaAdapter(Activity activity, List<Pessoa> pessoas) {
        this.activity = activity;
        this.pessoas = pessoas;
    }

    @Override
    public int getCount() {
        return pessoas.size();
    }

    @Override
    public Object getItem(int i) { return pessoas.get(i); }

    @Override
    public long getItemId(int i) {
        return pessoas.get(i).getId();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        View viewAdapter = activity.getLayoutInflater().inflate(R.layout.item, viewGroup, false);

        TextView Nome = viewAdapter.findViewById(R.id.txtNome);
        TextView CPF = viewAdapter.findViewById(R.id.txtCpf);
        TextView Logradouro = viewAdapter.findViewById(R.id.txtLogradouro);
        TextView NumeroCasa = viewAdapter.findViewById(R.id.intNumeroCasa);
        TextView CEP = viewAdapter.findViewById(R.id.intCEP);
        TextView Bairro = viewAdapter.findViewById(R.id.txtBairro);
        TextView Cidade = viewAdapter.findViewById(R.id.txtCidade);
        TextView Estado = viewAdapter.findViewById(R.id.txtEstado);
        TextView NumeroTelefone = viewAdapter.findViewById(R.id.txtNumeroTelefone);
        TextView DDD = viewAdapter.findViewById(R.id.intDDD);
        TextView TipoTelefone = viewAdapter.findViewById(R.id.txtTipoTelefone);

        Pessoa p = pessoas.get(i);
        Nome.setText(p.getNome());
        CPF.setText(p.getCpf());
        Logradouro.setText(p.getLogradouro());
        NumeroCasa.setText(p.getNumeroCasa().toString());
        CEP.setText(p.getCEP().toString());
        Bairro.setText(p.getBairro());
        Cidade.setText(p.getCidade());
        Estado.setText(p.getEstado());
        NumeroTelefone.setText(p.getNumeroTelefone().toString());
        DDD.setText(p.getDDD().toString());
        TipoTelefone.setText(p.getTipoTelefone());

        return viewAdapter;
    }
}