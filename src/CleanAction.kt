import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent

/**
 * Cancel & clean all Gradle tasks.
 * Also clean project from related build garbage.
 *
 * @author Kirill Biakov (kbiakov@gmail.com)
 */
class CleanAction : AnAction() {

    // event handler (on toolbar icon clicked)
    override fun actionPerformed(event: AnActionEvent) {
        event.project?.basePath?.let {
            Runtime.getRuntime().apply {
                exec("$it/gradlew --stop")
                exec("$it/gradlew clean ")
            }
        }
    }
}
