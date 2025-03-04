
package cdevents

// TestcaseKind represents an enum of TestcaseKind.
type TestcaseKind uint

const (
  TestcaseKindPerformance TestcaseKind = iota
  TestcaseKindFunctional
  TestcaseKindUnit
  TestcaseKindSecurity
  TestcaseKindCompliance
  TestcaseKindIntegration
  TestcaseKindE2e
  TestcaseKindOther
)

// Value returns the value of the enum.
func (op TestcaseKind) Value() any {
	if op >= TestcaseKind(len(TestcaseKindValues)) {
		return nil
	}
	return TestcaseKindValues[op]
}

var TestcaseKindValues = []any{"performance","functional","unit","security","compliance","integration","e2e","other"}
var ValuesToTestcaseKind = map[any]TestcaseKind{
  TestcaseKindValues[TestcaseKindPerformance]: TestcaseKindPerformance,
  TestcaseKindValues[TestcaseKindFunctional]: TestcaseKindFunctional,
  TestcaseKindValues[TestcaseKindUnit]: TestcaseKindUnit,
  TestcaseKindValues[TestcaseKindSecurity]: TestcaseKindSecurity,
  TestcaseKindValues[TestcaseKindCompliance]: TestcaseKindCompliance,
  TestcaseKindValues[TestcaseKindIntegration]: TestcaseKindIntegration,
  TestcaseKindValues[TestcaseKindE2e]: TestcaseKindE2e,
  TestcaseKindValues[TestcaseKindOther]: TestcaseKindOther,
}
