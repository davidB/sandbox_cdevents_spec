# CustomDataContentType

Content type of `customData` value. This attribute enables data
to carry any type of content, whereby format and encoding might differ from
that of the chosen event format. For example, an event rendered using the
[CloudEvents](cloudevents-binding.md) format might carry an XML payload in
data, and the consumer is informed by this attribute being set to
"application/xml". The rules for how data content is rendered for different
`customDataContentType` values are defined in the specific binding
specification

## Examples


* Default:
  ```json
  "application/json"
  ```

* ```json
  "application/xml"
  ```




