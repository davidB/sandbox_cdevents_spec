
package cdevents

// ArtifactDeleted represents a ArtifactDeleted model.
type ArtifactDeleted struct {
  User string
}

func (r ArtifactDeleted) IsArtifactPredicateKind() {}
