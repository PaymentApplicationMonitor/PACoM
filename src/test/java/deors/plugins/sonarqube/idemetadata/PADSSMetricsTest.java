package deors.plugins.sonarqube.idemetadata;

import static org.junit.Assert.assertEquals;

import lk.ac.mrt.cse.padsswidget.PADSSMetrics;
import org.junit.Test;

public class PADSSMetricsTest {

    public PADSSMetricsTest() {
        super();
    }

    @Test
    public void testMetricsDefinition() {

        PADSSMetrics metrics = new PADSSMetrics();

        assertEquals("plug-in should have 13 metrics defined", 13, metrics.getMetrics().size());
    }
}
