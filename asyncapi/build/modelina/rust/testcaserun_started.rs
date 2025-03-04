// TestcaserunStarted represents a TestcaserunStarted model.
#[derive(Clone, Debug, Deserialize, Serialize)]
pub struct TestcaserunStarted {
    #[serde(rename="trigger", skip_serializing_if = "Option::is_none")]
    pub trigger: Option<Box<crate::Trigger>>,
    #[serde(rename="environment")]
    pub environment: serde_json::Value,
    #[serde(rename="testSuiteRun", skip_serializing_if = "Option::is_none")]
    pub test_suite_run: Option<serde_json::Value>,
    #[serde(rename="testCase", skip_serializing_if = "Option::is_none")]
    pub test_case: Option<Box<crate::Testcase>>,
}
