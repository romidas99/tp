package seedu.address.ui;

import java.util.logging.Logger;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import javafx.stage.Stage;
import seedu.address.commons.core.LogsCenter;

/**
 * Controller for a help page
 */
public class HelpWindow extends UiPart<Stage> {

    public static final String HELP_MESSAGE = String.join("\n",
            "BizBook - Internship Tracker",
            "",
            "Application Fields:",
            "  • Company Name",
            "  • Industry",
            "  • Job Title",
            "  • Description",
            "  • Status: ToApply | Applied | Interviewing | Offer | Rejected",
            "",
            "Commands:",
            "  1) add <COMPANY>, <INDUSTRY>, <JOB_TITLE>, <DESCRIPTION>, <APPLICATION_STATUS>",
            "     - Add a new application with all fields",
            "     - Example: add Google, Technology, Software Engineering Intern, Full-stack development role, ToApply",
            "",
            "  2) list",
            "     - List all applications",
            "",
            "  3) status <INDEX> <STATUS>",
            "     - Update status of an application",
            "     - STATUS: ToApply | Applied | Interviewing | Offer | Rejected",
            "     - Example: status 2 Interviewing",
            "",
            "  4) delete <INDEX>",
            "     - Delete an application",
            "     - Example: delete 3",
            "",
            "  5) help",
            "     - Show this help");

    private static final Logger logger = LogsCenter.getLogger(HelpWindow.class);
    private static final String FXML = "HelpWindow.fxml";

    @FXML
    private Button copyButton;

    @FXML
    private Label helpMessage;

    /**
     * Creates a new HelpWindow.
     *
     * @param root Stage to use as the root of the HelpWindow.
     */
    public HelpWindow(Stage root) {
        super(FXML, root);
        helpMessage.setText(HELP_MESSAGE);
        helpMessage.setWrapText(true);
    }

    /**
     * Creates a new HelpWindow.
     */
    public HelpWindow() {
        this(new Stage());
    }

    /**
     * Shows the help window.
     * @throws IllegalStateException
     *     <ul>
     *         <li>
     *             if this method is called on a thread other than the JavaFX Application Thread.
     *         </li>
     *         <li>
     *             if this method is called during animation or layout processing.
     *         </li>
     *         <li>
     *             if this method is called on the primary stage.
     *         </li>
     *         <li>
     *             if {@code dialogStage} is already showing.
     *         </li>
     *     </ul>
     */
    public void show() {
        logger.fine("Showing help page about the application.");
        getRoot().show();
        getRoot().centerOnScreen();
    }

    /**
     * Returns true if the help window is currently being shown.
     */
    public boolean isShowing() {
        return getRoot().isShowing();
    }

    /**
     * Hides the help window.
     */
    public void hide() {
        getRoot().hide();
    }

    /**
     * Focuses on the help window.
     */
    public void focus() {
        getRoot().requestFocus();
    }

    /**
     * Copies the URL to the user guide to the clipboard.
     */
    @FXML
    private void copyUrl() {
        final Clipboard clipboard = Clipboard.getSystemClipboard();
        final ClipboardContent url = new ClipboardContent();
//        url.putString(USERGUIDE_URL);
        clipboard.setContent(url);
    }
}
