package pe.edu.upeu.registro.bean;

/**
 * Created by Core i7 on 03/05/2017.
 */

public class Producto {


    private int id;
    private int codProducto;
    private String desProducto;
    private  int cantidad;
    private  int precio;
    private int total;

    public Producto(){}

    public Producto(int id, int codProducto, String desProducto, int cantidad, int precio, int total) {
        this.id = id;
        this.codProducto = codProducto;
        this.desProducto = desProducto;
        this.cantidad = cantidad;
        this.precio = precio;
        this.total = total;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCodProducto() {
        return codProducto;
    }

    public void setCodProducto(int codProducto) {
        this.codProducto = codProducto;
    }

    public String getDesProducto() {
        return desProducto;
    }

    public void setDesProducto(String desProducto) {
        this.desProducto = desProducto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return codProducto +" "+ desProducto + " "+ cantidad +" "+ precio +" "+ total;
    }
}
