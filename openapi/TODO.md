# TODO

## For exploration

- [ ] integrate `description` into apidoc
- [ ] integrate `examples` into apidoc
- [ ] preserve newline from description when injected into api comments, markdown,...
- [x] custom rust generation with tagged unions `#[serde(tag = "type")]`
- [ ] validate scalars generation (date-time, non-empty string, purl, uri-reference)
- [ ] create a type for each scalars
- [ ] custom markdown generation near to what is existing in the spec
- [ ] try java & python generation (no custom)
- [ ] add build+test to validate deserialization+serialization
- [ ] generate samples (from examples, random data)

## If accepted

- [ ] add a linter to check the [rules](RULES.md) on the spec (using cuelang pkl ?)
- [ ] fully rewrite SDK ? (one by one, rust, python, go java) at least one to validate the flow
- [ ] make PR(s) on spec (with documentation update: spec, md, site, primer, ...)
- [ ] document the flow to create and to update a SDK