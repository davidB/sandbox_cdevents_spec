from __future__ import annotations
from typing import Any, Dict, Optional, Union
from pydantic import BaseModel, Field
from . import Trigger
from . import Testcase
class TestcaserunStarted(BaseModel): 
  trigger: Optional[Trigger.Trigger] = Field(default=None)
  environment: Any = Field()
  test_suite_run: Optional[Any] = Field(default=None)
  test_case: Optional[Testcase.Testcase] = Field(default=None)
