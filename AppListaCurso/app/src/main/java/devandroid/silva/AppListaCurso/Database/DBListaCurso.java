package devandroid.silva.AppListaCurso.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

import devandroid.silva.AppListaCurso.Model.Pessoa;

public class DBListaCurso extends SQLiteOpenHelper {

    private static final String DB_NAME = "listaCurso.db";
    private static final int DB_VERSION = 1;

    Cursor cursor;
    SQLiteDatabase db;


    public DBListaCurso(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);

        db = getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String sqlTabPessoa = "CREATE TABLE TabPessoa (id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "primeiroNome TEXT, sobreNome TEXT, telefoneContato TEXT, nomeCurso)";

        sqLiteDatabase.execSQL(sqlTabPessoa);

    }

    public void onSave(String tabela, ContentValues valor) {

        db.insert(tabela, null, valor);

    }

    public List<Pessoa> onRead() {

        List<Pessoa> listaPessoa = new ArrayList();

        Pessoa dadoPessoa;

        String querySQL = "SELECT * FROM TabPessoa";

        cursor = db.rawQuery(querySQL, null);

        if (cursor.moveToFirst()) {

            do {

                dadoPessoa = new Pessoa();
                dadoPessoa.setId(cursor.getInt(0));
                dadoPessoa.setPrimeiroNome(cursor.getString(1));
                dadoPessoa.setSobreNome(cursor.getString(2));
                dadoPessoa.setTelefoneContato(cursor.getString(3));
                dadoPessoa.setCursoDesejado(cursor.getString(4));

                listaPessoa.add(dadoPessoa);

            } while (cursor.moveToNext());

        } else {


        }


        return listaPessoa;
    }

    public void onUpdate(String tabela, ContentValues valor){

        int id = valor.getAsInteger("id");

        db.update(tabela,valor,"id=?",new String[]{Integer.toString(id)});

    }

    public void onDelete(String tabela, int id){

        db.delete(tabela,"id=?", new String[]{Integer.toString(id)});
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
