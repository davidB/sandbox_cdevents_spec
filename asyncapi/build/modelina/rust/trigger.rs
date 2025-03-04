// Trigger represents a Trigger model.
#[derive(Clone, Debug, Deserialize, Serialize)]
pub struct Trigger {
    #[serde(rename="kind", skip_serializing_if = "Option::is_none")]
    pub kind: Option<Box<crate::TriggerKind>>,
    #[serde(rename="uri", skip_serializing_if = "Option::is_none")]
    pub uri: Option<serde_json::Value>,
    #[serde(rename="additionalProperties", skip_serializing_if = "Option::is_none")]
    pub additional_properties: Option<std::collections::HashMap<String, serde_json::Value>>,
}
