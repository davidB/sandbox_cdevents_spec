package cdevents;
import cdevents.TestcaserunPredicate;
import cdevents.Trigger;
import cdevents.Testcase;
import java.util.Map;
import java.util.Objects;
import com.fasterxml.jackson.annotation.*;
import javax.validation.constraints.*;
public class TestcaserunStarted implements TestcaserunPredicate {
  @JsonProperty("trigger")
  @JsonInclude(JsonInclude.Include.NON_NULL)
  private Trigger trigger;
  @NotNull
  @JsonProperty("environment")
  private Object environment;
  @JsonProperty("testSuiteRun")
  @JsonInclude(JsonInclude.Include.NON_NULL)
  private Object testSuiteRun;
  @JsonProperty("testCase")
  @JsonInclude(JsonInclude.Include.NON_NULL)
  private Testcase testCase;

  public Trigger getTrigger() { return this.trigger; }
  public void setTrigger(Trigger trigger) { this.trigger = trigger; }

  public Object getEnvironment() { return this.environment; }
  public void setEnvironment(Object environment) { this.environment = environment; }

  public Object getTestSuiteRun() { return this.testSuiteRun; }
  public void setTestSuiteRun(Object testSuiteRun) { this.testSuiteRun = testSuiteRun; }

  public Testcase getTestCase() { return this.testCase; }
  public void setTestCase(Testcase testCase) { this.testCase = testCase; }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TestcaserunStarted self = (TestcaserunStarted) o;
      return 
        Objects.equals(this.trigger, self.trigger) &&
        Objects.equals(this.environment, self.environment) &&
        Objects.equals(this.testSuiteRun, self.testSuiteRun) &&
        Objects.equals(this.testCase, self.testCase);
  }

  @Override
  public int hashCode() {
    return Objects.hash((Object)trigger, (Object)environment, (Object)testSuiteRun, (Object)testCase);
  }

  @Override
  public String toString() {
    return "class TestcaserunStarted {\n" +   
      "    trigger: " + toIndentedString(trigger) + "\n" +
      "    environment: " + toIndentedString(environment) + "\n" +
      "    testSuiteRun: " + toIndentedString(testSuiteRun) + "\n" +
      "    testCase: " + toIndentedString(testCase) + "\n" +
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