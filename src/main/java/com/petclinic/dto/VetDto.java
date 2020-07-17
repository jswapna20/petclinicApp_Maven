	package com.petclinic.dto;

	public class VetDto{

		private int id;
		private String vetName;
		private String specialityName;

		public VetDto(){
		}

		public VetDto(final String vetName, final String specialityName){
		}

		public void setId(int id){
			this.id = id;
		}

		public int getId(){
			return id;
		}

		public void setVetName(String vetName){
			this.vetName = vetName;
		}

		public String getVetName(){
			return vetName;
		}

		public void setSpecialityName(String specialityName){
			this.specialityName = specialityName;
		}

		public String getSpecialityName(){
			return specialityName;
		}

		public boolean equals(Object o){
			if (o instanceof VetDto )
				return (id==(((VetDto)o).getId()));
			else 
				return false;
		}

		public String toString(){
				return id+""+vetName;
		}

	}
