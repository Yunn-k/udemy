package com.in28minutes.springboot.learnspringboot;

public class Course {

		private long id;
		private String anme;
		private String author;

		
		//Constructor
		public Course(long id, String anme, String author) {
			super();
			this.id = id;
			this.anme = anme;
			this.author = author;
		}
		
		//getters
		public long getId() {
			return id;
		}

		public String getAnme() {
			return anme;
		}

		public String getAuthor() {
			return author;
		}
		
		//toSring
		@Override
		public String toString() {
			return "Course [id=" + id + ", anme=" + anme + ", author=" + author + "]";
		}


		
		
		
		
		
}
