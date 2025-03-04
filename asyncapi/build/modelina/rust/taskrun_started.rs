// TaskrunStarted represents a TaskrunStarted model.
#[derive(Clone, Debug, Deserialize, Serialize)]
pub struct TaskrunStarted {
    #[serde(rename="taskName", skip_serializing_if = "Option::is_none")]
    pub task_name: Option<String>,
    #[serde(rename="uri", skip_serializing_if = "Option::is_none")]
    pub uri: Option<serde_json::Value>,
    #[serde(rename="pipelineRun", skip_serializing_if = "Option::is_none")]
    pub pipeline_run: Option<serde_json::Value>,
}
