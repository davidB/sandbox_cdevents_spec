package cdevents;
import cdevents.ArtifactPredicate;
import java.util.Objects;
import com.fasterxml.jackson.annotation.*;
import javax.validation.constraints.*;
public class ArtifactPublished implements ArtifactPredicate {
  @NotNull
  @JsonProperty("kind")
  private String kind;

  public String getKind() { return this.kind; }
  public void setKind(String kind) { this.kind = kind; }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ArtifactPublished self = (ArtifactPublished) o;
      return 
        Objects.equals(this.kind, self.kind);
  }

  @Override
  public int hashCode() {
    return Objects.hash((Object)kind);
  }

  @Override
  public String toString() {
    return "class ArtifactPublished {\n" +   
      "    kind: " + toIndentedString(kind) + "\n" +
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