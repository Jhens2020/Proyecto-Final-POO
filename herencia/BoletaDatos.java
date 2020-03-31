package herencia;

import java.util.ArrayList;
import java.util.List;

public class BoletaDatos {
    List<Boleta1> listaBoleta = new ArrayList<Boleta1>();

    public List<Boleta1> list() {
        return listaBoleta;
    }

    public void create(Boleta1 c) {
        listaBoleta.add(c);
    }

    public void delete(Boleta1 c) {
        listaBoleta.remove(c);
    }

    public void delete(int id) {
        boolean existe = false;
        for (Boleta1 c : listaBoleta) {
            System.out.println("Deleted:"+c.getId() + "\t" + c.getCliente());
            if (id == c.getId()) {
                try {
                    listaBoleta.remove(c);

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


