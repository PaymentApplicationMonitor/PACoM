package lk.ac.mrt.cse.padsswidget;

import org.sonar.api.Extension;
import org.sonar.api.SonarPlugin;

import java.util.Arrays;
import java.util.List;

/**
 * IDE Metadata plugin definition.
 *
 * @author Nuran Arachchi
 * @version 1.0
 */
public class PADSSIssueFilterPlugin extends SonarPlugin {

    /**
     * Default constructor.
     */
    public PADSSIssueFilterPlugin() {
        super();
    }

    /**
     * Defines the plugin extensions: metrics, sensor and dashboard widget.
     *
     * @return the list of extensions for this plugin
     */
    public List<Class<? extends Extension>> getExtensions() {
        return Arrays.asList(
            PADSSMetrics.class,
            PADSSSensor.class,
            PADSSIssueFilterWidget.class);
    }
}
