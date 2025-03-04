
package cdevents

// TestcaserunStarted represents a TestcaserunStarted model.
type TestcaserunStarted struct {
  Trigger *Trigger
  Environment interface{}
  TestSuiteRun interface{}
  TestCase *Testcase
}

func (r TestcaserunStarted) IsTestcaserunPredicateKind() {}
