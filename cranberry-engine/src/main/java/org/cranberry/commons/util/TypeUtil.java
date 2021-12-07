/**
 * Copyright 2020 the project cranberry authors
 * and the original author or authors annotated by {@author}
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.cranberry.commons.util;


import javax.lang.model.element.TypeElement;
import javax.lang.model.type.TypeKind;
import javax.lang.model.type.TypeMirror;
import javax.lang.model.util.Elements;
import javax.lang.model.util.Types;
import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * The type Type util.
 *
 * @author Alexander A. Kropotin
 * @project cranberry
 * @created 2020 -03-02 16:41
 */
public class TypeUtil {

    private final Types typeUtil;

    private final Elements elementUtil;

    private static final Set<TypeKind> PRIMITIVE_TYPES;

    private static final TypeKind ARRAY_TYPE;

    private static final Class<?> COLLECTION_TYPE;

    private static final Class<?> MAP_TYPE;

    static {
        PRIMITIVE_TYPES = new HashSet<TypeKind>(8, 1f) {{
            add(TypeKind.BOOLEAN);
            add(TypeKind.BYTE);
            add(TypeKind.CHAR);
            add(TypeKind.DOUBLE);
            add(TypeKind.FLOAT);
            add(TypeKind.INT);
            add(TypeKind.LONG);
            add(TypeKind.SHORT);
        }};

        ARRAY_TYPE = TypeKind.ARRAY;

        COLLECTION_TYPE = Collection.class;

        MAP_TYPE = Map.class;
    }

    /**
     * Instantiates a new Type util.
     *
     * @param types    the types
     * @param elements the elements
     */
    public TypeUtil(Types types, Elements elements) {
        this.typeUtil = types;
        this.elementUtil = elements;
    }

    /**
     * Is same boolean.
     *
     * @param t1 the t 1
     * @param t2 the t 2
     * @return the boolean
     */
    public boolean isSame(TypeMirror t1, TypeMirror t2) {
        return this.typeUtil.isAssignable(t1, t2);
    }

    /**
     * Is different boolean.
     *
     * @param t1 the t 1
     * @param t2 the t 2
     * @return the boolean
     */
    public boolean isDifferent(TypeMirror t1, TypeMirror t2) {
        return !this.typeUtil.isAssignable(t1, t2);
    }

    /**
     * Is primitive boolean.
     *
     * @param t the t
     * @return the boolean
     */
    public boolean isPrimitive(TypeMirror t) {
        return PRIMITIVE_TYPES.contains(t.getKind())
                && t.getKind().isPrimitive();
    }

    /**
     * Is array boolean.
     *
     * @param t the t
     * @return the boolean
     */
    public boolean isArray(TypeMirror t) {
        return t.getKind().equals(ARRAY_TYPE);
    }

    /**
     * Is collection boolean.
     *
     * @param t the t
     * @return the boolean
     */
    public boolean isCollection(TypeMirror t) {
        TypeElement paramType = this.getTypeAsElement(t);

        return paramType != null
                && paramType.getTypeParameters().size() == 1
                && this.typeUtil.isAssignable(
                        this.typeUtil.erasure(paramType.asType()),
                        this.getType(COLLECTION_TYPE)
        );
    }

    /**
     * Is map boolean.
     *
     * @param t the t
     * @return the boolean
     */
    public boolean isMap(TypeMirror t) {
        TypeElement paramType = this.getTypeAsElement(t);

        return paramType != null
                && paramType.getTypeParameters().size() == 2
                && this.typeUtil.isAssignable(
                this.typeUtil.erasure(paramType.asType()),
                this.getType(MAP_TYPE)
        );
    }

    /**
     * Gets type.
     *
     * @param clazz the clazz
     * @return the type
     */
    public TypeMirror getType(Class<?> clazz) {
        return this.getType(clazz.getCanonicalName());
    }

    /**
     * Gets type.
     *
     * @param className the class name
     * @return the type
     */
    public TypeMirror getType(String className) {
        return this.elementUtil.getTypeElement(className).asType();
    }

    /**
     * Gets type as element.
     *
     * @param className the class name
     * @return the type as element
     */
    public TypeElement getTypeAsElement(String className) {
        return (TypeElement) this.typeUtil.asElement(this.getType(className));
    }

    /**
     * Gets type as element.
     *
     * @param t the t
     * @return the type as element
     */
    public TypeElement getTypeAsElement(TypeMirror t) {
        return (TypeElement) this.typeUtil.asElement(t);
    }
}
