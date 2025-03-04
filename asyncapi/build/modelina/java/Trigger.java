package cdevents;
import cdevents.TriggerKind;
import java.util.Map;
import java.util.Objects;
import com.fasterxml.jackson.annotation.*;
import javax.validation.constraints.*;
public class Trigger {
  @JsonProperty("kind")
  @JsonInclude(JsonInclude.Include.NON_NULL)
  private TriggerKind kind;
  @JsonProperty("uri")
  @JsonInclude(JsonInclude.Include.NON_NULL)
  private Object uri;
  @JsonAnySetter
  @JsonInclude(JsonInclude.Include.NON_NULL)
  private Map<String, Object> additionalProperties;

  public TriggerKind getKind() { return this.kind; }
  public void setKind(TriggerKind kind) { this.kind = kind; }

  public Object getUri() { return this.uri; }
  public void setUri(Object uri) { this.uri = uri; }

  @JsonAnyGetter
  public Map<String, Object> getAdditionalProperties() { return this.additionalProperties; }
  public void setAdditionalProperties(Map<String, Object> additionalProperties) { this.additionalProperties = additionalProperties; }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Trigger self = (Trigger) o;
      return 
        Objects.equals(this.kind, self.kind) &&
        Objects.equals(this.uri, self.uri) &&
        Objects.equals(this.additionalProperties, self.additionalProperties);
  }

  @Override
  public int hashCode() {
    return Objects.hash((Object)kind, (Object)uri, (Object)additionalProperties);
  }

  @Override
  public String toString() {
    return "class Trigger {\n" +   
      "    kind: " + toIndentedString(kind) + "\n" +
      "    uri: " + toIndentedString(uri) + "\n" +
      "    additionalProperties: " + toIndentedString(additionalProperties) + "\n" +
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