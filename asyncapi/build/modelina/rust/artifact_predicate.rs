// ArtifactPredicate represents a union of types: ArtifactPublished, ArtifactDeleted
#[derive(Clone, Debug, Deserialize, Eq, Hash, Ord, PartialEq, PartialOrd, Serialize)]
#[serde(tag = "kind")]
pub enum ArtifactPredicate {
    #[serde(rename="ArtifactPublished")]
    ArtifactPublished(crate::ArtifactPublished),
    #[serde(rename="ArtifactDeleted")]
    ArtifactDeleted(crate::ArtifactDeleted),
}

