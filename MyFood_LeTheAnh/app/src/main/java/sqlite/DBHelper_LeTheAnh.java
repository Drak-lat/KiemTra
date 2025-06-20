package sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper_LeTheAnh extends SQLiteOpenHelper {

    private static final String DB_NAME = "Food_LeTheAnh.db";
    private static final int DB_VERSION = 1;

    public DBHelper_LeTheAnh(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE IF NOT EXISTS User_LeTheAnh (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "username TEXT, " +
                "password TEXT)");


        db.execSQL("CREATE TABLE IF NOT EXISTS Restaurant_LeTheAnh (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "name TEXT, " +
                "address TEXT, " +
                "imageUrl TEXT, " +
                "phone TEXT)");


        db.execSQL("CREATE TABLE IF NOT EXISTS Food_LeTheAnh (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "name TEXT, " +
                "description TEXT, " +
                "price_small REAL, " +
                "price_medium REAL, " +
                "price_large REAL, " +
                "imageUrl TEXT, " +
                "restaurantId INTEGER)");


        db.execSQL("INSERT INTO User_LeTheAnh (username, password) VALUES " +
                "('theanh', '111'), ('haha', '111')");


        db.execSQL("INSERT INTO Restaurant_LeTheAnh (name, address, imageUrl, phone) VALUES " +
                "('Quán ăn độc lạ Bình Dương', '68 Võ Nguyên Giáp, Dĩ An', 'https://i.imgur.com/pic1.jpg', '0909123456')," +
                "('Cháo Lòng nhóm 9', '45 Trần Hưng Đạo, Q1', 'https://i.imgur.com/pic2.jpg', '0933111222')");


        db.execSQL("INSERT INTO Food_LeTheAnh (name, description, price_small, price_medium, price_large, imageUrl, restaurantId) VALUES " +
                "('Bánh mì bò kho', 'Bò kho đậm đà, ăn kèm bánh mì nóng', 20000, 25000, 30000, 'https://i.imgur.com/banhmibokho.jpg', 1)," +
                "('Bánh mì chả lụa', 'Chả lụa + đồ chua + tương ớt', 15000, 20000, 25000, 'https://i.imgur.com/banhmichalua.jpg', 1)," +
                "('Phở bò tái', 'Phở bò truyền thống', 30000, 35000, 40000, 'https://i.imgur.com/phobo.jpg', 2)," +
                "('Phở gà ta', 'Thịt gà ta, nước dùng thơm ngon', 28000, 33000, 38000, 'https://i.imgur.com/phoga.jpg', 2)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS User_LeTheAnh");
        db.execSQL("DROP TABLE IF EXISTS Restaurant_LeTheAnh");
        db.execSQL("DROP TABLE IF EXISTS Food_LeTheAnh");
        onCreate(db);
    }
}
