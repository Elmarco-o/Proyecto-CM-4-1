package com.example.ficgame;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "db_juegos";
    private static final int DATABASE_VERSION = 1;

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Create the "usuarios" table
        db.execSQL("CREATE TABLE usuarios (_id INTEGER PRIMARY KEY AUTOINCREMENT, email TEXT, contrasena TEXT);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Handle upgrades if needed
    }

    // Method to check credentials in the database
    public boolean checkCredentials(String email, String contrasena) {
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM usuarios WHERE email = ? AND contrasena = ?", new String[]{email, contrasena});
        boolean isValid = cursor.moveToFirst();
        cursor.close();
        return isValid;
    }
}
