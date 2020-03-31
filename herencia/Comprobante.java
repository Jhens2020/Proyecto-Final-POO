
package herencia;

public class Comprobante {
    private int id;
    private String cliente;
    private String productos;
    private String fecha;
    private String precioU;
    private String precioT;



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getProductos() {
        return productos;
    }

    public void setProductos(String productos) {
        this.productos = productos;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getPrecioU() {
        return precioU;
    }

    public void setPrecioU(String precioU) {
        this.precioU = precioU;
    }
    public String getPrecioT() {
        return precioT;
    }

    public void setPrecioT(String precioT) {
        this.precioT = precioT;
    }
    //Metodo para ver si funciona
    public void Comprobante() {
        System.out.println("Factura");
        System.out.println("Boleta");
    }

}