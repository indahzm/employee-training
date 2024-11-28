package co.id.employeetraining.entity;

import org.hibernate.annotations.Where;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@SuppressWarnings("deprecation")
@Entity
@Table(name = "training")
@Where(clause = "deleted_date is null")
@Getter
@Setter
public class TrainingEntity extends BaseEntity {
	
	@Column(name = "pengajar")
	private String pengajar;
	
	@Column(name = "tema")
	private String tema;
	
}
