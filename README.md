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

## Exploration's remarks

### Json Schema

- every spec ends with a `schema.json`
- root as `cdevent.schema.json`
- one file per type
- use oneOf for polymorphism (but no discriminator as not supported by json schema)
- use `const` for constant values (like `enum` with a single value)

### OpenAPI

- use [Taskfile](https://taskfile.dev/) to run actions (validate, codegen, docgen,...)
- use OpenAPI 3.0 (supported by more tools)
  - In 3.0, Models are extended on json schema draft-07
  - In 3.1, Models are extended on json schema 2020-12
- use yaml format (less verbose than json, simpler for multi-line strings)
- create a root `api.yaml` file without `path`, we focus on the `components` part (the models)
- use of discriminator for subject/predicate
- use `x-const` for constant values (like `const` in json schema) instead of `enum` with a single value
- use `subject.type` to discriminate subjects and use the type of the event (aka `dev.events.{subject}.{predicate}`)
  - Maybe to replace by the name of the component (that will simplify the code generation, no mapping needed)
- OpenAPI ecosystem provide lot of codegenerator, we will focus on few that allow to use our own templates (and maybe extensions)
  - [ ] [openapi-generator](https://openapi-generator.tech/)
  - [ ] [swagger-codegen](https://github.com/swagger-api/swagger-codegen)
  - [ ] [schematools](https://github.com/kstasik/schema-tools)
  - comparison: [OpenAPI Generator vs Swagger Codegen v3: Which API Generator Is Best for Your Needs? - Engineer From Nepal](https://engineerfromnepal.com/blog/openapi-generator-vs-swagger-codegen-v3/), [FAQ: General | OpenAPI Generator](https://openapi-generator.tech/docs/faq/)
