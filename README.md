# sandbox_cdevents_spec

Experiments with the [cdevents spec](https://github.com/cdevents/spec) to use an other format for specification of the events.
And to generate documentation and SDK's models from the spec.

To have a relevent example, the experiment provide the 3 events (`{subject}.{predicate}`) (2 on the same subject):

- `artifact.published`
- `artifact.deleted`
- `taskrun.started`

## Links

- [cdevents spec](https://github.com/cdevents/spec)
- [Friendly schema/spec for code generator (breaking change) · cdevents/spec · Discussion #240](https://github.com/cdevents/spec/discussions/240)
- [Modeling language considerations for SDKs · Issue #5 · cdevents/implementation-wg](https://github.com/cdevents/implementation-wg/issues/5)

## Features to Explore, to try

- specification store on several files
- code generation:
  - polymorphism for subject/predicate
  - typed scalars (aka "string" with format)
    - date-time
    - non-empty string
    - purl
    - uri-reference
  - test, validation (runtime)
  - description => api documentation
  - example(s) => api documentation
  - example(s) => tests (unit test or doctest)
- doc: markdown
  - description
  - example(s)
- possible customization of templates/generation
- generate only models
- generation of cli/server for conformance/contract test
