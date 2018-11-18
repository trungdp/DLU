package Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyInfoData extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "MyInfoData";
    public static final String TABLE_NAME = "MyInfo";
    public static final int DATABASE_VERSION = 2;

    private static final String ID ="id";
    private static final String NAME ="name";
    private static final String EMAIL ="email";
    private static final String YEARS ="years";
    private static final String ADDRESS ="address";
    private static final String PASSWORD ="password";

    public MyInfoData(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE "+TABLE_NAME +" (" +
                ID +" VARCHAR(7) primary key, "+
                NAME + " VARCHAR(100), "+
                EMAIL +" VARCHAR(50), "+
                ADDRESS+" VARCHAR(100)," +
                YEARS +" INTEGER default 1," +
                PASSWORD + " VARCHAR(50))");
    }

    public void addStudent(Student student){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(ID, student.getId());
        values.put(NAME, student.getName());
        values.put(EMAIL, student.getEmail());
        values.put(ADDRESS, student.getAddress());
        values.put(YEARS, student.getYears());

        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
