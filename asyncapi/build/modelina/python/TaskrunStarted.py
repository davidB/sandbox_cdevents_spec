from __future__ import annotations
from typing import Any, Dict, Optional, Union
from pydantic import BaseModel, Field

class TaskrunStarted(BaseModel): 
  task_name: Optional[str] = Field(default=None)
  uri: Optional[Any] = Field(default=None)
  pipeline_run: Optional[Any] = Field(default=None)
