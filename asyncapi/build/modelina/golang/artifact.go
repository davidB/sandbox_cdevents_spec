
package cdevents

// Artifact represents a Artifact model.
type Artifact struct {
  Predicate ArtifactPredicate
}

func (r Artifact) IsSubjectKind() {}
