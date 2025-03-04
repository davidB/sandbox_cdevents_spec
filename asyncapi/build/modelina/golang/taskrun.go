
package cdevents

// Taskrun represents a Taskrun model.
type Taskrun struct {
  Predicate TaskrunPredicate
}

func (r Taskrun) IsSubjectKind() {}
