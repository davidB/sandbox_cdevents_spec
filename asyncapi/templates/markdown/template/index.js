import { File, Text } from "@asyncapi/generator-react-sdk";
import { Schema } from "../components/Schema";
//import { Schema } from "@asyncapi/modelina";
// import { List } from "@asyncapi/markdown-template";

export default function ({ asyncapi, params, originalAsyncAPI }) {
  const files = [];
  files.push(
    <File name="asyncapi.md">
      <Text># sample H1</Text>

      <>
        My application's markdown file.
        {`## sample H2
          list:
          - item1
          - item2
          `}
      </>
      {/* <List list={["item1", "item2"]} /> */}
      <Text>App name: **{asyncapi.info().title()}**</Text>
    </File>
  );

  // use modelina (see models.js)

  const schemas = asyncapi.allSchemas();
  const schemasById = new Map();
  // schemas is an instance of the Map
  schemas.forEach((schema) => {
    schemasById.set(schema.id(), schema);
  });
  // document in a predefined order
  // - cdevents.md
  //   - CDEvents
  //   - direct children of CDEvents
  //   - common primitives (Uri, DateTime, etc)
  //   - table of stage
  // - <stage>.md
  //   - Artifact
  //     - predicates of Artifact
  files.push(
    <File name={"main.md"}>
      <Schema schema={schemasById.get("CDEvent")} />
    </File>
  );
  // schemasById.forEach((schema, id) => {
  //   console.log(id);
  //   files.push(
  //     // We return a react file component and each time we do it, he name of the generated file will be a schema name
  //     // Content of the file will be a variable representing schema
  //     <File name={`${schema.id()}.js`}>
  //       const {schema.id()} = {JSON.stringify(schema._json, null, 2)}
  //       name: {schema.name}
  //       title: {schema.title()}
  //     </File>
  //   );
  // });
  // description: {schema.description()}
  // type: {schema.type()}
  // format: {schema.format()}
  // default: {schema.default()}
  // enum: {schema.enum()}
  // items: {schema.items()}
  // properties: {schema.properties()}
  return files;
}
