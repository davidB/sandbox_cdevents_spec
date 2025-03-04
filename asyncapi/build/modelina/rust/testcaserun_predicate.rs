// TestcaserunPredicate represents a union of types: TestcaserunStarted
#[derive(Clone, Debug, Deserialize, Eq, Hash, Ord, PartialEq, PartialOrd, Serialize)]
#[serde(tag = "kind")]
pub enum TestcaserunPredicate {
    #[serde(rename="TestcaserunStarted")]
    TestcaserunStarted(crate::TestcaserunStarted),
}

