package cdevents;
import cdevents.Context;
import cdevents.Subject;
import java.util.Map;
import java.util.Objects;
import com.fasterxml.jackson.annotation.*;
import javax.validation.constraints.*;
/**
 * CDEvents is a common specification for Continuous Delivery events.
 * 
 * An "event" is a data record expressing an occurrence and its context. Events are
 * routed from an event producer (the source) to interested event consumers. The
 * routing can be performed based on information contained in the event, but an
 * event will not identify a specific routing destination.
 * 
 */
public class CdEvent {
  @NotNull
  @JsonProperty("context")
  private Context context;
  @NotNull
  @JsonProperty("subject")
  private Subject subject;
  @JsonProperty("customDataContentType")
  @JsonInclude(JsonInclude.Include.NON_NULL)
  private String customDataContentType;

  /**
   * Examples: {"version":"0.5.0-draft","id":"A234-1234-1234","source":"/staging/tekton/","timestamp":"2018-04-05T17:31:00Z","schemaUri":"https://myorg.com/cdevents/schema/taskrun-started-1-1-0"}
   */
  public Context getContext() { return this.context; }
  public void setContext(Context context) { this.context = context; }

  public Subject getSubject() { return this.subject; }
  public void setSubject(Subject subject) { this.subject = subject; }

  /**
   * Content type of `customData` value. This attribute enables data
   * to carry any type of content, whereby format and encoding might differ from
   * that of the chosen event format. For example, an event rendered using the
   * [CloudEvents](cloudevents-binding.md) format might carry an XML payload in
   * data, and the consumer is informed by this attribute being set to
   * "application/xml". The rules for how data content is rendered for different
   * `customDataContentType` values are defined in the specific binding
   * specification
   * 
   * Examples: application/xml
   */
  public String getCustomDataContentType() { return this.customDataContentType; }
  public void setCustomDataContentType(String customDataContentType) { this.customDataContentType = customDataContentType; }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CdEvent self = (CdEvent) o;
      return 
        Objects.equals(this.context, self.context) &&
        Objects.equals(this.subject, self.subject) &&
        Objects.equals(this.customDataContentType, self.customDataContentType);
  }

  @Override
  public int hashCode() {
    return Objects.hash((Object)context, (Object)subject, (Object)customDataContentType);
  }

  @Override
  public String toString() {
    return "class CdEvent {\n" +   
      "    context: " + toIndentedString(context) + "\n" +
      "    subject: " + toIndentedString(subject) + "\n" +
      "    customDataContentType: " + toIndentedString(customDataContentType) + "\n" +
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