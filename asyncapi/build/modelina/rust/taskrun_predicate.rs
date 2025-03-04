// TaskrunPredicate represents a union of types: TaskrunStarted
#[derive(Clone, Debug, Deserialize, Eq, Hash, Ord, PartialEq, PartialOrd, Serialize)]
#[serde(tag = "kind")]
pub enum TaskrunPredicate {
    #[serde(rename="TaskrunStarted")]
    TaskrunStarted(crate::TaskrunStarted),
}

