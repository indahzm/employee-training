package co.id.employeetraining.entity;

import org.hibernate.annotations.Where;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@SuppressWarnings("deprecation")
@Entity
@Table(name = "detail_karyawan")
@Where(clause = "deleted_date is null")
@Getter
@Setter
public class DetailKaryawanEntity extends BaseEntity {
	
	@Column(name = "nik")
	private String nik;
	
	@Column(name = "npwp")
	private String npwp;

}
