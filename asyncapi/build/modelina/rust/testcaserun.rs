// Testcaserun represents a Testcaserun model.
#[derive(Clone, Debug, Deserialize, Eq, Hash, Ord, PartialEq, PartialOrd, Serialize)]
pub struct Testcaserun {
    #[serde(rename="predicate", skip_serializing_if = "Option::is_none")]
    pub predicate: Option<Box<crate::TestcaserunPredicate>>,
}
