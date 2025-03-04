// ArtifactPublished represents a ArtifactPublished model.
#[derive(Clone, Debug, Deserialize, Eq, Hash, Ord, PartialEq, PartialOrd, Serialize)]
pub struct ArtifactPublished {
    #[serde(rename="kind")]
    pub kind: String,
}
