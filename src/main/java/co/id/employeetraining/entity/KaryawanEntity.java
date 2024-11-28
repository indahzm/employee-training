package co.id.employeetraining.entity;

import java.util.Date;

import org.hibernate.annotations.Where;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Getter;
import lombok.Setter;

@SuppressWarnings("deprecation")
@Entity
@Table(name = "karyawan")
@Where(clause = "deleted_date is null")
@Getter
@Setter
public class KaryawanEntity extends BaseEntity {
	
	@Column(name = "alamat")
	private String alamat;
	
	@Column(name = "dob")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dob;
	
	@Column(name = "nama")
	private String nama;
	
	@Column(name = "status")
	private String status;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "detail_karyawan")
	private DetailKaryawanEntity detailKaryawan;

}
