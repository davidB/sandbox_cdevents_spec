// ArtifactPredicate represents a union of types: serde_json::Value, ArtifactDeleted
#[derive(Clone, Debug, Deserialize, Serialize)]
#[serde(tag = "kind")]
pub enum ArtifactPredicate {
    #[serde(rename="ArtifactPublished")]
    ArtifactPublished(serde_json::Value),
    #[serde(rename="ArtifactDeleted")]
    ArtifactDeleted(crate::ArtifactDeleted),
}

