# CDEvent

CDEvents is a common specification for Continuous Delivery events.

An "event" is a data record expressing an occurrence and its context. Events are
routed from an event producer (the source) to interested event consumers. The
routing can be performed based on information contained in the event, but an
event will not identify a specific routing destination.

## Properties

<details><summary><strong>context</strong></summary>

* Type: [`Context`](Context.md)
* Description: 
* Constraints: ?
* Examples: 
  * ```json
    {
      "version": "0.5.0-draft",
      "id": "A234-1234-1234",
      "source": "/staging/tekton/",
      "timestamp": "2018-04-05T17:31:00Z",
      "schemaUri": "https://myorg.com/cdevents/schema/taskrun-started-1-1-0"
    }
    ```



</details>
<details><summary><strong>subject</strong></summary>

* Type: [`Subject`](Subject.md)
* Description: 
* Constraints: ?
* Examples: *No examples*

</details>
<details><summary><strong>customDataContentType</strong></summary>

* Type: [`CustomDataContentType`](CustomDataContentType.md)
* Description: Content type of `customData` value. This attribute enables data
  to carry any type of content, whereby format and encoding might differ from
  that of the chosen event format. For example, an event rendered using the
  [CloudEvents](cloudevents-binding.md) format might carry an XML payload in
  data, and the consumer is informed by this attribute being set to
  "application/xml". The rules for how data content is rendered for different
  `customDataContentType` values are defined in the specific binding
  specification
* Constraints: ?
* Examples: 
  * Default:
    ```json
    "application/json"
    ```

  * ```json
    "application/xml"
    ```



</details>


