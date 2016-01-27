package lk.ac.mrt.cse.padsswidget;

import org.sonar.api.web.AbstractRubyTemplate;
import org.sonar.api.web.RubyRailsWidget;

/**
 * @author nuran
 * @version 1.0.
 * @since 1/21/16
 */
public abstract class CoreWidget extends AbstractRubyTemplate implements RubyRailsWidget {
    private String id;
    private String title;
    private String templatePath;

    protected CoreWidget(String id, String title, String templatePath) {
        this.id = id;
        this.title = title;
        this.templatePath = templatePath;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    protected String getTemplatePath() {
        return templatePath;
    }
}
