// Testcase represents a Testcase model.
#[derive(Clone, Debug, Deserialize, Serialize)]
pub struct Testcase {
    #[serde(rename="id")]
    pub id: serde_json::Value,
    #[serde(rename="version", skip_serializing_if = "Option::is_none")]
    pub version: Option<String>,
    #[serde(rename="name", skip_serializing_if = "Option::is_none")]
    pub name: Option<String>,
    #[serde(rename="kind", skip_serializing_if = "Option::is_none")]
    pub kind: Option<Box<crate::TestcaseKind>>,
    #[serde(rename="uri", skip_serializing_if = "Option::is_none")]
    pub uri: Option<serde_json::Value>,
}
