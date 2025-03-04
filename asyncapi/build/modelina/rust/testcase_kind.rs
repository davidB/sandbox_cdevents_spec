// TestcaseKind represents a TestcaseKind model.
#[derive(Clone, Copy, Debug, Deserialize, Eq, Hash, Ord, PartialEq, PartialOrd, Serialize)]
pub enum TestcaseKind {
    #[serde(rename="performance")]
    Performance,
    #[serde(rename="functional")]
    Functional,
    #[serde(rename="unit")]
    Unit,
    #[serde(rename="security")]
    Security,
    #[serde(rename="compliance")]
    Compliance,
    #[serde(rename="integration")]
    Integration,
    #[serde(rename="e2e")]
    E2e,
    #[serde(rename="other")]
    Other,
}
