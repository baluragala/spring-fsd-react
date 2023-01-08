/*
 * Copyright 2015 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.knowledgehut.chocostore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


// tag::code[]
@Component // <1>
public class DatabaseLoader implements CommandLineRunner { // <2>

	private final ChocolateRepository repository;

	@Autowired // <3>
	public DatabaseLoader(ChocolateRepository repository) {
		this.repository = repository;
	}

	@Override
	public void run(String... strings) throws Exception { // <4>
//		Faker faker = new Faker();
		this.repository.save(new Chocolate("Diary Milk", "Cadbury", "small",5,10));
		this.repository.save(new Chocolate("5 Star", "Cadbury", "small",5,10));
		this.repository.save(new Chocolate("KitKat", "Nestle", "small",5,10));

	}
}
// end::code[]
