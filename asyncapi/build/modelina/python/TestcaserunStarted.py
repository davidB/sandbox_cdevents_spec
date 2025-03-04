from __future__ import annotations
from typing import Any, Dict
from . import Trigger
from . import Testcase
class TestcaserunStarted: 
  def __init__(self, input: Dict):
    if 'trigger' in input:
      self._trigger: Trigger.Trigger = Trigger.Trigger(input['trigger'])
    self._environment: Any = input['environment']
    if 'test_suite_run' in input:
      self._test_suite_run: Any = input['test_suite_run']
    if 'test_case' in input:
      self._test_case: Testcase.Testcase = Testcase.Testcase(input['test_case'])

  @property
  def trigger(self) -> Trigger.Trigger:
    return self._trigger
  @trigger.setter
  def trigger(self, trigger: Trigger.Trigger):
    self._trigger = trigger

  @property
  def environment(self) -> Any:
    return self._environment
  @environment.setter
  def environment(self, environment: Any):
    self._environment = environment

  @property
  def test_suite_run(self) -> Any:
    return self._test_suite_run
  @test_suite_run.setter
  def test_suite_run(self, test_suite_run: Any):
    self._test_suite_run = test_suite_run

  @property
  def test_case(self) -> Testcase.Testcase:
    return self._test_case
  @test_case.setter
  def test_case(self, test_case: Testcase.Testcase):
    self._test_case = test_case
