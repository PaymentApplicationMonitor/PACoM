package lk.ac.mrt.cse.padsswidget;

import java.util.Arrays;
import java.util.List;

import org.sonar.api.measures.CoreMetrics;
import org.sonar.api.measures.Metric;
import org.sonar.api.measures.Metrics;

/**
 * IDE Metadata plugin metrics definition.
 *
 * @author Nuran Arachchi
 * @version 1.0
 */
public class PADSSMetrics implements Metrics {

    /**
     * The project name (as configured in the IDE).
     */
    public static final Metric IDE_PRJ_NAME =
        new Metric.Builder(
            "ide_prj_name",
            "Project name in IDE",
            Metric.ValueType.STRING)
            .setDescription("The project name (as configured in the IDE)")
            .setQualitative(true)
                .setBestValue(10.0)
                .setDomain(CoreMetrics.DOMAIN_GENERAL)
            .create();

    /**
     * Whether the project is configured as Java in the IDE.
     */
    public static final Metric IDE_IS_JAVA =
        new Metric.Builder(
            "ide_is_java",
            "Java project",
            Metric.ValueType.BOOL)
            .setDescription("Whether the project is configured as Java in the IDE")
            .setQualitative(true)
                .setBestValue(10.0)
                .setDomain(CoreMetrics.DOMAIN_GENERAL)
            .create();

    /**
     * Whether the project is configured as EAR in the IDE.
     */
    public static final Metric IDE_IS_EAR =
        new Metric.Builder(
            "ide_is_ear",
            "Enterprise Application project",
            Metric.ValueType.BOOL)
            .setDescription("Whether the project is configured as EAR in the IDE")
            .setQualitative(true)
                .setBestValue(10.0)
                .setDomain(CoreMetrics.DOMAIN_GENERAL)
            .create();

    /**
     * Whether the project is configured as EJB in the IDE.
     */
    public static final Metric IDE_IS_EJB =
        new Metric.Builder(
            "ide_is_ejb",
            "Enterprise JavaBeans project",
            Metric.ValueType.BOOL)
            .setDescription("Whether the project is configured as EJB in the IDE")
            .setQualitative(true)
                .setBestValue(10.0)
                .setDomain(CoreMetrics.DOMAIN_GENERAL)
            .create();

    /**
     * Whether the project is configured as Web in the IDE.
     */
    public static final Metric IDE_IS_WEB =
        new Metric.Builder(
            "ide_is_web",
            "Web Application project",
            Metric.ValueType.BOOL)
            .setDescription("Whether the project is configured as Web in the IDE")
            .setQualitative(true)
                .setBestValue(10.0)
                .setDomain(CoreMetrics.DOMAIN_GENERAL)
            .create();

    /**
     * Whether the project is configured as GWT in the IDE.
     */
    public static final Metric IDE_IS_GWT =
        new Metric.Builder(
            "ide_is_gwt",
            "Google Web Toolkit project",
            Metric.ValueType.BOOL)
            .setDescription("Whether the project is configured as GWT in the IDE")
            .setQualitative(true)
                .setBestValue(10.0)
                .setDomain(CoreMetrics.DOMAIN_GENERAL)
            .create();


    /**
     * The list of declared dependencies for the project.
     */
    public static final Metric IDE_DEPENDENCIES =
        new Metric.Builder(
            "ide_dependencies",
            "List of declared dependencies",
            Metric.ValueType.STRING)
            .setDescription("The list of declared dependencies for the project")
            .setQualitative(true)
                .setBestValue(10.0)
                .setDomain(CoreMetrics.DOMAIN_GENERAL)
            .create();

    /**
     * The list of configured classpath entries for the project.
     */
    public static final Metric IDE_CLASSPATH =
        new Metric.Builder(
            "ide_classpath",
            "List of configured classpath entries",
            Metric.ValueType.STRING)
            .setDescription("The list of configured classpath entries for the project")
            .setQualitative(true)
                .setBestValue(10.0)
                .setDomain(CoreMetrics.DOMAIN_GENERAL)
            .create();

    /**
     * Default constructor.
     */
    public PADSSMetrics() {
        super();
    }

    /**
     * Defines the plugin metrics.
     *
     * @return the list of this plugin metrics
     */
    public List<Metric> getMetrics() {
        return Arrays.asList(
            IDE_PRJ_NAME, IDE_IS_JAVA, IDE_IS_EAR, IDE_IS_EJB, IDE_IS_WEB,
            IDE_IS_GWT, IDE_DEPENDENCIES, IDE_CLASSPATH);
    }
}
