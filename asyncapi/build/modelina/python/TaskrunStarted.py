from __future__ import annotations
from typing import Any, Dict

class TaskrunStarted: 
  def __init__(self, input: Dict):
    if 'task_name' in input:
      self._task_name: str = input['task_name']
    if 'uri' in input:
      self._uri: Any = input['uri']
    if 'pipeline_run' in input:
      self._pipeline_run: Any = input['pipeline_run']

  @property
  def task_name(self) -> str:
    return self._task_name
  @task_name.setter
  def task_name(self, task_name: str):
    self._task_name = task_name

  @property
  def uri(self) -> Any:
    return self._uri
  @uri.setter
  def uri(self, uri: Any):
    self._uri = uri

  @property
  def pipeline_run(self) -> Any:
    return self._pipeline_run
  @pipeline_run.setter
  def pipeline_run(self, pipeline_run: Any):
    self._pipeline_run = pipeline_run
