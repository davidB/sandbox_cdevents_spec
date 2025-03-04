package cdevents;
import cdevents.Artifact;
import cdevents.Taskrun;
import cdevents.Testcaserun;
import java.util.Map;
import com.fasterxml.jackson.annotation.*;
@JsonTypeInfo(use=JsonTypeInfo.Id.NAME, include=JsonTypeInfo.As.EXISTING_PROPERTY, property="kind", visible=true)
@JsonSubTypes({
  @JsonSubTypes.Type(value = Artifact.class, name = "Artifact"),
  @JsonSubTypes.Type(value = Taskrun.class, name = "Taskrun"),
  @JsonSubTypes.Type(value = Testcaserun.class, name = "Testcaserun")
})
/**
 * Subject represents a union of types: Artifact, Taskrun, Testcaserun
 */
public interface Subject {
  
}