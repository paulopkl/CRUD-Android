package up.edu.br.exemplocrud;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Conexao extends SQLiteOpenHelper {

    private static final String name = "banco.db";
    private static final int version = 1;

    public Conexao(Context context) {
        super(context, name, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE pessoa(" +
                "Id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "Nome VARCHAR(50), " +
                "CPF VARCHAR(50), " +
                "Logradouro VARCHAR(256), " +
                "NumeroCasa INTEGER, " +
                "CEP INTEGER, " +
                "Bairro VARCHAR(50), " +
                "Cidade VARCHAR(30), " +
                "Estado VARCHAR(20), " +
                "NumeroTelefone INTEGER, " +
                "DDD INTEGER, " +
                "TipoTelefone VARCHAR(10)" +
                ")"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int versaoAntiga, int versaoNova) {
        db.execSQL("DROP TABLE IF EXISTS pessoa");
        onCreate(db);
    }
}
