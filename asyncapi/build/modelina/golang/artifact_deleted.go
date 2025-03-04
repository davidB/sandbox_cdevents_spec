
package cdevents

// ArtifactDeleted represents a ArtifactDeleted model.
type ArtifactDeleted struct {
  Kind string
  User string
}

func (r ArtifactDeleted) IsArtifactPredicateKind() {}
