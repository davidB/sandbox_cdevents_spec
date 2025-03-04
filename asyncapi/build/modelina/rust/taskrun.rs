// Taskrun represents a Taskrun model.
#[derive(Clone, Debug, Deserialize, Eq, Hash, Ord, PartialEq, PartialOrd, Serialize)]
pub struct Taskrun {
    #[serde(rename="predicate", skip_serializing_if = "Option::is_none")]
    pub predicate: Option<Box<crate::TaskrunPredicate>>,
}
