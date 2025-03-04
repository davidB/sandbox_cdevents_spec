from __future__ import annotations
from typing import Any, Dict, Optional, Union
from pydantic import BaseModel, Field
from . import TestcaserunStarted
class Testcaserun(BaseModel): 
  predicate: Optional[Union[TestcaserunStarted.TestcaserunStarted]] = Field(default=None)
