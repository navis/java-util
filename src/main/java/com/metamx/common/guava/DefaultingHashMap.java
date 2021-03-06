/*
 * Copyright 2011,2012 Metamarkets Group Inc.
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

package com.metamx.common.guava;

import com.google.common.base.Supplier;

import java.util.HashMap;

/**
 */
public class DefaultingHashMap<K, V> extends HashMap<K, V>
{
  private final Supplier<V> supplier;

  public DefaultingHashMap(
      Supplier<V> supplier
  )
  {
    this.supplier = supplier;
  }

  @Override
  public V get(Object o)
  {
    V retVal = super.get(o);

    if (retVal == null) {
      retVal = supplier.get();
      super.put((K) o, retVal);
    }

    return retVal;
  }
}
