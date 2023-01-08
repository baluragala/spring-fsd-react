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

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class Chocolate {

	private @Id
	@GeneratedValue Long id;
	private String name;
	private String brand;
	private String size;
	private double price;
	private long soh;


	public Chocolate(String name, String brand, String size, double price, long soh) {
		this.name = name;
		this.brand = brand;
		this.size = size;
		this.price = price;
		this.soh = soh;
	}

	public Chocolate() {

	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Chocolate chocolate = (Chocolate) o;
		return Objects.equals(id, chocolate.id) &&
				Objects.equals(name, chocolate.name) &&
				Objects.equals(brand, chocolate.brand) &&
				Objects.equals(size, chocolate.size);
	}

	@Override
	public String toString () {
		return "Chocolate{" +
				"id=" + id +
				", name='" + name + '\'' +
				", brand='" + brand + '\'' +
				", size='" + size + '\'' +
				'}';
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public long getSoh() {
		return soh;
	}

	public void setSoh(long soh) {
		this.soh = soh;
	}
}
// end::code[]
