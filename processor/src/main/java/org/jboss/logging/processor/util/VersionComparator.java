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

package org.jboss.logging.processor.util;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Compares 2 different version strings.
 * <p/>
 * The version strings must be valid integers separated by {@code .} (dots).
 * <p/>
 * Date: 09.11.2011
 *
 * @author <a href="mailto:jperkins@redhat.com">James R. Perkins</a>
 */
public class VersionComparator implements Comparator<String> {

    public static VersionComparator INSTANCE = new VersionComparator();

    private VersionComparator() {
    }

    /**
     * Compares the first version to the second version and returns, 0 if they are equal, a value less than 0 if the
     * first version is less than the second version or a value greater than 0 if the first version is greater than
     * the second version.
     *
     * @param version1 the first version to compare.
     * @param version2 the second version to compare.
     *
     * @return a value of 0 if the versions are equal, less than 0 if {@code version1} is less than {@code version2},
     *         a value greater than 0 if {@code version1} is greater than {@code version2}.
     */
    public static int compareVersion(final String version1, final String version2) {
        return INSTANCE.compare(version1, version2);
    }

    @Override
    public int compare(final String o1, final String o2) {
        final String[] vs1 = o1.split("\\.");
        final String[] vs2 = o2.split("\\.");
        final int len = (vs1.length > vs2.length ? vs1.length : vs2.length);
        final List<Integer> v1 = convert(vs1, len);
        final List<Integer> v2 = convert(vs2, len);
        int result = 0;
        for (int i = 0; i < len; i++) {
            final Integer vi1 = v1.get(i);
            final Integer vi2 = v2.get(i);
            result = vi1.compareTo(vi2);
            if (result != 0) {
                break;
            }
        }
        return result;
    }

    private static List<Integer> convert(final String[] version, final int len) {
        final List<Integer> result = new ArrayList<>(len);
        for (int i = 0; i < len; i++) {
            if (i < version.length) {
                final String s = version[i];
                if ("x".equalsIgnoreCase(s)) {
                    result.add(0);
                } else {
                    try {
                        result.add(Integer.valueOf(s));
                    } catch (NumberFormatException e) {
                        throw new IllegalArgumentException(String.format("Version part %s is not a valid integer", s), e);
                    }
                }
            } else {
                result.add(0);
            }
        }
        return result;
    }
}
