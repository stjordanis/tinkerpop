/*
 *  Licensed to the Apache Software Foundation (ASF) under one
 *  or more contributor license agreements.  See the NOTICE file
 *  distributed with this work for additional information
 *  regarding copyright ownership.  The ASF licenses this file
 *  to you under the Apache License, Version 2.0 (the
 *  "License"); you may not use this file except in compliance
 *  with the License.  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied.  See the License for the
 *  specific language governing permissions and limitations
 *  under the License.
 */

package org.apache.tinkerpop.gremlin.java.translator.jython;

import org.apache.tinkerpop.gremlin.java.translator.PythonTranslatorProvider;
import org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.GraphTraversalSource;
import org.apache.tinkerpop.gremlin.structure.Graph;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class PythonJythonTranslatorProvider extends PythonTranslatorProvider {

    @Override
    public GraphTraversalSource traversal(final Graph graph) {
        final GraphTraversalSource g = super.traversal(graph);
        return null == g ?
                graph.traversal() :
                g.withTranslator(PythonJythonTranslator.of("g", IMPORT_STATICS)); // the bypass translator will ensure that gremlin-groovy is ultimately used
    }

}
