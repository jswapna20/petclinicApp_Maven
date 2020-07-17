	package com.petclinic.dto;
	import java.util.Date;

	public class PetnOwnerDto{

		private int pid;
		private String petName;
		private String ownerName;
		private String visitDate;
		private String description;


		public PetnOwnerDto(){
		}

		public PetnOwnerDto(final String petName, final int pid, final String ownerName){
			this.pid = pid;	
			this.petName = petName;
			this.ownerName = ownerName;	
		}

		public PetnOwnerDto(final String petName, final String ownerName){
			this.petName = petName;
			this.ownerName = ownerName;	
		}

		public PetnOwnerDto(final int pid, final String visitDate, final String description){
			this.pid = pid;	
			this.petName = petName;
			this.ownerName = ownerName;	
		}
		
		public void setPid(int pid){
			this.pid = pid;
		}

		public int getPid(){
			return pid;
		}

		public void setPetName(String petName){
			this.petName = petName;
		}

		public String getPetName(){
			return petName;
		}

		public void setOwnerName(String ownerName){
			this.ownerName = ownerName;
		}

		public String getOwnerName(){
			return ownerName;
		}

		public void setVisitDate(String visitDate){
			this.visitDate = visitDate;
		}

		public String getVisitDate(){
			return visitDate;
		}

		public void setDescription(String description){
			this.description = description;
		}

		public String getDescription(){
			return description;
		}


	};