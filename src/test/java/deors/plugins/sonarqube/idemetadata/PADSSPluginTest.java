package deors.plugins.sonarqube.idemetadata;

import static org.junit.Assert.assertEquals;

import lk.ac.mrt.cse.padsswidget.PADSSPlugin;
import org.junit.Test;

public class PADSSPluginTest {

    public PADSSPluginTest() {
        super();
    }

    @Test
    public void testPluginDefinition() {

        PADSSPlugin plugin = new PADSSPlugin();

        assertEquals("plug-in should have 3 extensions defined", 3, plugin.getExtensions().size());
    }
}
