package vn.edu.itdlu.a1610234.dhdl.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import vn.edu.itdlu.a1610234.dhdl.Database.Student;

public class StudentManager extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "StudentManager";
    public static final String TABLE_NAME = "Student";
    public static final int DATABASE_VERSION = 2;

    private static final String ID ="id";
    private static final String NAME ="name";
    private static final String EMAIL ="email";
    private static final String YEARS ="years";
    private static final String ADDRESS ="address";
    private static final String PASSWORD ="password";
    private Context context;


    public StudentManager(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
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

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);
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

    public Student getStudent(String id){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_NAME, new String[] { ID,
                        NAME, EMAIL,ADDRESS,YEARS }, ID + "=?",
                new String[] { id }, null, null, null, null);
        if (cursor != null) cursor.moveToFirst();
        Student student = new Student(cursor.getString(0),
                cursor.getString(1),
                cursor.getString(2),
                cursor.getString(3),
                cursor.getInt(4),
                cursor.getString(5));

        cursor.close();
        db.close();
        return student;
    }

    public int update(Student student){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(NAME,student.getName());
        return db.update(TABLE_NAME,values,ID +"=?",new String[] { student.getId()});
    }

    public List<Student> getAllStudent(){
        List<Student> listStudent = new ArrayList<Student>();
        String selectQuery = "SELECT  * FROM " + TABLE_NAME;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery,null);
        if (cursor.moveToFirst()){
            do {
                Student student = new Student();
                student.setId(cursor.getString(0));
                student.setName(cursor.getString(1));
                student.setEmail(cursor.getString(2));
                student.setAddress(cursor.getString(3));
                student.setYears(cursor.getInt(4));
                student.setPassword(cursor.getString(5));
                listStudent.add(student);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return listStudent;
    }

    public void deleteStudent(Student student) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME, ID + " = ?",
                new String[] { student.getId() });
        db.close();
    }

    public int getStudentsCount() {
        String countQuery = "SELECT  COUNT(*) FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();
        return cursor.getCount();
    }
}
