from __future__ import annotations
from typing import Any, Dict, Optional, Union
from pydantic import BaseModel, Field
from . import Context
from . import Artifact
from . import Taskrun
from . import Testcaserun
class CdEvent(BaseModel): 
  context: Context.Context = Field()
  subject: Union[Artifact.Artifact, Taskrun.Taskrun, Testcaserun.Testcaserun] = Field()
  custom_data_content_type: Optional[str] = Field(description='''Content type of `customData` value. This attribute enables data
  to carry any type of content, whereby format and encoding might differ from
  that of the chosen event format. For example, an event rendered using the
  [CloudEvents](cloudevents-binding.md) format might carry an XML payload in
  data, and the consumer is informed by this attribute being set to
  "application/xml". The rules for how data content is rendered for different
  `customDataContentType` values are defined in the specific binding
  specification
  ''', default=None)
