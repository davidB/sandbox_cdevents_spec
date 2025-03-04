// ArtifactDeleted represents a ArtifactDeleted model.
#[derive(Clone, Debug, Deserialize, Eq, Hash, Ord, PartialEq, PartialOrd, Serialize)]
pub struct ArtifactDeleted {
    #[serde(rename="user", skip_serializing_if = "Option::is_none")]
    pub user: Option<String>,
}
