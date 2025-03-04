# Context



## Properties

<details><summary><strong>version</strong></summary>

* Type: [`Version`](Version.md)
* Description: 
* Constraints: ?
* Examples: 
  * ```json
    "0.4.0"
    ```

  * ```json
    "0.5.0-draft"
    ```



</details>
<details><summary><strong>id</strong></summary>

* Type: [`Id`](Id.md)
* Description: 
* Constraints: ?
* Examples: 
  * ```json
    "tenant1/12345-abcde"
    ```



</details>
<details><summary><strong>source</strong></summary>

* Type: [`Source`](Source.md)
* Description: 
* Constraints: ?
* Examples: 
  * ```json
    "/tekton"
    ```

  * ```json
    "https://www.jenkins.io/"
    ```

  * ```json
    "/cloud1/spinnaker-A"
    ```

  * ```json
    "/cluster2/keptn-A"
    ```

  * ```json
    "/teamX/knative-1"
    ```



</details>
<details><summary><strong>timestamp</strong></summary>

* Type: [`Timestamp`](Timestamp.md)
* Description: Scalar string in the format specified in [RFC 3339](https://datatracker.ietf.org/doc/html/rfc3339)
* Constraints: ?
* Examples: *No examples*

</details>
<details><summary><strong>schemaUri</strong></summary>

* Type: string
* Description: 
* Constraints: ?
* Examples: *No examples*

</details>
<details><summary><strong>chainId</strong></summary>

* Type: string
* Description: 
* Constraints: ?
* Examples: *No examples*

</details>

## Examples


* ```json
  {
    "version": "0.5.0-draft",
    "id": "A234-1234-1234",
    "source": "/staging/tekton/",
    "timestamp": "2018-04-05T17:31:00Z",
    "schemaUri": "https://myorg.com/cdevents/schema/taskrun-started-1-1-0"
  }
  ```




