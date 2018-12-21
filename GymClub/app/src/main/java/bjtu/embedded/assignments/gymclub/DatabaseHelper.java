package bjtu.embedded.assignments.gymclub;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "persons.db";
    private static final String TABLE_NAME = "persons";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_FIRSTNAME = "firstname";
    private static final String COLUMN_LASTNAME = "lastname";
    private static final String COLUMN_EMAIL = "email";
    private static final String COLUMN_PASSWORD = "password";

    SQLiteDatabase db;

    private static final String TABLE_CREATE="create table persons (id integer primary key not null ," +
            "firstname text not null, lastname text not null, email text not null, password text not null);";

    public DatabaseHelper(Context context)
    {
        super(context, DATABASE_NAME,    null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_CREATE);
        this.db = db;
    }

    public void insertPerson(Person p)
    {
        db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        //create a string query
        String query = "select  * from persons ";
        Cursor cursor = db.rawQuery(query, null);
        int count = cursor.getCount();

        values.put(COLUMN_ID, count);
        values.put(COLUMN_FIRSTNAME, p.getFirstname());
        values.put(COLUMN_LASTNAME, p.getLastname());
        values.put(COLUMN_EMAIL, p.getEmail());
        values.put(COLUMN_PASSWORD, p.getPassword());

        //this will insert the content in the database
        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    public String searchPassword(String email){

        db = this.getReadableDatabase();
        String query = "select email, password from " +TABLE_NAME;
        Cursor cursor = db.rawQuery(query, null);
        String a, b;
        b="not found";
        if(cursor.moveToFirst()){
            do{
                a=cursor.getString(0);

                if(a.equals(email)){
                    b=cursor.getString(1);
                    break;
                }
            }
            while (cursor.moveToNext());
        }
        return b;
    }

    public boolean searchEmail(String email){

        db = this.getReadableDatabase();
        String query = "select email from " +TABLE_NAME;
        Cursor cursor = db.rawQuery(query, null);
        if(cursor.moveToFirst()){
            do{
                if(cursor.getString(0).equals(email)){
                    return true;
                }
            }
            while (cursor.moveToNext());
        }
        return false;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String query = "DROP TABLE IF EXISTS"+TABLE_NAME;
        db.execSQL(query);
        this.onCreate(db);
    }
}
