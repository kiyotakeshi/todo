package com.kiyotakeshi.todo.entity;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class TodoTests {

	@Autowired
	TestEntityManager em;

	@Test
	void mapping() {
		var todo1 = this.em.find(Todo.class, 1000L);
		assertThat(todo1.getActivityName()).isEqualTo("go to supermarket");
		assertThat(todo1.getCategory()).isEqualTo(Category.Housework);
		assertThat(todo1.getLabel()).isEqualTo("my-label");
	}

	@Test
	void newTodo() {
		var todo = new Todo("new", Progress.Open, Category.Hobby, "test");
		this.em.persistAndFlush(todo);
	}

	@Test
	void update() {
		var todo1 = this.em.find(Todo.class, 1000L);
		todo1.setActivityName("go to bank");
		todo1.setProgress(Progress.Doing);
		todo1.setCategory(Category.Hobby);
		this.em.persistAndFlush(todo1);

		var updatedTodo1 = this.em.find(Todo.class, 1000L);
		assertThat(updatedTodo1.getActivityName()).isEqualTo("go to bank");
		assertThat(updatedTodo1.getProgress()).isEqualTo(Progress.Doing);
		assertThat(updatedTodo1.getCategory()).isEqualTo(Category.Hobby);
	}

}
