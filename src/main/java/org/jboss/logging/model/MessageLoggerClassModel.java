/*
 * JBoss, Home of Professional Open Source Copyright 2010, Red Hat, Inc., and
 * individual contributors by the @authors tag. See the copyright.txt in the
 * distribution for a full listing of individual contributors.
 *
 * This is free software; you can redistribute it and/or modify it under the
 * terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This software is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this software; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA, or see the FSF
 * site: http://www.fsf.org.
 */
package org.jboss.logging.model;

import com.sun.codemodel.internal.JAnnotationUse;
import com.sun.codemodel.internal.JBlock;
import com.sun.codemodel.internal.JCodeModel;
import com.sun.codemodel.internal.JDefinedClass;
import com.sun.codemodel.internal.JMethod;
import com.sun.codemodel.internal.JMod;
import org.jboss.logging.Logger;
import org.jboss.logging.MessageLogger;

import javax.annotation.Generated;
import java.util.Date;

/**
 * @author Kevin Pollet
 */
public class MessageLoggerClassModel extends ClassModel {

    private static final String LOGGER_PARAMETER_NAME = "logger";

    public MessageLoggerClassModel(final String className, final String superClassName, final String... interfacesName) {
        super(className, superClassName, interfacesName);
    }

    @Override
    public void initModel() throws Exception {
        super.initModel();

        JCodeModel model = this.getClassModel();

        /*
         * Add MessageLogger specific code
         */

        JDefinedClass definedClass = model._getClass(this.getClassName());

        //Add generated annotation
        JAnnotationUse generatedAnnotation = definedClass.annotate(Generated.class);
        generatedAnnotation.param("value", MessageLogger.class.getName());
        generatedAnnotation.param("date", new Date().toString());

        JMethod constructor = definedClass.constructor(JMod.PROTECTED);
        constructor.param(JMod.FINAL, Logger.class, LOGGER_PARAMETER_NAME);

        JBlock constructorBody = constructor.body();
        constructorBody.directStatement("super(" + LOGGER_PARAMETER_NAME + ");");
    }

}
