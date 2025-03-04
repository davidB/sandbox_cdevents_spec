
package cdevents

// TaskrunStarted represents a TaskrunStarted model.
type TaskrunStarted struct {
  TaskName string
  Uri interface{}
  PipelineRun interface{}
}

func (r TaskrunStarted) IsTaskrunPredicateKind() {}
