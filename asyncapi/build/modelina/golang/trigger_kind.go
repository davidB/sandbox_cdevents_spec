
package cdevents

// TriggerKind represents an enum of TriggerKind.
type TriggerKind uint

const (
  TriggerKindManual TriggerKind = iota
  TriggerKindPipeline
  TriggerKindEvent
  TriggerKindSchedule
  TriggerKindOther
)

// Value returns the value of the enum.
func (op TriggerKind) Value() any {
	if op >= TriggerKind(len(TriggerKindValues)) {
		return nil
	}
	return TriggerKindValues[op]
}

var TriggerKindValues = []any{"manual","pipeline","event","schedule","other"}
var ValuesToTriggerKind = map[any]TriggerKind{
  TriggerKindValues[TriggerKindManual]: TriggerKindManual,
  TriggerKindValues[TriggerKindPipeline]: TriggerKindPipeline,
  TriggerKindValues[TriggerKindEvent]: TriggerKindEvent,
  TriggerKindValues[TriggerKindSchedule]: TriggerKindSchedule,
  TriggerKindValues[TriggerKindOther]: TriggerKindOther,
}
