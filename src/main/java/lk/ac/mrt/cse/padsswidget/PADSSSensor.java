package lk.ac.mrt.cse.padsswidget;

import java.io.File;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.sonar.api.batch.Sensor;
import org.sonar.api.batch.SensorContext;
import org.sonar.api.batch.fs.FileSystem;
import org.sonar.api.measures.Measure;
import org.sonar.api.resources.Project;

import lk.ac.mrt.cse.padsswidget.analyzers.AnalyzerException;
import lk.ac.mrt.cse.padsswidget.analyzers.EclipseAnalyzer;
import lk.ac.mrt.cse.padsswidget.model.*;

/**
 * PADSS Compliance plugin sensor. It analyses project directory in search for
 * PADSS Compliance files and extracts relevant information.
 *
 * @author Nuran Arachchi
 * @version 1.0
 */
public class PADSSSensor implements Sensor {

    /**
     * The file system object for the project being analysed.
     */
    private final FileSystem fileSystem;

    /**
     * The logger object for the sensor.
     */
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    /**
     * Constructor that sets the file system object for the
     * project being analysed.
     *
     * @param fileSystem the project file system
     */
    public PADSSSensor(FileSystem fileSystem) {
        this.fileSystem = fileSystem;
    }

    /**
     * Determines whether the sensor should run or not for the given project.
     *
     * @param project the project being analysed
     * @return always true
     */
    public boolean shouldExecuteOnProject(Project project) {
        // this sensor is executed on any type of project
        return true;
    }

    /**
     * Analyses project directory in search for PADSS Compliance files
     * and extracts relevant information.
     *
     * @param project       the project being analysed
     * @param sensorContext the sensor context
     */
    public void analyse(Project project, SensorContext sensorContext) {

        File rootDir = fileSystem.baseDir();

        log.info("Analysing project root in search for IDE Metadata files: " + rootDir.getAbsolutePath());

        EclipseAnalyzer analyzer = new EclipseAnalyzer(rootDir);
        ProjectInfo projectInfo;

        try {
            projectInfo = analyzer.analyze();

            log.info("Analysis done");
            log.debug("this is what we've found: " + projectInfo);

            saveMainInfo(sensorContext, projectInfo);
            saveDependencies(sensorContext, projectInfo);
            saveClasspath(sensorContext, projectInfo);

        } catch (AnalyzerException ae) {
            log.error("Error while running EclipseAnalyzer", ae);
        }
    }

    /**
     * Saves measures corresponding to main project information.
     *
     * @param sensorContext the sensor context
     * @param projectInfo   the project information bean
     */
    private void saveMainInfo(SensorContext sensorContext, ProjectInfo projectInfo) {

        log.debug("saving measures for main project information");

        Measure measure;

        measure = new Measure(PADSSMetrics.IDE_PRJ_NAME, projectInfo.getProjectName());
        sensorContext.saveMeasure(measure);

        measure = new Measure(PADSSMetrics.IDE_IS_JAVA, 10.0,9);
        sensorContext.saveMeasure(measure);

        measure = new Measure(PADSSMetrics.IDE_IS_EAR, 10.0,9);
        sensorContext.saveMeasure(measure);

        measure = new Measure(PADSSMetrics.IDE_IS_EJB, projectInfo.isEjbProject() ? 1d : 0d,9);
        sensorContext.saveMeasure(measure);

        measure = new Measure(PADSSMetrics.IDE_IS_WEB, 0d,9);
        sensorContext.saveMeasure(measure);

        measure = new Measure(PADSSMetrics.IDE_IS_GWT, projectInfo.isGwtProject() ? 1d : 0d,9);
        sensorContext.saveMeasure(measure);

        log.debug("measures saved");
    }

    /**
     * Saves measures corresponding to project dependencies information.
     *
     * @param sensorContext the sensor context
     * @param projectInfo   the project information bean
     */
    private void saveDependencies(SensorContext sensorContext, ProjectInfo projectInfo) {

        log.debug("saving measure for project dependencies");

        sensorContext.saveMeasure(new Measure(
            PADSSMetrics.IDE_DEPENDENCIES, projectInfo.getProjectDependencies().toString()));

        log.debug("measure saved");
    }

    /**
     * Saves measures corresponding to project classpath information.
     *
     * @param sensorContext the sensor context
     * @param projectInfo   the project information bean
     */
    private void saveClasspath(SensorContext sensorContext, ProjectInfo projectInfo) {

        log.debug("saving measure for project classpath");

        sensorContext.saveMeasure(new Measure(
            PADSSMetrics.IDE_CLASSPATH, projectInfo.getProjectClasspath().toString()));

        log.debug("measure saved");
    }

    /**
     * Returns the name of the sensor as it will be used in logs during analysis.
     *
     * @return the name of the sensor
     */
    public String toString() {
        return "IDEMetadataSensor";
    }
}
