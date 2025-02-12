//copy from https://github.com/asyncapi/markdown-template/blob/master/components/Schema.js
import { Text } from "@asyncapi/generator-react-sdk";

import { CodeBlock, Expandable, Header, ListItem } from "./common";

// eslint-disable-next-line no-unused-vars
import { SchemaInterface } from "@asyncapi/parser";

/**
 * @param {{schema: SchemaInterface}} param0
 */
export function Schema({ schema, headerBaseLevel = 1 }) {
  return (
    <Text>
      <Header type={headerBaseLevel}>{extractTypeName(schema)}</Header>
      <Text newLines={2}>{extractDescription(schema)}</Text>

      <SchemaPropertiesSection
        schema={schema}
        headerBaseLevel={headerBaseLevel + 1}
      />
      <SchemaExamplesSection
        schema={schema}
        headerBaseLevel={headerBaseLevel + 1}
      />
    </Text>
  );
}

/**
 * Display the properties
 * @param {{schema: SchemaInterface, headerBaseLevel: number}} param0
 */
function SchemaPropertiesSection({ schema, headerBaseLevel = 1 }) {
  if (schema.type() != "object") {
    return;
  }
  return (
    <Text>
      <Header type={headerBaseLevel}>Properties</Header>
      {Object.entries(schema.properties()).map((property) => {
        //console.log(property[0]); // propertyName
        //console.log(property[1]); // propertySchema
        return <SchemaPropertyItem schema={property[1]} name={property[0]} />;
      })}
    </Text>
  );
}

/**
 * Display the a single property definition
 * @param {{schema: SchemaInterface, name: string, indentation: number}} param0
 */
function SchemaPropertyItem({ schema, name, indentation = 0 }) {
  return (
    <Expandable title={`<strong>${name}</strong>`} indentation={indentation}>
      <Text />
      <ListItem>Type: {extractTypeName(schema)}</ListItem>
      <ListItem>Description: {extractDescription(schema)}</ListItem>
      <ListItem>Constraints: ?</ListItem>
      <ListItem>
        Examples: <SchemaExamplesList schema={schema} />
      </ListItem>
    </Expandable>
  );
}

/**
 * Display the examples
 * Could be used a subpart of schema or properties.
 * @param {{schema: SchemaInterface, name: string, indentation: number}} param0
 */

function SchemaExamplesSection({ schema, headerBaseLevel = 1 }) {
  if (!schema.examples() && !schema.default()) {
    return;
  }
  return (
    <Text>
      <Header type={headerBaseLevel}>Examples</Header>
      <SchemaExamplesList schema={schema} />
    </Text>
  );
}

/**
 * Display the examples
 * Could be used a subpart of schema or properties.
 * @param {{schema: SchemaInterface, name: string, indentation: number}} param0
 */
// TODO add a way to display description of each example (via extension ?)
function SchemaExamplesList({ schema, indentation = 0 }) {
  if (!schema.examples() && !schema.default()) {
    return <Text indentation={indentation}>*No examples*</Text>;
  }
  return (
    <Text indentation={indentation}>
      {"\n"}
      {schema.default() ? (
        <ListItem>
          Default:
          <CodeBlock>{JSON.stringify(schema.default(), null, 2)}</CodeBlock>
        </ListItem>
      ) : (
        ""
      )}
      {schema.examples().map((example) => (
        <ListItem>
          <CodeBlock>{JSON.stringify(example, null, 2)}</CodeBlock>
        </ListItem>
      ))}
    </Text>
  );
}
/**
 * @param {SchemaInterface} schema
 */
function extractDescription(schema, asSummary = false) {
  let description = schema.description() || "";
  if (asSummary) {
    description = description.split("\n")[0].split(".")[0]; // first line/sentence
    // } else {
    //   description = description.replace(new RegExp("S*\r?\n", "g"), " ");
  }
  description = description.trim();
  const externalDocs = schema.externalDocs();
  // eslint-disable-next-line sonarjs/no-nested-template-literals
  description = externalDocs
    ? `${!description.endsWith(".") ? `${description}.` : description} [${
        externalDocs.description() || "Documentation"
      }](${externalDocs.url()})`
    : description;
  description = description.trim();
  return description;
}

/**
 * @param {SchemaInterface} schema
 */
function extractTypeName(schema) {
  const customType = extractCustomTypeName(schema);
  if (customType) {
    return customType;
  }
  const type = schema.type();
  if (type === "array") {
    return `${extractTypeName(schema.items())}[]`;
  }
  return type;
}

/**
 * @param {SchemaInterface} schema
 * @returns {string|null}
 */
export function extractCustomTypeName(schema) {
  const name = schema.$id() || schema.id() || schema.title();
  if (name.startsWith("<anonymous")) {
    return null;
  }
  return name;
}

// /**
//  * Recusrively extracts all customTypes from the schema.
//  * @param {SchemaInterface} schema
//  * @param {Array<[string, SchemaInterface]>} customTypes
//  * @returns {Array<[string, SchemaInterface]>} customTypes
//  */
// export function listCustomTypes(schema, customTypes = Array()) {
//   const customTypeName = extractCustomTypeName(schema);
//   if (
//     customTypeName &&
//     !customTypes.find(([name]) => name === customTypeName)
//   ) {
//     customTypes.push([customTypeName, schema]);
//   }
//   if (schema.type() === "object" && schema.properties()) {
//     Object.entries(schema.properties()).forEach(
//       ([propertyName, propertySchema]) => {
//         listCustomTypes(propertySchema, customTypes);
//       }
//     );
//   }
//   if (schema.anyOf()) {
//     schema.anyOf().forEach((s) => {
//       listCustomTypes(s, customTypes);
//     });
//   }
//   if (schema.oneOf()) {
//     schema.oneOf().forEach((s) => {
//       listCustomTypes(s, customTypes);
//     });
//   }
//   if (schema.allOf()) {
//     schema.allOf().forEach((s) => {
//       listCustomTypes(s, customTypes);
//     });
//   }

//   return customTypes;
// }
