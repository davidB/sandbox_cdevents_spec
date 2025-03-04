package cdevents;
import cdevents.TestcaseKind;
import java.util.Objects;
import com.fasterxml.jackson.annotation.*;
import javax.validation.constraints.*;
public class Testcase {
  @NotNull
  @JsonProperty("id")
  private Object id;
  @JsonProperty("version")
  @JsonInclude(JsonInclude.Include.NON_NULL)
  private String version;
  @JsonProperty("name")
  @JsonInclude(JsonInclude.Include.NON_NULL)
  private String name;
  @JsonProperty("kind")
  @JsonInclude(JsonInclude.Include.NON_NULL)
  private TestcaseKind kind;
  @JsonProperty("uri")
  @JsonInclude(JsonInclude.Include.NON_NULL)
  private Object uri;

  public Object getId() { return this.id; }
  public void setId(Object id) { this.id = id; }

  public String getVersion() { return this.version; }
  public void setVersion(String version) { this.version = version; }

  public String getName() { return this.name; }
  public void setName(String name) { this.name = name; }

  public TestcaseKind getKind() { return this.kind; }
  public void setKind(TestcaseKind kind) { this.kind = kind; }

  public Object getUri() { return this.uri; }
  public void setUri(Object uri) { this.uri = uri; }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Testcase self = (Testcase) o;
      return 
        Objects.equals(this.id, self.id) &&
        Objects.equals(this.version, self.version) &&
        Objects.equals(this.name, self.name) &&
        Objects.equals(this.kind, self.kind) &&
        Objects.equals(this.uri, self.uri);
  }

  @Override
  public int hashCode() {
    return Objects.hash((Object)id, (Object)version, (Object)name, (Object)kind, (Object)uri);
  }

  @Override
  public String toString() {
    return "class Testcase {\n" +   
      "    id: " + toIndentedString(id) + "\n" +
      "    version: " + toIndentedString(version) + "\n" +
      "    name: " + toIndentedString(name) + "\n" +
      "    kind: " + toIndentedString(kind) + "\n" +
      "    uri: " + toIndentedString(uri) + "\n" +
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