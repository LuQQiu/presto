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
package io.prestosql.type;

import io.prestosql.spi.type.Type;
import io.prestosql.spi.type.TypeSignature;
import org.testng.annotations.Test;

import static io.prestosql.metadata.MetadataManager.createTestMetadataManager;
import static org.testng.Assert.assertEquals;

public class TestFunctionType
{
    @Test
    public void testDisplayName()
    {
        Type function = createTestMetadataManager().getType(TypeSignature.parseTypeSignature("function(row(field double),bigint)"));
        assertEquals(function.getDisplayName(), "function(row(field double),bigint)");
    }
}
