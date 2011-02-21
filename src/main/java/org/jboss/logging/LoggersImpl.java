/*
 *  JBoss, Home of Professional Open Source Copyright 2011, Red Hat, Inc., and
 *  individual contributors by the @authors tag. See the copyright.txt in the
 *  distribution for a full listing of individual contributors.
 *
 *  This is free software; you can redistribute it and/or modify it under the
 *  terms of the GNU Lesser General Public License as published by the Free
 *  Software Foundation; either version 2.1 of the License, or (at your option)
 *  any later version.
 *
 *  This software is distributed in the hope that it will be useful, but WITHOUT
 *  ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 *  FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 *  details.
 *
 *  You should have received a copy of the GNU Lesser General Public License
 *  along with this software; if not, write to the Free Software Foundation,
 *  Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA, or see the FSF
 *  site: http://www.fsf.org.
 */

package org.jboss.logging;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

/**
 *
 * @author James R. Perkins (jrp) - 20.Feb.2011
 */
public class LoggersImpl implements Loggers {

    public Class<?> loggerClass() {
        return Logger.class;
    }

    public Class<?> basicLoggerClass() {
        return BasicLogger.class;
    }

    public List<Method> basicLoggerMethods() {
        return Arrays.asList(basicLoggerClass().getMethods());
    }

}