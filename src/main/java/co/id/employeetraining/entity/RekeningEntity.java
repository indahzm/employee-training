package co.id.employeetraining.entity;

import org.hibernate.annotations.Where;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@SuppressWarnings("deprecation")
@Entity
@Table(name = "rekening")
@Where(clause = "deleted_date is null")
@Getter
@Setter
public class RekeningEntity extends BaseEntity {
	
	@Column(name = "jenis")
	private String jenis;
	
	@Column(name = "nama")
	private String nama;
	
	@Column(name = "rekening")
	private String rekening;
	
	@Column(name = "alamat")
	private String alamat;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_karyawan")
	private KaryawanEntity karyawan;

}
