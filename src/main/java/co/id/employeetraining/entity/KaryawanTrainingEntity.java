package co.id.employeetraining.entity;

import java.util.Date;

import org.hibernate.annotations.Where;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@SuppressWarnings("deprecation")
@Entity
@Table(name = "karyawan_training")
@Where(clause = "deleted_date is null")
@Getter
@Setter
public class KaryawanTrainingEntity extends BaseEntity {
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@Column(name = "tanggal")
	private Date tanggal;
	
	@ManyToOne
	@JoinColumn(name = "id_karyawan")
	private KaryawanEntity karyawan;
	
	@ManyToOne
	@JoinColumn(name = "id_training")
	private TrainingEntity training;

}
