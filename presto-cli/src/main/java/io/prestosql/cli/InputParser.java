/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.prestosql.cli;

import io.prestosql.sql.parser.StatementSplitter;
import org.jline.reader.EOFError;
import org.jline.reader.ParsedLine;
import org.jline.reader.Parser;
import org.jline.reader.SyntaxError;
import org.jline.reader.impl.DefaultParser;

import static io.prestosql.cli.Console.STATEMENT_DELIMITERS;

public class InputParser
        implements Parser
{
    @Override
    public ParsedLine parse(String line, int cursor, ParseContext context)
            throws SyntaxError
    {
        StatementSplitter splitter = new StatementSplitter(line, STATEMENT_DELIMITERS);
        if (splitter.getCompleteStatements().isEmpty()) {
            throw new EOFError(-1, -1, null);
        }

        return new DefaultParser().parse(line, cursor, context);
    }
}
