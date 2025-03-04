package cdevents;
import cdevents.TaskrunStarted;
import com.fasterxml.jackson.annotation.*;
@JsonTypeInfo(use=JsonTypeInfo.Id.NAME, include=JsonTypeInfo.As.EXISTING_PROPERTY, property="kind", visible=true)
@JsonSubTypes({
  @JsonSubTypes.Type(value = TaskrunStarted.class, name = "TaskrunStarted")
})
/**
 * TaskrunPredicate represents a union of types: TaskrunStarted
 */
public interface TaskrunPredicate {
  
}