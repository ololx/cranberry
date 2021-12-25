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
package io.github.ololx.cranberry.commons.utils;


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
 * project cranberry
 * created 2020 -03-02 16:41
 */
public final class TypeUtil {

    /**
     * The variable  typeUtil
     */
    private final Types typeUtil;

    /**
     * The variable elementUtil
     */
    private final Elements elementUtil;

    /**
     * The variable PRIMITIVE_TYPES
     */
    private static final Set<TypeKind> PRIMITIVE_TYPES;

    /**
     * The variable ARRAY_TYPE
     */
    private static final TypeKind ARRAY_TYPE;

    /**
     * The variable COLLECTION_TYPE
     */
    private static final Class<?> COLLECTION_TYPE;

    /**
     * The variable MAP_TYPE
     */
    private static final Class<?> MAP_TYPE;

    /**
     * The variable PRIMITIVE_TYPES_COUNT
     */
    private static final int PRIMITIVE_TYPES_CAPACITY = 8;

    static {
        PRIMITIVE_TYPES = new HashSet<TypeKind>(PRIMITIVE_TYPES_CAPACITY, 1f) {
            {
                add(TypeKind.BOOLEAN);
                add(TypeKind.BYTE);
                add(TypeKind.CHAR);
                add(TypeKind.DOUBLE);
                add(TypeKind.FLOAT);
                add(TypeKind.INT);
                add(TypeKind.LONG);
                add(TypeKind.SHORT);
            }
        };

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
    public TypeUtil(final Types types, final Elements elements) {
        this.typeUtil = types;
        this.elementUtil = elements;
    }

    /**
     * Is same boolean.
     *
     * @param type1 the t 1
     * @param type2 the t 2
     * @return the boolean
     */
    public boolean isSame(final TypeMirror type1, final TypeMirror type2) {
        return this.typeUtil.isAssignable(type1, type2);
    }

    /**
     * Is different boolean.
     *
     * @param type1 the t 1
     * @param type2 the t 2
     * @return the boolean
     */
    public boolean isDifferent(final TypeMirror type1, final TypeMirror type2) {
        return !this.typeUtil.isAssignable(type1, type2);
    }

    /**
     * Is primitive boolean.
     *
     * @param t the t
     * @return the boolean
     */
    public boolean isPrimitive(final TypeMirror t) {
        return PRIMITIVE_TYPES.contains(t.getKind())
                && t.getKind().isPrimitive();
    }

    /**
     * Is array boolean.
     *
     * @param t the t
     * @return the boolean
     */
    public boolean isArray(final TypeMirror t) {
        return t.getKind().equals(ARRAY_TYPE);
    }

    /**
     * Is collection boolean.
     *
     * @param t the t
     * @return the boolean
     */
    public boolean isCollection(final TypeMirror t) {
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
    public boolean isMap(final TypeMirror t) {
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
    public TypeMirror getType(final Class<?> clazz) {
        return this.getType(clazz.getCanonicalName());
    }

    /**
     * Gets type.
     *
     * @param className the class name
     * @return the type
     */
    public TypeMirror getType(final String className) {
        return this.elementUtil.getTypeElement(className).asType();
    }

    /**
     * Gets type as element.
     *
     * @param className the class name
     * @return the type as element
     */
    public TypeElement getTypeAsElement(final String className) {
        return (TypeElement) this.typeUtil.asElement(this.getType(className));
    }

    /**
     * Gets type as element.
     *
     * @param t the t
     * @return the type as element
     */
    public TypeElement getTypeAsElement(final TypeMirror t) {
        return (TypeElement) this.typeUtil.asElement(t);
    }
}
