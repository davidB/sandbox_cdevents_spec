// Context represents a Context model.
#[derive(Clone, Debug, Deserialize, Eq, Hash, Ord, PartialEq, PartialOrd, Serialize)]
pub struct Context {
    #[serde(rename="version")]
    pub version: String,
    #[serde(rename="id")]
    pub id: String,
    #[serde(rename="source")]
    pub source: String,
    #[serde(rename="timestamp")]
    pub timestamp: String,
    #[serde(rename="schemaUri", skip_serializing_if = "Option::is_none")]
    pub schema_uri: Option<String>,
    #[serde(rename="chainId", skip_serializing_if = "Option::is_none")]
    pub chain_id: Option<String>,
}
