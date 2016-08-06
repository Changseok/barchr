/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package ka.gws.barchr.persistence.jpa.entity;

import org.springframework.stereotype.Component;

import ka.gws.barchr.persistence.api.entity.ConnPoolConf;
import ka.gws.barchr.persistence.api.entity.Entity;
import ka.gws.barchr.persistence.api.entity.EntityFactory;
import ka.gws.barchr.persistence.api.entity.user.User;
import ka.gws.barchr.persistence.jpa.entity.user.JPAUser;


@Component
public class JPAEntityFactory implements EntityFactory {

	@SuppressWarnings("unchecked")
	@Override
	public <KEY, T extends Entity<KEY>> T newEntity(final Class<T> reference) {
		T result;

		if (reference.equals(User.class)) {
			result = (T) new JPAUser();
		} else {
			throw new IllegalArgumentException("Could not find a JPA implementation of " + reference.getName());
		}

		return result;
	}

	@Override
	public ConnPoolConf newConnPoolConf() {
		return new JPAConnPoolConf();
	}

}
