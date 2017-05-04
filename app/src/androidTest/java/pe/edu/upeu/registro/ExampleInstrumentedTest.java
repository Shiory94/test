package pe.edu.upeu.registro;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.util.Log;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

import pe.edu.upeu.registro.bean.Person;
import pe.edu.upeu.registro.bean.Producto;
import pe.edu.upeu.registro.dao.PersonDAO;
import pe.edu.upeu.registro.dao.ProductoDAO;

import static org.junit.Assert.*;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void useAppContext() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();
        assertEquals("pe.edu.upeu.registro", appContext.getPackageName());

        PersonDAO dao = new PersonDAO(appContext);
        Person person = new Person();
        person.setName("Joselin");
        person.setLastNameF("Aliaga");
        person.setLastNameM("Ancco");
        dao.savePerson(person);

        List<Person> list = dao.findPersonAll();

        Log.i("list:::",list.size()+"");

        dao.close();
        ProductoDAO dao1 = new ProductoDAO(appContext);
        Producto producto= new Producto();
        producto.setCodProducto(121);
        producto.setDesProducto("Producot1");
        producto.setCantidad(314);
        producto.setPrecio(2352);
        producto.setTotal(453);

        dao1.saveProducto(producto);

        List<Producto> list1 = dao1.findProductoAll();

        Log.i("list:::",list1.size()+"");

        dao.close();
    }
}
