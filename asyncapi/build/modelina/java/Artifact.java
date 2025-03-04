package cdevents;
import cdevents.Subject;
import java.util.Objects;
import com.fasterxml.jackson.annotation.*;
import javax.validation.constraints.*;
public class Artifact implements Subject {
  @JsonProperty("predicate")
  @JsonInclude(JsonInclude.Include.NON_NULL)
  private Object predicate;

  public Object getPredicate() { return this.predicate; }
  public void setPredicate(Object predicate) { this.predicate = predicate; }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Artifact self = (Artifact) o;
      return 
        Objects.equals(this.predicate, self.predicate);
  }

  @Override
  public int hashCode() {
    return Objects.hash((Object)predicate);
  }

  @Override
  public String toString() {
    return "class Artifact {\n" +   
      "    predicate: " + toIndentedString(predicate) + "\n" +
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