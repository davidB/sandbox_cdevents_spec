// CdEvent represents a CdEvent model.
#[derive(Clone, Debug, Deserialize, Eq, Hash, Ord, PartialEq, PartialOrd, Serialize)]
pub struct CdEvent {
    #[serde(rename="context")]
    pub context: Box<crate::Context>,
    #[serde(rename="subject")]
    pub subject: Box<crate::Subject>,
    #[serde(rename="customDataContentType", skip_serializing_if = "Option::is_none")]
    pub custom_data_content_type: Option<String>,
}
