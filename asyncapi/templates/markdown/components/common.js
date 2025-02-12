//copy from https://github.com/asyncapi/markdown-template/blob/master/components/common.js

import {
  IndentationTypes,
  Text,
  withIndendation,
} from "@asyncapi/generator-react-sdk";
import { FormatHelpers } from "../helpers/format";

export function Header({ type = 1, childrenContent = "" }) {
  const hashes = Array(type).fill("#").join("");
  return <Text newLines={2}>{`${hashes} ${childrenContent}`}</Text>;
}

export function Link({ href = "", childrenContent = "" }) {
  return `[${childrenContent}](${href})`;
}

export function Image({ src = "", desc = "", childrenContent = "" }) {
  return `![${desc || childrenContent}](${src})`;
}

export function List({ list = [] }) {
  if (list.length === 0) return null;
  return list.map((item, idx) => <ListItem key={idx}>{item}</ListItem>);
}

export function ListItem({
  type = "*",
  childrenContent = "",
  indentation = 0,
}) {
  return (
    <>
      {type}{" "}
      {withIndendation(
        childrenContent,
        2 * (indentation + 1),
        IndentationTypes.SPACES
      ).trimStart()}
      {"\n"}
    </>
  );
}

export function Table({ headers = [], rowRenderer = () => [], data = [] }) {
  const row = (entry, idx) => (
    <Text key={idx}>{`| ${rowRenderer(entry)
      .map(FormatHelpers.escapePipes)
      .join(" | ")} |`}</Text>
  );
  return (
    <>
      <TableHead headers={headers} />
      {data.map((entry, idx) => row(entry, idx))}
    </>
  );
}

export function TableHead({ headers = [] }) {
  const header = `| ${headers.join(" | ")} |`;
  const breaks = `|${Array(headers.length).fill("---|").join("")}`;

  return (
    <>
      <Text>{header}</Text>
      <Text>{breaks}</Text>
    </>
  );
}

export function TableRow({ rowRenderer = () => [], entry }) {
  return (
    <Text>{`| ${rowRenderer(entry)
      .map(FormatHelpers.escapePipes)
      .join(" | ")} |`}</Text>
  );
}

export function CodeBlock({
  language = "json",
  childrenContent = "",
  indentation = 0,
}) {
  return (
    <Text indentation={indentation}>
      {"\n```"}
      {language}
      {"\n"}
      {childrenContent}
      {"\n```"}
    </Text>
  );
}

export function BlockQuote({ childrenContent = "" }) {
  return <Text newLines={2}>{`> ${childrenContent}`}</Text>;
}

export function NewLine({ numbers = 1 }) {
  return Array(numbers).fill("\n").join("");
}

export function Expandable({ title, indentation = 0, childrenContent = "" }) {
  return (
    <Text indentation={indentation}>
      {"<details><summary>"}
      {title}
      {"</summary>\n"}
      {childrenContent}
      {"</details>"}
    </Text>
  );
}
