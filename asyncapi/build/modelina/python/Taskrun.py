from __future__ import annotations
from typing import Any, Dict, Optional, Union
from pydantic import BaseModel, Field
from . import TaskrunStarted
class Taskrun(BaseModel): 
  predicate: Optional[Union[TaskrunStarted.TaskrunStarted]] = Field(default=None)
