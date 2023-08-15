/*
 * JBoss, Home of Professional Open Source.
 *
 * Copyright 2023 Red Hat, Inc., and individual contributors
 * as indicated by the @author tags.
 *
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

package org.jboss.logging.processor.report;

import org.jboss.logging.annotations.BaseUrl;
import org.jboss.logging.annotations.Message;
import org.jboss.logging.annotations.MessageBundle;
import org.jboss.logging.annotations.ResolutionDoc;

/**
 * Used for validating the XML for a {@code resolutionUrl} attribute.
 * @author <a href="mailto:jperkins@redhat.com">James R. Perkins</a>
 */
@SuppressWarnings("unused")
@BaseUrl("https://jboss.org/")
@MessageBundle(projectCode = "RPTM")
public interface TestReportMessages {

    @Message(id = 1, value = "Test message")
    @ResolutionDoc
    RuntimeException defaultUrl();

    @Message("Test message")
    RuntimeException noUrl();

    @Message(id = 2, value = "Test message")
    @ResolutionDoc
    RuntimeException containsUrl();
}
