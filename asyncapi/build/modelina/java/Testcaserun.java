package cdevents;
import cdevents.Subject;
import cdevents.TestcaserunPredicate;
import java.util.Map;
import java.util.Objects;
import com.fasterxml.jackson.annotation.*;
import javax.validation.constraints.*;
public class Testcaserun implements Subject {
  @JsonProperty("predicate")
  @JsonInclude(JsonInclude.Include.NON_NULL)
  private TestcaserunPredicate predicate;

  public TestcaserunPredicate getPredicate() { return this.predicate; }
  public void setPredicate(TestcaserunPredicate predicate) { this.predicate = predicate; }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Testcaserun self = (Testcaserun) o;
      return 
        Objects.equals(this.predicate, self.predicate);
  }

  @Override
  public int hashCode() {
    return Objects.hash((Object)predicate);
  }

  @Override
  public String toString() {
    return "class Testcaserun {\n" +   
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