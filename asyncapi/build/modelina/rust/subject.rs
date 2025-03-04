// Subject represents a union of types: Artifact, Taskrun, Testcaserun
#[derive(Clone, Debug, Deserialize, Eq, Hash, Ord, PartialEq, PartialOrd, Serialize)]
#[serde(tag = "kind")]
pub enum Subject {
    #[serde(rename="Artifact")]
    Artifact(crate::Artifact),
    #[serde(rename="Taskrun")]
    Taskrun(crate::Taskrun),
    #[serde(rename="Testcaserun")]
    Testcaserun(crate::Testcaserun),
}

