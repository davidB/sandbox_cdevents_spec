# sandbox_cdevents_spec

Experiments with the [cdevents spec](https://github.com/cdevents/spec) to use an other format for specification of the events.
And to generate documentation and SDK's models from the spec.

To have a relevent example, the experiment provide the 3 events (`{subject}.{predicate}`) (2 on the same subject):

- `artifact.published`
- `artifact.deleted` (to have 2 on the same subject)
- `taskrun.started`
- (optional) `testcaserun.started` (to have 2 on the same predicate)

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
- generation of cli/server for conformance/contract test ?

## Exploration's remarks

### Json Schema

- every spec ends with a `schema.json`
- root as `cdevent.schema.json`
- one file per type
- use oneOf for polymorphism (but no discriminator as not supported by json schema)
- use `const` for constant values (like `enum` with a single value)
- try to use:
  - [x] <https://quicktype.io/>
    - doesn't support json schema 2020-12 (try to switch to draft 07 & 06)
  - [ ] [schematools](https://github.com/kstasik/schema-tools)
    - see also the OpenAPI section
    - TODO try with "discriminator" (no in the spec, but could be managed by the tool)

### OpenAPI

- use [Taskfile](https://taskfile.dev/) to run actions (validate, codegen, docgen,...)
- try to [OpenAPI 3.1](https://spec.openapis.org/oas/v3.1.0.html#schema-object) (support in alpha/beta by most of the tools)
  - In 3.0,
    - models are extended on json schema draft-07
  - In 3.1,
    - models are extended on json schema 2020-12
    - allow siblings info to $ref (like override of description)
    - allow const? (part of json schema 2020-12)
- use yaml format (less verbose than json, simpler for multi-line strings)
- create a root `api.yaml` file without `path`, we focus on the `components` part (the models)
- use of discriminator for subject/predicate
- 2 approaches for the models:
  - `v4m` try to match v0.4.0 of spec (see [comments in cdevent.yaml.disable](openapi/spec/v4m/cdevent.yaml.disable))
  - `v6` more freedom on the model (see [comments in cdevent.yaml](openapi/spec/v6/cdevent.yaml))
- OpenAPI ecosystem provide lot of codegenerator (see [OpenAPI.Tools - an Open Source list of great tools for OpenAPI.](https://openapi.tools/#sdk)), we will focus on few that allow to use our own templates (and maybe extensions)
  - [x] [openapi-generator](https://openapi-generator.tech/)
    - java based
    - lot of templates, lot of contributors over time,
    - documentations, examples & some articles (like [OpenAPI Custom Generator | Baeldung](https://www.baeldung.com/java-openapi-custom-generator))
    - options to use templates but the template engine is logicless (logic => create a generator in java :-( )
    - internal datamodel used by templates depend on the generator and should prepare/expose logic (isXxx)
    - currently the one, I spent the most time on
  - [x] ~~[swagger-codegen](https://github.com/swagger-api/swagger-codegen)~~
    - openapi-generator is based on swagger-codegen, fork mainly due to ownership company vs community
  - [ ] [schematools](https://github.com/kstasik/schema-tools)
    - from rust ecosystem (not listed on OpenAPI.Tools)
    - I like the approach (vs openapi-generator)
    - early/ young project
    - more powerful template engine (tera, based on jinja2, with more buitin functions than mustache or handlebars)
    - buggy (not able to validate my spec but able to process it)
    - I don't know how to use generate multiple files in some cases (eg. 1 file per type)
    - The internal model used by template doesn't expose all the information (title, ...)
    - Dereference looks a good idea but not to generate models, because it's not just an include and we lost title and additional info injected by our layout
  - [ ] [Generator | AsyncAPI Initiative for event-driven APIs](https://www.asyncapi.com/tools/generator)
    - javascript
    - template packaged as npm package
    - generate a full "client" (for messaging system)
  - [ ] [Modelina | AsyncAPI Initiative for event-driven APIs](https://www.asyncapi.com/tools/modelina)
    - javascript
    - templating ?
  - comparaison: [OpenAPI Generator vs Swagger Codegen v3: Which API Generator Is Best for Your Needs? - Engineer From Nepal](https://engineerfromnepal.com/blog/openapi-generator-vs-swagger-codegen-v3/), [FAQ: General | OpenAPI Generator](https://openapi-generator.tech/docs/faq/)

### Smithy

[Smithy](https://smithy.io/2.0/index.html) is designed to create API for Resources oriented API (ala REST): resources definition and associated operations / lifecycles.

- smithy is used by AWS to generate AWS SDKs
- 2.0 is young and a lot of plugins(code generator) are "work in progress" (see [smithy-lang/awesome-smithy: Awesome Smithy is a curated list of awesome build-tools, code-generators, examples, and other resources related to the Smithy IDL.](https://github.com/smithy-lang/awesome-smithy#client-code-generators))
  - repositories (plugins, ...) with a lot of contributors & activity (see <https://github.com/smithy-lang>)
  - plugins are coded in kotlin, java
  - some plugins are "intimidating" (layout, number of files, "complexity", etc.)
  - some plugins are not yet published on maven central (see <https://repo.maven.apache.org/maven2/software/amazon/smithy/>) but already documented to be published (e.g. go, python, rust), in fact they are used locally to generate the AWS SDKs
- useful traits (annotations) and way to define models
- I didn't find how to only generate payload (data model) without all the service, operations, ... (except by extracting/copying the model from the generated code)
- No "clear" control on the json representation of the model as it depends on the plugin & protocol

### Conclusion & feelings (temporary)

- no ready to use generator (yet) with zero configuration for Markdown, Java, Python, Rust, Go, ...
- generated code is only a part of the SDK or spec'documentation
- generating samples from the spec will require a dedicated tool and template (like [Schemathesis](https://schemathesis.readthedocs.io/en/stable/) or [Specmatic](https://specmatic.io/)) based on examples or random data (like in property-based testing) based on one 1 SDK
- having a single entrypoint in spec (json schema maybe extracted from the spec) will make validation of examples, or message simpler for non-SDK users
- TODO? custom (homemade) generator with minimal logic in the "generator" and more logic in the "template" (ala schematools)
- TODO? invest more time (contribution?) in some of the tools (openapi-generator, schematools, codegen, modelina)
- TODO? change the spec to be more like in programming languages
- TODO? review all events => normalize, remove duplication, add missing fields, etc.
- TODO? complementary linter to validate rules over the spec (naming convention, use of $ref, etc.): pkl, cuelang, opa... ?
- should SDK includes integration with CloudEvents, http frameworks, etc.?

## Dev & Build

- Use [mise (mise-en-place)](https://mise.jdx.dev/) to setup tools (java, task, ...)
- Use [Taskfile](https://taskfile.dev/) to run actions (validate, codegen, docgen,...), installed by mise

```sh
❯ mise install
❯ cd openapi
❯ task --list
task: Available tasks for this project:
* codegen:                     Generate code from the spec (all languages)
* openapi-generator-cli:       allow to call openapi-generator-cli directly by passing arguments after `--` (eg. `task openapi-generator-cli -- help`)
* schematools-cli:             allow to call schematools directly by passing arguments after `--` (eg. `task schematools-cli -- --help`)
* validate:                    Validate the spec
* codegen:go:                  Generate code from the spec (go)
* codegen:java:                Generate code from the spec (java)
* codegen:markdown:            Generate code from the spec (markdown) <-- documentation
* codegen:python:              Generate code from the spec (python)
* codegen:rust:                Generate code from the spec (rust)
```
