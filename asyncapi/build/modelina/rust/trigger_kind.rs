// TriggerKind represents a TriggerKind model.
#[derive(Clone, Copy, Debug, Deserialize, Eq, Hash, Ord, PartialEq, PartialOrd, Serialize)]
pub enum TriggerKind {
    #[serde(rename="manual")]
    Manual,
    #[serde(rename="pipeline")]
    Pipeline,
    #[serde(rename="event")]
    Event,
    #[serde(rename="schedule")]
    Schedule,
    #[serde(rename="other")]
    Other,
}
