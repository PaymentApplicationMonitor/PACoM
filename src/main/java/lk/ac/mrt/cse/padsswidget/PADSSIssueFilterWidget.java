package lk.ac.mrt.cse.padsswidget;

/**
 * @author nuran
 * @version 1.0.
 * @since 1/21/16
 */
import org.sonar.api.web.*;

import static org.sonar.api.web.WidgetScope.GLOBAL;

@WidgetCategory({"Filters", "Issues"})
@UserRole(UserRole.USER)
@WidgetProperties({
        @WidgetProperty(key = PADSSIssueFilterWidget.FILTER_PROPERTY, type = WidgetPropertyType.ISSUE_FILTER, optional = false),
        @WidgetProperty(key = PADSSIssueFilterWidget.DISTRIBUTION_AXIS_PROPERTY, type = WidgetPropertyType.SINGLE_SELECT_LIST, defaultValue = "severities",
                options = {"severities", "resolutions", "statuses", "rules", "tags", "projectUuids", "assignees", "reporters",
                        "authors", "languages", "actionPlans", "createdAt"}),
        @WidgetProperty(key = PADSSIssueFilterWidget.DISPLAY_FILTER_DESCRIPTION, type = WidgetPropertyType.BOOLEAN, defaultValue = "false"),
        @WidgetProperty(key = PADSSIssueFilterWidget.DISPLAY_MODE, type = WidgetPropertyType.SINGLE_SELECT_LIST, defaultValue = "count", options = {"count", "debt"})
})
public class PADSSIssueFilterWidget extends CoreWidget {

    public static final String FILTER_PROPERTY = "filter";
    public static final String DISTRIBUTION_AXIS_PROPERTY = "distributionAxis";
    public static final String DISPLAY_FILTER_DESCRIPTION = "display padss code issues";
    public static final String DISPLAY_MODE = "displayMode";
    public static final String ID = "padss_issue_filter";

    public PADSSIssueFilterWidget() {
        super(ID, "PA Issue Filter", "/lk/ac/mrt/cse/padsswidget/issue_filter.html.erb");
    }
}
