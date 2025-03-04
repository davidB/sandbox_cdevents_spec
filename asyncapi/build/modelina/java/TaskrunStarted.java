package cdevents;
import cdevents.TaskrunPredicate;
import java.util.Objects;
import com.fasterxml.jackson.annotation.*;
import javax.validation.constraints.*;
public class TaskrunStarted implements TaskrunPredicate {
  @JsonProperty("taskName")
  @JsonInclude(JsonInclude.Include.NON_NULL)
  private String taskName;
  @JsonProperty("uri")
  @JsonInclude(JsonInclude.Include.NON_NULL)
  private Object uri;
  @JsonProperty("pipelineRun")
  @JsonInclude(JsonInclude.Include.NON_NULL)
  private Object pipelineRun;

  public String getTaskName() { return this.taskName; }
  public void setTaskName(String taskName) { this.taskName = taskName; }

  public Object getUri() { return this.uri; }
  public void setUri(Object uri) { this.uri = uri; }

  public Object getPipelineRun() { return this.pipelineRun; }
  public void setPipelineRun(Object pipelineRun) { this.pipelineRun = pipelineRun; }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TaskrunStarted self = (TaskrunStarted) o;
      return 
        Objects.equals(this.taskName, self.taskName) &&
        Objects.equals(this.uri, self.uri) &&
        Objects.equals(this.pipelineRun, self.pipelineRun);
  }

  @Override
  public int hashCode() {
    return Objects.hash((Object)taskName, (Object)uri, (Object)pipelineRun);
  }

  @Override
  public String toString() {
    return "class TaskrunStarted {\n" +   
      "    taskName: " + toIndentedString(taskName) + "\n" +
      "    uri: " + toIndentedString(uri) + "\n" +
      "    pipelineRun: " + toIndentedString(pipelineRun) + "\n" +
    "}";
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}