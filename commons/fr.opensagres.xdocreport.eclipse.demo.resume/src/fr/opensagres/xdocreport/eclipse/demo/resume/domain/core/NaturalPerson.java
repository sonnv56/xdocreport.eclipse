package fr.opensagres.xdocreport.eclipse.demo.resume.domain.core;

import java.util.Date;

public class NaturalPerson extends Person {

	/**
     * 
     */
	private static final long serialVersionUID = -1233890503792715089L;

	public NaturalPerson() {

	}

	public NaturalPerson(long id) {
		this.id = id;
	}

	// @Id
	// @GeneratedValue
	private Long id;

	public void setId(Long id) {

		this.id = id;

	}

	// @Enumerated(EnumType.STRING)
	// @Column(length=10)
	private MaritalStatus maritalStatus;

	// @Column(length=100,nullable=false)
	private String firstName;
	// @Column(length=100,nullable=false)
	private String lastName;
	// @Column
	private Date birthDate;

	// @Column
	private String birthPlace;

	// @Column
	private String mobilePhone;

	// @Column
	private boolean drivingLicense;

	// @ManyToOne
	private Country nationality;

	// @OneToOne(mappedBy="employee")
	// @PrimaryKeyJoinColumn(referencedColumnName = "ID")
	private Collaboration currentEmployer;

	public MaritalStatus getMaritalStatus() {
		return maritalStatus;
	}

	public void setMaritalStatus(MaritalStatus maritalStatus) {
		// Object oldValue = this.maritalStatus;
		this.maritalStatus = maritalStatus;
		// firePropertyChange("maritalStatus", oldValue, maritalStatus);
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		// Object oldValue = this.firstName;
		this.firstName = firstName;
		// firePropertyChange("firstName", oldValue, firstName);
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		// Object oldValue = this.lastName;
		this.lastName = lastName;
		// firePropertyChange("lastName", oldValue, lastName);
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		// Object oldValue = this.birthDate;
		this.birthDate = birthDate;
		// firePropertyChange("birthDate", oldValue, birthDate);
	}

	public String getBirthPlace() {
		return birthPlace;
	}

	public void setBirthPlace(String birthPlace) {
		// Object oldValue = this.birthPlace;
		this.birthPlace = birthPlace;
		// firePropertyChange("birthPlace", oldValue, birthPlace);
	}

	public String getMobilePhone() {
		return mobilePhone;
	}

	public void setMobilePhone(String mobilePhone) {
		// Object oldValue = this.mobilePhone;
		this.mobilePhone = mobilePhone;
		// firePropertyChange("mobilePhone", oldValue, mobilePhone);
	}

	public boolean isDrivingLicense() {
		return drivingLicense;
	}

	public void setDrivingLicense(boolean drivingLicense) {
		// Object oldValue = this.drivingLicense;
		this.drivingLicense = drivingLicense;
		// firePropertyChange("drivingLicense", oldValue, drivingLicense);
	}

	public Country getNationality() {
		return nationality;
	}

	public void setNationality(Country nationality) {
		// Object oldValue = this.nationality;
		this.nationality = nationality;
		// firePropertyChange("nationality", oldValue, nationality);
	}

	public Long getId() {
		return id;
	}

	public Collaboration getCurrentEmployer() {
		return currentEmployer;
	}

	public void setCurrentEmployer(Collaboration currentEmployer) {
		//Object oldValue = this.currentEmployer;
		this.currentEmployer = currentEmployer;
		//firePropertyChange("currentEmployer", oldValue, currentEmployer);
	}

}
