package cdevents;
import cdevents.ArtifactPublished;
import cdevents.ArtifactDeleted;
import com.fasterxml.jackson.annotation.*;
@JsonTypeInfo(use=JsonTypeInfo.Id.NAME, include=JsonTypeInfo.As.EXISTING_PROPERTY, property="kind", visible=true)
@JsonSubTypes({
  @JsonSubTypes.Type(value = ArtifactPublished.class, name = "ArtifactPublished"),
  @JsonSubTypes.Type(value = ArtifactDeleted.class, name = "ArtifactDeleted")
})
/**
 * ArtifactPredicate represents a union of types: ArtifactPublished, ArtifactDeleted
 */
public interface ArtifactPredicate {
  String getKind();
}