import { File, Text } from "@asyncapi/generator-react-sdk";
import {
  Schema,
  extractCustomTypeName,
  pathOfCustomType,
} from "../components/Schema";
//import { Schema } from "@asyncapi/modelina";
// import { List } from "@asyncapi/markdown-template";

export default function ({ asyncapi, params, originalAsyncAPI }) {
  try {
    const files = [];
    files.push(
      <File name="asyncapi.md">
        <Text># sample H1</Text>
        <Text newLines={2} indentation={2}>
          {`
          My application's markdown raw text.
          ## sample H2
          list:
          - item1
          - item2
          `}
        </Text>
        {/* <Text>----</Text> */}
        <>
          My application's markdown file.
          {`## sample H2
          list:
          - item1
          - item2
          `}
        </>
        {/* <List list={["item1", "item2"]} /> */}
        <Text indentation={1}>App name: **{asyncapi.info().title()}**</Text>
      </File>
    );

    // use modelina (see models.js)

    const schemas = asyncapi.allSchemas();
    const schemasById = new Map();
    // schemas is an instance of the Map
    schemas.forEach((schema) => {
      const customType = extractCustomTypeName(schema);
      if (customType) {
        schemasById.set(customType, schema);
      }
    });

    // console.log(">>>>>>>>>>>>>>>> schemasById");
    // console.log(schemasById.size);
    // for (const id of schemasById.keys()) {
    //   console.log(id);
    // }

    // TODO:
    // document in a predefined order
    // - cdevents.md
    //   - CDEvents
    //   - direct children of CDEvents
    //   - common primitives (Uri, DateTime, etc)
    //   - table of stage
    // - <stage>.md
    //   - Artifact
    //     - predicates of Artifact
    // In this case, how identifying the files name (and link) from just the TypeName?
    // Alternatives: 1 files per schema (ala apidoc) + 1 overview file (manual or generated)
    // files.push(
    //   <File name={"main.md"}>
    //     <Schema schema={schemasById.get("CDEvent")} />
    //   </File>
    // );
    schemasById.forEach((schema, id) => {
      console.log(id);
      // files.push(
      //   // We return a react file component and each time we do it, he name of the generated file will be a schema name
      //   // Content of the file will be a variable representing schema
      //   <File name={`${schema.id()}.js`}>
      //     const {schema.id()} = {JSON.stringify(schema._json, null, 2)}
      //     name: {schema.name}
      //     title: {schema.title()}
      //   </File>
      // );
      files.push(
        <File name={pathOfCustomType(id)}>
          <Schema schema={schema} />
        </File>
      );
    });
    // description: {schema.description()}
    // type: {schema.type()}
    // format: {schema.format()}
    // default: {schema.default()}
    // enum: {schema.enum()}
    // items: {schema.items()}
    // properties: {schema.properties()}
    return files;
  } catch (e) {
    console.error(e);
    throw e;
  }
}
