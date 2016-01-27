package lk.ac.mrt.cse.padsswidget;

import org.sonar.api.web.AbstractRubyTemplate;
import org.sonar.api.web.Description;
import org.sonar.api.web.RubyRailsWidget;
import org.sonar.api.web.UserRole;

/**
 * PA DSS Compliance Widget
 *
 * @author Nuran Arachchi
 * @version 1.0
 */
@UserRole(UserRole.USER)
@Description("Shows Payment Application Data Security Standard (PADSS) Non Compliance in the source code.")
public class PSDSSDashboardWidget
    extends AbstractRubyTemplate
    implements RubyRailsWidget {

    final private String id = "PA-DSSmetadata";
    final private String title = "PA DSS Compliance Monitor";
    private String templatePath ="/lk/ac/mrt/cse/padsswidget/padss_widget.html.erb";
    /**
     * Default constructor.
     */
    public PSDSSDashboardWidget() {
        super();
    }

    /**
     * Returns the widget id.
     *
     * @return the widget id
     */
    public String getId() {
        return id;
    }

    /**
     * Returns the widget title.
     *
     * @return the widget title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Returns the path to the widget Ruby file.
     *
     * @return the path to the widget Ruby file
     */
    @Override
    protected String getTemplatePath() {
        //templatePath = "/home/nuran/projects/fypproject/padssWidget/src/main/resources"+templatePath;
        return templatePath;
    }
}
