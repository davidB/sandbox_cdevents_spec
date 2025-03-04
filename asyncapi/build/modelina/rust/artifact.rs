// Artifact represents a Artifact model.
#[derive(Clone, Debug, Deserialize, Eq, Hash, Ord, PartialEq, PartialOrd, Serialize)]
pub struct Artifact {
    #[serde(rename="predicate", skip_serializing_if = "Option::is_none")]
    pub predicate: Option<Box<crate::ArtifactPredicate>>,
}
