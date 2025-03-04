package cdevents;

import java.util.Objects;
import com.fasterxml.jackson.annotation.*;
import javax.validation.constraints.*;
/**
 * Examples: {"version":"0.5.0-draft","id":"A234-1234-1234","source":"/staging/tekton/","timestamp":"2018-04-05T17:31:00Z","schemaUri":"https://myorg.com/cdevents/schema/taskrun-started-1-1-0"}
 */
public class Context {
  @NotNull
  @Pattern(regexp="\\d+\\.\\d+\\.\\d+(-.*)?")
  @JsonProperty("version")
  private String version;
  @NotNull
  @Size(min=1)
  @JsonProperty("id")
  private String id;
  @NotNull
  @Size(min=1)
  @JsonProperty("source")
  private String source;
  @NotNull
  @JsonProperty("timestamp")
  private java.time.OffsetDateTime timestamp;
  @Size(min=1)
  @JsonProperty("schemaUri")
  @JsonInclude(JsonInclude.Include.NON_NULL)
  private String schemaUri;
  @Size(min=1)
  @JsonProperty("chainId")
  @JsonInclude(JsonInclude.Include.NON_NULL)
  private String chainId;

  /**
   * Examples: 0.4.0, 0.5.0-draft
   */
  public String getVersion() { return this.version; }
  public void setVersion(String version) { this.version = version; }

  /**
   * Examples: tenant1/12345-abcde
   */
  public String getId() { return this.id; }
  public void setId(String id) { this.id = id; }

  /**
   * Examples: /tekton, https://www.jenkins.io/, /cloud1/spinnaker-A, /cluster2/keptn-A, /teamX/knative-1
   */
  public String getSource() { return this.source; }
  public void setSource(String source) { this.source = source; }

  /**
   * Scalar string in the format specified in [RFC 3339](https://datatracker.ietf.org/doc/html/rfc3339)
   * 
   */
  public java.time.OffsetDateTime getTimestamp() { return this.timestamp; }
  public void setTimestamp(java.time.OffsetDateTime timestamp) { this.timestamp = timestamp; }

  public String getSchemaUri() { return this.schemaUri; }
  public void setSchemaUri(String schemaUri) { this.schemaUri = schemaUri; }

  public String getChainId() { return this.chainId; }
  public void setChainId(String chainId) { this.chainId = chainId; }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Context self = (Context) o;
      return 
        Objects.equals(this.version, self.version) &&
        Objects.equals(this.id, self.id) &&
        Objects.equals(this.source, self.source) &&
        Objects.equals(this.timestamp, self.timestamp) &&
        Objects.equals(this.schemaUri, self.schemaUri) &&
        Objects.equals(this.chainId, self.chainId);
  }

  @Override
  public int hashCode() {
    return Objects.hash((Object)version, (Object)id, (Object)source, (Object)timestamp, (Object)schemaUri, (Object)chainId);
  }

  @Override
  public String toString() {
    return "class Context {\n" +   
      "    version: " + toIndentedString(version) + "\n" +
      "    id: " + toIndentedString(id) + "\n" +
      "    source: " + toIndentedString(source) + "\n" +
      "    timestamp: " + toIndentedString(timestamp) + "\n" +
      "    schemaUri: " + toIndentedString(schemaUri) + "\n" +
      "    chainId: " + toIndentedString(chainId) + "\n" +
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