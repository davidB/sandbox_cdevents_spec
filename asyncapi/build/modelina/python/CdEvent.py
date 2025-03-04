from __future__ import annotations
from typing import Any, Dict
from . import Context
from . import Artifact
from . import Taskrun
from . import Testcaserun
class CdEvent: 
  def __init__(self, input: Dict):
    self._context: Context.Context = Context.Context(input['context'])
    self._subject: Artifact.Artifact | Taskrun.Taskrun | Testcaserun.Testcaserun = input['subject']
    if 'custom_data_content_type' in input:
      self._custom_data_content_type: str = input['custom_data_content_type']

  @property
  def context(self) -> Context.Context:
    return self._context
  @context.setter
  def context(self, context: Context.Context):
    self._context = context

  @property
  def subject(self) -> Artifact.Artifact | Taskrun.Taskrun | Testcaserun.Testcaserun:
    return self._subject
  @subject.setter
  def subject(self, subject: Artifact.Artifact | Taskrun.Taskrun | Testcaserun.Testcaserun):
    self._subject = subject

  @property
  def custom_data_content_type(self) -> str:
    return self._custom_data_content_type
  @custom_data_content_type.setter
  def custom_data_content_type(self, custom_data_content_type: str):
    self._custom_data_content_type = custom_data_content_type
