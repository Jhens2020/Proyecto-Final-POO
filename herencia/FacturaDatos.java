package herencia;

import java.util.ArrayList;
import java.util.List;

public class FacturaDatos {
    List<Factura> listaFactura = new ArrayList<Factura>();

    public List<Factura> list() {
        return listaFactura;
    }

    public void create(Factura c) {
        listaFactura.add(c);
    }

    public void delete(Factura c) {
        listaFactura.remove(c);
    }

    public void delete(int id) {
        boolean existe = false;
        for (Factura c : listaFactura) {
            System.out.println("Deleted:"+c.getId() + "\t" + c.getCliente());
            if (id == c.getId()) {
                try {
                    listaFactura.remove(c);

                } catch (java.util.ConcurrentModificationException e2) {
                    
                    System.out.println("Contacto si exist e2="+e2);
                }
                existe= true;
            }
        }
        if(!existe) {
            System.out.println("Contacto no existe");
        }
    }

}


