from __future__ import annotations
from typing import Any, Dict, Optional, Union
from pydantic import BaseModel, Field
from . import TestcaseKind
class Testcase(BaseModel): 
  id: Any = Field()
  version: Optional[str] = Field(default=None)
  name: Optional[str] = Field(default=None)
  kind: Optional[TestcaseKind.TestcaseKind] = Field(default=None)
  uri: Optional[Any] = Field(default=None)
