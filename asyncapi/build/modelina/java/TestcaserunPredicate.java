package cdevents;
import cdevents.TestcaserunStarted;
import java.util.Map;
import com.fasterxml.jackson.annotation.*;
@JsonTypeInfo(use=JsonTypeInfo.Id.NAME, include=JsonTypeInfo.As.EXISTING_PROPERTY, property="kind", visible=true)
@JsonSubTypes({
  @JsonSubTypes.Type(value = TestcaserunStarted.class, name = "TestcaserunStarted")
})
/**
 * TestcaserunPredicate represents a union of types: TestcaserunStarted
 */
public interface TestcaserunPredicate {
  
}