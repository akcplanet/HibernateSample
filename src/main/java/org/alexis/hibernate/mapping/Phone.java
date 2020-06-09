package org.alexis.hibernate.mapping;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Phone  implements Serializable {

		 private static final long serialVersionUID = 1L;
		
		@Id
		@GenericGenerator(name = "uuid2", strategy = "uuid2")
		@GeneratedValue(generator = "uuid2")
		private String id;

		private String name;
		
		private String number;
		
		@OneToOne(mappedBy = "phonenew", cascade = CascadeType.ALL)
		private Student student;
		
		
	/*
	 * @OneToOne(mappedBy = "phonect", cascade = CascadeType.ALL) private Company
	 * comapnytx;
	 * 
	 * 
	 * public Company getComapnytx() { return comapnytx; }
	 * 
	 * public void setComapnytx(Company comapnytx) { this.comapnytx = comapnytx; }
	 */

		public Student getStudent() {
			return student;
		}

		public void setStudent(Student student) {
			this.student = student;
		}

		public Phone() {
			super();
		}

		public Phone(String name, String number) {
			super();
			this.name = name;
			this.number = number;
		}

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getNumber() {
			return number;
		}

		public void setNumber(String number) {
			this.number = number;
		}
		
		
		
		

}
