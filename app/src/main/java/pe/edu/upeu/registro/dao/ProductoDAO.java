package pe.edu.upeu.registro.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import pe.edu.upeu.registro.bean.Producto;
import pe.edu.upeu.registro.bean.Producto;
import pe.edu.upeu.registro.util.Commons;

/**
 * Created by Core i7 on 03/05/2017.
 */

public class ProductoDAO extends SQLiteOpenHelper {


    private static final int VERSION=1;

    public ProductoDAO (Context context) {
        super(context, Commons.DATABASE, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String ddl="CREATE TABLE Producto(" +
                " id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
                " codProducto INTEGER," +
                " desProducto TEXT," +
                " cantidad INTEGER," +
                " precio INTEGER," +
                " total INTEGER," +

                ");";
        db.execSQL(ddl);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        String ddl ="DROP TABLE IF EXISTS Producto";
        db.execSQL(ddl);
        this.onCreate(db);
    }



    public void saveProducto(Producto producto){
        ContentValues values=new ContentValues();
        values.put("codProducto",producto.getCodProducto());
        values.put("desProducto",producto.getDesProducto());
        values.put("cantidad",producto.getCantidad());
        values.put("precio",producto.getPrecio());
        values.put("total",producto.getTotal());

        getWritableDatabase().insert("Producto",null,values);
    }

    public List<Producto> findProductoAll() {
        List<Producto> listProducto = new ArrayList<Producto>();
        String columns[]={"id","name","lastNameF","lastNameM","site","address","sex","status","statusMarried","score","photo"};
        String where=null;
        Cursor cursor = getReadableDatabase().query("Producto",columns,where,null,null,null,null);
        Producto producto=null;
        while (cursor.moveToNext()){

            producto = new Producto();
            producto.setId(cursor.getInt(0));
            producto.setCodProducto(cursor.getInt(1));
            producto.setDesProducto(cursor.getString(2));
            producto.setCantidad(cursor.getInt(3));
            producto.setPrecio(cursor.getInt(4));
            producto.setTotal(cursor.getInt(5));

            listProducto.add(producto);
        }
        return listProducto;
    }

}
